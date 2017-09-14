package com.example.dell.bloodpressure.ui.persionalfragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dell.bloodpressure.R;
import com.example.dell.bloodpressure.base.BaseFragment;
import com.example.dell.bloodpressure.ui.landing.LandingActivity;

/**
 * Created by dell on 2017/9/12.
 */

public class PersionalFragment extends BaseFragment {

    private View view;
    private LinearLayout discovery_set;
    private LinearLayout discovery_news;
    private LinearLayout discovery_data;
    private Button discovery_landing;
    private LinearLayout discovery_plus;
    private LinearLayout discovery_collection;

    @Override
    protected void initdata() {

    }

    @Override
    protected void initview(LayoutInflater inflater) {
        view = inflater.inflate(R.layout.fragment_discovery, null);
        initView(view);
    }

    @Override
    protected View initlayout() {
        return view;
    }
    private void initView(View view) {
        //登陆
        discovery_landing = (Button) view.findViewById(R.id.discovery_landing);
        //我的加号
        discovery_plus = (LinearLayout) view.findViewById(R.id.discovery_plus);
        //我的收藏
        discovery_collection = (LinearLayout) view.findViewById(R.id.discovery_collection);
        //个人资料
        discovery_data = (LinearLayout) view.findViewById(R.id.discovery_data);
        //消息
        discovery_news = (LinearLayout) view.findViewById(R.id.discovery_news);
        //设置
        discovery_set = (LinearLayout) view.findViewById(R.id.discovery_set);

        discovery_landing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(),"点击了按钮",Toast.LENGTH_LONG).show();
                startActivity(new Intent(getActivity(), LandingActivity.class));

            }
        });


        //控件监听
        getidscoverymonitor();


    }



    public void getidscoverymonitor() {

        //我的加号
        discovery_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LandingActivity.class));

                Toast.makeText(getActivity(), "请先登陆", Toast.LENGTH_LONG).show();

            }
        });


        //我的收藏
        discovery_collection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LandingActivity.class));

                Toast.makeText(getActivity(), "请先登陆", Toast.LENGTH_LONG).show();

            }
        });


        //个人资料
        discovery_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LandingActivity.class));

                Toast.makeText(getActivity(), "请先登陆", Toast.LENGTH_LONG).show();

            }
        });


        //消息
        discovery_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LandingActivity.class));

                Toast.makeText(getActivity(), "请先登陆", Toast.LENGTH_LONG).show();

            }
        });
        //设置
        discovery_set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LandingActivity.class));

                Toast.makeText(getActivity(), "请先登陆", Toast.LENGTH_LONG).show();

            }
        });


    }


}
