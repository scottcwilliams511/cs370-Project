package com.app.agile_overlords.moveandgroove.Fragments;

//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.app.agile_overlords.moveandgroove.Adapters.ViewHolder.UserAdapter;
import com.app.agile_overlords.moveandgroove.Listeners.userCallbackListener;
import com.app.agile_overlords.moveandgroove.Models.UserModel;
import com.app.agile_overlords.moveandgroove.R;
import com.app.agile_overlords.moveandgroove.Services.UserTask;

/**
 * Created by brittneyryn on 4/8/16.
 */
public class MainFragment extends Fragment {
    private Button userButton;
    private Button workoutButton;
    private Button foodButton;
    private Button calendarButton;
    private Button weightButton;
    private RelativeLayout itemsView;

    private UserAdapter adapter;
    private LinearLayoutManager layoutManager;
    private OnFragmentEvent onFragmentEvent;



    public MainFragment(){

    }


    public static MainFragment newInstance(){
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.main_display, container, false);

        userButton = (Button)view.findViewById(R.id.userButton);
        workoutButton = (Button)view.findViewById(R.id.workoutButton);
        foodButton =  (Button)view.findViewById(R.id.foodButton);
        calendarButton = (Button)view.findViewById(R.id.calendarButton);
        weightButton = (Button)view.findViewById(R.id.weightButton);



        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userCallbackListener listener = new userCallbackListener() {
                    @Override
                    public void onSearchCallback(UserModel user) {

                            adapter = new UserAdapter(user.getUserResults());
                            adapter.setOnItemSelected(new UserAdapter.OnItemSelected() {
                                @Override
                                public void onSelected(UserModel user) {
                                    if (onFragmentEvent != null) onFragmentEvent.onEvent(user);
                                }
                            });

                        }

                };

                UserTask userTask = new UserTask(listener);
                userTask.execute(userButton.getText().toString());
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

    public void setOnFragmentEvent(OnFragmentEvent onFragmentEvent) {
        this.onFragmentEvent = onFragmentEvent;
    }
    public interface OnFragmentEvent {
        void onEvent(UserModel item);
    }

}
