package com.gabcode.randomgallery_mvvm.data.source.remote;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.gabcode.randomgallery_mvvm.data.UserProfile;

import java.util.List;

public interface UserProfileDataSource {

    interface LoadDataCallback {
        void onDataLoaded(List<UserProfile> userResult);
        void onDataNotAvailable();
    }

    void getUserProfiles(@NonNull LoadDataCallback callback);
}
