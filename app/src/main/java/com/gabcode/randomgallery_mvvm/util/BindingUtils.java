package com.gabcode.randomgallery_mvvm.util;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

public class BindingUtils {

    @BindingAdapter("thumbnail")
    public static void loadImage(ImageView view, String imageThumbnail) {
        ImageUtils.setOnHolder(view.getContext(), view, imageThumbnail);
    }

    @BindingAdapter("imageLarge")
    public static void loadImageLarge(ImageView view, String imageLarge) {
        ImageUtils.setOnHolderLarge(view.getContext(), view, imageLarge);
    }

    @BindingAdapter("android:visibility")
    public static void setVisibility(View view, boolean visible) {
        view.setVisibility((visible) ?  View.VISIBLE : View.GONE);
    }
}
