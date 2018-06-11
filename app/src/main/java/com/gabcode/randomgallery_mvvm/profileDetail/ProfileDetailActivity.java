package com.gabcode.randomgallery_mvvm.profileDetail;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.gabcode.randomgallery_mvvm.BaseActivity;
import com.gabcode.randomgallery_mvvm.R;
import com.gabcode.randomgallery_mvvm.data.UserProfile;
import com.gabcode.randomgallery_mvvm.databinding.ActivityProfileDetailBinding;

public class ProfileDetailActivity extends BaseActivity {

    public static final String EXTRA_USER_PROFILE = "userProfile";

    private ActivityProfileDetailBinding profileDetailBinding;
    private ProfileDetailViewModel profileDetailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserProfile userProfile = getIntent().getParcelableExtra(EXTRA_USER_PROFILE);

        profileDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_profile_detail);
        profileDetailViewModel = obtainViewModel(this);
        profileDetailBinding.setViewModel(profileDetailViewModel);

        setUpToolbar(profileDetailBinding.contentToolbar.toolbar, getString(R.string.tx_title_profile_detail), true);

        profileDetailViewModel.onLoadData(userProfile);
    }

    public ProfileDetailViewModel obtainViewModel(FragmentActivity activity) {
        return ViewModelProviders.of(activity).get(ProfileDetailViewModel.class);
    }

}
