package com.ammaryasser.cleanarchitectureapp.modules;

import com.ammaryasser.cleanarchitectureapp.MainActivity;
import com.ammaryasser.cleanarchitectureapp.RepositoryAdapter;
import com.ammaryasser.cleanarchitectureapp.scopes.MainActivityScope;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeActivityModule {

    private final MainActivity mainActivity;

    public HomeActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @MainActivityScope
    public RepositoryAdapter providesRepositoryAdapter(Picasso picasso) {
        return new RepositoryAdapter(mainActivity, picasso);
    }
}
