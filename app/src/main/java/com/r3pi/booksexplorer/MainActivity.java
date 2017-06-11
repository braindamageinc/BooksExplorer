package com.r3pi.booksexplorer;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.r3pi.booksexplorer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private BookListRepository bookRepo;
    private BooksListViewModel listViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(binding.toolbar);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        binding.list.setLayoutManager(layoutManager);

        RecyclerView.Adapter listAdapter = new BooksListAdapter();
        binding.list.setAdapter(listAdapter);

        this.listViewModel = new BooksListViewModel((BooksListAdapter) listAdapter);

        this.bookRepo = new BookListRepository();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i("TEST", "onQueryTextSubmit >>>>>>>> " + query);

                bookRepo.testListBooks(query, listViewModel);

                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("TEST", "onQueryTextChange === " + newText);

                return false;
            }
        });

        return true;
    }

}
