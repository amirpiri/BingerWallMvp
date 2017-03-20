package com.amir.bingerwallmvp.mainscreen;

import com.amir.bingerwallmvp.util.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by amir on 3/19/17.
 */

@Module
public class MainScreenModule {
    private final MainScreenContract.View mView;


    public MainScreenModule(MainScreenContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    MainScreenContract.View providesMainScreenContractView() {
        return mView;
    }
}

