package com.example.tom.mvp_chabelets.features.main;

import android.support.annotation.NonNull;

import com.example.tom.mvp_chabelets.base.mvp.MVPPresenter;
import com.example.tom.mvp_chabelets.base.mvp.MVPView;
import com.example.tom.mvp_chabelets.model.net.pojo.DataGetResponse;

import java.util.List;

public interface MainContract {

    interface View extends MVPView {
        void onPhotoFetchSuccessful(@NonNull List<DataGetResponse> photoList);
    }

    interface Presenter extends MVPPresenter<View> {
        void onPhotoFetchCall();
    }
}
