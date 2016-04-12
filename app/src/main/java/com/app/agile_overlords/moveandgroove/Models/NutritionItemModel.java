package com.app.agile_overlords.moveandgroove.Models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Scott Williams on 3/31/2016.
 */
<<<<<<< HEAD
public class NutritionItemModel {
=======
public class NutritionItemModel implements Serializable {
    private String id;
    private String foodName;
    private ArrayList<String> smallImageUrls;
    //todo add other fields from what the search returns
>>>>>>> fragments

    private String _id;
    private Fields fields;

    public String get_id() {
        return _id;
    }

    public Fields getFields() {
        return fields;
    }
}
