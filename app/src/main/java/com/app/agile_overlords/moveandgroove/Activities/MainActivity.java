package com.app.agile_overlords.moveandgroove.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import java.lang.Object;
import android.widget.FrameLayout;


import com.app.agile_overlords.moveandgroove.Fragments.MainFragment;
import com.app.agile_overlords.moveandgroove.Fragments.SearchFragment;
import com.app.agile_overlords.moveandgroove.Fragments.UserFragment;
import com.app.agile_overlords.moveandgroove.Models.UserModel;
import com.app.agile_overlords.moveandgroove.R;

/**
 * Created by brittneyryn on 4/8/16.
 */
public class MainActivity extends AppCompatActivity {
    private MainFragment mainFragment;
    private UserFragment userFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_display);
        mainFragment = MainFragment.newInstance();

        mainFragment.setOnFragmentEvent(new MainFragment.OnFragmentEvent() {

            public void onEvent(UserModel user) {
                userFragment = UserFragment.newInstance();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, userFragment)
                        .addToBackStack(UserFragment.class.getSimpleName())
                        .commit();
            }

        });
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mainFragment)
                .addToBackStack(MainFragment.class.getSimpleName())
                .commit();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}