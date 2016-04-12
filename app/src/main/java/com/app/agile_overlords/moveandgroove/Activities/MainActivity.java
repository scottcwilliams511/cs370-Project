package com.app.agile_overlords.moveandgroove.Activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


import com.app.agile_overlords.moveandgroove.Fragments.MainFragment;
import com.app.agile_overlords.moveandgroove.Fragments.UserFragment;
import com.app.agile_overlords.moveandgroove.Models.UserModel;
import com.app.agile_overlords.moveandgroove.R;

/**
 * Created by brittneyryn on 4/8/16.
 */
public class MainActivity extends AppCompatActivity {
    private MainFragment mainFragment;
    private UserFragment userFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        setContentView(R.layout.activity_search);

        searchText = (EditText)findViewById(R.id.searchText);
        searchButton = (Button)findViewById(R.id.searchButton);
        nutritionRecyclerView = (RecyclerView) this.findViewById(R.id.nutritionRecyclerView);
=======
        setContentView(R.layout.main_display);
        mainFragment = MainFragment.newInstance();
>>>>>>> master

        mainFragment.setOnFragmentEvent(new MainFragment.OnFragmentEvent() {

<<<<<<< HEAD
<<<<<<< HEAD
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

                NutritionSearchTask nutritionSearchTask = new NutritionSearchTask(listener);

                nutritionSearchTask.execute(searchText.getText().toString());
=======
            public void onEvent(UserModel user){
=======
            public void onEvent(UserModel user) {
>>>>>>> fragments
                userFragment = UserFragment.newInstance();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, userFragment)
                        .addToBackStack(UserFragment.class.getSimpleName())
                        .commit();
>>>>>>> master
            }

        });

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, mainFragment)
                .addToBackStack(MainFragment.class.getSimpleName())
                .commit();

    }
    public void onBackPressed(){
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            Log.i("MainActivity", "popping backstack");
            fm.popBackStack();
        } else {
            Log.i("MainActivity", "nothing on backstack, calling super");
            super.onBackPressed();
        }
    }

<<<<<<< HEAD
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
=======
>>>>>>> master

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
<<<<<<< HEAD
    */

}
=======

}
>>>>>>> master
