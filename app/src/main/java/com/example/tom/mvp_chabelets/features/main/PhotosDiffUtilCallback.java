package com.example.tom.mvp_chabelets.features.main;

import android.support.v7.util.DiffUtil;

import com.example.tom.mvp_chabelets.model.net.pojo.DataGetResponse;

import java.util.List;
import java.util.Objects;

public class PhotosDiffUtilCallback extends DiffUtil.Callback {

    private final List<DataGetResponse> oldList;
    private final List<DataGetResponse> newList;

    PhotosDiffUtilCallback(List<DataGetResponse> oldList, List<DataGetResponse> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        DataGetResponse oldPhoto = oldList.get(oldItemPosition);
        DataGetResponse newPhoto = newList.get(newItemPosition);
        return Objects.equals(oldPhoto.getPhotoName(), newPhoto.getPhotoName());
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        DataGetResponse oldPhoto = oldList.get(oldItemPosition);
        DataGetResponse newPhoto = newList.get(newItemPosition);
        return Objects.equals(oldPhoto.getPhotoRemoteUrl(), newPhoto.getPhotoRemoteUrl()) &&
                Objects.equals(oldPhoto.getPhotoDescription(), newPhoto.getPhotoDescription());
    }

}
