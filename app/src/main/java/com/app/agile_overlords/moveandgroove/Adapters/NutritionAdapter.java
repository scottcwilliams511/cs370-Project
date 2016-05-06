package com.app.agile_overlords.moveandgroove.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.agile_overlords.moveandgroove.Models.NutritionItemModel;
import com.app.agile_overlords.moveandgroove.Adapters.ViewHolder.NutritionItemViewHolder;
import com.app.agile_overlords.moveandgroove.R;

import java.util.ArrayList;

/**
 * Created by Scott Williams on 3/31/2016.
 */
public class NutritionAdapter extends RecyclerView.Adapter<NutritionItemViewHolder>{


    private ArrayList<NutritionItemModel> nutritionItemCollection;
    private OnItemSelected onItemSelected;

    public NutritionAdapter(ArrayList<NutritionItemModel> nutritionItemCollection){
        this.nutritionItemCollection = nutritionItemCollection;
    }


    @Override
    public NutritionItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nutrition, parent, false);
        return new NutritionItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NutritionItemViewHolder holder,int position) {
        NutritionItemModel item = nutritionItemCollection.get(position);
        holder.setOnRecipeItemClicked(new NutritionItemViewHolder.OnNutritionItemClicked(){
            @Override
            public void onClick(NutritionItemModel item) {
                if(onItemSelected != null) {
                    onItemSelected.onSelected(item);
                }
            }
        });

        // Bind the RecipeItemModel data to the view managed by the ViewHolder
        holder.bind(item);
    }

//    public void bind(final NutritionItemModel item,final OnItemSelected listener) {
//
//        NutritionItemViewHolder.setOnItemSelected(new View.OnClickListener(){
//            @Override public void onClick(View v) {
//                listener.onSelected(item);
//            }
//        });
//
//    }



    @Override
    public final void onViewRecycled(final NutritionItemViewHolder holder) {
        super.onViewRecycled(holder);
        holder.setOnRecipeItemClicked(null);
        holder.unbind();
    }

    @Override
    public int getItemCount() {return nutritionItemCollection.size();}

    public void setOnItemSelected(OnItemSelected onItemSelected) {
        this.onItemSelected = onItemSelected;
    }
    public interface OnItemSelected {
        void onSelected(NutritionItemModel item);
    }

}
