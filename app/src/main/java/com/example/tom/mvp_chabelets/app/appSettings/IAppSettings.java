package com.example.tom.mvp_chabelets.app.appSettings;

import android.support.annotation.NonNull;

public interface IAppSettings {

    void setIsLogged();

    String getUserToken();

    void setUserToken(@NonNull String userToken);

    String getObjectId();

    void setObjectId(@NonNull String userToken);

    boolean isLogged();

}
