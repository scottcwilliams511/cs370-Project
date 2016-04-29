package com.app.agile_overlords.moveandgroove.Services.api;

import retrofit2.http.Path;
import rx.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import com.app.agile_overlords.moveandgroove.Models.SearchResultsModel;

/**
 * Created by brittneyryn on 4/15/16.
 */
public interface NutritionApiAdapter {
    @GET("{item}")
    Observable<SearchResultsModel> getSearchResults(
            @Path("item") String searchItem,
            @Query("appId") String appId,
            @Query("appKey") String appKey);
}
