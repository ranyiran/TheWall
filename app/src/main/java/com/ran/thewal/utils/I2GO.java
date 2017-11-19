package com.ran.thewal.utils;

import android.app.Activity;
import android.content.Intent;

import com.ran.thewal.R;
import com.ran.thewal.activity.LoginActivity;
import com.ran.thewal.activity.MainActivity;
import com.ran.thewal.activity.RegisteActivity;

/**
 * Created by Slim Shady on 2017/11/18.
 */
public class I2GO {

    public static void Go2MainActivity(Activity mContext) {
        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);
        mContext.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);

    }


    public static void Go2LoginActivity(Activity mContext) {
        Intent intent = new Intent(mContext, LoginActivity.class);
        mContext.startActivity(intent);
        mContext.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }
    public static void Go2RegistActivity(Activity mContext) {
        Intent intent = new Intent(mContext, RegisteActivity.class);
        mContext.startActivity(intent);
        mContext.overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
    }
}
