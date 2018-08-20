package com.example.tom.mvp_chabelets.features.main;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tom.mvp_chabelets.R;
import com.example.tom.mvp_chabelets.base.adapter.BaseAdapter;
import com.example.tom.mvp_chabelets.features.main.swipe.ItemTouchHelperAdapter;
import com.example.tom.mvp_chabelets.model.net.pojo.DataGetResponse;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterWithPagination extends BaseAdapter<DataGetResponse, RecyclerView.ViewHolder>
        implements ItemTouchHelperAdapter {

    private static final int TYPE_PHOTO = 1001;
    private static final int TYPE_COUNTER = 1002;
    private static final int TYPE_BAR = 1003;


    public AdapterWithPagination(@NonNull List<DataGetResponse> items) {
        super(items);
    }

    @Override
    public int getItemViewType(int position) {
        int result = TYPE_PHOTO;
        if (position == 0) {
            result = TYPE_COUNTER;
        } else if (position == getItemCount() - 1) {
            result = TYPE_BAR;
        }
        return result;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageViewHolder holder = null;
        switch (viewType) {
            case TYPE_COUNTER:
                holder = new ImageViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_counter, parent, false));
                break;
            case TYPE_PHOTO:
                holder = new ImageViewHolder(LayoutInflater.from(parent.getContext()).
                        inflate(R.layout.item_photo_list, parent, false));
                break;
            case TYPE_BAR:
                holder = new ImageViewHolder(LayoutInflater.from(parent.getContext()).
                        inflate(R.layout.item_progress_bar, parent, false));
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);

        switch (viewType) {
            case TYPE_COUNTER:

                CountViewHolder countViewHolder = (CountViewHolder) holder;
                ButterKnife.bind(countViewHolder.countTextViewItem);
                countViewHolder.countTextViewItem.setText(getItemCount());
                break;
            case TYPE_PHOTO:
                ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
                DataGetResponse dataGetResponse = getItems().get(position);
                Log.v("TAG", "adapter: " + position + imageViewHolder.photoImageView);
                Glide.with(holder.itemView.getContext())
                        .load(dataGetResponse.getPhotoRemoteUrl())
                        .into(imageViewHolder.photoImageView);
                imageViewHolder.headline.setText(dataGetResponse.getPhotoName());
                imageViewHolder.description.setText(dataGetResponse.getPhotoDescription());

                holder.itemView.setOnClickListener(v -> {
                    if (getListener() != null) {
                        getListener().onItemClick(v, position);
                    }
                });
        }
    }

    public void updatePhotoListitems(List<DataGetResponse> dataGetResponses) {
        final PhotosDiffUtilCallback
                diffUtilCallback = new PhotosDiffUtilCallback(super.getItems(), dataGetResponses);
        final DiffUtil.DiffResult result = DiffUtil.calculateDiff(diffUtilCallback);
        getItems().clear();
        getItems().addAll(dataGetResponses);
        result.dispatchUpdatesTo(this);

    }

    @Override
    public void onItemDismiss(int position) {
        getItems().remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(getItems(), i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(getItems(), i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.headlineMarkerItemTextView)
        TextView headline;
        @BindView(R.id.descriptionMarkerItemTextView)
        TextView description;
        @BindView(R.id.photoMarkerItemImageView)
        ImageView photoImageView;

        ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class CountViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.countTextViewItem)
        TextView countTextViewItem;

        public CountViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    static class ProgressBarViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.progressBar)
        ProgressBar progressBar;

        public ProgressBarViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
