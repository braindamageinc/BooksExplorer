package com.r3pi.booksexplorer.ui.BooksList;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ListContentPager {

    private static final float THRESHOLD_LOAD_MORE = 0.75f;
    private final BooksListViewModel listViewModel;

    private RecyclerView recyclerView;

    public ListContentPager(RecyclerView recyclerView, BooksListViewModel listViewModel) {
        this.recyclerView = recyclerView;
        this.listViewModel = listViewModel;

        recyclerView.addOnScrollListener(new ScrollChangeListener());
    }

    public void cleanup() {
        this.recyclerView.clearOnScrollListeners();
    }

    private class ScrollChangeListener extends RecyclerView.OnScrollListener {

        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);

            LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

            int totalItemCount = layoutManager.getItemCount();
            int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
            int itemTiggerLoadMore = (int) (totalItemCount * THRESHOLD_LOAD_MORE);

            if (lastVisibleItemPosition >= itemTiggerLoadMore) {
                listViewModel.loadMore();
            }
        }

    }

}
