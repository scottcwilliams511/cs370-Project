package com.app.agile_overlords.moveandgroove.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


import com.app.agile_overlords.moveandgroove.Adapters.NutritionAdapter;
import com.app.agile_overlords.moveandgroove.AppDefines;
import com.app.agile_overlords.moveandgroove.Models.NutritionItemModel;
import com.app.agile_overlords.moveandgroove.Models.SearchResultsModel;
import com.app.agile_overlords.moveandgroove.R;
import com.app.agile_overlords.moveandgroove.Services.api.ApiClient;

/**
 * Created by brittneyryn on 4/14/16.
 */
public class SearchFragment extends Fragment {
    private EditText searchText;
    private Button searchButton;
    private RecyclerView nutritionRecyclerView;
    private NutritionAdapter adapter;
    private LinearLayoutManager layoutManager;
    private OnFragmentEvent onFragmentEvent;

    public SearchFragment(){

    }

    public static SearchFragment newInstance(){
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        searchText = (EditText)view.findViewById(R.id.searchText);
        searchButton = (Button)view.findViewById(R.id.searchButton);
        nutritionRecyclerView = (RecyclerView)view.findViewById(R.id.nutritionRecyclerView);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiClient.getInstance().getNutritionApiAdapter()
                        .getSearchResults(
                                searchText.getText().toString(),
                                AppDefines.APPLICATION_ID,
                                AppDefines.APPLICATION_KEY
                        )
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<SearchResultsModel>() {
                            @Override
                            public void onCompleted() {

                            }

                            @Override
                            public void onError(Throwable e) {
                                int i = 0;
                            }

                            @Override
                            public void onNext(SearchResultsModel searchResultsModel) {

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
                                layoutManager.scrollToPosition(0);
                                // Assigning the LayoutManager to the RecyclerView
                                nutritionRecyclerView.setLayoutManager(layoutManager);
                                // Assigning the Adapter to the RecyclerView. If this isn't done, the view will not populate
                                nutritionRecyclerView.setAdapter(adapter);
                            }
                        });
            }
        });



<<<<<<< HEAD

=======
>>>>>>> origin/BennettMatthew1
        return view;
    }


    public void setOnFragmentEvent(OnFragmentEvent onFragmentEvent) {
        this.onFragmentEvent = onFragmentEvent;
    }
    public interface OnFragmentEvent {
        void onEvent(NutritionItemModel item);
    }

}

