package com.ammaryasser.cleanarchitectureapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ammaryasser.cleanarchitectureapp.components.DaggerMainActivityComponent;
import com.ammaryasser.cleanarchitectureapp.components.MainActivityComponent;
import com.ammaryasser.cleanarchitectureapp.modules.HomeActivityModule;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Inject
    RepositoryAdapter repositoryAdapter;
    @Inject
    Picasso picasso4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivityComponent mainActivityComponent = DaggerMainActivityComponent.builder()
                .homeActivityModule(new HomeActivityModule(this))
                .githubApplicationComponent(App.get(this).getGithubApplicationComponent())
                .build();
        mainActivityComponent.inject(this);
        Timber.e("Picasso4 %s", picasso4);

    }
}
