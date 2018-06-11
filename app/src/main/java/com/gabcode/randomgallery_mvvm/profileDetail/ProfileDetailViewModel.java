package com.gabcode.randomgallery_mvvm.profileDetail;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.gabcode.randomgallery_mvvm.data.UserProfile;

public class ProfileDetailViewModel extends ViewModel {

    public ObservableField<String> imageUrl = new ObservableField<>();
    public ObservableField<String> username = new ObservableField<>();
    public ObservableField<String> firstName = new ObservableField<>();
    public ObservableField<String> lastName = new ObservableField<>();
    public ObservableField<String> email = new ObservableField<>();

    public ProfileDetailViewModel() {}

    void onLoadData(UserProfile userProfile) {
        imageUrl.set(userProfile.getPicture().getLarge());
        username.set(userProfile.getLogin().getUsername());
        firstName.set(userProfile.getName().getFirst());
        lastName.set(userProfile.getName().getLast());
        email.set(userProfile.getEmail());
    }

}
