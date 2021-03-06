package com.r3pi.booksexplorer.ui.BooksList;

import com.r3pi.booksexplorer.model.BooksListJSONModel;

public class BookListItemViewModelFactory {

    private static final String AUTHOR_DELIM_TOKEN = ", ";

    public BookListItemViewModel getBookListItemViewModel(BooksListJSONModel.Item item) {
        String title = item.getVolumeInfo().getTitle();
        String authors = "";

        if (item.getVolumeInfo().getAuthors() != null) {
            for (String author : item.getVolumeInfo().getAuthors()) {
                authors += author + AUTHOR_DELIM_TOKEN;
            }

            authors = authors.substring(0, authors.length() - AUTHOR_DELIM_TOKEN.length());
        }

        String coverURL = null;
        if (item.getVolumeInfo().getImageLinks() != null) {
            if (item.getVolumeInfo().getImageLinks().getThumbnail() != null) {
                coverURL = item.getVolumeInfo().getImageLinks().getThumbnail();
            } else if (item.getVolumeInfo().getImageLinks().getSmallThumbnail() != null) {
                coverURL = item.getVolumeInfo().getImageLinks().getSmallThumbnail();
            }
        }

        String year = item.getVolumeInfo().getPublishedDate();
        String detailsURL = item.getSelfLink();
        String volumeId = item.getId();

        return new BookListItemViewModel(coverURL, title, authors, year, detailsURL, volumeId);
    }

}
