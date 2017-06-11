package com.r3pi.booksexplorer;

import android.databinding.BindingAdapter;
import android.os.Build;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class BindingAdapterUtil {

    @BindingAdapter("android:src")
    static public void setImageURL(ImageView imageView, String url) {
        Picasso.with(imageView.getContext()).load(url).into(imageView);
    }

    @BindingAdapter("textHTML")
    static public void setTextFromHTML(TextView textView, String text) {
        if (text != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                textView.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT));
            } else {
                textView.setText(Html.fromHtml(text));
            }
        }
    }

}
