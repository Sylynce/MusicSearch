package com.android.willstiles.myapps.musicsearch.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.willstiles.myapps.musicsearch.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    private Button searchButton;
    private EditText searchBox;
    private SearchListener searchListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        bindViews(view);
        bindEvents();
        return view;
    }

    private void bindViews(View view){
        searchButton = (Button) view.findViewById(R.id.searchButton);
        searchBox = (EditText) view.findViewById(R.id.searchBox);
    }

    private void bindEvents(){
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchListener.startSearch(searchBox.getText().toString());
            }
        });
    }

    public void setSearchListener(SearchListener searchListener) {
        this.searchListener = searchListener;
    }

    public interface SearchListener {
        void startSearch(String searchParameters);
    }
}
