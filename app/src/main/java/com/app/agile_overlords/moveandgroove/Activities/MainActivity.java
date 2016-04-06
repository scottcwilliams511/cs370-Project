package com.app.agile_overlords.moveandgroove.Activities;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.app.agile_overlords.moveandgroove.R;
import com.app.agile_overlords.moveandgroove.Adapters.NutritionAdapter;
import com.app.agile_overlords.moveandgroove.Listeners.INutritionCallbackListener;
import com.app.agile_overlords.moveandgroove.Models.SearchResultsModel;
import com.app.agile_overlords.moveandgroove.Services.NutritionSearchTask;

public class MainActivity extends AppCompatActivity {

    private EditText searchText;
    private Button searchButton;
    private RecyclerView nutritionRecyclerView;

    private NutritionAdapter adapter;
    private LinearLayoutManager layoutManager;

    private String[] mPlanetTiles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchText = (EditText)findViewById(R.id.searchText);
        searchButton = (Button)findViewById(R.id.searchButton);
        nutritionRecyclerView = (RecyclerView)findViewById(R.id.nutritionRecyclerView);

        mPlanetTiles = getResources().getStringArray(R.array.planets_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                INutritionCallbackListener listener =  new INutritionCallbackListener() {
                    @Override
                    public void onSearchCallback(SearchResultsModel searchResultsModel) {
                        adapter = new NutritionAdapter(searchResultsModel.getSearchResults());
                        nutritionRecyclerView.setLayoutManager(layoutManager);
                        nutritionRecyclerView.setAdapter(adapter);
                    }
                };
            }
        });

                //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                //setSupportActionBar(toolbar);

                //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                //fab.setOnClickListener(new View.OnClickListener() {
                //    @Override
                //    public void onClick(View view) {
                //       Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //               .setAction("Action", null).show();
                //   }
                //});
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
}
