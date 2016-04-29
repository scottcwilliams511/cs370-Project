package com.app.agile_overlords.moveandgroove.Models;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by matthew on 4/1/16.
 */
public class ExerciseModel {
    private long id;
    private String name;
    private String type; // Cardio, Strength, Endurance
    private String numSets;
    private String numReps;
    //private Boolean weights;
    private String caloriesBurned;
    private String duration; // duration in minutes

    public ExerciseModel(){}

    public ExerciseModel(String name,String type){
        this.name = name;
        this.type = type;
        //this.numReps = numReps;
        //this.numSets = numSets;
        //this.duration = duration;
    }


    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getNumSets() { return numSets; }
    public void setNumSets(String numSets) { this.numSets = numSets; }
    public String getNumReps() { return numReps; }
    public void setNumReps(String numReps) { this.numReps = numReps; }
    //public Boolean isWeights() { return weights; }
    //public void setWeights(Boolean weights) { this.weights = weights; }
    public String getCaloriesBurned() { return caloriesBurned; }
    public void setCaloriesBurned(String caloriesBurned) { this.caloriesBurned = caloriesBurned; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }
/*
    @Override
    public String toString() {
        return name;
    }
    */
}
