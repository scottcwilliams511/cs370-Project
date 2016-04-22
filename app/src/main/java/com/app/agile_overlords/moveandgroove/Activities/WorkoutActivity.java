package com.app.agile_overlords.moveandgroove.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.agile_overlords.moveandgroove.Fragments.MainFragment;
import com.app.agile_overlords.moveandgroove.Fragments.WorkoutFragment;
import com.app.agile_overlords.moveandgroove.R;

/**
 * Created by brittneyryn on 4/12/16.
 */
public class WorkoutActivity extends AppCompatActivity {
    private WorkoutFragment workoutFragment;
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
    }
}
