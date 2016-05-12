package com.app.agile_overlords.moveandgroove.Fragments;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
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

import com.app.agile_overlords.moveandgroove.Calorie;
import com.app.agile_overlords.moveandgroove.CalorieConsumed;
import com.app.agile_overlords.moveandgroove.CalorieSingleton;
import com.app.agile_overlords.moveandgroove.Models.UserModel;
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
    private Integer weights;
    private String name;
    private TextView name2;
    private TextView caloriesConsumed;
    private TextView caloriesBurned;
    private TextView calorieTotal;
    private UserModel userModel = new UserModel();
    Context mContext;



    public static WeightFragment newInstance(){
        WeightFragment fragment = new WeightFragment();
        Bundle agrs = new Bundle();
        fragment.setArguments(agrs);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDb = new MySQLiteHelper(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_weight, container, false);
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "Aller_Bd.ttf");
        userModel = myDb.getAllUserData();
        mContext = getActivity();

        caloriesConsumed = (TextView)view.findViewById(R.id.caloriesConsumed);
        caloriesBurned = (TextView)view.findViewById(R.id.caloriesBurned);
        calorieTotal = (TextView)view.findViewById(R.id.calorieTotal);

        //TODO get calories for both of those things above

        caloriesConsumed.setText("Calories consumed: " + CalorieConsumed.getCalorie(mContext));
        caloriesBurned.setText("Calories burned: " + Calorie.getCalorie(mContext));
        calorieTotal.setText("Net total: " + (CalorieConsumed.getCalorie(mContext) - Calorie.getCalorie(mContext)));


        //final UserModel userModel = myDb.getAllUserData();

        name2 = (TextView)view.findViewById(R.id.weightView);
        //name2.setText(name);
        name2.setText(userModel.GetWeight().toString());


        title = (TextView)view.findViewById(R.id.titletext);
        title. setTypeface(font);

        currWeight = (TextView)view.findViewById(R.id.currenttext);
        currWeight. setTypeface(font);


        enterButton = (Button)view.findViewById(R.id.enterButton);
        //place to enter text
        editText = (EditText)view.findViewById(R.id.editText);

        enterButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               //String itemString = editText.getText().toString();
                                            /*   if (editText.equals("")) {
                                                   Toast.makeText(getActivity(), "Please enter something", Toast.LENGTH_LONG).show();
                                               }
                                               if (checkNum(editText.getText().toString()) == false) {
                                                   Toast.makeText(getActivity(), "Please enter an number", Toast.LENGTH_LONG).show();
                                               }
//
                                               else {
 *//*
                                                   boolean isUpdate = myDb.updateUserWeight(editText.getText().toString());
                                                   if (isUpdate == true)
                                                       Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_LONG).show();
                                                   else
                                                       Toast.makeText(getActivity(), "Data not Inserted", Toast.LENGTH_LONG).show();
                                                   name2.setText(userModel.GetWeight().toString());
                                                   */
                                               myDb.deleteUserData(userModel.GetFirstName());
                                               myDb.insertUser(userModel.GetFirstName().toString(), userModel.GetLastName().toString(), userModel.GetSex().toString(),
                                                       userModel.GetAge().toString(), editText.getText().toString(), userModel.GetHeightFeet().toString(), userModel.GetHeightInches().toString());
                                               //myDb.insertWeight(editText.getText().toString());
                                               name2.setText(editText.getText().toString());

                                               Toast.makeText(getActivity(), "Data Updated", Toast.LENGTH_LONG).show();



                                               }


                                       }



        );

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

    public static boolean checkNum(String str){

        try
        {
            Integer integer = Integer.parseInt(str);
            //Integer dub  = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }




}
