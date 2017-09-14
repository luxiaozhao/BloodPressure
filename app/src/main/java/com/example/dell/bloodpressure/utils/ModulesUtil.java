package com.example.dell.bloodpressure.utils;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dell on 2017/9/13.
 */

@Module
public class ModulesUtil {

    @Provides
    RetrofitUtil getretrofit(){

        return new RetrofitUtil();
    }
}
