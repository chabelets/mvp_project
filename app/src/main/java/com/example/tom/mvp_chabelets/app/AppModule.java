package com.example.tom.mvp_chabelets.app;

import android.support.annotation.NonNull;

import com.example.tom.mvp_chabelets.app.appSettings.IAppSettings;
import com.example.tom.mvp_chabelets.model.net.Network;

public interface AppModule {

    @NonNull
    Network getNet();

    @NonNull
    IAppSettings getAppSettings() ;
}
