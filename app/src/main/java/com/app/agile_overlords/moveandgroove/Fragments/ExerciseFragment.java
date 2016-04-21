package com.app.agile_overlords.moveandgroove.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.app.agile_overlords.moveandgroove.Models.ExerciseModel;
import com.app.agile_overlords.moveandgroove.R;

import java.util.List;
import java.util.Random;

/**
 * Created by matthew on 4/19/16.
 */
public class ExerciseFragment extends Fragment {
    //private ExerciseDataSource datasource;
    private Button addButton;


    public static ExerciseFragment newInstance(){
        ExerciseFragment fragment = new ExerciseFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        //datasource = new ExerciseDataSource(getContext()); // TODO: Check if right
        //datasource.open();
    }


  //  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
   //     View view = inflater.inflate(R.layout.fragment_exercise, container, false);

     //   addButton = (Button)view.findViewById(R.id.addButton);
        // TODO: create form for exercise
        // TODO: figure out how to save information to excercise model

        //List<ExerciseModel> values = datasource.getAllExercises();

        // use the SimpleCursorAdapter to show the
        // elements in a ListView
        //ArrayAdapter<ExerciseModel> adapter = new ArrayAdapter<ExerciseModel>(getActivity(),
        //           android.R.layout.simple_list_item_1, values);
        //getActivity().setListAdapter(adapter);

        //addButton.setOnClickListener(new View.OnClickListener(){
/*
            @Override
            public void onClick(View v) {
                @SuppressWarnings("unchecked")
                //ArrayAdapter<ExerciseModel> adapter = (ArrayAdapter<ExerciseModel>) getListAdapter();
                ExerciseModel exercise = null;
                switch (v.getId()) {
                    case R.id.add:
                        String[] exercises = new String[] { "Pullups", "Pushups", "Situps" };
                        int nextInt = new Random().nextInt(3);
                        // save the new comment to the database
                        // This is where you will be setting your exercise objects
                      //  exercise = datasource.createExercise(exercises[nextInt]);
                      //  adapter.add(exercise);
                        break;
                    case R.id.delete:
                       / if (getListAdapter().getCount() > 0) {
                            exercise = (ExerciseModel) getListAdapter().getItem(0);
                            datasource.deleteExercise(exercise);
                            adapter.remove(exercise);
                        }
                        break;
                }
                adapter.notifyDataSetChanged();

            }
        });


        return view;
        */
   // }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



}
