package com.r3pi.booksexplorer;

import android.arch.lifecycle.ViewModel;
import android.support.v7.util.DiffUtil;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class BooksListViewModel extends ViewModel {

    private List<BookListItemViewModel> listContents = new ArrayList<>();

    private BooksListAdapter listAdapter;

    private String currentQuery;
    private int currentStartIdx;
    private IModelRepository modelRepository;

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
        modelRepository.getBooksList(query, startIdx, this);
    }

    public void updateListContents(List<BooksListJSONModel.Item> items, int startIdx) {
        BookListItemViewModelFactory listItemViewModelFactory = new BookListItemViewModelFactory();

        List<BookListItemViewModel> newList = new ArrayList<>(listContents);

        if (startIdx == 0) {
            newList.clear();
        }

        for (BooksListJSONModel.Item item : items) {
            newList.add(listItemViewModelFactory.getBookListItemViewModel(item));
        }

        updateAdapter(newList);

        listContents = newList;
    }

    private void updateAdapter(List<BookListItemViewModel> newList) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new BooksListDiffCallback(newList, listAdapter.getListContents()));
        listAdapter.setListContents(newList);
        diffResult.dispatchUpdatesTo(listAdapter);
    }

    public void setModelRepository(IModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    public String getCurrentQuery() {
        return currentQuery;
    }


    private class BooksListDiffCallback extends DiffUtil.Callback {

        List<BookListItemViewModel> newList;
        List<BookListItemViewModel> oldList;

        public BooksListDiffCallback(List<BookListItemViewModel> newList, List<BookListItemViewModel> oldList) {
            this.oldList = oldList;
            this.newList = newList;
        }

        @Override
        public int getOldListSize() {
            return oldList.size();
        }

        @Override
        public int getNewListSize() {
            return newList.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            BookListItemViewModel oldItem = oldList.get(oldItemPosition);
            BookListItemViewModel newItem = newList.get(newItemPosition);

            return oldItem.volumeId.equals(newItem.volumeId);
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return areItemsTheSame(oldItemPosition, newItemPosition);
        }
    }

}