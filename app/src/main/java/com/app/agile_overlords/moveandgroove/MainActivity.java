package com.app.agile_overlords.moveandgroove;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.fitness.Fitness;

import android.support.v4.app.FragmentActivity;

public class MyActivity extends FragmentActivity implements OnConnectionFailedListener{
    private GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //create a googleapiclient instance
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Fitness.API)
                .addScope(Fitness.Scope_file)
                .build();
        }

        @Override
        public void onConnectionFailed(ConnectionResult result) {
            //error message
        }

}