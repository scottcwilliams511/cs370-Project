package com.app.agile_overlords.moveandgroove.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.agile_overlords.moveandgroove.MySQLiteHelper;
import com.app.agile_overlords.moveandgroove.R;

/**
 * Created by matthew on 4/19/16.
 */
public class CreateExerciseFragment extends Fragment {
    MySQLiteHelper myDb;
    private Button addButton;
    private EditText addName;

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


        addButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertExercise(addName.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getActivity(), "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                });
        return view;
    }



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
