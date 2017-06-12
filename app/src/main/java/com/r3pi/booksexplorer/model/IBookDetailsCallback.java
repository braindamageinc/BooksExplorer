package com.r3pi.booksexplorer.model;

public interface IBookDetailsCallback {

    public void onResult(BookDetailsJSONModel model);

    public void onFail(String error);

}
