package com.app.agile_overlords.moveandgroove.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.app.agile_overlords.moveandgroove.R;

/**
 * Created by brittneyryn on 4/12/16.
 */
public class WeightFragment extends Fragment {

    // TODO: Have a way to display past weights

    private TextView weightText;
    private Button enterButton;
    private EditText editText;
    private LinearLayoutManager layoutManager;

    public static WeightFragment newInstance(){
        WeightFragment fragment = new WeightFragment();
        Bundle agrs = new Bundle();
        fragment.setArguments(agrs);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_weight, container, false);
        //weightText = (TextView)view.findViewById(R.id.weightText);
        //enterButton = (Button)view.findViewById(R.id.enterButton);
        //editText = (EditText)view.findViewById(R.id.editText);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        /*enterButton.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

            }
        });
*/
        return view;
    }





}
