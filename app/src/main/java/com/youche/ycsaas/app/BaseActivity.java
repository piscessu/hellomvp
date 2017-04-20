package com.youche.ycsaas.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.youche.ycsaas.module.movie.MovieContract;

import butterknife.ButterKnife;

/**
 * Created by SuChangz on 2017/4/18.
 * Desc
 */

public abstract class BaseActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(layoutResID());
        ButterKnife.bind(this);
        initViews();
        initParams();
    }

    protected abstract int layoutResID();

    protected abstract void initViews();

    protected abstract void initParams();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    public void setPresenter(MovieContract.Presenter presenter) {

    }
}
