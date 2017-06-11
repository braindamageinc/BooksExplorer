package com.r3pi.booksexplorer;


import android.util.Log;
import android.widget.TextView;

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

        /*bookListService.getBookDetails("I7eFIs8yvlAC").enqueue(new Callback<BookDetailsJSONModel>() {
            @Override
            public void onResponse(Call<BookDetailsJSONModel> call, Response<BookDetailsJSONModel> response) {
                String bookDescr = response.body().getVolumeInfo().getDescription();
                Log.i("TEST", "" + bookDescr);

                listViewModel.setText(bookDescr);
            }

            @Override
            public void onFailure(Call<BookDetailsJSONModel> call, Throwable t) {
                Log.e("TEST", t.toString());
            }
        });*/

    }


}
