package com.r3pi.booksexplorer.ui.BookDetails;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.r3pi.booksexplorer.model.BookDetailsJSONModel;
import com.r3pi.booksexplorer.model.IBookDetailsCallback;
import com.r3pi.booksexplorer.model.IModelRepository;

public class BookDetailsViewModel extends ViewModel {

    public ObservableField<String> coverURL = new ObservableField<>();
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> author = new ObservableField<>();
    public ObservableField<String> description = new ObservableField<>();
    public ObservableField<String> year = new ObservableField<>();

    private final String volumeId;
    private final IModelRepository modelRepository;

    public BookDetailsViewModel(String volumeId, IModelRepository modelRepository) {
        this.volumeId = volumeId;
        this.modelRepository = modelRepository;

        modelRepository.getBookDetails(volumeId, new IBookDetailsCallback() {
            @Override
            public void onResult(BookDetailsJSONModel model) {
                updateViewModel(model);
            }

            @Override
            public void onFail(String error) {
                BookDetailsViewModel.this.description.set(error);
            }
        });
    }

    private void updateViewModel(BookDetailsJSONModel model) {
        // only get book description, the rest of the data is passed via intent
        String description = model.getVolumeInfo().getDescription();
        this.description.set(description);
    }

    public void updateBookDetails(String title, String author, String year, String coverURL) {
        this.title.set(title);
        this.author.set(author);
        this.year.set(year);
        this.coverURL.set(coverURL);
    }

}
