package com.app.agile_overlords.moveandgroove.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import com.app.agile_overlords.moveandgroove.Calorie;
import com.app.agile_overlords.moveandgroove.CalorieSingleton;
import com.app.agile_overlords.moveandgroove.Models.UserModel;
import com.app.agile_overlords.moveandgroove.R;

import org.w3c.dom.Text;


/**
 * Created by brittneyryn on 4/12/16.
 */
public class WorkoutFragment extends Fragment {

    public static final Integer DEFAULT = 0;
    Context mContext;


    private TextView caloriesBurned;
    private TextView steps;
    // Takes you to workouts already made and allows for edit
    private Button workoutButton;
    private Button createWorkout;
    private Button clearButton;
    private OnFragmentEvent onFragmentEvent;
    private OnBackPressed onBackPressed;



    private TextView cal;

    /*private Button startButton;
    private Button stopButton;
    private Button resetButton;
    private Chronometer chronometer;
    private long timeWhenStopped;*/

    public static WorkoutFragment newInstance(){
        WorkoutFragment fragment = new WorkoutFragment();
        Bundle agrs = new Bundle();
        fragment.setArguments(agrs);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View view = inflater.inflate(R.layout.fragment_workout, container, false);
        //caloriesBurned = (TextView)view.findViewById(R.id.caloriesBurned);
        //steps = (TextView)view.findViewById(R.id.steps);
        workoutButton = (Button)view.findViewById(R.id.workoutButton);
        createWorkout = (Button)view.findViewById(R.id.createWorkout);
        clearButton = (Button)view.findViewById(R.id.clearButton);


        mContext = getActivity();

        Float calorie = Calorie.getCalorie(mContext);
        //if(calorie.equals(DEFAULT));
        cal = (TextView)view.findViewById(R.id.calView);

        //cal.setText(Double.toString(CalorieSingleton.getCalorieSingleton()));
        cal.setText(Float.toString(calorie));

        /*startButton = (Button) view.findViewById(R.id.startButton);
        stopButton = (Button) view.findViewById(R.id.stopButton);
        resetButton = (Button) view.findViewById(R.id.resetButton);
        chronometer = (Chronometer) view.findViewById(R.id.chronometer);*/

        workoutButton.setOnClickListener(new View.OnClickListener(){
            // When the button is clicked, the display_workouts_fragment will switch with the workout fragment
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, ExerciseFragment.newInstance())
                        .addToBackStack(ExerciseFragment.class.getSimpleName())
                        .commit();

            }
        });

        createWorkout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, CreateExerciseFragment.newInstance())
                        .addToBackStack(CreateExerciseFragment.class.getSimpleName())
                        .commit();
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Calories cleared!", Toast.LENGTH_LONG).show();
                Calorie.clearCalorie(mContext);
                Toast.makeText(getActivity(), "Calories cleared!", Toast.LENGTH_LONG).show();
                Float calorie = Calorie.getCalorie(mContext);
                //if(calorie.equals(DEFAULT));

                //cal.setText(Double.toString(CalorieSingleton.getCalorieSingleton()));
                cal.setText(Float.toString(calorie));

            }
        });

       /* startButton.setOnClickListener(new View.OnClickListener(){
=======
        /*startButton.setOnClickListener(new View.OnClickListener(){
>>>>>>> origin/BennettMatthew1

            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                chronometer.start();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                timeWhenStopped = chronometer.getBase() - SystemClock.elapsedRealtime();
                chronometer.stop();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                timeWhenStopped = 0;
            }
<<<<<<< HEAD
        });
*/

        return view;

    }

//    public void load(View view)
//    {
//        SharedPreferences sharedPreferences = get
//    }

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

    public void setOnBackPressed(OnBackPressed onBackPressed) {
        this.onBackPressed = onBackPressed;
    }

    public interface OnFragmentEvent {
        void onEvent(UserModel item);
    }

    public interface OnBackPressed {
        void backPressed();
    }


}