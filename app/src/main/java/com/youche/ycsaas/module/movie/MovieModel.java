package com.youche.ycsaas.module.movie;

import com.youche.ycsaas.app.BaseModel;
import com.youche.ycsaas.http.RetrofitFactory;


import io.reactivex.Observable;

/**
 * Created by SuChangz on 2017/4/18.
 * Desc
 */

public class MovieModel extends BaseModel {
    /**
     * 获取电影列表
     *
     * @param start
     * @param count
     * @return
     */
    public Observable<MovieEntity> getTopMovie(int start, int count) {

        return RetrofitFactory.getService().getTopMovie(start, count);
    }
}

