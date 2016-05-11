package com.app.agile_overlords.moveandgroove.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
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
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        if(getFragmentManager().getBackStackEntryCount() > 0)
            getFragmentManager().popBackStack();
        else
            super.onBackPressed();
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
