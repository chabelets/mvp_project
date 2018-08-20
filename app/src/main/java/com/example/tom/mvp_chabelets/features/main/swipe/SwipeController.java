package com.example.tom.mvp_chabelets.features.main.swipe;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.tom.mvp_chabelets.app.App;
import com.example.tom.mvp_chabelets.model.net.Network;

public class SwipeController extends ItemTouchHelper.Callback {

    private Network network;
    private final ItemTouchHelperAdapter adapter;

    public SwipeController(ItemTouchHelperAdapter adapter,Context context) {
        this.adapter = adapter;
        this.network = App.getApp(context).getNet();
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        adapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        adapter.onItemDismiss(viewHolder.getAdapterPosition());
        if (direction == ItemTouchHelper.LEFT | direction == ItemTouchHelper.END){
            network.deleteItem();
        }
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }
}
