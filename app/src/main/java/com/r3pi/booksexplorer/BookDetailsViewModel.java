package com.r3pi.booksexplorer;

import android.databinding.ObservableField;

public class BookDetailsViewModel {

    public ObservableField<String> coverURL = new ObservableField<>();
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String> author = new ObservableField<>();
    public ObservableField<String> description = new ObservableField<>();
    public ObservableField<String> year = new ObservableField<>();

    public BookDetailsViewModel(String coverURL, String title, String author, String year, String description) {
        this.coverURL.set(coverURL);
        this.title.set(title);
        this.author.set(author);
        this.description.set(description);
        this.year.set(year);
    }

}
