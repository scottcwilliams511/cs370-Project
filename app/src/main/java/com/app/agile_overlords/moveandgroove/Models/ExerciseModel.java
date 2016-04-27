package com.app.agile_overlords.moveandgroove.Models;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by matthew on 4/1/16.
 */
public class ExerciseModel {
    private long id;
    private String name;
    private String type; // Cardio, Strength, Endurance
    private Integer numSets;
    private Integer numReps;
    private Boolean weights;
    private Integer caloriesBurned;
    private Integer duration; // duration in minutes

    public ExerciseModel(String name,String type,int numReps, int numSets, int duration){
        this.name = name;
        this.type = type;
        this.numReps = numReps;
        this.numSets = numSets;
        this.duration = duration;
    }



    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Integer getNumSets() { return numSets; }
    public void setNumSets(Integer numSets) { this.numSets = numSets; }
    public Integer getNumReps() { return numReps; }
    public void setNumReps(Integer numReps) { this.numReps = numReps; }
    public Boolean isWeights() { return weights; }
    public void setWeights(Boolean weights) { this.weights = weights; }
    public Integer getCaloriesBurned() { return caloriesBurned; }
    public void setCaloriesBurned(Integer caloriesBurned) { this.caloriesBurned = caloriesBurned; }
    public Integer getDuration() { return duration; }
    public void setDuration() { this.duration = duration; }

    @Override
    public String toString() {
        return name;
    }
}
