package com.example.tom.mvp_chabelets.base.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import io.reactivex.annotations.Nullable;

public abstract class BaseViewHolder<T, L extends BaseRecyclerListener> extends RecyclerView.ViewHolder {

    private L listener;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public BaseViewHolder(View itemView, L listener) {
        super(itemView);
        this.listener = listener;
    }

    public abstract void onBind(T item);

    public abstract void onBind(T item, @Nullable OnRecyclerItemClickListener listener);

    protected L getListener() {
        return listener;
    }

}