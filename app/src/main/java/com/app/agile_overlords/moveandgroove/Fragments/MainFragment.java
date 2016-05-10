package com.app.agile_overlords.moveandgroove.Fragments;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
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
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.app.agile_overlords.moveandgroove.FitChart.Widgets.FitChart;
import com.app.agile_overlords.moveandgroove.FitChart.Widgets.FitChartValue;
import com.app.agile_overlords.moveandgroove.Models.UserModel;
import com.app.agile_overlords.moveandgroove.R;

import java.util.ArrayList;
import java.util.Collection;

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
    private Integer numSteps = 0;
    private FitChart fitChart;

    private LinearLayoutManager layoutManager;
    private OnFragmentEvent onFragmentEvent;

    // For the Sensor
    private TextView textView;
    private SensorManager mSensorManager;
    private Sensor mStepCounterSensor;
    private Sensor mStepDetectorSensor;
    private SensorEventListener sensorEventListener;
    private ProgressBar progressBar;

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

    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        float[] values = event.values;
        int value = -1;

        if(values.length > 0) {
            value = (int) values[0];
        }
        if(sensor.getType()== Sensor.TYPE_STEP_COUNTER) {
            steps.setText(value + " steps today");
            numSteps = value;
//            progressBar.setProgress(value);
        } else if(sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            steps.setText("Step Detector Detected : " + value);
        }

      numSteps = value;
      Resources resources = getResources();
      Collection<FitChartValue> fvalues = new ArrayList<>();
      fvalues.add(new FitChartValue(numSteps, resources.getColor(R.color.chart_value_1)));
      if(numSteps >= 1500)
          fvalues.add(new FitChartValue(numSteps, resources.getColor(R.color.chart_value_2)));
      if(numSteps >= 3500)
          fvalues.add(new FitChartValue(numSteps, resources.getColor(R.color.chart_value_3)));
      if(numSteps >= 7500)
          fvalues.add(new FitChartValue(numSteps, resources.getColor(R.color.chart_value_4)));
      fitChart.setValues(fvalues);

    }

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


    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
        //compiler wanted this here, don't know what it's for
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        steps = (TextView)view.findViewById(R.id.steps);
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "Aller_Bd.ttf");
        steps.setTypeface(font);

        // TODO: Get steps to display

       /*mSensorManager = (SensorManager)
                getActivity().getSystemService(Context.SENSOR_SERVICE);
        mStepCounterSensor = mSensorManager
                .getDefaultSensor((Sensor.TYPE_STEP_COUNTER));
        mStepDetectorSensor = mSensorManager
                .getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);*/

/*        final FitChart fitChart = (FitChart)findViewById(R.id.fitChart);
        fitChart.setMinValue(0f);
        fitChart.setMaxValue(100f);

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources resources = getResources();
                Collection<FitChartValue> values = new ArrayList<>();
                values.add(new FitChartValue(30f, resources.getColor(R.color.chart_value_1)));
                values.add(new FitChartValue(20f, resources.getColor(R.color.chart_value_2)));
                values.add(new FitChartValue(15f, resources.getColor(R.color.chart_value_3)));
                values.add(new FitChartValue(10f, resources.getColor(R.color.chart_value_4)));
                fitChart.setValues(values);
            }
        });
    }
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
                    //progressBar.setProgress(value);
                } else if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
                    steps.setText("Step Detector Detected : " + value);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
*/

        //mSensorManager.registerListener(sensorEventListener, mSensor, mSensorManager.SENSOR_DELAY_FASTEST);

        fitChart = (FitChart)view.findViewById(R.id.fitChart);
        fitChart.setMinValue(0f);
        fitChart.setMaxValue(10000f);

        Resources resources = getResources();
        Collection<FitChartValue> values = new ArrayList<>();
        values.add(new FitChartValue(numSteps, resources.getColor(R.color.chart_value_1)));
        if(numSteps >= 1500)
            values.add(new FitChartValue(numSteps, resources.getColor(R.color.chart_value_2)));
        if(numSteps >= 3500)
            values.add(new FitChartValue(numSteps, resources.getColor(R.color.chart_value_3)));
        if(numSteps >= 7500)
            values.add(new FitChartValue(numSteps, resources.getColor(R.color.chart_value_4)));
        fitChart.setValues(values);


        //userButton = (Button)view.findViewById(R.id.userButton);
        workoutButton = (Button)view.findViewById(R.id.workoutButton);
        foodButton =  (Button)view.findViewById(R.id.foodButton);
        weightButton = (Button)view.findViewById(R.id.weightButton);
        // dataButton = (Button)view.findViewById(R.id.dataButton);



       /* userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, UserFragment.newInstance())
                        .addToBackStack(UserFragment.class.getSimpleName())
                        .commit();
            }

        });*/

        foodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, FoodFragment.newInstance())
                        .addToBackStack(FoodFragment.class.getSimpleName())
                        .commit();

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


        workoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, WorkoutFragment.newInstance())
                        .addToBackStack(WorkoutFragment.class.getSimpleName())
                        .commit();
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
