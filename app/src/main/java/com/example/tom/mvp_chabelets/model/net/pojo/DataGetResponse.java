package com.example.tom.mvp_chabelets.model.net.pojo;

import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataGetResponse {
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("PhotoName")
    @Expose
    private String photoName;
    @SerializedName("PhotoDescription")
    @Expose
    private String photoDescription;
    @SerializedName("PhotoLocationLatitude")
    @Expose
    private String photoLocationLatitude;
    @SerializedName("PhotoLocationLongitude")
    @Expose
    private String photoLocationLongitude;
    @SerializedName("PhotoLocalUrl")
    @Expose
    private String photoLocalUrl;
    @SerializedName("PhotoRemoteUrl")
    @Expose
    private String photoRemoteUrl;
    @SerializedName("created")
    @Expose
    private String photoCreatedDate;

    @NonNull
    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(@NonNull String photoName) {
        this.photoName = photoName;
    }

    @NonNull
    public String getPhotoDescription() {
        return photoDescription;
    }

    public void setPhotoDescription(@NonNull String photoDescription) {
        this.photoDescription = photoDescription;
    }

    @NonNull
    public String getPhotoLocationLatitude() {
        return photoLocationLatitude;
    }

    public void setPhotoLocationLatitude(@NonNull String photoLocationLatitude) {
        this.photoLocationLatitude = photoLocationLatitude;
    }

    @NonNull
    public String getPhotoLocationLongitude() {
        return photoLocationLongitude;
    }

    public void setPhotoLocationLongitude(@NonNull String photoLocationLongitude) {
        this.photoLocationLongitude = photoLocationLongitude;
    }

    @NonNull
    public String getPhotoLocalUrl() {
        return photoLocalUrl;
    }

    public void setPhotoLocalUrl(@NonNull String photoLocalUrl) {
        this.photoLocalUrl = photoLocalUrl;
    }

    @NonNull
    public String getPhotoRemoteUrl() {
        return photoRemoteUrl;
    }

    public void setPhotoRemoteUrl(@NonNull String photoRemoteUrl) {
        this.photoRemoteUrl = photoRemoteUrl;
    }

    public String getPhotoCreatedDate() {
        return photoCreatedDate;
    }

    public void setPhotoCreatedDate(String photoCreatedDate) {
        this.photoCreatedDate = photoCreatedDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
