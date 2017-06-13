package com.r3pi.booksexplorer.ui.BooksList;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;
import android.support.v7.util.DiffUtil;

import com.r3pi.booksexplorer.model.BooksListJSONModel;
import com.r3pi.booksexplorer.model.IBooksListCallback;
import com.r3pi.booksexplorer.model.IModelRepository;

import java.util.ArrayList;
import java.util.List;

public class BooksListViewModel extends ViewModel implements IBooksListCallback {

    private List<BookListItemViewModel> listContents = new ArrayList<>();
    private final BookListItemViewModelFactory bookListItemViewModelFactory;

    private BooksListAdapter listAdapter;

    private String currentQuery;
    private int currentStartIdx;
    private final IModelRepository modelRepository;

    public ObservableBoolean isEmptyList = new ObservableBoolean(true);
    public ObservableBoolean isSearching = new ObservableBoolean(false);

    public BooksListViewModel(IModelRepository modelRepository, BookListItemViewModelFactory bookListItemViewModelFactory) {
        this.modelRepository = modelRepository;
        this.bookListItemViewModelFactory = bookListItemViewModelFactory;
    }

    public void setAdapter(BooksListAdapter listAdapter) {
        this.listAdapter = listAdapter;

        updateAdapter(listContents);
    }

    public void searchBooks(String query) {
        if (!query.equals(currentQuery)) {
            currentQuery = query;
            currentStartIdx = 0;
            getBooks(currentQuery, currentStartIdx);
        }
    }

    public void loadMore() {
        getBooks(currentQuery, listContents.size());
    }

    private void getBooks(String query, int startIdx) {
        boolean requestStarted = modelRepository.getBooksList(query, startIdx, this);

        isSearching.set(requestStarted && startIdx <= 0);
        isEmptyList.set(isEmptyList.get() && !isSearching.get());
    }

    private void updateAdapter(List<BookListItemViewModel> newList) {
        if (listAdapter != null) {
            listAdapter.update(newList);
        }

        isEmptyList.set(newList.isEmpty());
    }

    public String getCurrentQuery() {
        return currentQuery;
    }

    @Override
    public void onResult(List<BooksListJSONModel.Item> items, int startIdx) {
        List<BookListItemViewModel> newList = new ArrayList<>(listContents);

        isSearching.set(false);

        if (startIdx == 0) {
            newList.clear();
        }

        for (BooksListJSONModel.Item item : items) {
            newList.add(bookListItemViewModelFactory.getBookListItemViewModel(item));
        }

        updateAdapter(newList);

        listContents = newList;
    }

    @Override
    public void onFail(String error) {
        //TODO: show error msg
    }

    public List<BookListItemViewModel> getListContents() {
        return listContents;
    }

}