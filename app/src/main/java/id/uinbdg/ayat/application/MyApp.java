package id.uinbdg.ayat.application;

import android.app.Application;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;

import java.util.concurrent.TimeUnit;

import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;
import io.objectbox.android.BuildConfig;
import okhttp3.OkHttpClient;

public class MyApp extends Application {
    private BoxStore boxStore;
    @Override
    public void onCreate() {
        super.onCreate();

    }

}
