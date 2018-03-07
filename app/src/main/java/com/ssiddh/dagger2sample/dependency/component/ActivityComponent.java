package com.ssiddh.dagger2sample.dependency.component;

import com.ssiddh.dagger2sample.MainActivity;
import com.ssiddh.dagger2sample.dependency.PerActivity;
import com.ssiddh.dagger2sample.dependency.module.ActivityModule;

import dagger.Component;

/**
 * Created by sudhanshu on 3/6/18.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}


