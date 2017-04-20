package com.youche.ycsaas.http;

import com.youche.ycsaas.module.movie.MovieEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by SuChangz on 2017/4/18.
 * Desc 服务接口
 */

public interface RetrofitService {
    @GET("top250")
    Observable<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);
}
