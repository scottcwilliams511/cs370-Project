package com.app.agile_overlords.moveandgroove.Utilities;

import com.app.agile_overlords.moveandgroove.AppDefines;
/**
 * Created by Never Forget on 4/5/2016.
 */

// NEEDS TO BE CHANGED TO FIT OUT API
public class URLFormatUtility {
    private static final String NUTRITION_ROUTE = "?results=0%3A20&cal_min=0&cal_max=300&fields=item_name%2Cbrand_name%2Cnf_calories%2Cnf_calories_from_fat" +
                                                   "%2Cnf_total_fat%2Cnf_saturated_fat%2Cnf_trans_fatty_acid%2Cnf_polyunsaturated_fat%2Cnf_monounsaturated_fat" +
                                                    "%2Cnf_cholesterol%2Cnf_sodium%2Cnf_total_carbohydrate%2Cnf_dietary_fiber%2Cnf_sugars%2Cnf_protein%2Cnf_vitamin_a_dv" +
                                                    "%2Cnf_vitamin_c_dv%2Cnf_calcium_dv%2Cnf_iron_dv%2Cnf_servings_per_container%2Cnf_serving_size_qty" +
                                                    "%2Cnf_serving_size_unit%2Cnf_serving_weight_grams";
    public static String formatNutritionSearchString(String searchString) {
        String urlString = AppDefines.BASE_API_URL +
                searchString +
                NUTRITION_ROUTE +
                "&appId=" +
                AppDefines.APPLICATION_ID +
                "&appKey=" +
                AppDefines.APPLICATION_KEY;
                //+
                //"&q=" + searchString;

        return urlString;
    }
}