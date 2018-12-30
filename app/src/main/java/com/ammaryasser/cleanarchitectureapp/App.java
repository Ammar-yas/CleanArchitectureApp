package com.ammaryasser.cleanarchitectureapp;

import android.app.Application;

import com.ammaryasser.cleanarchitectureapp.components.DaggerGithubApplicationComponent;
import com.ammaryasser.cleanarchitectureapp.components.GithubApplicationComponent;
import com.ammaryasser.cleanarchitectureapp.modules.ContextModule;
import com.ammaryasser.cleanarchitectureapp.services.GithubService;
import com.squareup.picasso.Picasso;

import timber.log.Timber;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        GithubApplicationComponent githubApplicationComponent =
                DaggerGithubApplicationComponent.builder()
                        .contextModule(new ContextModule(this))
                        .build();
        GithubService githubService = githubApplicationComponent.getGithubService();
        Picasso picasso = githubApplicationComponent.getPicasso();
        Timber.e("Github service: %S", githubService);
        Timber.e("Picasso %s", picasso);
    }
}
