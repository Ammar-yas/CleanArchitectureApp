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
        GithubService githubService1 = githubApplicationComponent.getGithubService();
        Picasso picasso1 = githubApplicationComponent.getPicasso();
        GithubService githubService2 = githubApplicationComponent.getGithubService();
        Picasso picasso2 = githubApplicationComponent.getPicasso();
        GithubService githubService3 = githubApplicationComponent.getGithubService();
        Picasso picasso3 = githubApplicationComponent.getPicasso();
        Timber.e("Github service1: %S", githubService1);
        Timber.e("Picasso1 %s", picasso1);
        Timber.e("Github service1: %S", githubService2);
        Timber.e("Picasso1 %s", picasso2);
        Timber.e("Github service1: %S", githubService3);
        Timber.e("Picasso1 %s", picasso3);
    }
}
