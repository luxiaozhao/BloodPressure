package com.example.dell.bloodpressure.apimanage;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by dell on 2017/9/12.
 */

public interface IRetrofitAPI {

    @GET
    Observable<ResponseBody> get(@Url String url);
}
