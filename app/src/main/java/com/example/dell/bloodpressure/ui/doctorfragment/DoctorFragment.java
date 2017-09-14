package com.example.dell.bloodpressure.ui.doctorfragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dell.bloodpressure.R;
import com.example.dell.bloodpressure.base.BaseFragment;
import com.example.dell.bloodpressure.components.DaggerAppComponent;
import com.example.dell.bloodpressure.entity.HotDoctorBean;
import com.example.dell.bloodpressure.utils.RetrofitUtil;
import com.example.dell.bloodpressure.utils.UrlUtil;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by dell on 2017/9/12.
 *
 * 医生在线
 *
 */

public class DoctorFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout location_ln;
    private ImageView location_ima;
    private RelativeLayout work_ln;
    private RelativeLayout grade_ln;
    private RelativeLayout search_ln;
    private CheckBox add_check;
    private Button query_bt;
    private RadioButton ask_bt;
    private RadioButton phone_bt;
    private GridView hot_gridview;
    private View view;

    @Inject
    HotDoctorBean hotbean;
    @Inject
    RetrofitUtil retrofitUtil;
    private TextView location_ln_textview;


    @Override
    protected void initdata() {

        retrofitUtil.get(UrlUtil.DOCTOR_HOT, hotbean, new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {

                hotbean = (HotDoctorBean) value;
//                Log.e(TAG, "onNext: "+hotbean.getData().get(2).getName() );


            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    protected void initview(LayoutInflater inflater) {

        DaggerAppComponent.create().inject(this);

        view = inflater.inflate(R.layout.doctorfragment, null);
//        Intent intent = getIntent();
//        String name = intent.getStringExtra("name");


        location_ln = (RelativeLayout) view.findViewById(R.id.location_ln);
        location_ima = (ImageView) view.findViewById(R.id.location_ima);
        work_ln = (RelativeLayout) view.findViewById(R.id.work_ln);
        grade_ln = (RelativeLayout) view.findViewById(R.id.grade_ln);
        search_ln = (RelativeLayout) view.findViewById(R.id.search_ln);
        add_check = (CheckBox) view.findViewById(R.id.add_check);
        query_bt = (Button) view.findViewById(R.id.query_bt);
        ask_bt = (RadioButton) view.findViewById(R.id.ask_bt);
        phone_bt = (RadioButton) view.findViewById(R.id.phone_bt);
        hot_gridview = (GridView) view.findViewById(R.id.hot_gridview);
        location_ln_textview = (TextView) view.findViewById(R.id.location_ln_textview);
        query_bt.setOnClickListener(this);


//        location_ln_textview



        location_ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(getActivity(),ProvinceFragment.class));

//                Toast.makeText(getActivity(),"跳到省份",Toast.LENGTH_LONG).show();

            startActivity(new Intent(getActivity(),ProvinceFragment.class));


            }
        });


    }

    @Override
    protected View initlayout() {

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.query_bt:

                break;
        }
    }
}
