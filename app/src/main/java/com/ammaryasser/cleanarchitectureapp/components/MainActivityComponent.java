package com.ammaryasser.cleanarchitectureapp.components;

import com.ammaryasser.cleanarchitectureapp.MainActivity;
import com.ammaryasser.cleanarchitectureapp.modules.HomeActivityModule;
import com.ammaryasser.cleanarchitectureapp.scopes.MainActivityScope;

import dagger.Component;

@MainActivityScope
@Component(modules = HomeActivityModule.class, dependencies = GithubApplicationComponent.class)
public interface MainActivityComponent {
    public void inject(MainActivity mainActivity);
}

