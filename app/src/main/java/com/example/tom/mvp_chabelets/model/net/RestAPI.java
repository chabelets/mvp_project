package com.example.tom.mvp_chabelets.model.net;

import com.example.tom.mvp_chabelets.model.net.pojo.DataGetResponse;
import com.example.tom.mvp_chabelets.model.net.pojo.LoginEntity;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestAPI {

    @POST("users/login")
    Single<LoginEntity> getLoginUser(@Body LoginEntity user,
                                     @Header("Authorization") String userToken);

    @GET("data/{table_name}")
    Single <List<DataGetResponse>> getPhoto(@Path(value = "table_name", encoded = true) String tableName,
                                            @Header("Authorization") String userToken,
                                            @Query(value = "pageSize", encoded = true) int pageSize);

    @DELETE("data/{table_name}/{object-id}")
    void deleteItem(@Path(value = "table_name", encoded = true) String tableName,
                                             @Header("Authorization") String userToken);
}

