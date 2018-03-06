package com.ssiddh.dagger2sample;

import android.app.Application;
import android.content.Context;

import com.ssiddh.dagger2sample.data.DataManager;

import javax.inject.Inject;

/**
 * Created by sudhanshu on 3/6/18.
 */

public class SampleApplication extends Application {

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static SampleApplication get(Context context) {
        return (SampleApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                                .builder()
                                .applicationModule(new ApplicationModule(this))
                                .build();

        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

}
