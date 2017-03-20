package com.amir.bingerwallmvp.mainscreen;

import com.amir.bingerwallmvp.data.component.NetComponent;
import com.amir.bingerwallmvp.util.CustomScope;

import dagger.Component;

/**
 * Created by amir on 3/19/17.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainActivity activity);
}
