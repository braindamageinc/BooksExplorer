package com.r3pi.booksexplorer;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class BooksListAdapter extends RecyclerView.Adapter<BooksListAdapter.ViewHolder> {

    public List<BookListItemViewModel> listContent;

    public BooksListAdapter() {
         listContent = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.book_list_item, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(listContent.get(position));
    }

    @Override
    public int getItemCount() {
        return listContent.size();
    }

    public List<BookListItemViewModel> getListContents() {
        return listContent;
    }

    public void setListContents(List<BookListItemViewModel> listContent) {
        this.listContent = listContent;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ViewDataBinding binding;

        public ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(BookListItemViewModel bookListItemViewModel) {
            binding.setVariable(BR.book, bookListItemViewModel);
        }
    }


}
