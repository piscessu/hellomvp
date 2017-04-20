package com.youche.ycsaas.http;

import com.youche.ycsaas.config.Config;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SuChangz on 2017/4/18.
 * Desc
 */

public class RetrofitFactory {
    private static Retrofit sRetrofit;

    private RetrofitFactory() {

    }

    public static RetrofitService getService() {
        if (sRetrofit == null) {
            synchronized (RetrofitFactory.class) {
                if (sRetrofit == null) {
                    sRetrofit = new Retrofit.Builder()
                            .baseUrl(Config.BASE_URL)
                            .client(getOkHttpClient())
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }
        return sRetrofit.create(RetrofitService.class);
    }

    //设置OkHttpClient，拦截器，超时时间等信息
    private static OkHttpClient getOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder builder = chain.request().newBuilder();
                        builder.addHeader("token", "abc");
                        return chain.proceed(builder.build());
                    }
                })
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
        return okHttpClient;
    }
}
