package com.r3pi.booksexplorer.ui.BooksList;

import android.support.v7.util.DiffUtil;

import java.util.List;

public class BooksListDiffCallback extends DiffUtil.Callback {

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