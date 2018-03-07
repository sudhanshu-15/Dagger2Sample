package com.ssiddh.dagger2sample.dependency.component;

import android.app.Application;
import android.content.Context;

import com.ssiddh.dagger2sample.SampleApplication;
import com.ssiddh.dagger2sample.data.DataManager;
import com.ssiddh.dagger2sample.data.DbHelper;
import com.ssiddh.dagger2sample.data.SharedPrefsHelper;
import com.ssiddh.dagger2sample.dependency.ApplicationContext;
import com.ssiddh.dagger2sample.dependency.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sudhanshu on 3/6/18.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(SampleApplication sampleApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();

}
