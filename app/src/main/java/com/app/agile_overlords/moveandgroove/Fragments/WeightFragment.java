package com.app.agile_overlords.moveandgroove.Fragments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.agile_overlords.moveandgroove.MoveAndGrooveApplication;
import com.app.agile_overlords.moveandgroove.MySQLiteHelper;
import com.app.agile_overlords.moveandgroove.R;

import org.w3c.dom.Text;

import java.io.FileOutputStream;

/**
 * Created by brittneyryn on 4/12/16.
 */


public class WeightFragment extends Fragment {

    // TODO: Have a way to display past weights

    private MySQLiteHelper myDb;
    private TextView weightText;
    private Button enterButton;
    private EditText editText;
    private LinearLayoutManager layoutManager;
    private TextView title;
    private TextView currWeight;
    private TextView weight;
    private String name;
    private TextView name2;



    public static WeightFragment newInstance(){
        WeightFragment fragment = new WeightFragment();
        Bundle agrs = new Bundle();
        fragment.setArguments(agrs);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_weight, container, false);

        myDb = new MySQLiteHelper(getActivity());

        myDb.open();


//
        name2 = (TextView)view.findViewById(R.id.weightView);
//        name2.setText(name);
        name2.setText(Integer.toString(MoveAndGrooveApplication.getUserModel().GetWeight()));


        myDb.close();

        title = (TextView)view.findViewById(R.id.titletext);
        //current weight
        //weightText = (TextView)view.findViewById(R.id.weightText);
        //button to update weight
        currWeight = (TextView)view.findViewById(R.id.currenttext);
        enterButton = (Button)view.findViewById(R.id.enterButton);
        //place to enter text
       editText = (EditText)view.findViewById(R.id.editText);
        UpdateData();
        // update click handler. handle null exceptions
       // layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
//        enterButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            //todo make this button go to the database
//            }
//        });




        /*enterButton.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

            }
        });
*/
        return view;
    }


    public void UpdateData() {
        enterButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               boolean isUpdate = myDb.updateUserWeight(editText.getText().toString());
                                               if (isUpdate == true)
                                                   Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_LONG).show();
                                               else
                                                   Toast.makeText(getActivity(), "Data not Inserted", Toast.LENGTH_LONG).show();
                                               name2.setText(Integer.toString(MoveAndGrooveApplication.getUserModel().GetWeight()));
                                           }

                                       }



        );

    }


}
