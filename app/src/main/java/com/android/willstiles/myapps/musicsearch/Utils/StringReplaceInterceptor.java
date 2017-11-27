package com.android.willstiles.myapps.musicsearch.Utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Will Stiles on 11/26/2017.
 */

public class StringReplaceInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        String url = request.url().toString();
        url = url.replace("%3F", "?");
        Request newRequest = new Request.Builder()
                .url(url)
                .build();
        return chain.proceed(newRequest);
    }
}
