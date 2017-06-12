package com.r3pi.booksexplorer.model;


import java.util.List;

public interface IBooksListCallback {

    public void onResult(List<BooksListJSONModel.Item> items, int startIdx);

    public void onFail(String error);

}
