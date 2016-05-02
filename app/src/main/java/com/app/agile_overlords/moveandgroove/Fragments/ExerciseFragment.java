package com.app.agile_overlords.moveandgroove.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.app.agile_overlords.moveandgroove.WorkoutDefines;
import com.app.agile_overlords.moveandgroove.Models.ExerciseModel;
import com.app.agile_overlords.moveandgroove.Fragments.ExerciseInfoFragment;
import com.app.agile_overlords.moveandgroove.Adapters.ExerciseAdapter;
import com.app.agile_overlords.moveandgroove.DividerItemDecoration;
import com.app.agile_overlords.moveandgroove.MySQLiteHelper;
import com.app.agile_overlords.moveandgroove.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by brittneyryn on 4/24/16.
 * This is the page where a user can view their exercises and click on them to display more information
 */
//page referenced for recycler view below
//http://www.androidhive.info/2016/01/android-working-with-recycler-view/
// TODO: List Exercises

public class ExerciseFragment extends Fragment {

    private List<ExerciseModel> exerciseList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ExerciseAdapter mAdapter;
    private Button exerciseInfoButton;
    private MySQLiteHelper myDb;

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
        myDb = new MySQLiteHelper(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        exerciseList = myDb.getExerciseData();
        prepareExerciseData();
        View view = inflater.inflate(R.layout.fragment_exercise, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        mAdapter = new ExerciseAdapter(exerciseList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);


        exerciseInfoButton = (Button)view.findViewById(R.id.enterButton);

        exerciseInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction()
                        .replace(R.id.container, CreateExerciseFragment.newInstance())
                        .addToBackStack(CreateExerciseFragment.class.getSimpleName())
                        .commit();
            }

        });

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                ExerciseModel exerciseModel = exerciseList.get(position);



                getFragmentManager().beginTransaction()
                        .replace(R.id.container, ExerciseInfoFragment.newInstance(exerciseModel))
                        .addToBackStack(ExerciseInfoFragment.class.getSimpleName())
                        .commit();



               // Toast.makeText(getContext(), exerciseModel.getName() + "is selected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }


        }));


        mAdapter.notifyDataSetChanged();
        //prepareExerciseData();
        return view;
    }

    public interface ClickListener {
        void onClick(View view, int position);
        void onLongClick(View view, int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach(){
        super.onDetach();
    }


    public static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
        private GestureDetector gestureDetector;
        private ExerciseFragment.ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final
        ExerciseFragment.ClickListener clickListener){
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child,recyclerView.getChildPosition(child));
                    }
                }
            });

        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(),e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child,rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }




    private void prepareExerciseData(){


        //***These are hardcoded exercises***

        ExerciseModel exerciseModel = new ExerciseModel("Running","Cardio",WorkoutDefines.RUNNING_INFO);
        exerciseList.add(exerciseModel);
        exerciseModel = new ExerciseModel("Biking","dunno",WorkoutDefines.BIKING_INFO);
        exerciseList.add(exerciseModel);
        exerciseModel = new ExerciseModel("Walking","dunno",WorkoutDefines.WALKING_INFO);
        exerciseList.add(exerciseModel);
        exerciseModel = new ExerciseModel("Swimming","dunno",WorkoutDefines.SWIMMING_INFO);
        exerciseList.add(exerciseModel);
        exerciseModel = new ExerciseModel("Squats","dunno",WorkoutDefines.SQUAT_INFO);
        exerciseList.add(exerciseModel);
        exerciseModel = new ExerciseModel("Sit-ups","dunno",WorkoutDefines.SITUP_INFO);
        exerciseList.add(exerciseModel);
        exerciseModel = new ExerciseModel("Push-ups","dunno",WorkoutDefines.PUSHUP_INFO);
        exerciseList.add(exerciseModel);
        exerciseModel = new ExerciseModel("Jumping Jacks","dunno", WorkoutDefines.JUMPJACK_INFO);
        exerciseList.add(exerciseModel);
        exerciseModel = new ExerciseModel("Jump Rope","dunno",WorkoutDefines.JUMPROPE_INFO);
        exerciseList.add(exerciseModel);
        exerciseModel = new ExerciseModel("Basketball","dunno",WorkoutDefines.BASKETBALL_INFO);
        exerciseList.add(exerciseModel);
        exerciseModel = new ExerciseModel("Lifting (vigorous)","dunno", WorkoutDefines.VIG_LIFT_INFO);
        exerciseList.add(exerciseModel);
        exerciseModel = new ExerciseModel("Lifting (light)","dunno",WorkoutDefines.NOT_LIFT_INFO);
        exerciseList.add(exerciseModel);
        exerciseModel = new ExerciseModel("Sitting","dunno",WorkoutDefines.SITTING_INFO);
        exerciseList.add(exerciseModel);


        //**********************************

        //mAdapter.notifyDataSetChanged();
    }








}