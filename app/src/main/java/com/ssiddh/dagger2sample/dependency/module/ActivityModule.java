package com.ssiddh.dagger2sample.dependency.module;

import android.app.Activity;
import android.content.Context;

import com.ssiddh.dagger2sample.dependency.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sudhanshu on 3/6/18.
 */

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    Activity provideActivity() {
        return activity;
    }

}
