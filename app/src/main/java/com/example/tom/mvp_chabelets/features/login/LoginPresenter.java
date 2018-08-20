package com.example.tom.mvp_chabelets.features.login;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.tom.mvp_chabelets.app.App;
import com.example.tom.mvp_chabelets.app.appSettings.IAppSettings;
import com.example.tom.mvp_chabelets.base.mvp.BasePresenter;
import com.example.tom.mvp_chabelets.model.net.Network;
import com.example.tom.mvp_chabelets.model.net.pojo.LoginEntity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter<LoginContract.View>
        implements LoginContract.Presenter{
    private Network network;
    private IAppSettings appSettings;

    LoginPresenter(@NonNull Context context) {
        this.network = App.getApp(context).getNet();
        this.appSettings = App.getApp(context).getAppSettings();
    }

    @Override
    public void test() {
        Log.e("getPresenter", "hahahaha");
    }

    @Override
    public void onBtnLoginClicked(@NonNull String login, @NonNull String pass) {
        LoginEntity loginEntity = new LoginEntity();
        loginEntity.setEmail(login);
        loginEntity.setPassword(pass);
        network.getLoginUser(loginEntity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(loginEntity1 -> {
                    LoginPresenter.this.getView().onLogInSuccess();
                    Log.v("TAG", "loginEntity1 " + loginEntity1);
                }, throwable -> LoginPresenter.this.getView()
                        .onLogInFailure(throwable.getMessage()));
    }

}
