package com.amir.bingerwallmvp.data.component;

import android.content.SharedPreferences;

import com.amir.bingerwallmvp.data.module.AppModule;
import com.amir.bingerwallmvp.data.module.NetModule;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by amir on 3/19/17.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    // downstream components need these exposed with the return type
    // method name does not really matter
    Retrofit retrofit();
    OkHttpClient okHttpClient();
    Gson gson();
    SharedPreferences sharedPreferences();
}
