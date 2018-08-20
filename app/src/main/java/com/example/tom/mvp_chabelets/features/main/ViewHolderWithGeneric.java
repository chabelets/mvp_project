package com.example.tom.mvp_chabelets.features.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tom.mvp_chabelets.R;
import com.example.tom.mvp_chabelets.base.adapter.BaseViewHolder;
import com.example.tom.mvp_chabelets.base.adapter.OnRecyclerItemClickListener;
import com.example.tom.mvp_chabelets.model.net.pojo.DataGetResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.Nullable;

class ViewHolderWithGeneric extends BaseViewHolder<DataGetResponse, OnRecyclerItemClickListener>{


    @BindView(R.id.headlineMarkerItemTextView)
    TextView headline;
    @BindView(R.id.descriptionMarkerItemTextView)
    TextView description;
    @BindView(R.id.photoMarkerItemImageView)
    ImageView photoImageView;

    public ViewHolderWithGeneric(View itemView, OnRecyclerItemClickListener listener) {
        super(itemView, listener);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void onBind(DataGetResponse item) {

    }


    @Override
    public void onBind(DataGetResponse photo, @Nullable OnRecyclerItemClickListener listener) {
        headline.setText(photo.getPhotoName());
        description.setText(photo.getPhotoDescription());
        Glide.with(itemView.getContext())
                .load(photo.getPhotoRemoteUrl())
                .into(photoImageView);
        headline.setText(photo.getPhotoName());

        if (getListener() != null) {
            itemView.setOnClickListener(v -> { getListener().onItemClick(getAdapterPosition());
            });
        }
    }
}
