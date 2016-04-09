package com.app.agile_overlords.moveandgroove.Adapters.ViewHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;

import com.app.agile_overlords.moveandgroove.Models.UserModel;
import com.app.agile_overlords.moveandgroove.R;

import java.util.ArrayList;

/**
 * Created by brittneyryn on 4/8/16.
 */
public class UserAdapter extends ArrayAdapter<UserViewHolder> {

    // A local collection that will eventually be assigned a collection of RecipeItemModels as a
    // part of class instantiation
    private UserModel user;
    private OnItemSelected onItemSelected;

    public UserAdapter(Context context, int resource) {
        super(context, resource);
    }



    // An overridden virtual method that is responsible for creating an instance of a ViewHolder to
    // contain the data for a given object.
   /* @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_user, parent, false);

        // We return a new instance of RecipeItemViewHolder after passing it a a view to bind data to
        return new UserViewHolder(view);
    }*/

    // An overridden virtual method that binds an item in the collection of RecipesItemModels to the
    // instance of the ViewHolder created in {@see onCreateViewHolder}.


    // The setter that allows other classes to create a reference to the listener.
    public void setOnItemSelected(OnItemSelected onItemSelected) {
        this.onItemSelected = onItemSelected;
    }

    // An interface defined internal to the Adapter class.  This interface, in conjunction with the
    // ViewHolder interface, will relay events captured on the ViewHolder (selection events) up to
    // the Adapter, and subsequently, up to the SearchFragment and SearchActivity by means of a chained
    // set of listeners.
    public interface OnItemSelected {
        void onSelected(UserModel item);
    }



}
