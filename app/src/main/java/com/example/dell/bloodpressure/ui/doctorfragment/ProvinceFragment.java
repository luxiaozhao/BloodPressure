package com.example.dell.bloodpressure.ui.doctorfragment;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.example.dell.bloodpressure.R;
import com.example.dell.bloodpressure.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 *省份选择
 */
public class ProvinceFragment extends BaseFragment {

    private View view;
    private ListView province_listview;
List<String> provlist=new ArrayList<>();
    @Override
    protected void initdata() {

    }

    @Override
    protected void initview(LayoutInflater inflater) {


        view = inflater.inflate(R.layout.fragment_province,null);
//        province_listview = (ListView) view.findViewById(R.id.province_listview);
//
//
//
//        provlist.add("不限");
//
//        provlist.add("北京市");
//
//        provlist.add("山东省");
//
//        provlist.add("山西省");
//
//        provlist.add("河北省");
//
//        provlist.add("河南省");
//
//        provlist.add("天津市");
//
//        provlist.add("辽宁省");
//
//        provlist.add("黑龙江省");
//
//        provlist.add("吉林省");
//
//        provlist.add("湖北省");
//
//        provlist.add("湖南省");
//
//        provlist.add("上海市");
//
//        provlist.add("四川省");
//
//        provlist.add("重庆市");
//
//        provlist.add("陕西省");
//
//        provlist.add("甘肃省");
//
//        provlist.add("云南省");
//
//        provlist.add("新疆维吾尔自治区");
//
//        provlist.add("内蒙古自治区");
//
//        provlist.add("海南省");
//
//        provlist.add("贵州省");
//
//        provlist.add("青海省");
//
//        provlist.add("广东省");
//
//        provlist.add("宁夏回族自治区");
//
//        provlist.add("西藏自治区");
//
//        provlist.add("广西壮族自治区");
//
//        provlist.add("江苏省");
//
//        provlist.add("浙江省");
//
//        provlist.add("安徽省");
//
//        provlist.add("江西省");
//
//        provlist.add("福建省");
//
//        MyAdapter myAdapter=new MyAdapter(getActivity(),provlist);
//
//        province_listview.setAdapter(myAdapter);


//        province_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//
//                Toast.makeText(getActivity(),"点击了",Toast.LENGTH_LONG).show();
//
//
//
//            }
//        });


    }

    @Override
    protected View initlayout() {
        return view;
    }

}

/*
    public ProvinceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_province, container, false);
    }*/
