package com.amir.bingerwallmvp.util;

import com.amir.bingerwallmvp.data.Post;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by amir on 3/31/17.
 */

public interface service {
    @GET("/HPImageArchive.aspx?format=js&idx=0&n=18&mkt=en-US")
    Observable<Post> getPostList();
}
