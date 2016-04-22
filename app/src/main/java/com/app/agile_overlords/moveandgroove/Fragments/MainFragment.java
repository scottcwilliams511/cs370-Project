package com.app.agile_overlords.moveandgroove.Fragments;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

<<<<<<< HEAD

import com.app.agile_overlords.moveandgroove.Activities.CalendarActivity;
=======
import com.app.agile_overlords.moveandgroove.Activities.DataActivity;
>>>>>>> scottwbranch3
import com.app.agile_overlords.moveandgroove.Activities.SearchActivity;
import com.app.agile_overlords.moveandgroove.Activities.WorkoutActivity;
import com.app.agile_overlords.moveandgroove.Models.UserModel;
import com.app.agile_overlords.moveandgroove.R;
import com.app.agile_overlords.moveandgroove.TestExerciseDB_Activity;

/**
 * Created by brittneyryn on 4/8/16.
 */
public class MainFragment extends Fragment implements SensorEventListener{


    private Button userButton;
    private Button workoutButton;
    private Button foodButton;
    private Button calendarButton;
    private Button weightButton;
    private Button dataButton;
    private TextView steps;

    private LinearLayoutManager layoutManager;
    private OnFragmentEvent onFragmentEvent;

    // For the Sensor
    private TextView textView;
    private SensorManager mSensorManager;
    private Sensor mStepCounterSensor;
    private Sensor mStepDetectorSensor;
    private SensorEventListener sensorEventListener;

    // For Navi drawer

    private DrawerLayout mDrawer;
    private Toolbar toolbar;






    public MainFragment(){

    }


    public static MainFragment newInstance(){
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       mSensorManager = (SensorManager)
               getActivity().getSystemService(Context.SENSOR_SERVICE);
       mStepCounterSensor = mSensorManager
               .getDefaultSensor((Sensor.TYPE_STEP_COUNTER));
       mStepDetectorSensor = mSensorManager
               .getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);

    }

  /* public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        float[] values = event.values;
        int value = -1;

        if(values.length > 0) {
            value = (int) values[0];
        }
        if(sensor.getType()== Sensor.TYPE_STEP_COUNTER) {
            textView.setText("Step Counter Detected L " + value);
        } else if(sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            textView.setText("Step Detector Detected : " + value);
        }
    }*/

    public void onResume() {
       super.onResume();
       mSensorManager.registerListener(this, mStepCounterSensor,
               SensorManager.SENSOR_DELAY_FASTEST);
        mSensorManager.registerListener(this, mStepDetectorSensor,
                SensorManager.SENSOR_DELAY_FASTEST);
    }

    public void onStop() {
       super.onStop();
        mSensorManager.unregisterListener(this, mStepCounterSensor);
        mSensorManager.unregisterListener(this, mStepDetectorSensor);

    }


    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
        //compiler wanted this here, don't know what it's for
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        steps = (TextView)view.findViewById(R.id.steps);
        // TODO: Fix progress bar
        final ProgressBar progressBar = (ProgressBar)view.findViewById(R.id.circularProgressbar);
        progressBar.setMax(10000);
       // ObjectAnimator animation = ObjectAnimator.ofInt (progressBar, "Steps", 0, 10000); // see this max value coming back here, we animale towards that value
       // animation.setInterpolator (new DecelerateInterpolator());
        progressBar.post(new Runnable() {
            @Override
            public void run() {
                progressBar.setProgress(0);
            }
        });

        //animation.start ();

        // TODO: Get steps to display

       /*mSensorManager = (SensorManager)
                getActivity().getSystemService(Context.SENSOR_SERVICE);
        mStepCounterSensor = mSensorManager
                .getDefaultSensor((Sensor.TYPE_STEP_COUNTER));
        mStepDetectorSensor = mSensorManager
                .getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);*/
        sensorEventListener = new SensorEventListener() {
            public void onSensorChanged(SensorEvent event) {
                Sensor sensor = event.sensor;
                float[] values = event.values;
                int value = -1;

                if (values.length > 0) {
                    value = (int) values[0];
                }
                if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
                    steps.setText("Step Counter Detected L " + value);
                    progressBar.setProgress(value);
                } else if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
                    steps.setText("Step Detector Detected : " + value);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };


        //mSensorManager.registerListener(sensorEventListener, mSensor, mSensorManager.SENSOR_DELAY_FASTEST);




        userButton = (Button)view.findViewById(R.id.userButton);
        workoutButton = (Button)view.findViewById(R.id.workoutButton);
        foodButton =  (Button)view.findViewById(R.id.foodButton);
        calendarButton = (Button)view.findViewById(R.id.calendarButton);
        weightButton = (Button)view.findViewById(R.id.weightButton);
        dataButton = (Button)view.findViewById(R.id.dataButton);
<<<<<<< HEAD

=======
>>>>>>> scottwbranch3


        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, UserFragment.newInstance())
                        .addToBackStack(UserFragment.class.getSimpleName())
                        .commit();
            }

        });

        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SearchActivity.class);
                startActivity(i);
            }
        });

        weightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, WeightFragment.newInstance())
                        .addToBackStack(WeightFragment.class.getSimpleName())
                        .commit();
            }

        });

        calendarButton.setOnClickListener(new View.OnClickListener(){
            @Override
        public void onClick(View v){
                Intent i = new Intent(getActivity(), CalendarActivity.class);
                startActivity(i);

            }
        });

        workoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), WorkoutActivity.class);
                startActivity(i);
            }

        });

<<<<<<< HEAD

        dataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), TestExerciseDB_Activity.class);
=======
        dataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(getActivity(), DataActivity.class);
>>>>>>> scottwbranch3
                startActivity(i);
            }
        });
        return view;


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach(){
        super.onDetach();
    }

    public void setOnFragmentEvent(OnFragmentEvent onFragmentEvent) {
        this.onFragmentEvent = onFragmentEvent;
    }
    public interface OnFragmentEvent {
        void onEvent(UserModel item);
    }

}
