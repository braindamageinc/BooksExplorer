package com.r3pi.booksexplorer;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface BooksAPIService {

    @GET("books/v1/volumes?")
    Call<BooksListJSONModel> getBooksList(@Query("q") String searchBook);

    @GET("books/v1/volumes?")
    Call<ResponseBody> getBooksListRaw(@Query("q") String searchBook);

    @GET("books/v1/volumes/{volumeId}")
    Call<BookDetailsJSONModel> getBookDetails(@Path("volumeId") String volumeId);
}
