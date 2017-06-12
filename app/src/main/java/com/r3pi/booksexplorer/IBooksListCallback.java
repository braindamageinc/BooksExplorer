package com.r3pi.booksexplorer;


import java.util.List;

public interface IBooksListCallback {

    public void onResult(List<BooksListJSONModel.Item> items, int startIdx);

    public void onFail(String error);

}
