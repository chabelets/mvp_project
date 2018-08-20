package com.example.tom.mvp_chabelets.base.mvp;

import android.support.annotation.NonNull;

public interface MVPPresenter <V extends MVPView>{
    void onAttach(@NonNull V view);

    void onDetach(@NonNull V view);

    V getView();

    boolean isAttached();
}
