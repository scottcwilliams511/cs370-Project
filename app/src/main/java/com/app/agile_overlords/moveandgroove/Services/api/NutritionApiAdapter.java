package com.app.agile_overlords.moveandgroove.Services.api;

import rx.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import com.app.agile_overlords.moveandgroove.Models.SearchResultsModel;

/**
 * Created by brittneyryn on 4/15/16.
 */
public interface NutritionApiAdapter {
    @GET("item")
    Observable<SearchResultsModel> getSearchResults(
            @Query("_app_id") String appId,
            @Query("_app_key") String appKey,
            @Query("q") String searchString);
}
