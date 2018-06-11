package com.gabcode.randomgallery_mvvm.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.gabcode.randomgallery_mvvm.R;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class ImageUtils {

    public static void setOnHolder (Context context, ImageView imageHolder, String imageUrl) {
        Glide.with(context)
                .asBitmap()
                .load(imageUrl)
                .thumbnail(0.1f)
                .apply(new RequestOptions()
                        .skipMemoryCache(true)
                        .error(R.drawable.photo_profile)
                        .diskCacheStrategy(DiskCacheStrategy.NONE))
                .into(imageHolder);
    }

    public static void setOnHolderLarge(Context context, ImageView imageHolder, String imageUrl) {
        Glide.with(context)
                .load(imageUrl)
                .apply(new RequestOptions()
                        .error(R.drawable.photo_profile)
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                .into(imageHolder);
    }
}
