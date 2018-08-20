package com.example.tom.mvp_chabelets.app.appSettings;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

public class AppSettings implements IAppSettings{

    private static final String KEY_USER = "KEY_USER";
    private static final String APP_PREF_OBJECT_ID = "APP_PREF_OBJECT_ID";
    private static final String APP_PREF_USER_TOKEN = "APP_PREF_USER_TOKEN";
    private SharedPreferences sharedPreferences;

    public AppSettings(@NonNull Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setIsLogged() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(KEY_USER, true);
        editor.apply();
    }

    public String getUserToken() {
        return sharedPreferences.getString(APP_PREF_USER_TOKEN, null);
    }

    public void setUserToken(@NonNull String userToken) {
        setSharedEditor(userToken);
    }

    public String getObjectId() {
        return sharedPreferences.getString(APP_PREF_OBJECT_ID, null);
    }

    public void setObjectId(@NonNull String userToken) {
        setEditorKey(APP_PREF_OBJECT_ID, userToken);
    }

    public boolean isLogged() {
        return sharedPreferences.getBoolean(KEY_USER, false);
    }

    private void setEditorKey(@NonNull String editorKey, @NonNull String userToken){
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putString(editorKey, userToken);
        sharedPreferencesEditor.apply();
    }

    private void setSharedEditor(@NonNull String userToken) {
        setEditorKey(APP_PREF_USER_TOKEN, userToken);
    }

}

