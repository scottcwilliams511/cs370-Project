package com.app.agile_overlords.moveandgroove.Models;

/**
 * Created by matthew on 4/1/16.
 */
public class ExerciseModel {
    private String name;
    private String type; // Cardio, Strength, Endurance
    private Integer numSets;
    private Integer numReps;
    private Boolean weights;
    private Integer caloriesBurned;
    private Integer duration; // duration in minutes

    public String GetName() { return name; }
    public void SetName(String name) { this.name = name; }
    public String GetType() { return type; }
    public void SetType(String type) { this.type = type; }
    public Integer GetNumSets() { return numSets; }
    public void SetNumSets(Integer numSets) { this.numSets = numSets; }
    public Integer GetNumReps() { return numReps; }
    public void SetNumReps(Integer numReps) { this.numReps = numReps; }
    public Boolean isWeights() { return weights; }
    public void setWeights(Boolean weights) { this.weights = weights; }
    public Integer GetCaloriesBurned() { return caloriesBurned; }
    public void SetCaloriesBurned(Integer caloriesBurned) { this.caloriesBurned = caloriesBurned; }
    public Integer GetDuration() { return duration; }
    public void SetDuration() { this.duration = duration; }

}
