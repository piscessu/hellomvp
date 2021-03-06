package com.youche.ycsaas.module.movie;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.youche.ycsaas.R;
import com.youche.ycsaas.app.BaseActivity;
import com.youche.ycsaas.util.UIUtils;

import butterknife.BindView;
import es.dmoral.toasty.Toasty;

public class MovieListActivity extends BaseActivity implements MovieContract.View {

    private MoviePresenter mMoviePresenter;

    @BindView(R.id.rcv_movielist)
    RecyclerView mRcvMovielist;

    @Override
    protected int layoutResID() {
        return R.layout.movielist_act;
    }

    @Override
    protected void init() {

        mRcvMovielist.setLayoutManager(new LinearLayoutManager(this));
        new MoviePresenter(this);
        mMoviePresenter.getTopMovie(0, 10);
    }

    @Override
    public void showData(MovieEntity movieEntity) {
        Toasty.info(this, movieEntity.getTitle()).show();
        mRcvMovielist.setAdapter(new MovieAdapter(this, movieEntity.getSubjects()));
    }


    @Override
    public void startLoading() {
        UIUtils.showLoading(this, getString(R.string.message_loading));
    }

    @Override
    public void complete() {
        UIUtils.dismissLoading(this);
    }

    @Override
    public void error(Throwable e) {
        UIUtils.dismissLoading(this);
        Toasty.error(this, e.getMessage()).show();
    }

    @Override
    public void setPresenter(MovieContract.Presenter presenter) {
        mMoviePresenter = (MoviePresenter) presenter;
    }
}
