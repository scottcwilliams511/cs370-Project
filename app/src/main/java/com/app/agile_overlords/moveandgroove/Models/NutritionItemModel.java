package com.app.agile_overlords.moveandgroove.Models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Scott Williams on 3/31/2016.
 */
public class NutritionItemModel implements Serializable {
    private String id;
    private String foodName;
    private ArrayList<String> smallImageUrls;
    //todo add other fields from what the search returns

    public String getId() {return id;}

    public String getFoodName() {return foodName;}

    public ArrayList<String> getSmallImageUrls() {
        return smallImageUrls;
    }

    //todo add getters for later elements

}
