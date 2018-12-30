package com.ammaryasser.cleanarchitectureapp.components;

import com.ammaryasser.cleanarchitectureapp.modules.GithubServiceModule;
import com.ammaryasser.cleanarchitectureapp.services.GithubService;
import com.squareup.picasso.Picasso;

import dagger.Component;

@Component(modules = GithubServiceModule.class)
public interface GithubApplicationComponent {

    Picasso getPicasso();

    GithubService getGithubService();

}
