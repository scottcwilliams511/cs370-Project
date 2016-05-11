package com.app.agile_overlords.moveandgroove.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.app.agile_overlords.moveandgroove.Fragments.MainFragment;
import com.app.agile_overlords.moveandgroove.Fragments.FoodFragment;
import com.app.agile_overlords.moveandgroove.Fragments.NutritionItemFragment;
import com.app.agile_overlords.moveandgroove.Fragments.SearchFragment;
import com.app.agile_overlords.moveandgroove.Models.NutritionItemModel;
import com.app.agile_overlords.moveandgroove.R;

/**
 * Created by brittneyryn on 4/14/16.
 */
public class SearchActivity extends AppCompatActivity {

    private SearchFragment searchFragment;
    private NutritionItemFragment nutritionItemFragment;
    private FoodFragment foodFragment;


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
    @Override
    public void onBackPressed(){
        foodFragment = FoodFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, foodFragment)
                .commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
