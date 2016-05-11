package com.app.agile_overlords.moveandgroove.Activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.app.agile_overlords.moveandgroove.CalorieSingleton;
import com.app.agile_overlords.moveandgroove.Fragments.MainFragment;
import com.app.agile_overlords.moveandgroove.Fragments.UserFragment;
import com.app.agile_overlords.moveandgroove.Models.UserModel;
import com.app.agile_overlords.moveandgroove.MoveAndGrooveApplication;
import com.app.agile_overlords.moveandgroove.MySQLiteHelper;
import com.app.agile_overlords.moveandgroove.R;

import java.sql.Time;

/**
 * Created by brittneyryn on 4/8/16.
 */
public class MainActivity extends AppCompatActivity {

    private MySQLiteHelper myDb;
    private MainFragment mainFragment;
    private UserFragment userFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myDb = new MySQLiteHelper(this);

        myDb.open();


        myDb.deleteAllUsers();
        myDb.insertSingleUser();

        myDb.close();

        mainFragment = MainFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mainFragment)
                .addToBackStack(MainFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0)
            getFragmentManager().popBackStack();
        else
            super.onBackPressed();
    }

    // `onPostCreate` called when activity start-up is complete after `onStart()`
    // NOTE! Make sure to override the method with only a single `Bundle` argument
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
    Log.d("tag" ,"" +
            "334534534545345345345345345here!@#!@$!$@#$@%");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

