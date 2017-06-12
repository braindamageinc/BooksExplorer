package com.r3pi.booksexplorer;

public interface IModelRepository {

    public boolean getBooksList(String query, int startIdx, IBooksListCallback callback);

    public boolean getBookDetails(String volumeId, IBookDetailsCallback callback);

    public int getNumTotalBooks();

}
