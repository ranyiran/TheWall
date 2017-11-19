package com.ran.thewal.utils;

import android.content.Context;
import android.content.Intent;

import com.ran.thewal.activity.MainActivity;

/**
 * Created by Slim Shady on 2017/11/18.
 */
public class I2GO {

    public static void Go2MainActivity(Context mContext) {
        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);

    }
}
