package com.example.tom.mvp_chabelets.features.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tom.mvp_chabelets.R;
import com.example.tom.mvp_chabelets.model.net.pojo.DataGetResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

class PhotoListRecyclerAdapter extends RecyclerView.Adapter<PhotoListRecyclerAdapter.PhotoItemViewHolder> {

    private List<DataGetResponse> photos = new ArrayList<>();;

    PhotoListRecyclerAdapter(List<DataGetResponse> data) {
        this.photos = data;
    }

    @NonNull
    @Override
    public PhotoItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        PhotoItemViewHolder holder;
//        holder = new PhotoItemViewHolder(LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item_photo_list, parent, false));
//        return holder;
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_photo_list, parent, false);
        return new PhotoItemViewHolder(view);
//        return new PhotoItemViewHolder(LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item_photo_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoItemViewHolder holder, int position) {
        DataGetResponse dataGetResponse = photos.get(position);
        Log.v("TAG", "adapter: " + position + holder.photo);
        Glide.with(holder.itemView.getContext())
                .load(dataGetResponse.getPhotoRemoteUrl())
                .into(holder.photo);
        holder.headline.setText(dataGetResponse.getPhotoName());
        holder.description.setText(dataGetResponse.getPhotoDescription());
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class PhotoItemViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.headlineMarkerItemTextView)
        TextView headline;
        @BindView(R.id.descriptionMarkerItemTextView)
        TextView description;
        @BindView(R.id.photoMarkerItemImageView)
        ImageView photo;

        PhotoItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
