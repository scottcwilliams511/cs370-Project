package com.app.agile_overlords.moveandgroove.Models;

import com.app.agile_overlords.moveandgroove.Models.NutritionItemModel;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 * Created by Scott Williams on 3/31/2016.
 */
public class SearchResultsModel {

    @SerializedName("matches")
    ArrayList<NutritionItemModel> searchResults;

    public ArrayList<NutritionItemModel> getSearchResults() {return searchResults;}

}
