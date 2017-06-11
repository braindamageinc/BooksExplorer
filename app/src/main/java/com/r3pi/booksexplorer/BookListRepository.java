package com.r3pi.booksexplorer;


import android.util.Log;

import com.r3pi.booksexplorer.databinding.BookDetailsActivityBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookListRepository implements IModelRepository {

    private final BooksAPIService booksAPIService;

    private int numTotalBooks = 0;

    private boolean requestCompleted;

    /*
    &key=AIzaSyAr-Nsaoiw6naYxYjfQcbYnO3ztJ68cSPY
     */

    public BookListRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.googleapis.com/")
                .build();

        this.booksAPIService = retrofit.create(BooksAPIService.class);

        requestCompleted = true;
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
                    String coverURL = response.body().getVolumeInfo().getImageLinks().getLarge();
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

    @Override
    public void getBooksList(String query, final int startIdx, final BooksListViewModel listViewModel) {
        if (requestCompleted) {
            Log.i("TEST", "START REQ " + query + " IDX: " + startIdx);
            requestCompleted = false;
            booksAPIService.getBooksList(query, startIdx).enqueue(new Callback<BooksListJSONModel>() {
                @Override
                public void onResponse(Call<BooksListJSONModel> call, Response<BooksListJSONModel> response) {
                    numTotalBooks = response.body().getTotalItems();

                    listViewModel.updateListContents(response.body().getItems(), startIdx);

                    requestCompleted = true;
                }

                @Override
                public void onFailure(Call<BooksListJSONModel> call, Throwable t) {
                    Log.e("TEST", t.toString());
                    requestCompleted = true;
                }
            });
        }
    }

    @Override
    public void getBookDetails(String volumeId) {

    }

    public int getNumTotalBooks() {
        return numTotalBooks;
    }

}
