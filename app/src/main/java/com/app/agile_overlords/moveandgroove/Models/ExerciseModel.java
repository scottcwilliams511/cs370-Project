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
    public String getInfo() {return info;}
    public void setInfo(String string) {this.info = string;}
}