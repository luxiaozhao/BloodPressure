package com.example.dell.bloodpressure.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.dell.bloodpressure.app.App;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * Created by dell on 2017/9/12.
 */

public abstract class BaseActivity extends AutoLayoutActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.activity = this;
        setContentView(initlayout());

        initview();
        initdata();
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.activity = this;

        initresume();
    }

    protected abstract void initresume();

    protected abstract void initdata();

    protected abstract void initview();

    protected abstract int initlayout();

}
