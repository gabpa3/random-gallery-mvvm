package com.gabcode.randomgallery_mvvm.profileGallery;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.gabcode.randomgallery_mvvm.R;
import com.gabcode.randomgallery_mvvm.data.UserProfile;
import com.gabcode.randomgallery_mvvm.databinding.ItemGalleryBinding;
import com.gabcode.randomgallery_mvvm.util.BindingUtils;

import java.util.List;

public class ItemGalleryAdapter extends RecyclerView.Adapter<ItemGalleryAdapter.IGViewHolder> {

    private List<UserProfile> userProfiles;
    private ProfileGalleryViewModel viewModel;

    public ItemGalleryAdapter(List<UserProfile> userProfiles, ProfileGalleryViewModel viewModel) {
        this.userProfiles = userProfiles;
        this.viewModel = viewModel;
    }

    public void setUserProfiles(List<UserProfile> userProfiles) {
        this.userProfiles.clear();
        this.userProfiles.addAll(userProfiles);
        notifyDataSetChanged();
    }

    @Override
    public IGViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemGalleryBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_gallery, parent, false);

        return new IGViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull IGViewHolder holder, int position) {
        UserProfile userProfile = userProfiles.get(position);
        holder.bind(userProfile);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull IGViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    @Override
    public int getItemCount() {
        return userProfiles.size();
    }

    public class IGViewHolder extends RecyclerView.ViewHolder implements ProfileGalleryItemListener {

        private ItemGalleryBinding binding;

        public IGViewHolder(ItemGalleryBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(UserProfile userProfile) {
            binding.setItem(userProfile);
            binding.setListener(this);
            binding.executePendingBindings();
        }

        void unbind() {
            if (binding != null)
                binding.unbind();
        }

        @Override
        public void onItemClicked(UserProfile userProfile) {
            viewModel.getNavigateToDetail().setValue(userProfile);
        }
    }


}
