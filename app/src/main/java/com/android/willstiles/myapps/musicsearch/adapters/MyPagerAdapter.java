package com.android.willstiles.myapps.musicsearch.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Will Stiles on 11/18/2017.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public MyPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return 2;
    }
}
