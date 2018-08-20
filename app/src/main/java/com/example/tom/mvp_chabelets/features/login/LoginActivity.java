package com.example.tom.mvp_chabelets.features.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.EditText;

import com.example.tom.mvp_chabelets.R;
import com.example.tom.mvp_chabelets.base.mvp.BaseActivity;
import com.example.tom.mvp_chabelets.util.Starter;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<LoginContract.View, LoginContract.Presenter>
        implements LoginContract.View {

    @BindView(R.id.login)
    EditText login;
    @BindView(R.id.password)
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter.test();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginContract.Presenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public LoginContract.View createView() {
        return this;
    }

    @OnClick(R.id.loginButton)
    public void onViewClicked() {
        presenter.onBtnLoginClicked(
                String.valueOf(login.getText()),
                String.valueOf(password.getText()));
    }

    @Override
    public void onLogInSuccess() {
        Log.v("response", "SUCCESS ");
                startNextActivity();
    }

    @Override
    public void onLogInFailure(@NonNull String errorMsg) {
        Log.v("response", "ERROR " + errorMsg);
    }

    private void startNextActivity() {
        Starter.startMainActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
