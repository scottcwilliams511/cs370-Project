package com.app.agile_overlords.moveandgroove.Fragments;


//todo make sure all fragments use v4 else we will get errors later on!!!
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.method.ScrollingMovementMethod;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

import com.app.agile_overlords.moveandgroove.Models.UserModel;
import com.app.agile_overlords.moveandgroove.Models.ExerciseModel;
import com.app.agile_overlords.moveandgroove.R;
import com.app.agile_overlords.moveandgroove.WorkoutDefines;

/**
 * Created by brittneyryn on 4/24/16.
 */

// TODO: Page displays info and stop watch
public class ExerciseInfoFragment extends Fragment {
    private Button startButton;
    private Button stopButton;
    private Button resetButton;
    private Chronometer chronometer;
    private long timeWhenStopped;
    private TextView name;
    private TextView type;
    private TextView info;
    private TextView calorieValue;
    private Button calorieCalculate;
    private EditText enterTime;
    private double calories;

    public ExerciseInfoFragment() {

    }

    public static ExerciseInfoFragment newInstance() {
        ExerciseInfoFragment fragment = new ExerciseInfoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public static ExerciseInfoFragment newInstance(ExerciseModel exerciseModel){
        ExerciseInfoFragment f = new ExerciseInfoFragment();
        Bundle args = new Bundle();
        args.putSerializable("exerciseModel", exerciseModel);
        f.setArguments(args);
        return f;
    }
    public ExerciseModel getExerciseModel(){
        return (ExerciseModel) getArguments().getSerializable("exerciseModel");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_exercise_info, container, false);
       startButton = (Button) view.findViewById(R.id.startButton);
       stopButton = (Button) view.findViewById(R.id.stopButton);
       resetButton = (Button) view.findViewById(R.id.resetButton);
       chronometer = (Chronometer) view.findViewById(R.id.chronometer);
       name = (TextView)view.findViewById(R.id.name);
       type = (TextView)view.findViewById(R.id.type);
       info = (TextView)view.findViewById(R.id.info);
       calorieCalculate = (Button) view.findViewById(R.id.enterCalories);
       enterTime = (EditText) view.findViewById(R.id.editText);
       calorieValue = (TextView) view.findViewById(R.id.calorieValue);

       info.setMovementMethod(new ScrollingMovementMethod());
       final ExerciseModel exerciseModel = getExerciseModel();
       name.setText(exerciseModel.getName());
       type.setText("Catagory: " + exerciseModel.getType());
       info.setText(exerciseModel.getInfo());

       final WorkoutDefines workoutDefines = new WorkoutDefines();
       final UserModel userModel = new UserModel("male",20,150);

       calorieCalculate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               double value = Double.parseDouble(enterTime.getText().toString());

               if(exerciseModel.getName() == "Running") {
                   calories = workoutDefines.caloriesBurnedRunning(userModel.GetSex(),userModel.GetWeight(),
                           userModel.GetAge(),180,value);
               } else if(exerciseModel.getName() == "Biking") {
                   calories = workoutDefines.caloriesBurnedBiking(userModel.GetWeight(),value,12);
               }else if(exerciseModel.getName() == "Walking") {
                   calories = workoutDefines.caloriesBurnedWalking(userModel.GetWeight(),value,false);
               }else if(exerciseModel.getName() == "Swimming") {
                   calories = workoutDefines.caloriesBurnedSwimming(value,userModel.GetWeight());
               }



               calorieValue.setText("Calories burned: " + String.format("%.2f",calories));

           }


       });



        //Bundle bundle = this.getArguments();
        //ExerciseModel exerciseModel;
        //exerciseModel = (ExerciseModel)getActivity().getIntent().getSerializable("exerciseModel");
/*
        chronometer.setFormat("H:MM:SS");
=======
        //chronometer.setFormat("H:MM:SS");
>>>>>>> master
=======
        View view = inflater.inflate(R.layout.calendar_main, container, false);
        startButton = (Button) view.findViewById(R.id.startButton);
        stopButton = (Button) view.findViewById(R.id.stopButton);
        resetButton = (Button) view.findViewById(R.id.resetButton);
        chronometer = (Chronometer) view.findViewById(R.id.chronometer);
        //chronometer.setFormat("H:MM:SS");
>>>>>>> origin/master
        startButton.setOnClickListener(new View.OnClickListener(){

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
        });
        */
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

}
