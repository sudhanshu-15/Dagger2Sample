package com.ssiddh.dagger2sample.data;

import android.content.Context;
import android.content.res.Resources;

import com.ssiddh.dagger2sample.data.model.User;
import com.ssiddh.dagger2sample.dependency.ApplicationContext;

import javax.inject.Inject;

/**
 * Created by sudhanshu on 3/6/18.
 */

public class DataManager {

    private Context context;
    private DbHelper dbHelper;
    private SharedPrefsHelper sharedPrefsHelper;

    @Inject
    public DataManager(@ApplicationContext Context context,
                       DbHelper dbHelper,
                       SharedPrefsHelper sharedPrefsHelper) {
        this.context = context;
        this.dbHelper = dbHelper;
        this.sharedPrefsHelper = sharedPrefsHelper;
    }

    public void saveAccessToken(String accessToken) {
        sharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public  String getAccessToken() {
        return sharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

    public Long createUser(User user) throws Exception {
        return dbHelper.insertUser(user);
    }

    public User getUser(Long userId) throws Resources.NotFoundException, NullPointerException {
        return dbHelper.getUser(userId);
    }
}
