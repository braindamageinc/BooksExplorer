package com.r3pi.booksexplorer;

import java.util.ArrayList;
import java.util.List;

public class BooksListViewModel {

    private List<BookListItemViewModel> listContents;

    private BooksListAdapter listAdapter;

    public BooksListViewModel(BooksListAdapter listAdapter) {
        this.listAdapter = listAdapter;
        this.listContents = new ArrayList<>();
    }

    public void updateListContents(List<BooksListJSONModel.Item> items) {
        //TODO: use diff utils to merge contents
        listContents.clear();

        for (BooksListJSONModel.Item item : items) {
            try {
                String title = item.getVolumeInfo().getTitle();
                String authors = "";
                for (String author : item.getVolumeInfo().getAuthors()) {
                    authors += author + ", ";
                }
                String coverURL = item.getVolumeInfo().getImageLinks().getSmallThumbnail();
                String year = item.getVolumeInfo().getPublishedDate();
                String detailsURL = item.getSelfLink();
                String volumeId = item.getId();
                listContents.add(new BookListItemViewModel(coverURL, title, authors, year, detailsURL, volumeId));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        listAdapter.setContent(listContents);
    }
}
