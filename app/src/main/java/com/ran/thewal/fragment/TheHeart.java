package com.ran.thewal.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ran.thewal.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TheHeart extends Fragment {


    public TheHeart() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_suixin, container, false);
        return view;
    }

}
