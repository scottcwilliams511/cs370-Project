package com.app.agile_overlords.moveandgroove.Adapters.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import com.app.agile_overlords.moveandgroove.Models.NutritionItemModel;
import com.app.agile_overlords.moveandgroove.R;

/**
 * Created by Scott Williams on 3/31/2016.
 */
public class NutritionItemViewHolder extends RecyclerView.ViewHolder {
    private TextView foodName;
    private ImageView foodThumbnail;
    //todo add other elements here

    public NutritionItemViewHolder(final View itemView) {super(itemView);}

    public final void bind(final NutritionItemModel item) {
        foodName = (TextView)itemView.findViewById(R.id.foodName);
        foodThumbnail = (ImageView)itemView.findViewById(R.id.foodThumbnail);
        //todo add other element id things here

        //used for preloading images
        Glide.with(itemView.getContext())
                .load(item.getSmallImageUrls().get(0))
                .into(foodThumbnail);

        foodName.setText(item.getFoodName());
    }

    public final void unbind() {
        //todo ?
        //For later with butterknife
    }

}
