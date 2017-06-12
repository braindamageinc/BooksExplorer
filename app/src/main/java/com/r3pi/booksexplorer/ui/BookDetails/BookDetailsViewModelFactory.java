package com.r3pi.booksexplorer.ui.BookDetails;


import android.arch.lifecycle.ViewModelProvider;

import com.r3pi.booksexplorer.model.IModelRepository;

public class BookDetailsViewModelFactory implements ViewModelProvider.Factory {

    private final String volumeId;
    private final IModelRepository modelRepository;

    public BookDetailsViewModelFactory(String volumeId, IModelRepository modelRepository) {
        this.volumeId = volumeId;
        this.modelRepository = modelRepository;
    }

    @Override
    public BookDetailsViewModel create(Class modelClass) {
        return new BookDetailsViewModel(volumeId, modelRepository);
    }
}
