package com.ran.thewal.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.ran.thewal.R;
import com.ran.thewal.utils.I2GO;

import cn.bmob.v3.Bmob;

public class SplashActivity extends AppCompatActivity {
    final Handler mHandler = new Handler();
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //MainActivity中对Bmob进行初始化
        mContext = this;
        Bmob.initialize(mContext, "5fd204589fb3f06c7901d470a8509901");
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                I2GO.Go2LoginActivity((Activity) mContext);
            }
        }, 2000);
    }
}
