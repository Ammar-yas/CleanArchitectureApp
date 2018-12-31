package com.ammaryasser.cleanarchitectureapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ammaryasser.cleanarchitectureapp.components.DaggerHomeActivityComponent;
import com.ammaryasser.cleanarchitectureapp.components.HomeActivityComponent;
import com.ammaryasser.cleanarchitectureapp.modules.HomeActivityModule;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HomeActivityComponent homeActivityComponent = DaggerHomeActivityComponent.builder()
                .homeActivityModule(new HomeActivityModule(this))
                .githubApplicationComponent(App.get(this).getGithubApplicationComponent())
                .build();
        RepositoryAdapter repositoryAdapter = homeActivityComponent.repositoryAdapter();
    }
}
