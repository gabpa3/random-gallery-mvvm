package com.gabcode.randomgallery_mvvm.data.source.remote;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.gabcode.randomgallery_mvvm.data.UserProfile;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserProfileRepository implements UserProfileDataSource {

    @Override
    public void getUserProfiles(@NonNull LoadDataCallback callback) {
        Call<ResponseApiArray> call = ServiceApiClient.getInstance().getUserProfiles();
        call.enqueue(new Callback<ResponseApiArray>() {
            @Override
            public void onResponse(Call<ResponseApiArray> call, Response<ResponseApiArray> response) {
                if (response.code() == HttpsURLConnection.HTTP_OK && response.body() != null) {
                    callback.onDataLoaded(response.body().getResults());
                } else
                    callback.onDataNotAvailable();
            }

            @Override
            public void onFailure(Call<ResponseApiArray> call, Throwable t) {
                callback.onDataNotAvailable();
            }
        });
    }
}
