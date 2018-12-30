package com.ammaryasser.cleanarchitectureapp.components;

import com.ammaryasser.cleanarchitectureapp.modules.GithubServiceModule;
import com.ammaryasser.cleanarchitectureapp.modules.PicassoModule;
import com.ammaryasser.cleanarchitectureapp.scopes.GithubApplicationScope;
import com.ammaryasser.cleanarchitectureapp.services.GithubService;
import com.squareup.picasso.Picasso;

import dagger.Component;

@GithubApplicationScope
@Component(modules = {GithubServiceModule.class, PicassoModule.class})
public interface GithubApplicationComponent {

    Picasso getPicasso();

    GithubService getGithubService();

}
