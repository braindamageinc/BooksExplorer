package com.r3pi.booksexplorer.model;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BookListRepository implements IModelRepository {

    private static final int INVALID_IDX = -1;
    private static final String BOOKS_API_BASE_URL = "https://www.googleapis.com/";

    private final BooksAPIService booksAPIService;

    private int numTotalBooks;

    private boolean requestCompleted;

    private static final String BOOKS_API_KEY = "AIzaSyAr-Nsaoiw6naYxYjfQcbYnO3ztJ68cSPY";

    public BookListRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BOOKS_API_BASE_URL)
                .build();

        this.booksAPIService = retrofit.create(BooksAPIService.class);

        requestCompleted = true;
        numTotalBooks = INVALID_IDX;
    }

    @Override
    public boolean getBooksList(String query, final int startIdx, final IBooksListCallback callback) {
        boolean requestStarted = false;

        if (canLoadMore(startIdx)) {
            requestCompleted = false;
            booksAPIService.getBooksList(query, startIdx, BOOKS_API_KEY).enqueue(new Callback<BooksListJSONModel>() {
                @Override
                public void onResponse(Call<BooksListJSONModel> call, Response<BooksListJSONModel> response) {
                    numTotalBooks = response.body().getTotalItems();

                    if (callback != null) {
                        callback.onResult(response.body().getItems(), startIdx);
                    }

                    requestCompleted = true;
                }

                @Override
                public void onFailure(Call<BooksListJSONModel> call, Throwable t) {
                    if (callback != null) {
                        callback.onFail(t.toString());
                    }

                    requestCompleted = true;
                }
            });

            requestStarted = true;
        }

        return requestStarted;
    }

    private boolean canLoadMore(int startIdx) {
        boolean canLoadMore = requestCompleted;

        if (numTotalBooks != INVALID_IDX) {
            canLoadMore = canLoadMore && (startIdx < numTotalBooks);
        }

        return canLoadMore;
    }

    @Override
    public boolean getBookDetails(String volumeId, final IBookDetailsCallback callback) {
        boolean requestStarted = true;

        booksAPIService.getBookDetails(volumeId, BOOKS_API_KEY).enqueue(new Callback<BookDetailsJSONModel>() {
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

        return requestStarted;
    }

    public int getNumTotalBooks() {
        return numTotalBooks;
    }

}
