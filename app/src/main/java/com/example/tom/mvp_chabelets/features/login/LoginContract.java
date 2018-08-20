package com.example.tom.mvp_chabelets.features.login;

import android.support.annotation.NonNull;

import com.example.tom.mvp_chabelets.base.mvp.MVPPresenter;
import com.example.tom.mvp_chabelets.base.mvp.MVPView;

public interface LoginContract {

    interface View extends MVPView {
        void onLogInSuccess();

        void onLogInFailure(@NonNull String errorMsg);
    }

    interface Presenter extends MVPPresenter<View> {
        void test();

        void onBtnLoginClicked(@NonNull String login, @NonNull String pass);
    }
}
