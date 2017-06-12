package com.r3pi.booksexplorer.ui.BooksList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableField;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

import com.r3pi.booksexplorer.ui.BookDetails.BookDetailsActivity;
import com.r3pi.booksexplorer.R;

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
        detailsActivityIntent.putExtra(BookDetailsActivity.BOOK_TITLE_EXTRA, title.get());
        detailsActivityIntent.putExtra(BookDetailsActivity.BOOK_AUTHOR_EXTRA, author.get());
        detailsActivityIntent.putExtra(BookDetailsActivity.BOOK_YEAR_EXTRA, year.get());
        detailsActivityIntent.putExtra(BookDetailsActivity.BOOK_COVER_URL_EXTRA, coverURL.get());

        Context context = v.getContext();
        View coverImage = v.findViewById(R.id.imageCover);

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, coverImage, "coverImage");
        context.startActivity(detailsActivityIntent, options.toBundle());
    }

}
