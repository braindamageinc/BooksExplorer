package com.r3pi.booksexplorer;


import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookListRepository implements IModelRepository {

    private static final int INVALID_IDX = -1;

    private final BooksAPIService booksAPIService;

    private int numTotalBooks;

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
        numTotalBooks = INVALID_IDX;
    }

    @Override
    public void getBooksList(String query, final int startIdx, final BooksListViewModel listViewModel) {
        if (canLoadMore(startIdx)) {
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

    private boolean canLoadMore(int startIdx) {
        boolean canLoadMore = requestCompleted;

        if (numTotalBooks != INVALID_IDX) {
            canLoadMore = canLoadMore && (startIdx < numTotalBooks);
        }

        return canLoadMore;
    }

    @Override
    public void getBookDetails(String volumeId, final IBookDetailsCallback callback) {
        booksAPIService.getBookDetails(volumeId).enqueue(new Callback<BookDetailsJSONModel>() {
            @Override
            public void onResponse(Call<BookDetailsJSONModel> call, Response<BookDetailsJSONModel> response) {
                if (callback != null) {
                    callback.onResult(response.body());
                }
            }

            @Override
            public void onFailure(Call<BookDetailsJSONModel> call, Throwable t) {
                if (callback != null) {
                    callback.onFail(t.toString());
                }
            }
        });
    }

    public int getNumTotalBooks() {
        return numTotalBooks;
    }

}
