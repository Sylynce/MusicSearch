package com.android.willstiles.myapps.musicsearch.Presenters;

import com.android.willstiles.myapps.musicsearch.Interfaces.ITunesClient;
import com.android.willstiles.myapps.musicsearch.Models.Results;
import com.android.willstiles.myapps.musicsearch.Models.ResultsWrapper;
import com.android.willstiles.myapps.musicsearch.Utils.StringReplaceInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Will Stiles on 11/18/2017.
 */

public class ResultsPresenter implements Callback<ResultsWrapper> {

    private static final String BASE_URL = "https://itunes.apple.com/";
    private View view;

    public ResultsPresenter(View view){
        this.view = view;
    }

    public void startSearch(String searchParameters) {
        String endPoint = buildSearchEndpoint(searchParameters);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new StringReplaceInterceptor())
                .build();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ITunesClient service = retrofit.create(ITunesClient.class);
        Call<ResultsWrapper> call = service.searchITunes(endPoint);
        call.enqueue(this);
    }

    private String buildSearchEndpoint(String searchParameters) {
        searchParameters = searchParameters.trim().replace(' ', '+');
        return "?term=" + searchParameters + "&media=music";
    }

    @Override
    public void onResponse(Call<ResultsWrapper> call, Response<ResultsWrapper> response) {
        if (response.isSuccessful()) {
            List<Results> results = Arrays.asList(response.body().getResults());
            view.showResults(results);
        }
    }

    @Override
    public void onFailure(Call<ResultsWrapper> call, Throwable t) {
        view.onFailure();
    }

    public interface View {
        void showResults(List<Results> list);
        void onFailure();
    }
}
