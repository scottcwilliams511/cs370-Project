package com.app.agile_overlords.moveandgroove.Adapters.ViewHolder;

import android.view.View;
import android.widget.TextView;

import com.app.agile_overlords.moveandgroove.Models.NutritionItemModel;
import com.app.agile_overlords.moveandgroove.R;

/**
 * Created by Scott Williams on 3/31/2016.
 */
public class NutritionItemViewHolder {
    private TextView foodName;
    //todo add other elements here

    public NutritionItemViewHolder(final View itemView) {super(itemView);}

    public final void bind(final NutritionItemModel item) {
        foodName = (TextView)itemView.findViewById(R.id.foodName);
        //todo add other element id things here

        //used for preloading images
        //Glide.with(itemView.getContext())
         //       .load(item.getSmallImageUrls().get(0))
        foodName.setText(item.getFoodName());
    }

    public final void unbind() {
        //todo ?
        //For later with butterknife
    }

}
