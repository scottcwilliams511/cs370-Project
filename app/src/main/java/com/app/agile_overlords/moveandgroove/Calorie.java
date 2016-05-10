package com.app.agile_overlords.moveandgroove;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Never Forget on 5/7/2016.
 */
public class Calorie {
    private SharedPreferences sharedPreferences;
    private static String PREF_NAME = "prefs";

    public Calorie() {

    }

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static Float getCalorie(Context context) {
        return getPrefs(context).getFloat("calorie", 0);
    }

    public static void setCalorie(Context context, Float calorie) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putFloat("calorie", calorie);
        editor.commit();
    }

    public static void clearCalorie(Context context) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putFloat("calorie", 0);
        editor.commit();
    }
}
