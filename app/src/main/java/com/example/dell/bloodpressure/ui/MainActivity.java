package com.example.dell.bloodpressure.ui;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.dell.bloodpressure.R;
import com.example.dell.bloodpressure.base.BaseActivity;
import com.example.dell.bloodpressure.ui.bloodfragmnet.BloodFragment;
import com.example.dell.bloodpressure.ui.doctorfragment.DoctorFragment;
import com.example.dell.bloodpressure.ui.persionalfragment.PersionalFragment;
import com.example.dell.bloodpressure.utils.Netwoke;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    //网络状态工具类
    private Netwoke netwoke;
    //退出时的时间
    private long mExitTime;
    private RadioButton doctor_bt;
    private RadioButton blood_bt;
    private RadioButton persional_bt;
    private RadioGroup navi_group;
    private FrameLayout show_fm;
    private Fragment fdoctor,fblood,fpersional,mfragment;
    private ArrayList<Fragment> fragments;
    private FragmentManager fm;

    @Override
    protected void initresume() {

    }

    @Override
    protected void initdata() {

        initfragment();
    }

    private void initfragment() {

        fragments = new ArrayList<>();
        fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        fdoctor = new DoctorFragment();
        fblood = new BloodFragment();
        fpersional = new PersionalFragment();
        fragments.add(fdoctor);
        fragments.add(fblood);
        fragments.add(fpersional);
        mfragment = fdoctor;
        ft.add(R.id.show_fm,mfragment);
        ft.commitAllowingStateLoss();

    }

    @Override
    protected void initview() {
        doctor_bt = (RadioButton) findViewById(R.id.doctor_bt);
        blood_bt = (RadioButton) findViewById(R.id.blood_bt);
        persional_bt = (RadioButton) findViewById(R.id.persional_bt);
        navi_group = (RadioGroup) findViewById(R.id.navi_group);
        show_fm = (FrameLayout) findViewById(R.id.show_fm);

        doctor_bt.setOnClickListener(this);
        blood_bt.setOnClickListener(this);
        persional_bt.setOnClickListener(this);

    }

    @Override
    protected int initlayout() {
        return R.layout.activity_main;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.doctor_bt:

                switchfragment(fragments.get(0),mfragment);
                break;
            case R.id.blood_bt:

                switchfragment(fragments.get(1),mfragment);
                break;
            case R.id.persional_bt:

                switchfragment(fragments.get(2),mfragment);
                break;
        }
    }

    private void switchfragment(Fragment fnext, Fragment fnow) {

        if (mfragment != fnext) {

            mfragment = fnext;

            FragmentTransaction ft = fm.beginTransaction();

            if (fnext.isAdded()) {

                ft.hide(fnow).show(fnext).commitAllowingStateLoss();
            } else {

                ft.hide(fnow).add(R.id.show_fm,fnext).commitAllowingStateLoss();
            }

        }

    }

    //对返回键进行监听
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }

    //判断网络状态
    private void getnetwoke() {

        if (netwoke == null) {
            netwoke = new Netwoke();
        }

        String getnetwoke = netwoke.getnetwoke(MainActivity.this);

        Toast.makeText(MainActivity.this, getnetwoke, Toast.LENGTH_SHORT).show();

        if (getnetwoke.equals("网络无连接")) {
            setNetwork();
        }
    }

    private void setNetwork() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("无法连接网络");

        builder.setMessage("网络不可用，如果继续，请先设置网络！");

        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {

                Intent intent = null;

                /**

                 * 判断手机系统的版本！如果API大于10 就是3.0+

                 * 因为3.0以上的版本的设置和3.0以下的设置不一样，调用的方法不同

                 */

                if (Build.VERSION.SDK_INT > 10) {

                    intent = new Intent(Settings.ACTION_WIFI_SETTINGS);

                } else {

                    intent = new Intent();

                    ComponentName component = new ComponentName(

                            "com.android.settings",

                            "com.android.settings.WirelessSettings");

                    intent.setComponent(component);

                    intent.setAction("android.intent.action.VIEW");

                }

                startActivity(intent);

            }

        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

            @Override

            public void onClick(DialogInterface dialog, int which) {


            }

        });

        builder.create();

        builder.show();
    }

}
