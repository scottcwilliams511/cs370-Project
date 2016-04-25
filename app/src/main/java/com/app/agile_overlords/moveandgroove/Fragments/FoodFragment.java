package com.app.agile_overlords.moveandgroove.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.app.agile_overlords.moveandgroove.Activities.SearchActivity;
import com.app.agile_overlords.moveandgroove.R;

/**
 * Created by brittneyryn on 4/21/16.
 */

public class FoodFragment extends Fragment {

    private Button addButton;
    private TextView caloriesConsumed;

    public FoodFragment() {

    }

    public static FoodFragment newInstance() {
        FoodFragment fragment = new FoodFragment();
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
        View view = inflater.inflate(R.layout.fragment_food, container, false);
        addButton = (Button)view.findViewById(R.id.addButton);
        caloriesConsumed = (TextView)view.findViewById(R.id.caloriesConsumed);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SearchActivity.class);
                startActivity(i);
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


}
