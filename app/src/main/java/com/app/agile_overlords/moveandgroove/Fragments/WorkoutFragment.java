package com.app.agile_overlords.moveandgroove.Fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
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
    // Takes you to workouts already made and allows for edit
    private Button workoutButton;
    //private Button createWorkout;
    private Button clearButton;
    private OnFragmentEvent onFragmentEvent;
    private OnBackPressed onBackPressed;


    private TextView cal;

    public static WorkoutFragment newInstance(){
        WorkoutFragment fragment = new WorkoutFragment();
        Bundle agrs = new Bundle();
        fragment.setArguments(agrs);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance){
        View view = inflater.inflate(R.layout.fragment_workout, container, false);
        caloriesBurned = (TextView)view.findViewById(R.id.caloriesBurned);
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "Aller_Bd.ttf");
        caloriesBurned.setTypeface(font);

        workoutButton = (Button)view.findViewById(R.id.workoutButton);
       // createWorkout = (Button)view.findViewById(R.id.createWorkout);
        clearButton = (Button)view.findViewById(R.id.clearButton);


        mContext = getActivity();

        Float calorie = Calorie.getCalorie(mContext);
        //if(calorie.equals(DEFAULT));
        cal = (TextView)view.findViewById(R.id.calView);
        Typeface font2 = Typeface.createFromAsset(getContext().getAssets(), "Aller_Rg.ttf");
        cal.setTypeface(font2);

        //cal.setText(Double.toString(CalorieSingleton.getCalorieSingleton()));
        cal.setText(Float.toString(calorie));


        workoutButton.setOnClickListener(new View.OnClickListener() {
            // When the button is clicked, the display_workouts_fragment will switch with the workout fragment
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, ExerciseFragment.newInstance())
                        .addToBackStack(ExerciseFragment.class.getSimpleName())
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

        onBackPressed.backPressed();
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