package com.ran.thewal.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ran.thewal.fragment.FindAndLostFragment;
import com.ran.thewal.fragment.NonameFragment;
import com.ran.thewal.fragment.TheHeart;

/**
 * Created by Slim Shady on 2017/12/18.
 */
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private String[] mTitles = new String[]{"随心爱", "寻物", "匿名"};

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new FindAndLostFragment();
        } else if (position == 2) {
            return new NonameFragment();
        }
        return new TheHeart();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    //用来设置tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }


}
