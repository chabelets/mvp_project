package com.example.tom.mvp_chabelets.features.main;

import android.arch.paging.PositionalDataSource;
import android.support.annotation.NonNull;

import com.example.tom.mvp_chabelets.model.net.pojo.DataGetResponse;

public class PhotoPositionalDataSource extends PositionalDataSource<DataGetResponse> {

    private DataGetResponse dataGetResponse;

    public PhotoPositionalDataSource(DataGetResponse dataGetResponse) {
        this.dataGetResponse = dataGetResponse;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<DataGetResponse> callback) {
//        List<DataGetResponse> result = dataGetResponse.getPhotoName()
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<DataGetResponse> callback) {

    }
}
