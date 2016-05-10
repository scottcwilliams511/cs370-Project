package com.app.agile_overlords.moveandgroove.Activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
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
        //Time now = new Time();
        //now.setToNow();
//        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity);
        //super.onCreateDrawer();
        setContentView(R.layout.activity_main);
        //  toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        //setSupportActionBar(toolbar);


        myDb = new MySQLiteHelper(this);

        myDb.open();


        myDb.deleteAllUsers();
        myDb.insertSingleUser();

        myDb.close();

        //getPreferences()
//        if(CalorieSingleton.getCalorieSingleton() == null)
//            CalorieSingleton.setCalorieSingleton(0.0);

//        MoveAndGrooveApplication.getUserModel().SetFirstName(MySQLiteHelper.FIRST_NAME);
//        MoveAndGrooveApplication.getUserModel().SetLastName(MySQLiteHelper.LAST_NAME);
//        Float convertWeight = Float.parseFloat(MySQLiteHelper.WEIGHT);
//        MoveAndGrooveApplication.getUserModel().SetWeight(convertWeight);
//        MoveAndGrooveApplication.getUserModel().SetSex(MySQLiteHelper.SEX);
//        Integer convertAge = Integer.parseInt(MySQLiteHelper.AGE);
//        MoveAndGrooveApplication.getUserModel().SetAge(convertAge);
//        Integer convertHtft = Integer.parseInt(MySQLiteHelper.HEIGHT_FEET);
//        MoveAndGrooveApplication.getUserModel().SetHeightFeet(convertHtft);
//        Integer convertHtin = Integer.parseInt(MySQLiteHelper.HEIGHT_INCHES);
//        MoveAndGrooveApplication.getUserModel().SetHeightInches(convertHtin);
//        Float convertWeek = Float.parseFloat(MySQLiteHelper.WEEKLY_GOAL);
//        MoveAndGrooveApplication.getUserModel().SetWeeklyGoal(convertWeek);
//        Float convertGoal = Float.parseFloat(MySQLiteHelper.GOAL_WEIGHT);
//        MoveAndGrooveApplication.getUserModel().SetGoalWeight(convertGoal);


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
                userFragment.newInstance();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, userFragment)
                        .addToBackStack(UserFragment.class.getSimpleName())
                        .commit();

                return true;
            //case R.id.action_music:
            //showHelp();
            //return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

