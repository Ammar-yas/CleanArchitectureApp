package com.ammaryasser.cleanarchitectureapp.modules;

import android.content.Context;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

@Module(includes = ContextModule.class)
public class NetworkModule {

    @Provides
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    public HttpLoggingInterceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
    }

    @Provides
    public File providesFile(Context context) {
        String cacheFileName = "okhttp_cache";
        return new File(context.getCacheDir(), cacheFileName);
    }

    @Provides
    public Cache provideCache(File cacheFile) {
        int tenMegaBytes = 10 * 1000 * 1000;
        return new Cache(cacheFile, tenMegaBytes);
    }

}
