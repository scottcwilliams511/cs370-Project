package com.app.agile_overlords.moveandgroove.Models;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by matthew on 4/1/16.
 */
public class ExerciseModel implements java.io.Serializable {
    private int id;
    private String name;
    private String type;
    private String info;
<<<<<<< HEAD
=======
    private String caloriesBurned;
    private String duration; // duration in minutes
>>>>>>> origin/bob2

    public ExerciseModel(){}

    public ExerciseModel(String name,String type, String info){
        this.name = name;
        this.type = type;
        this.info = info;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
<<<<<<< HEAD
    public String getInfo() {return info;}
    public void setInfo(String string) {this.info = string;}
=======
    public String getNumSets() { return numSets; }
    public void setNumSets(String numSets) { this.numSets = numSets; }
    public String getNumReps() { return numReps; }
    public void setNumReps(String numReps) { this.numReps = numReps; }
    public String getCaloriesBurned() { return caloriesBurned; }
    public void setCaloriesBurned(String caloriesBurned) { this.caloriesBurned = caloriesBurned; }
    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

>>>>>>> origin/bob2
}