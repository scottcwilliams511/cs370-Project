package com.app.agile_overlords.moveandgroove;

import android.os.AsyncTask;

import java.io.IOException;

//todo look at lab 4 file imports and see if needed.....

/**
 * Created by Scott Williams on 3/31/2016.
 */
public class NutritionSearchTask extends AsyncTask<String,String,SearchResultsModel> {

    private INutritionCallbackListener nutritionCallbackListener;

    public NutritionSearchTask (final INutritionCallbackListener nutritionCallbackListener) {
        this.nutritionCallbackListener = nutritionCallbackListener;
    }

    @Override
    protected SearchResultsModel doInBackground(String... params) {
        HttpRequestManager httpRequestManager = new HttpRequestManager();
        String response = "";

        try {
            response = httpRequestManager.getNutrition(URLFormatUtility.formatNutritionSearchString(params[0]));
        } catch (IOException exception) {
            String exceptionString = exception.getMessage();
        }

        return NutritionParser.parseNutritionFromJson(response);
    }

    @Override
    protected void onPostExecute(SearchResultsModel searchResultsModel){
        super.onPostExecute(searchResultsModel);
        nutritionCallbackListener.onSearchCallback(searchResultsModel);
    }

}
