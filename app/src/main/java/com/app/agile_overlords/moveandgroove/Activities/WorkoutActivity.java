package com.app.agile_overlords.moveandgroove.Activities;

import android.app.ListActivity;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.app.agile_overlords.moveandgroove.Fragments.MainFragment;
import com.app.agile_overlords.moveandgroove.Fragments.UserFragment;
import com.app.agile_overlords.moveandgroove.Fragments.WorkoutFragment;
import com.app.agile_overlords.moveandgroove.R;

/**
 * Created by brittneyryn on 4/12/16.
 */
public class WorkoutActivity extends AppCompatActivity {
    private WorkoutFragment workoutFragment;
    private UserFragment userFragment;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        workoutFragment = workoutFragment.newInstance();

        workoutFragment.setOnBackPressed(new WorkoutFragment.OnBackPressed() {
            @Override
            public void backPressed() {
                onBackPressed();
            }
        });

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, workoutFragment)
                .addToBackStack(MainFragment.class.getSimpleName())
                .commit();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        /*if (getFragmentManager().getBackStackEntryCount() > 0)
            getFragmentManager().popBackStack();
        else
            super.onBackPressed();*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                userFragment = UserFragment.newInstance();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, userFragment)
                        .addToBackStack(UserFragment.class.getSimpleName())
                        .commit();
                Log.d("tag", "" +
                        "334534534545345345345345345here!@#!@$!$@#$@%");
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}