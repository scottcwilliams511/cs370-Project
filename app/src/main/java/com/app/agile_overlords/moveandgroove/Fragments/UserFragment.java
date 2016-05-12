package com.app.agile_overlords.moveandgroove.Fragments;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.agile_overlords.moveandgroove.Models.UserModel;
import com.app.agile_overlords.moveandgroove.MoveAndGrooveApplication;
import com.app.agile_overlords.moveandgroove.MySQLiteHelper;
import com.app.agile_overlords.moveandgroove.R;

/**
 * Created by brittneyryn on 4/5/16.
 */



public class UserFragment extends Fragment {
    private Button editButton;
    private LinearLayoutManager layoutManager;
    private OnFragmentEvent onFragmentEvent;
    private TextInputEditText firstN;
    private EditText lastN;
    private EditText weight;
    private EditText sex;
    private EditText age;
    private EditText heightFt;
    private EditText heightIn;
    private TextInputLayout inputLayoutFirst;
    private MySQLiteHelper myDb;
    private UserModel userModel = new UserModel();

    public UserFragment() {

    }

    public static UserFragment newInstance() {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        myDb = new MySQLiteHelper(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);




        myDb = new MySQLiteHelper(getActivity());

        myDb.open();

        //if(myDb.getProfilesCount() = 0){
//            myDb.insertUser("Jeff", "Fisher", "male", "20", "150", "5", "11");




       /* firstN = (EditText)view.findViewById(R.id.firstN);

        lastN = (EditText)view.findViewById(R.id.lastN);

        weight = (EditText)view.findViewById(R.id.weight);

        sex = (EditText)view.findViewById(R.id.sex);

        age = (EditText)view.findViewById(R.id.age);

        heightFt = (EditText)view.findViewById(R.id.heightFt);

        heightIn = (EditText)view.findViewById(R.id.heightIn);

        View view = inflater.inflate(R.layout.fragment_user, container, false);*/

       // myDb.insertUser("Jeff", "Fisher", "male", "20", "150", "5", "11");
       // userModel = myDb.getAllUserData();
       /* firstN = (EditText)view.findViewById(R.id.firstN);
        firstN.setText(userModel.GetFirstName());
        lastN = (EditText)view.findViewById(R.id.lastN);
        lastN.setText(userModel.GetLastName());
        weight = (EditText)view.findViewById(R.id.weight);
        weight.setText(userModel.GetWeight().toString());
        sex = (EditText)view.findViewById(R.id.sex);
        sex.setText(userModel.GetSex().toString());
        age = (EditText)view.findViewById(R.id.age);
        age.setText(userModel.GetAge().toString());
        heightFt = (EditText)view.findViewById(R.id.heightFt);
        heightFt.setText(userModel.GetHeightFeet().toString());
        heightIn = (EditText)view.findViewById(R.id.heightIn);
        heightIn.setText(userModel.GetHeightInches().toString());
        editButton = (Button)view.findViewById(R.id.updateInfo);*/

       //
       userModel.SetFirstName("bob");
        userModel.SetLastName("mario");
        userModel.SetWeight(175);
        userModel.SetSex("male");
        userModel.SetAge(21);
        userModel.SetHeightFeet(5);
        userModel.SetHeightInches(11);

        inputLayoutFirst = (TextInputLayout)view.findViewById(R.id.input_layout_first);
       //MoveAndGrooveApplication.getUserModel().GetFirstName();
        //TODO get rid of this hard coded user here and link the user from another place
        firstN = (TextInputEditText)view.findViewById(R.id.firstN);
        //firstN.setText(MoveAndGrooveApplication.getUserModel().GetFirstName().toString());
        firstN.setText(userModel.GetFirstName().toString());
        lastN = (EditText)view.findViewById(R.id.lastN);
        lastN.setText(userModel.GetLastName().toString());
        weight = (EditText)view.findViewById(R.id.weight);
        weight.setText(userModel.GetWeight().toString());
        sex = (EditText)view.findViewById(R.id.sex);
        sex.setText(userModel.GetSex().toString());
        age = (EditText)view.findViewById(R.id.age);
        age.setText(userModel.GetAge().toString());
        heightFt = (EditText)view.findViewById(R.id.heightFt);
        heightFt.setText(userModel.GetHeightFeet().toString());
        heightIn = (EditText)view.findViewById(R.id.heightIn);
        heightIn.setText(userModel.GetHeightInches().toString());

        editButton = (Button)view.findViewById(R.id.updateInfo);


        UpdateData();

        myDb.close();

        return view;
    }

    //TODO make a button which takes all the textfields, if they are null dont update
    //the info, else update the database info


    public void UpdateData() {
        editButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               String firstString = firstN.getText().toString();
                                               String lastString = lastN.getText().toString();
                                               String weightString = weight.getText().toString();
                                               String sexString = sex.getText().toString();
                                               String ageString = age.getText().toString();
                                               String heightftString = heightFt.getText().toString();
                                               String heightinString = heightIn.getText().toString();

                                               if (firstString.equals(""))
                                                   firstN.setText(String.valueOf(MoveAndGrooveApplication.getUserModel().GetFirstName()));
                                               if(lastString.equals(""))
                                                   lastN.setText(String.valueOf(MoveAndGrooveApplication.getUserModel().GetLastName()));
                                               if(weightString.equals(""))
                                                   weight.setText(Integer.valueOf(MoveAndGrooveApplication.getUserModel().GetWeight()));
                                               if(sexString.equals(""))
                                                   sex.setText(String.valueOf(MoveAndGrooveApplication.getUserModel().GetSex()));
                                               if(ageString.equals(""))
                                                   age.setText(Integer.valueOf(MoveAndGrooveApplication.getUserModel().GetAge()));
                                               if(heightftString.equals(""))
                                                   heightFt.setText(Integer.valueOf(MoveAndGrooveApplication.getUserModel().GetHeightFeet()));
                                               if(heightinString.equals(""))
                                                   heightFt.setText(Integer.valueOf(MoveAndGrooveApplication.getUserModel().GetHeightInches()));

                                               boolean isUpdate = myDb.updateUserData(firstN.getText().toString(), lastN.getText().toString(), weight.getText().toString(),
                                                       sex.getText().toString(), age.getText().toString(), heightFt.getText().toString(), heightIn.getText().toString());
                                               if(isUpdate == true)
                                                   Toast.makeText(getActivity(),"Profile info updated",Toast.LENGTH_LONG).show();
                                               else
                                                   Toast.makeText(getActivity(),"Data not Inserted",Toast.LENGTH_LONG).show();
                                           }
                                      }
        );
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



    public void setOnFragmentEvent(OnFragmentEvent onFragmentEvent) {
        this.onFragmentEvent = onFragmentEvent;
    }

    public interface OnFragmentEvent {
        void onEvent(UserModel item);
    }


}