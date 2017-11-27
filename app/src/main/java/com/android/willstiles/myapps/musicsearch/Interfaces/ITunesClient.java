package com.android.willstiles.myapps.musicsearch.Interfaces;

import com.android.willstiles.myapps.musicsearch.Models.ResultsWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Will Stiles on 11/21/2017.
 */

public interface ITunesClient {
    @GET("search{search}")
    Call<ResultsWrapper> searchITunes(@Path("search") String searchParameters);
}
