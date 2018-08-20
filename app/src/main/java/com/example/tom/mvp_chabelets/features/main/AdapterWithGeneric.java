package com.example.tom.mvp_chabelets.features.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tom.mvp_chabelets.R;
import com.example.tom.mvp_chabelets.base.adapter.BaseAdapter;
import com.example.tom.mvp_chabelets.base.adapter.OnRecyclerItemClickListener;
import com.example.tom.mvp_chabelets.model.net.pojo.DataGetResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.Nullable;

public class AdapterWithGeneric extends BaseAdapter<DataGetResponse, AdapterWithGeneric.ImageViewHolder> {

    public AdapterWithGeneric(@NonNull List<DataGetResponse> items) {
        super(items);
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageViewHolder(inflate(parent, R.layout.item_photo_list));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        DataGetResponse dataGetResponse = getItems().get(position);
        Log.v("TAG", "adapter: " + position + holder.photoImageView);
        Glide.with(holder.itemView.getContext())
                .load(dataGetResponse.getPhotoRemoteUrl())
                .into(holder.photoImageView);
        holder.headline.setText(dataGetResponse.getPhotoName());
        holder.description.setText(dataGetResponse.getPhotoDescription());

        holder.itemView.setOnClickListener(v -> {
            if (getListener() != null) {
                getListener().onItemClick(v, position);
            }
        });
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

        public void onBind(DataGetResponse photo, @Nullable OnRecyclerItemClickListener listener) {



        }
    }

}
