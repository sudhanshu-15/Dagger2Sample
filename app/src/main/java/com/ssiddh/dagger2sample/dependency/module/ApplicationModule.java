package com.ssiddh.dagger2sample.dependency.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.ssiddh.dagger2sample.dependency.ApplicationContext;
import com.ssiddh.dagger2sample.dependency.DatabaseInfo;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sudhanshu on 3/6/18.
 */
@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    Application provideApplication() {
        return application;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return "test-dagger.db";
    }

    @Provides
    @DatabaseInfo
    Integer provideDatabaseVersion() {
        return 2;
    }

    @Provides
    SharedPreferences provideSharedPrefs() {
        return application.getSharedPreferences("test-prefs", Context.MODE_PRIVATE);
    }

}
