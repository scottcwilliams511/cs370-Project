package com.app.agile_overlords.moveandgroove;

import android.app.Application;

/**
 * Created by Never Forget on 5/5/2016.
 */
public class CalorieSingleton extends Application {

    private static Double calorieSingleton;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static Double getCalorieSingleton() {
        return calorieSingleton;
    }

    public static void setCalorieSingleton(Double calorieSingleton) {
        CalorieSingleton.calorieSingleton = calorieSingleton;
    }
}
