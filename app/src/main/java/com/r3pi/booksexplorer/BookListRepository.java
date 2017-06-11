package com.r3pi.booksexplorer;


import android.util.Log;
import android.widget.TextView;

import com.r3pi.booksexplorer.databinding.BookDetailsActivityBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookListRepository {


    /*
    &key=AIzaSyAr-Nsaoiw6naYxYjfQcbYnO3ztJ68cSPY
     */


    public void testListBooks(String query, final BooksListViewModel listViewModel) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.googleapis.com/")
                .build();

        BooksAPIService bookListService = retrofit.create(BooksAPIService.class);

        bookListService.getBooksList(query).enqueue(new Callback<BooksListJSONModel>() {
            @Override
            public void onResponse(Call<BooksListJSONModel> call, Response<BooksListJSONModel> response) {
                Log.i("TEST", response.toString());

                listViewModel.updateListContents(response.body().getItems());
            }

            @Override
            public void onFailure(Call<BooksListJSONModel> call, Throwable t) {
                Log.e("TEST", t.toString());
            }
        });
    }

    public void testBookDetails(final String volumeId, final BookDetailsActivityBinding binding) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.googleapis.com/")
                .build();

        BooksAPIService bookListService = retrofit.create(BooksAPIService.class);

        bookListService.getBookDetails(volumeId).enqueue(new Callback<BookDetailsJSONModel>() {
            @Override
            public void onResponse(Call<BookDetailsJSONModel> call, Response<BookDetailsJSONModel> response) {
                try {
                    String title = response.body().getVolumeInfo().getTitle();
                    String authors = "";
                    for (String author : response.body().getVolumeInfo().getAuthors()) {
                        authors += author + ", ";
                    }
                    String coverURL = response.body().getVolumeInfo().getImageLinks().getThumbnail();
                    String year = response.body().getVolumeInfo().getPublishedDate();
                    String description = response.body().getVolumeInfo().getDescription();
                    binding.setBookDetails(new BookDetailsViewModel(coverURL, title, authors, year, description));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<BookDetailsJSONModel> call, Throwable t) {
                Log.e("TEST", t.toString());
            }
        });

    }
}
