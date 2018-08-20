package com.example.tom.mvp_chabelets.model.net;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.tom.mvp_chabelets.BuildConfig;
import com.example.tom.mvp_chabelets.app.AppModule;
import com.example.tom.mvp_chabelets.model.net.pojo.DataGetResponse;
import com.example.tom.mvp_chabelets.model.net.pojo.LoginEntity;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Net implements Network {
    private static final String BASE_URL = "https://api.backendless.com/";
    private static final String APPLICATION_ID = "D0C2329C-1475-7BEC-FF56-E36FFAC2D600" + "/";
    private static final String REST_SECRET_KEY = "1C02B61E-F38A-0219-FFA7-760BB45A7000" + "/";
    private static final String URL = BASE_URL + APPLICATION_ID + REST_SECRET_KEY;
    private static final String DB_PHOTOS_TABLE = "PhotosTable";
    private static RestAPI restAPI;
    private ExecutorService executorService = Executors.newFixedThreadPool(5);
    private Handler handler = new Handler(Looper.getMainLooper());
    private Network network;
    private AppModule appModule;


    public Net(AppModule appModule) {
        this.appModule = appModule;
        retrofitBuilder();
        //TODO здесь сделать токен, obj id - дбавить в модел
    }

    @Override
    public Single<LoginEntity> getLoginUser(@NonNull final LoginEntity loginEntity) {
       return restAPI.getLoginUser(loginEntity, appModule.getAppSettings().getUserToken());
    }

    @Override
    public Single <List<DataGetResponse>> fetchRemotePhotos() {
        return restAPI.getPhoto(DB_PHOTOS_TABLE, appModule.getAppSettings().getUserToken(), 30);
    }

    @Override
    public void deleteItem() {
        restAPI.deleteItem(DB_PHOTOS_TABLE, appModule.getAppSettings().getUserToken());
    }

    private void retrofitBuilder() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        Log.v("LOG", "interceptor " + interceptor);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BACKEND_FULL_APP_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        restAPI = retrofit.create(RestAPI.class);
    }
}
