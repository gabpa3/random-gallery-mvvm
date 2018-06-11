package com.gabcode.randomgallery_mvvm.profileGallery;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;

import com.gabcode.randomgallery_mvvm.SingleLiveEvent;
import com.gabcode.randomgallery_mvvm.data.UserProfile;
import com.gabcode.randomgallery_mvvm.data.source.remote.UserProfileDataSource;
import com.gabcode.randomgallery_mvvm.data.source.remote.UserProfileRepository;

import java.util.List;

public class ProfileGalleryViewModel extends ViewModel {

    private MutableLiveData<List<UserProfile>> userProfiles;

    public final SingleLiveEvent<Boolean> dataLoading = new SingleLiveEvent<>();
    private SingleLiveEvent<UserProfile> navigateToDetail = new SingleLiveEvent<>();

    private final UserProfileRepository userProfileRepository;

    public ProfileGalleryViewModel() {
        this.userProfileRepository = new UserProfileRepository();
    }

    public LiveData<List<UserProfile>> getUserProfiles() {
        if (userProfiles == null) {
            userProfiles = new MutableLiveData<>();
            loadUserProfiles();
        }
        return userProfiles;
    }

    private void loadUserProfiles() {
        dataLoading.setValue(true);
        userProfileRepository.getUserProfiles(new UserProfileDataSource.LoadDataCallback() {
            @Override
            public void onDataLoaded(List<UserProfile> userResult) {
                dataLoading.setValue(false);
                if (userResult != null)
                    userProfiles.setValue(userResult);
            }

            @Override
            public void onDataNotAvailable() {
                dataLoading.setValue(false);
            }
        });
    }

    public SingleLiveEvent<Boolean> getDataLoading() {
        return dataLoading;
    }

    public SingleLiveEvent<UserProfile> getNavigateToDetail() {
        return navigateToDetail;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
//        userProfileRepository

    }
}
