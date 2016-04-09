package com.app.agile_overlords.moveandgroove.Activities;


import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.agile_overlords.moveandgroove.Fragments.NutritionItemFragment;
import com.app.agile_overlords.moveandgroove.Fragments.SearchFragment;
import com.app.agile_overlords.moveandgroove.Models.NutritionItemModel;
import com.app.agile_overlords.moveandgroove.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class SearchActivity extends AppCompatActivity {

    private SearchFragment searchFragment;
    private NutritionItemFragment nutritionFragment;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    /* //private EditText searchText;
     private Button searchButton;
     private RecyclerView nutritionRecyclerView;

     private NutritionAdapter adapter;
     private LinearLayoutManager layoutManager;

     //@Bind(R.id.searchText)
     private EditText searchText;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.fragment_search);

         searchText = (EditText)findViewById(R.id.searchText);

         searchButton = (Button)findViewById(R.id.searchButton);
         nutritionRecyclerView = (RecyclerView)findViewById(R.id.nutritionRecyclerView);
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
 }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_search);

        // Creation of a new fragment instance
        searchFragment = SearchFragment.newInstance();

        // A listener that handles an event from the SearchFragment. In this case, it is handling the
        // selection of an item from the search results RecyclerView
        searchFragment.setOnFragmentEvent(new SearchFragment.OnFragmentEvent() {
            // The override for the listener interface method
            @Override
            public void onEvent(NutritionItemModel item) {
                // Creation of a new, different fragment instance to replace the instance currently in view
                nutritionFragment = NutritionItemFragment.newInstance(item);

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, nutritionFragment)
                        .addToBackStack(NutritionItemFragment.class.getSimpleName())
                        .commit();
            }
        });

        // The FragmentManager is used to inject the SearchFragment into the SearchActivity view.
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, searchFragment)
                .addToBackStack(SearchFragment.class.getSimpleName())
                .commit();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}