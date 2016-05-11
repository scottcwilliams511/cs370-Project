package com.app.agile_overlords.moveandgroove.Fragments;



import android.graphics.Typeface;
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
import android.widget.Toast;
import com.app.agile_overlords.moveandgroove.Calorie;
import com.app.agile_overlords.moveandgroove.CalorieSingleton;
import com.app.agile_overlords.moveandgroove.Models.UserModel;
import com.app.agile_overlords.moveandgroove.Models.ExerciseModel;
import com.app.agile_overlords.moveandgroove.MySQLiteHelper;
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
    private Button calorieCalculate, deleteButton;
    private EditText enterTime;
    private double calories;
    private MySQLiteHelper myDb;

    Context mContext;

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
        myDb = new MySQLiteHelper(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_exercise_info, container, false);

       Typeface font = Typeface.createFromAsset(getContext().getAssets(), "Aller_Rg.ttf");

       startButton = (Button) view.findViewById(R.id.startButton);
       stopButton = (Button) view.findViewById(R.id.stopButton);
       resetButton = (Button) view.findViewById(R.id.resetButton);
       chronometer = (Chronometer) view.findViewById(R.id.chronometer);
       chronometer.setTypeface(font);

       name = (TextView)view.findViewById(R.id.name);
       type = (TextView)view.findViewById(R.id.type);
       info = (TextView)view.findViewById(R.id.info);
       name.setTypeface(font);
       type.setTypeface(font);
       info.setTypeface(font);
       calorieCalculate = (Button) view.findViewById(R.id.enterCalories);
       enterTime = (EditText) view.findViewById(R.id.editText);
       calorieValue = (TextView) view.findViewById(R.id.calorieValue);
       deleteButton = (Button) view.findViewById(R.id.deleteButton);

       mContext = getActivity();

       info.setMovementMethod(new ScrollingMovementMethod());
       final ExerciseModel exerciseModel = getExerciseModel();
       name.setText(exerciseModel.getName());
       type.setText("Catagory: " + exerciseModel.getType());
       info.setText(exerciseModel.getInfo());

       final WorkoutDefines workoutDefines = new WorkoutDefines();

        //TODO delete the below if we have user working
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
               }else if(exerciseModel.getName() == "Squats") {
                   calories = workoutDefines.caloriesBurnedFromSquats(userModel.GetWeight(), value);
               }else if(exerciseModel.getName() == "sit-ups" || exerciseModel.getName() == "push-ups") {
                   calories = workoutDefines.caloriesBurnedFromSitupsAndPushups(userModel.GetWeight(),value);
               }else if(exerciseModel.getName() == "Jumping Jacks") {
                   calories = workoutDefines.caloriesBurnedJumping(userModel.GetWeight(),value,true);
               }else if(exerciseModel.getName() == "Jump Rope") {
                   calories = workoutDefines.caloriesBurnedJumping(userModel.GetWeight(), value, false);
               }else if(exerciseModel.getName() == "Basketball") {
                   calories = workoutDefines.caloriesBurnedFromBasketball(value, userModel.GetWeight());
               }else if(exerciseModel.getName() == "Lifting (vigorous)") {
                   calories = workoutDefines.caloriesBurnedFromWeighLifting(value, userModel.GetWeight(), true);
               }else if(exerciseModel.getName() == "Lifting (light)") {
                   calories = workoutDefines.caloriesBurnedFromWeighLifting(value, userModel.GetWeight(), false);
               }else if(exerciseModel.getName() == "Sitting") {
                   calories = workoutDefines.caloriesBurnedSitting(value, userModel.GetWeight());
               }else {
                   calories = workoutDefines.caloriesBurnedCustomExercise(userModel.GetSex(),userModel.GetWeight(),userModel.GetAge(),180,value);
               }

               calorieValue.setText("Calories burned: " + String.format("%.2f", calories));
               calories += Calorie.getCalorie(mContext);

               Float f = (float)calories;
               Calorie.setCalorie(mContext, f);
//               calories += CalorieSingleton.getCalorieSingleton();
//               CalorieSingleton.setCalorieSingleton(calories);
               //calorieValue.setText("Calories burned: " + calories);

           }


       });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDb.deleteExerciseData(exerciseModel.getName());
                if(deletedRows > 0)
                    Toast.makeText(getActivity(), "Data Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getActivity(),"Data not Deleted, Default Exercise",Toast.LENGTH_LONG).show();
            }
        });


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

       return view;
    }
}