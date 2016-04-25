package com.app.agile_overlords.moveandgroove.Activities;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.app.agile_overlords.moveandgroove.Fragments.MainFragment;
import com.app.agile_overlords.moveandgroove.Fragments.UserFragment;
import com.app.agile_overlords.moveandgroove.Models.UserModel;
import com.app.agile_overlords.moveandgroove.R;

/**
 * Created by brittneyryn on 4/8/16.
 */
public class MainActivity extends AppCompatActivity {

    private MainFragment mainFragment;
    private UserFragment userFragment;
    private DrawerLayout mDrawer;
    private Toolbar toolbar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFragment = MainFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mainFragment)
                .addToBackStack(MainFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public void onBackPressed(){
        if(getFragmentManager().getBackStackEntryCount() > 0)
            getFragmentManager().popBackStack();
        else
            super.onBackPressed();
    }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
    // `onPostCreate` called when activity start-up is complete after `onStart()`
    // NOTE! Make sure to override the method with only a single `Bundle` argument
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}


