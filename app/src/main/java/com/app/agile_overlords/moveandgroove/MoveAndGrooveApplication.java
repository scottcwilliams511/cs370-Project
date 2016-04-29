package com.app.agile_overlords.moveandgroove;

import android.app.Application;

import com.app.agile_overlords.moveandgroove.Models.UserModel;

/**
 * Created by Never Forget on 4/26/2016.
 */
public class MoveAndGrooveApplication extends Application {

    private static UserModel userModel;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static UserModel getUserModel(){
        if(userModel == null) {
            userModel = new UserModel();
        }

        return userModel;
    }
}
