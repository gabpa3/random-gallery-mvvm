package com.gabcode.randomgallery_mvvm.profileGallery;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gabcode.randomgallery_mvvm.BaseActivity;
import com.gabcode.randomgallery_mvvm.R;
import com.gabcode.randomgallery_mvvm.data.UserProfile;
import com.gabcode.randomgallery_mvvm.databinding.ActivityProfileGalleryBinding;
import com.gabcode.randomgallery_mvvm.profileDetail.ProfileDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class ProfileGalleryActivity extends BaseActivity implements ProfileGalleryItemNavigator {

    private final int SPAN_COUNT = 6;

    private ItemGalleryAdapter adapter;

    private ActivityProfileGalleryBinding profileGalleryBinding;
    private ProfileGalleryViewModel profileGalleryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        profileGalleryBinding = DataBindingUtil.setContentView(this, R.layout.activity_profile_gallery);
        profileGalleryViewModel = obtainViewModel(this);

        setUpToolbar(profileGalleryBinding.contentToolbar.toolbar, getString(R.string.app_name), false);
        setUpRecyclerView(profileGalleryBinding.recyclerView);

        profileGalleryViewModel.getUserProfiles().observe(this, this::displayItems);
        profileGalleryViewModel.getNavigateToDetail().observe(this, this::navigateToDetail);
        profileGalleryViewModel.getDataLoading().observe(this, this::setProgressBarVisible);
    }

    public ProfileGalleryViewModel obtainViewModel(FragmentActivity activity) {
        return ViewModelProviders.of(activity).get(ProfileGalleryViewModel.class);
    }

    private void setUpRecyclerView(RecyclerView recyclerView) {
        adapter = new ItemGalleryAdapter(new ArrayList<>(), profileGalleryViewModel);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, SPAN_COUNT);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }

    private void displayItems(List<UserProfile> userProfiles) {
        adapter.setUserProfiles(userProfiles);
    }

    private void setProgressBarVisible(boolean value) {
        profileGalleryBinding.progressBar.setVisibility(value ? View.VISIBLE : View.GONE);
    }

    @Override
    public void navigateToDetail(UserProfile userProfile) {
        Intent intent = new Intent(this, ProfileDetailActivity.class);
        intent.putExtra(ProfileDetailActivity.EXTRA_USER_PROFILE, userProfile);
        startActivity(intent);
    }
}
