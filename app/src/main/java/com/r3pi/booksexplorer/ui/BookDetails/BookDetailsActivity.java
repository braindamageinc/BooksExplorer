package com.r3pi.booksexplorer.ui.BookDetails;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.r3pi.booksexplorer.model.BookListRepository;
import com.r3pi.booksexplorer.R;
import com.r3pi.booksexplorer.databinding.BookDetailsActivityBinding;

public class BookDetailsActivity extends AppCompatActivity {

    public static String BOOK_VOLUME_ID_EXTRA = "BOOK_VOLUME_ID_EXTRA";
    public static String BOOK_TITLE_EXTRA = "BOOK_TITLE_EXTRA";
    public static String BOOK_AUTHOR_EXTRA = "BOOK_AUTHOR_EXTRA";
    public static String BOOK_YEAR_EXTRA = "BOOK_YEAR_EXTRA";
    public static String BOOK_COVER_URL_EXTRA = "BOOK_COVER_URL_EXTRA";

    private BookDetailsViewModel bookDetailsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BookDetailsActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.book_details_activity);

        String volumeId = getIntent().getStringExtra(BOOK_VOLUME_ID_EXTRA);

        BookDetailsViewModelFactory viewModelFactory = new BookDetailsViewModelFactory(volumeId, new BookListRepository());
        bookDetailsViewModel = ViewModelProviders.of(this, viewModelFactory).get(BookDetailsViewModel.class);

        binding.setBookDetails(bookDetailsViewModel);

        setBookDetailsFromIntent(getIntent());
    }

    private void setBookDetailsFromIntent(Intent intent) {
        bookDetailsViewModel.updateBookDetails(intent.getStringExtra(BOOK_TITLE_EXTRA),
                                                intent.getStringExtra(BOOK_AUTHOR_EXTRA),
                                                intent.getStringExtra(BOOK_YEAR_EXTRA),
                                                intent.getStringExtra(BOOK_COVER_URL_EXTRA));
    }


}
