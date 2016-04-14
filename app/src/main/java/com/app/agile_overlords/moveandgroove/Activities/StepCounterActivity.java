package com.app.agile_overlords.moveandgroove.Activities;

import android.content.Context;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.widget.TextView;

import com.app.agile_overlords.moveandgroove.R;

/**
 * Created by Scott Williams on 4/14/2016.
 *
 * http://blog.bawa.com/2013/11/create-your-own-simple-pedometer.html
 *
 */
public class StepCounterActivity extends AppCompatActivity implements SensorEventListener{
    private TextView textView;

    private SensorManager mSensorManager;
    private Sensor mStepCounterSensor;
    private Sensor mStepDetectorSensor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //todo create a layout file or something to put the counter
        //setContentView(R.layout.activity_step);
        //textView = (TextView) findViewById(R.id.textview);

        mSensorManager = (SensorManager)
                getSystemService(Context.SENSOR_SERVICE);
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
            textView.setText("Step Counter Detected L " + value);
        } else if(sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            textView.setText("Step Detector Detected : " + value);
        }
    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this,mStepCounterSensor,
                SensorManager.SENSOR_DELAY_FASTEST);
        mSensorManager.registerListener(this, mStepDetectorSensor,
                SensorManager.SENSOR_DELAY_FASTEST);
    }

    protected void onStop() {
        super.onStop();
        mSensorManager.unregisterListener(this, mStepCounterSensor);
        mSensorManager.unregisterListener(this, mStepDetectorSensor);

    }

    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
        //compiler wanted this here, don't know what it's for
    }


}