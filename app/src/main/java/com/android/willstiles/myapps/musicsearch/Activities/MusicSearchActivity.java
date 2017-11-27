package com.android.willstiles.myapps.musicsearch.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.android.willstiles.myapps.musicsearch.Fragments.ResultsFragment;
import com.android.willstiles.myapps.musicsearch.Fragments.SearchFragment;
import com.android.willstiles.myapps.musicsearch.R;
import com.android.willstiles.myapps.musicsearch.adapters.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MusicSearchActivity extends FragmentActivity {

    private ViewPager mainPager;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_search);
        bindViews();
        buildFragments();
        setupViewPager();
    }

    private void bindViews(){
        mainPager = findViewById(R.id.pager);
    }

    private void setupViewPager(){
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), fragments);
        mainPager.setAdapter(adapter);
    }

    private void buildFragments(){
        ResultsFragment resultsFragment = new ResultsFragment();
        SearchFragment searchFragment = new SearchFragment();
        searchFragment.setSearchListener(getSearchListener(resultsFragment.getSearchListener()));
        fragments = new ArrayList<>();
        fragments.add(searchFragment);
        fragments.add(resultsFragment);
    }

    private SearchFragment.SearchListener getSearchListener(final SearchFragment.SearchListener searchListener) {
        return new SearchFragment.SearchListener() {
            @Override
            public void startSearch(String searchParameters) {
                searchListener.startSearch(searchParameters);
                mainPager.setCurrentItem(1);
            }
        };
    }
}

