package com.r3pi.booksexplorer;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.r3pi.booksexplorer.databinding.BookDetailsActivityBinding;

public class BookDetailsActivity extends AppCompatActivity {

    public static String BOOK_VOLUME_ID_EXTRA = "BOOK_VOLUME_ID_EXTRA";

    private BookDetailsViewModel bookDetailsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BookDetailsActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.book_details_activity);

        setSupportActionBar(binding.toolbar);

        String volumeId = getIntent().getStringExtra(BOOK_VOLUME_ID_EXTRA);

        BookDetailsViewModelFactory viewModelFactory = new BookDetailsViewModelFactory(volumeId, new BookListRepository());
        bookDetailsViewModel = ViewModelProviders.of(this, viewModelFactory).get(BookDetailsViewModel.class);

        binding.setBookDetails(bookDetailsViewModel);
    }


}
