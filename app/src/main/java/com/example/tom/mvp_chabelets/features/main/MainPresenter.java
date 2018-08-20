package com.example.tom.mvp_chabelets.features.main;

import android.content.Context;
import android.util.Log;

import com.example.tom.mvp_chabelets.app.App;
import com.example.tom.mvp_chabelets.base.mvp.BasePresenter;
import com.example.tom.mvp_chabelets.model.net.Network;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    private Network network;

    MainPresenter(Context context){
        this.network = App.getApp(context).getNet();
    }

    @Override
    public void onPhotoFetchCall() {
        network.fetchRemotePhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(dataGetResponse -> getView().onPhotoFetchSuccessful(dataGetResponse),
                        throwable -> Log.v("TAG", "MainPresenter onFailure"));
    }
}
