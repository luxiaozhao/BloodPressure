package com.example.dell.bloodpressure.utils;


import com.example.dell.bloodpressure.apimanage.IRetrofitAPI;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dell on 2017/8/23.
 */

public class RetrofitUtil<T> {
    private static final int MAXTIME = 50;
    private final IRetrofitAPI api;
    private T type;

    public RetrofitUtil() {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(MAXTIME, TimeUnit.SECONDS)
                .readTimeout(MAXTIME, TimeUnit.SECONDS)
                .writeTimeout(MAXTIME, TimeUnit.SECONDS)
                .build();

        api = new Retrofit.Builder()
                .client(client)
                .baseUrl("http://api.wws.xywy.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(IRetrofitAPI.class);
    }

    public void get(String url, final T t , Observer observer) {

        type = t;
        Observable<ResponseBody> observable = api.get(url);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ResponseBody, T>() {
                    @Override
                    public T apply(ResponseBody responseBody) throws Exception {

                        Gson gson = new Gson();
                        type = (T) gson.fromJson(responseBody.string(), t.getClass());

                        return type;
                    }
                })
                .subscribe(observer);
    }
}
