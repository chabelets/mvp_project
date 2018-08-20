package com.example.tom.mvp_chabelets.model.net;

import android.support.annotation.NonNull;

import com.example.tom.mvp_chabelets.model.net.pojo.DataGetResponse;
import com.example.tom.mvp_chabelets.model.net.pojo.LoginEntity;

import java.util.List;

import io.reactivex.Single;

public interface Network {

    Single<LoginEntity> getLoginUser(@NonNull final LoginEntity loginEntity);

    Single <List<DataGetResponse>> fetchRemotePhotos();

    void deleteItem();


}
