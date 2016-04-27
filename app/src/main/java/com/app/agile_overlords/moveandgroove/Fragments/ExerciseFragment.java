package com.app.agile_overlords.moveandgroove.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.agile_overlords.moveandgroove.R;

/**
 * Created by brittneyryn on 4/24/16.
 * This is the page where a user can view their exercises and click on them to display more information
 */

// TODO: List Exercises

public class ExerciseFragment extends Fragment {

    public ExerciseFragment() {

    }

    public static ExerciseFragment newInstance() {
        ExerciseFragment fragment = new ExerciseFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercise, container, false);
        return view;
    }
}
