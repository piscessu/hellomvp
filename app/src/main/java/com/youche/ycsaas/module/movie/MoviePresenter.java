package com.youche.ycsaas.module.movie;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by SuChangz on 2017/4/18.
 * Desc
 */

public class MoviePresenter implements MovieContract.Presenter {
    private MovieContract.View mView;
    private MovieModel mMovieModel;
    private static final String TAG = "MoviePresenter";

    public MoviePresenter(MovieContract.View view) {
        mView = view;
        mMovieModel = new MovieModel();
    }

    @Override
    public void getTopMovie(int start, int count) {
        mView.startLoading();
        mMovieModel.getTopMovie(start, count)
                .subscribeOn(Schedulers.io())//请求发生在io线程
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MovieEntity>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieEntity movieEntity) {
                        mView.showData(movieEntity);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.error(e);
                    }

                    @Override
                    public void onComplete() {
                        mView.complete();
                    }
                });

    }

    @Override
    public void start() {

    }
}
