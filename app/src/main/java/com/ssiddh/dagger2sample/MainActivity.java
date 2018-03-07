package com.ssiddh.dagger2sample;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ssiddh.dagger2sample.data.DataManager;
import com.ssiddh.dagger2sample.data.model.User;
import com.ssiddh.dagger2sample.dependency.component.ActivityComponent;
import com.ssiddh.dagger2sample.dependency.component.DaggerActivityComponent;
import com.ssiddh.dagger2sample.dependency.module.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    DataManager dataManager;

    private ActivityComponent activityComponent;

    private TextView textViewUserInfo;
    private TextView textViewAccessToken;

    public ActivityComponent getActivityComponent() {
        if(activityComponent == null) {
            activityComponent = DaggerActivityComponent
                    .builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(SampleApplication.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        textViewUserInfo = (TextView) findViewById(R.id.user_info);
        textViewAccessToken = (TextView) findViewById(R.id.access_token);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createUser();
        getUser();
        dataManager.saveAccessToken("ASDR12443JFDJF43543J543H3K543");

        String token = dataManager.getAccessToken();
        if(token != null) {
            textViewAccessToken.setText(token);
        }
    }

    private void createUser() {
        try {
            dataManager.createUser(new User("John", "2100 E Linglebach"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getUser() {
        try {
            User user = dataManager.getUser(1L);
            textViewUserInfo.setText(user.toString());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
