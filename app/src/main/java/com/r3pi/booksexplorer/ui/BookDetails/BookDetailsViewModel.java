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
        String title = model.getVolumeInfo().getTitle();
        String authors = "";

        if (model.getVolumeInfo().getAuthors() != null) {
            for (String author : model.getVolumeInfo().getAuthors()) {
                authors += author + ", ";
            }
        }

        /*String coverURL = null;
        if (model.getVolumeInfo().getImageLinks() != null) {
            if (model.getVolumeInfo().getImageLinks().getLarge() != null) {
                coverURL = model.getVolumeInfo().getImageLinks().getLarge();
            } else if (model.getVolumeInfo().getImageLinks().getMedium() != null) {
                coverURL = model.getVolumeInfo().getImageLinks().getMedium();
            } else if (model.getVolumeInfo().getImageLinks().getThumbnail() != null) {
                coverURL = model.getVolumeInfo().getImageLinks().getThumbnail();
            } else if (model.getVolumeInfo().getImageLinks().getSmallThumbnail() != null) {
                coverURL = model.getVolumeInfo().getImageLinks().getSmallThumbnail();
            }
        }*/

        String year = model.getVolumeInfo().getPublishedDate();
        String description = model.getVolumeInfo().getDescription();

        //this.coverURL.set(coverURL);
        //this.title.set(title);
        //this.author.set(authors);
        this.description.set(description);
        //this.year.set(year);
    }

}
