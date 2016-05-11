package com.app.agile_overlords.moveandgroove.Services.api;

import com.app.agile_overlords.moveandgroove.AppDefines;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import com.app.agile_overlords.moveandgroove.Services.api.NutritionApiAdapter;

/**
 * Created by brittneyryn on 4/15/16.
 */
public class ApiClient {
    private static ApiClient instance;

    public static ApiClient getInstance() {
        if (instance == null) {
            instance = new ApiClient();
        }

        return instance;
    }

    public NutritionApiAdapter getNutritionApiAdapter() {
        NutritionApiAdapter api = new Retrofit.Builder()
                .baseUrl(AppDefines.BASE_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(NutritionApiAdapter.class);

        return api;
    }
}