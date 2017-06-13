package com.r3pi.booksexplorer.ui.BooksList;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.r3pi.booksexplorer.R;
import com.r3pi.booksexplorer.databinding.BooksListActivityBinding;
import com.r3pi.booksexplorer.model.BookListRepository;

public class BooksListActivity extends AppCompatActivity {

    private BooksListViewModel listViewModel;
    private ListContentPager listContentPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BooksListActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.books_list_activity);

        setSupportActionBar(binding.toolbar);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.list.setLayoutManager(layoutManager);

        RecyclerView.Adapter listAdapter = new BooksListAdapter();
        binding.list.setAdapter(listAdapter);

        BookListViewModelFactory listViewModelFactory = new BookListViewModelFactory(new BookListRepository());
        this.listViewModel = ViewModelProviders.of(this, listViewModelFactory).get(BooksListViewModel.class);
        this.listViewModel.setAdapter((BooksListAdapter) listAdapter);

        binding.setBooksList(listViewModel);

        this.listContentPager = new ListContentPager(binding.list, listViewModel);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        this.listViewModel.setAdapter(null);
        this.listContentPager.cleanup();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        setupToolbarSearchView(menu);

        return true;
    }

    private void setupToolbarSearchView(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchItem.expandActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                listViewModel.searchBooks(query);

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        searchView.setQuery(listViewModel.getCurrentQuery(), false);
        searchView.clearFocus();
    }

}
