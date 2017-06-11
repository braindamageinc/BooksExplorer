package com.r3pi.booksexplorer;

import android.content.Intent;
import android.databinding.ObservableField;
import android.view.View;

public class BookListItemViewModel {

    public ObservableField<String> coverURL = new ObservableField<>();
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> author = new ObservableField<>();
    public ObservableField<String> detailsURL = new ObservableField<>();
    public ObservableField<String> year = new ObservableField<>();
    public ObservableField<String> volumeId = new ObservableField<>();

    public BookListItemViewModel(String coverURL, String title, String author, String year, String detailsURL, String volumeId) {
        this.coverURL.set(coverURL);
        this.title.set(title);
        this.author.set(author);
        this.detailsURL.set(detailsURL);
        this.year.set(year);
        this.volumeId.set(volumeId);
    }

    public void onClick(View v) {
        Intent detailsActivityIntent = new Intent(v.getContext(), BookDetailsActivity.class);
        detailsActivityIntent.putExtra(BookDetailsActivity.BOOK_VOLUME_ID_EXTRA, volumeId.get());

        v.getContext().startActivity(detailsActivityIntent);
    }

}
