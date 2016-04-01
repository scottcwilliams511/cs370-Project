package com.app.agile_overlords.moveandgroove;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Scott Williams on 3/31/2016.
 */
public class NutritionAdapter extends RecyclerView.Adapter<NutritionItemViewHolder>{


    private ArrayList<NutritionItemModel> nutritionItemCollection;

    public NutritionAdapter(ArrayList<NutritionItemModel> nutritionItemCollection){
        this.nutritionItemCollection = nutritionItemCollection;
    }

    @Override
    public NutritionItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflator.from(parent.getContext()).inflate(R.layout.item_nutrition, parent,false);
        return new NutritionItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NutritionItemViewHolder holder,int position) {
        NutritionItemModel item = nutritionItemCollection.get(position);
        holder.bind(item);
    }

    @Override
    public final void onViewRecycled(final NutritionItemViewHolder holder) {
        super.onViewRecycled(holder);
        holder.unbind();
    }

    @Override
    public int getItemCount() {return nutritionItemCollection.size();}


}
