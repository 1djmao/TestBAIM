package com.example.testbaim;

import android.app.Application;

import com.qim.basdk.BAIM;

public class BAApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        BAIM.getInstance().init(this);
    }
}
