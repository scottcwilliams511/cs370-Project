package com.app.agile_overlords.moveandgroove.Fragments;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.LayoutInflater;
import android.widget.EditText;

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
    private EditText firstN;
    private EditText lastN;
    private EditText weight;
    private EditText sex;
    private EditText age;
    private EditText heightFt;
    private EditText heightIn;
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

        //userModel = myDb.getAllUserData();
        userModel.SetFirstName("bob");
        userModel.SetLastName("mario");
        userModel.SetWeight(175);
        userModel.SetSex("male");
        userModel.SetAge(21);
        userModel.SetHeightFeet(5);
        userModel.SetHeightInches(11);


       //MoveAndGrooveApplication.getUserModel().GetFirstName();
        //TODO get rid of this hard coded user here and link the user from another place
        firstN = (EditText)view.findViewById(R.id.firstN);
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

        return view;
    }

    //TODO make a button which takes all the textfields, if they are null dont update
    //the info, else update the database info



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