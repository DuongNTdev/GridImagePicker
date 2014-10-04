/*
 * Copyright 2014 Habzy Huang
 */
package com.habzy.image.picker;

import java.util.ArrayList;

import com.jfeinstein.jazzyviewpager.JazzyViewPager;
import com.jfeinstein.jazzyviewpager.JazzyViewPager.TransitionEffect;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewPagerDialogFragment extends DialogFragment {

    private static final String TAG = ViewPagerDialogFragment.class.getName();
    private JazzyViewPager mJazzy;
    private int mCurrentItem;
    private ArrayList<GridItemModel> mModelsList;

    public ViewPagerDialogFragment(ArrayList<GridItemModel> modelsList, int currentItem) {
        mModelsList = modelsList;
        mCurrentItem = currentItem;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "====== OnCreate.");
    }

    @SuppressLint("InflateParams")
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "====== onCreateView.");
        View view_pager = inflater.inflate(R.layout.view_pager, null);
        mJazzy = (JazzyViewPager) view_pager.findViewById(R.id.jazzy_pager);
        mJazzy.setTransitionEffect(TransitionEffect.Tablet);
        mJazzy.setImagePath(mModelsList);
        mJazzy.setCurrentItem(mCurrentItem);
        mJazzy.setPageMargin(0);

        return mJazzy;
    }

}
