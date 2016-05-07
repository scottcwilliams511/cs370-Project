package com.app.agile_overlords.moveandgroove.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.app.agile_overlords.moveandgroove.Models.NutritionItemModel;
import com.app.agile_overlords.moveandgroove.R;
import com.bumptech.glide.Glide;

/**
 * Created by brittneyryn on 4/9/16.
 */
public class NutritionItemFragment extends Fragment {
    private NutritionItemModel item;
    private static final String ITEM = "hits";

    private TextView detailName;
    private TextView calories;


    public NutritionItemFragment() {
        // Required empty public constructor
    }

    // A RecipeItemModel is passed in during instantiation for addition to the fragment's args
    public static NutritionItemFragment newInstance(NutritionItemModel item) {
        NutritionItemFragment fragment = new NutritionItemFragment();
        Bundle args = new Bundle();
        args.putSerializable(ITEM, item);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            item = (NutritionItemModel)getArguments().getSerializable(ITEM);
        }
    }

    // Once the fragment's view has been created, the RecipeItemModel data is assigned to the various
    // layout elements.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nutrition, container, false);
        //recipeDetailThumbnail = (ImageView)view.findViewById(R.id.recipeDetailThumbnail);
        detailName = (TextView)view.findViewById(R.id.detailName);
        calories = (TextView)view.findViewById(R.id.calories);
        detailName.setText(item.getFields().getItem_name());
        calories.setText(item.getFields().get_calories());





        // Use the Glide library (referenced in Gradle) to preload an image resource for the recipeDetailThumbnail
        /*Glide.with(this).load(item.getFoodName())
                .into(foodThumbnail);

        // Set the value of the recipeDetailName
        foodName.setText(item.getFoodName());*/

        // An inline adapter is declared for the list view since it will only be handling a collection
        // of strings.


        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

