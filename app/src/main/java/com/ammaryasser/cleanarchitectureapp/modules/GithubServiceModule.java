package com.ammaryasser.cleanarchitectureapp.modules;

import com.ammaryasser.cleanarchitectureapp.services.GithubService;
import com.ammaryasser.cleanarchitectureapp.utils.Constants;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class GithubServiceModule {

    @Provides
    public GithubService getGithubService(Retrofit githubRetrofit) {
        return githubRetrofit.create(GithubService.class);
    }

    @Provides
    public Retrofit getRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl(Constants.githubServiceBaseUrl)
                .build();
    }

}
