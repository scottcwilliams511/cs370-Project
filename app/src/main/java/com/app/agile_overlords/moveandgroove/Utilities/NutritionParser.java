package com.app.agile_overlords.moveandgroove.Utilities;

import com.google.gson.Gson;
import com.app.agile_overlords.moveandgroove.Models.SearchResultsModel;

/**
 * Created by Never Forget on 4/5/2016.
 */
public class NutritionParser {
    public static final SearchResultsModel parseNutritionFromJson(final String inputString) {
        SearchResultsModel searchResultsModel;
        Gson gson = new Gson();
        searchResultsModel = gson.fromJson(inputString, SearchResultsModel.class);

        return searchResultsModel;
    }
}
