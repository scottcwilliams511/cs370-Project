package com.app.agile_overlords.moveandgroove.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.agile_overlords.moveandgroove.Models.ExerciseModel;
import com.app.agile_overlords.moveandgroove.MySQLiteHelper;
import com.app.agile_overlords.moveandgroove.R;

/**
 * Created by matthew on 4/19/16.
 */
public class CreateExerciseFragment extends Fragment {
    MySQLiteHelper myDb;
    private Button addButton;
    private EditText addName, addType, addSets, addReps, addCals, addDuration;
    private ExerciseModel model = new ExerciseModel();

    public static CreateExerciseFragment newInstance(){
        CreateExerciseFragment fragment = new CreateExerciseFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDb = new MySQLiteHelper(getActivity());

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_exercise, container, false);

        addButton = (Button) view.findViewById(R.id.addButton);
        addName = (EditText) view.findViewById(R.id.addName);
        addType = (EditText) view.findViewById(R.id.addType);
        addSets = (EditText) view.findViewById(R.id.addSets);
        addReps = (EditText) view.findViewById(R.id.addReps);
        //addCals = (EditText) view.findViewById(R.id.addCals);
        addDuration = (EditText) view.findViewById(R.id.addDuration);

        addButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
/*
                        myDb.insertExercise(addName.getText().toString(), addType.getText().toString(),
                                addSets.getText().toString(), addReps.getText().toString(), addDuration.getText().toString());
                                */

                        boolean isInserted = myDb.insertExercise(addName.getText().toString(),
                                addType.getText().toString(), addSets.getText().toString(), addReps.getText().toString(),
                                addDuration.getText().toString());
                        if (isInserted == true) {
                            Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_LONG).show();
                            model.setName(addName.getText().toString());
                            model.setType(addType.getText().toString());
                            model.setNumSets(addSets.getText().toString());
                            model.setNumReps(addReps.getText().toString());
                            //model.setCaloriesBurned(addCals.getText().toString());
                            model.setDuration(addDuration.getText().toString());
                        } else
                            Toast.makeText(getActivity(), "Data not Inserted", Toast.LENGTH_LONG).show();


                        /*
                        String name = addName.getText().toString();
                        String type = addType.getText().toString();
                        String sets = addSets.getText().toString();
                        String reps = addReps.getText().toString();
                        String duration = addDuration.getText().toString();

                        myDb = new MySQLiteHelper(getActivity());
                        myDb.insertExercise(name, type, sets, reps, duration);
                        Toast.makeText(getActivity(), "Data inserted", Toast.LENGTH_LONG).show();
                        */
                    }

                });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
