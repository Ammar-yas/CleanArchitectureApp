package com.ammaryasser.cleanarchitectureapp.modules;

import com.ammaryasser.cleanarchitectureapp.services.GithubService;
import com.ammaryasser.cleanarchitectureapp.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = NetworkModule.class)
public class GithubServiceModule {

    @Provides
    public GithubService getGithubService(Retrofit githubRetrofit) {
        return githubRetrofit.create(GithubService.class);
    }

    @Provides
    public Gson procidesGson() {
        return new GsonBuilder()
                //. register adapter time adapter
                .create();
    }

    @Provides
    public Retrofit getRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl(Constants.GITHUB_BASE_URL)
                .build();
    }

}
