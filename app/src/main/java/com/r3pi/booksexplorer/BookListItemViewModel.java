package com.r3pi.booksexplorer;

import android.databinding.ObservableField;
import android.util.Log;
import android.view.View;

public class BookListItemViewModel {

    public ObservableField<String> coverURL = new ObservableField<>();
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> author = new ObservableField<>();
    public ObservableField<String> detailsURL = new ObservableField<>();
    public ObservableField<String> year = new ObservableField<>();

    public BookListItemViewModel(String coverURL, String title, String author, String year, String detailsURL) {
        this.coverURL.set(coverURL);
        this.title.set(title);
        this.author.set(author);
        this.detailsURL.set(detailsURL);
        this.year.set(year);
    }

    public void onClick(View v) {
        //TODO: on click => book details activity
        Log.i("TEST", "Item clicked: " + title.get());
    }

}
