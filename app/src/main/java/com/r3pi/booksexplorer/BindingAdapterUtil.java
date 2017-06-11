package com.r3pi.booksexplorer;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class BindingAdapterUtil {

    @BindingAdapter("android:src")
    static public void setImageURL(ImageView imageView, String url) {
        Picasso.with(imageView.getContext()).load(url).into(imageView);
    }

}
