package com.r3pi.booksexplorer;

public interface IModelRepository {

    public void getBooksList(String query, int startIdx, BooksListViewModel listViewModel);

    public void getBookDetails(String volumeId, IBookDetailsCallback callback);

    public int getNumTotalBooks();

}
