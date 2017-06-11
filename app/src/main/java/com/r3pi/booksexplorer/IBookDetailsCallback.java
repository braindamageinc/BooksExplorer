package com.r3pi.booksexplorer;

public interface IBookDetailsCallback {

    public void onResult(BookDetailsJSONModel model);

    public void onFail(String error);

}
