package com.app.agile_overlords.moveandgroove.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.agile_overlords.moveandgroove.Models.ExerciseModel;
import com.app.agile_overlords.moveandgroove.R;

import java.util.List;



/**
 * Created by Scott Williams on 4/26/2016.
 */
public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.MyViewHolder> {

    private List<ExerciseModel> exerciseModelList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView id, name, type, numSets, numReps,duration;

        public MyViewHolder(View view) {
            super(view);
           // id = (TextView) view.findViewById(R.id.id);
            name = (TextView) view.findViewById(R.id.name);
           // type = (TextView) view.findViewById(R.id.type);
            //numSets = (TextView) view.findViewById(R.id.numSets);
            //numReps = (TextView) view.findViewById(R.id.numReps);
           // duration = (TextView) view.findViewById(R.id.duration);
        }
    }

    public ExerciseAdapter(List<ExerciseModel> exerciseModelList) {
        this.exerciseModelList = exerciseModelList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.exercise_list_row, parent, false);
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ExerciseModel exerciseModel = exerciseModelList.get(position);
        //holder.id.setText(String.valueOf(exerciseModel.getId()));
        holder.name.setText(String.valueOf(exerciseModel.getName()));
        //holder.type.setText(String.valueOf(exerciseModel.getType()));
       // holder.numSets.setText(String.valueOf(exerciseModel.getNumSets()));
        //holder.numReps.setText(String.valueOf(exerciseModel.getNumReps()));
        //holder.duration.setText(String.valueOf(exerciseModel.getDuration()));
    }


    @Override
    public int getItemCount(){
        return exerciseModelList.size();
    }

}
