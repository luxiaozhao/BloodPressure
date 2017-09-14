package com.example.dell.bloodpressure.ui.bloodfragmnet;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dell.bloodpressure.R;
import com.example.dell.bloodpressure.base.BaseFragment;

/**
 * Created by dell on 2017/9/12.
 */

public class BloodFragment extends BaseFragment{

    private View view;
    private ImageView blood_upload;
    private LinearLayout blood_doctors;
    private LinearLayout blood_information;
    private LinearLayout blood_remind;

    @Override
    protected void initdata() {

    }

    @Override
    protected void initview(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_management,null);

        blood_upload = (ImageView) view.findViewById(R.id.blood_upload);

        blood_doctors = (LinearLayout) view.findViewById(R.id.blood_doctors);
        blood_information = (LinearLayout) view.findViewById(R.id.blood_Information);
        blood_remind = (LinearLayout) view.findViewById(R.id.blood_remind);
        getlinearLayout();

    }

    @Override
    protected View initlayout() {
        return view;
    }

    public void getlinearLayout() {


        //上传血压数据
        blood_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getActivity(),PressureActivity.class));


                Toast.makeText(getActivity(),"点击了",Toast.LENGTH_LONG).show();
            }
        });
        //问医生
              blood_doctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"点击了",Toast.LENGTH_LONG).show();
            }
        });
        //资讯
        blood_information.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"点击了",Toast.LENGTH_LONG).show();
            }
        });
        //提醒
        blood_remind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"点击了",Toast.LENGTH_LONG).show();
            }
        });

    }
}
