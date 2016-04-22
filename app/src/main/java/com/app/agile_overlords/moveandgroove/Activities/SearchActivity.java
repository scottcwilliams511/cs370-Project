package com.app.agile_overlords.moveandgroove.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.app.agile_overlords.moveandgroove.Adapters.NutritionAdapter;
import com.app.agile_overlords.moveandgroove.Fragments.MainFragment;
import com.app.agile_overlords.moveandgroove.Fragments.SearchFragment;
import com.app.agile_overlords.moveandgroove.Listeners.INutritionCallbackListener;
import com.app.agile_overlords.moveandgroove.Models.NutritionItemModel;
import com.app.agile_overlords.moveandgroove.Models.UserModel;
import com.app.agile_overlords.moveandgroove.R;
import com.app.agile_overlords.moveandgroove.Fragments.NutritionItemFragment;

/**
 * Created by brittneyryn on 4/14/16.
 */
public class SearchActivity extends AppCompatActivity {

    private SearchFragment searchFragment;
    private NutritionItemFragment nutritionItemFragment;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);
        searchFragment = SearchFragment.newInstance();


        searchFragment.setOnFragmentEvent(new SearchFragment.OnFragmentEvent() {

            @Override
            public void onEvent(NutritionItemModel item){
                nutritionItemFragment = NutritionItemFragment.newInstance(item);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, nutritionItemFragment)
                        .addToBackStack(NutritionItemFragment.class.getSimpleName())
                        .commit();
            }
        });

       getSupportFragmentManager().beginTransaction()
                .add(R.id.container, searchFragment)
                .addToBackStack(MainFragment.class.getSimpleName())
                .commit();



    }


}
