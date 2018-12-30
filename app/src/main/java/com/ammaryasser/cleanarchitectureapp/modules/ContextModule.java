package com.ammaryasser.cleanarchitectureapp.modules;

import android.content.Context;

import com.ammaryasser.cleanarchitectureapp.scopes.GithubApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @GithubApplicationScope
    public Context providesContext() {
        return context;
    }
}
