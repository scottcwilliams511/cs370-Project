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


        userModel = myDb.getAllUserData();
        firstN = (TextInputEditText)view.findViewById(R.id.firstN);
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
        editButton = (Button)view.findViewById(R.id.updateInfo);

        inputLayoutFirst = (TextInputLayout)view.findViewById(R.id.input_layout_first);

        editButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              myDb.deleteUserData(firstN.getText().toString());
                                              myDb.insertUser(firstN.getText().toString(), lastN.getText().toString(), sex.getText().toString(),
                                                      age.getText().toString(), weight.getText().toString(), heightFt.getText().toString(), heightIn.getText().toString());
                                              Toast.makeText(getActivity(), "Data Updated", Toast.LENGTH_LONG).show();
                                          }
        });


        return view;
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