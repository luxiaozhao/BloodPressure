package com.example.dell.bloodpressure.components;

import com.example.dell.bloodpressure.ui.doctorfragment.DoctorFragment;
import com.example.dell.bloodpressure.utils.ModulesUtil;

import dagger.Component;

/**
 * Created by dell on 2017/9/13.
 */

@Component(modules = {ModulesUtil.class})
public interface AppComponent {
    void inject(DoctorFragment doctorFragment);
}
