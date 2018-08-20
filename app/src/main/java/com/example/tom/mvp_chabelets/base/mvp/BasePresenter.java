package com.example.tom.mvp_chabelets.base.mvp;

import android.support.annotation.NonNull;

public abstract class BasePresenter<V extends MVPView> implements MVPPresenter<V> {

    protected V view;

    @Override
    public V getView() {
        return view;
    }

    @Override
    public boolean isAttached() {
        return this.view != null;
    }

    @Override
    public void onAttach(@NonNull V view) {
        this.view = view;
    }

    @Override
    public void onDetach(@NonNull V view) {
        this.view = null;
    }
}
