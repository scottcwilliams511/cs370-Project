package com.app.agile_overlords.moveandgroove.Fragments;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.app.agile_overlords.moveandgroove.Activities.SearchActivity;
import com.app.agile_overlords.moveandgroove.CalorieConsumed;
import com.app.agile_overlords.moveandgroove.R;

import org.w3c.dom.Text;

/**
 * Created by brittneyryn on 4/21/16.
 */

public class FoodFragment extends Fragment {

    private Button addButton, clearButton;
    private TextView caloriesConsumed;
    private float calorie;
    private TextView cal;

    Context mContext;

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
        clearButton = (Button)view.findViewById(R.id.clearButton);
        caloriesConsumed = (TextView)view.findViewById(R.id.caloriesConsumed);

        mContext = getActivity();

        calorie = CalorieConsumed.getCalorie(mContext);
        cal = (TextView)view.findViewById(R.id.cal);
        Typeface font2 = Typeface.createFromAsset(getContext().getAssets(), "Aller_Rg.ttf");
        cal.setTypeface(font2);
        cal.setText(Float.toString(calorie));


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), SearchActivity.class);
                startActivity(i);
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalorieConsumed.clearCalorie(mContext);
                Float calorie = CalorieConsumed.getCalorie(mContext);
                cal.setText(Float.toString(calorie));
                Toast.makeText(getActivity(), "Calories cleared!", Toast.LENGTH_LONG).show();
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

    @Override
     public void onResume() {
        super.onResume();
        mContext = getActivity();
        calorie = CalorieConsumed.getCalorie(mContext);
        Typeface font2 = Typeface.createFromAsset(getContext().getAssets(), "Aller_Rg.ttf");
        cal.setTypeface(font2);
        cal.setText(Float.toString(calorie));
        }


}