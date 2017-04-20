package com.youche.ycsaas.module.movie;

import com.youche.ycsaas.app.BasePresenter;
import com.youche.ycsaas.app.BaseView;

/**
 * Created by SuChangz on 2017/4/18.
 * Desc
 */

public interface MovieContract {

    interface View extends BaseView<Presenter> {

        void startLoading();

        void showData(MovieEntity movieEntity);

        void error(Throwable t);

        void complete();

    }

    interface Presenter extends BasePresenter {
        void getTopMovie(int start, int count);
    }
}
