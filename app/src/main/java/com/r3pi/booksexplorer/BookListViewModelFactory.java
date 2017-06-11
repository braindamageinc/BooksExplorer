package com.r3pi.booksexplorer;

import android.arch.lifecycle.ViewModelProvider;

public class BookListViewModelFactory implements ViewModelProvider.Factory {

    private final IModelRepository modelRepository;

    public BookListViewModelFactory(IModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public BooksListViewModel create(Class modelClass) {
        return new BooksListViewModel(modelRepository);
    }
}
