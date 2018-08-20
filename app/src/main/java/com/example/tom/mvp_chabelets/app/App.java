package com.example.tom.mvp_chabelets.app;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.tom.mvp_chabelets.app.appSettings.AppSettings;
import com.example.tom.mvp_chabelets.app.appSettings.IAppSettings;
import com.example.tom.mvp_chabelets.model.net.Net;
import com.example.tom.mvp_chabelets.model.net.Network;

public class App extends Application implements AppModule{

    private Network network;
    private IAppSettings appSettings;

    @Override
    public void onCreate() {
        super.onCreate();
        appSettings = new AppSettings(this);
        network = new Net(this);
    }

    @NonNull
    public static AppModule getApp(Context context){
        return (AppModule) context.getApplicationContext();
    }

    @NonNull
    @Override
    public Network getNet() {
        return network;
    }

    @NonNull
    @Override
    public IAppSettings getAppSettings() {
        return appSettings;
    }

}
