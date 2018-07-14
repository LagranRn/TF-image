package com.example.administrator.tfimaege.base;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.v4.content.ContextCompat;

public class BaseApp extends Application {
    public static Context sContext;

    @Override
    public void onCreate() {
        sContext = getApplicationContext();
        super.onCreate();
    }

    public static Context getContext() {
        return sContext;
    }
}
