package com.android.willstiles.myapps.musicsearch.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.willstiles.myapps.musicsearch.Models.Results;
import com.android.willstiles.myapps.musicsearch.Presenters.ResultsPresenter;
import com.android.willstiles.myapps.musicsearch.R;
import com.android.willstiles.myapps.musicsearch.adapters.RecyclerAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultsFragment extends Fragment implements ResultsPresenter.View {

    private RecyclerView listView;
    private ResultsPresenter presenter;

    private SearchFragment.SearchListener searchListener = new SearchFragment.SearchListener() {
        @Override
        public void startSearch(String searchParameters) {
            presenter.startSearch(searchParameters);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_results, container, false);
        bindViews(view);
        setupRecyclerView();
        presenter = new ResultsPresenter(this);
        return view;
    }

    private void setupRecyclerView(){
        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private void bindViews(View view){
        listView = view.findViewById(R.id.list);
    }


    @Override
    public void showResults(List<Results> music){
        listView.setAdapter(new RecyclerAdapter(music));
    }

    @Override
    public void onFailure() {
        Toast.makeText(getContext(),"There was an error while searching", Toast.LENGTH_LONG).show();
    }

    public SearchFragment.SearchListener getSearchListener() {
        return searchListener;
    }

}
