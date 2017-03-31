package com.amir.bingerwallmvp;

import android.app.Application;

import com.amir.bingerwallmvp.data.component.DaggerNetComponent;
import com.amir.bingerwallmvp.data.component.NetComponent;
import com.amir.bingerwallmvp.data.module.AppModule;
import com.amir.bingerwallmvp.data.module.NetModule;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by amir on 3/19/17.
 */

public class App extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://www.bing.com"))
                .build();
    }


    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}