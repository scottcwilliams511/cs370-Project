package com.app.agile_overlords.moveandgroove.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.app.agile_overlords.moveandgroove.Adapters.NutritionAdapter;
import com.app.agile_overlords.moveandgroove.Listeners.INutritionCallbackListener;
import com.app.agile_overlords.moveandgroove.Models.NutritionItemModel;
import com.app.agile_overlords.moveandgroove.Models.SearchResultsModel;
import com.app.agile_overlords.moveandgroove.R;
import com.app.agile_overlords.moveandgroove.Services.NutritionSearchTask;

/**
 * Created by brittneyryn on 4/7/16.
 */
public class SearchFragment extends Fragment {
    private EditText searchText;
    private Button searchButton;
    private RecyclerView nutritionRecyclerView;

    private NutritionAdapter adapter;
    private LinearLayoutManager layoutManager;
    private OnFragmentEvent onFragmentEvent;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public SearchFragment() {

    }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        // Assigning layout file instances of these UI elements to their java counterparts
        searchText = (EditText)view.findViewById(R.id.searchText);
        searchButton = (Button)view.findViewById(R.id.searchButton);
        nutritionRecyclerView = (RecyclerView)view.findViewById(R.id.nutritionRecyclerView);

        // A RecyclerView needs a layout manager assigned to instruct it on how to lay content out
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        // A click listener is defined to handle the callback from the RecipeAsyncTask
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creating an inline concrete implementation of the listener to handle callback on the main thread
                INutritionCallbackListener listener = new INutritionCallbackListener() {
                    @Override
                    public void onSearchCallback(SearchResultsModel searchResultsModel) {

                        // On handling the http response, instantiate a new adapter with the results
                        adapter = new NutritionAdapter(searchResultsModel.getSearchResults());

                        adapter.setOnItemSelected(new NutritionAdapter.OnItemSelected() {
                            @Override
                            public void onSelected(NutritionItemModel item) {
                                if (onFragmentEvent != null) {
                                    onFragmentEvent.onEvent(item);
                                }
                            }
                        });

                        // Assigning the LayoutManager to the RecyclerView
                        nutritionRecyclerView.setLayoutManager(layoutManager);
                        // Assigning the Adapter to the RecyclerView. If this isn't done, the view will not populate
                        nutritionRecyclerView.setAdapter(adapter);
                    }
                };

                // Instantiate a new AsyncTask to make an http call on background thread.
                // RecipeSearch task now has a constructor which requires an instance of IRecipeCallbackListener
                NutritionSearchTask nutritionSearchTask = new NutritionSearchTask(listener);
                // Execute the AsyncTask
                nutritionSearchTask.execute(searchText.getText().toString());
            }
        });

        return view;
    }

    /*public View onCreate(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

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
*/
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void setOnFragmentEvent(OnFragmentEvent onFragmentEvent) {
        this.onFragmentEvent = onFragmentEvent;
    }


public interface OnFragmentEvent {
    void onEvent(NutritionItemModel item);
}

}

