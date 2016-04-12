package com.app.agile_overlords.moveandgroove.Services;

import android.os.AsyncTask;

import com.app.agile_overlords.moveandgroove.Listeners.userCallbackListener;
import com.app.agile_overlords.moveandgroove.Models.UserModel;

/**
 * Created by brittneyryn on 4/9/16.
 */
public class UserTask extends AsyncTask<String, String, UserModel>{
    private userCallbackListener listener;

    public UserTask(final userCallbackListener listener){
        this.listener = listener;
    }

    @Override
    protected UserModel doInBackground(String... params) {
        return null;
    }

    @Override
    protected void onPostExecute(UserModel user) {
        super.onPostExecute(user);
        // Invoke the local listener which has a reference to the concretely implemented listener in SearchActivity
        listener.onSearchCallback(user);
    }


}
