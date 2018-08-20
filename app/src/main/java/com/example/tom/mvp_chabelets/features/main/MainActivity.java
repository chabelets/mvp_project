package com.example.tom.mvp_chabelets.features.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import com.example.tom.mvp_chabelets.R;
import com.example.tom.mvp_chabelets.base.mvp.BaseActivity;
import com.example.tom.mvp_chabelets.features.main.swipe.SwipeController;
import com.example.tom.mvp_chabelets.model.net.pojo.DataGetResponse;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainContract.View, MainContract.Presenter> implements MainContract.View {

    AdapterWithPagination adapter;
//    PhotoListRecyclerAdapter adapter;
    @BindView(R.id.markerRecyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onStart() {
        super.onStart();
    presenter.onPhotoFetchCall();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void onPhotoFetchSuccessful(@NonNull List<DataGetResponse> photoList) {


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        Log.v("TAG", "size "+ photoList.size());
        if (adapter == null) {
            adapter = new AdapterWithPagination(photoList);
        } else {
            adapter.notifyDataSetChanged();
//            MyPositionalDataSource dataSource = new MyPositionalDataSource(new EmployeeStorage());
//
//            PagedList.Config config = new PagedList.Config.Builder()
//                    .setEnablePlaceholders(false)
//                    .setPageSize(10)
//                    .build();
//            PagedList<DataGetResponse> pagedList = new PagedList.Builder<>(dataSource, config)
//                    .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
//                    .setMainThreadExecutor(new MainThreadExecutor())
//                    .build();
//            PhotosDiffUtilCallback
//                    photosDiffUtilCallback = new PhotosDiffUtilCallback(adapter.getData, photoList);
//            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new PhotosDiffUtilCallback());
//            adapter.setData(photoList);
//            diffResult.dispatchUpdatesTo(adapter);
        }
        recyclerView.setAdapter(adapter);
        ItemTouchHelper.Callback swipeController = new SwipeController(adapter, this);
        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public MainContract.View createView() {
        return this;
    }

}