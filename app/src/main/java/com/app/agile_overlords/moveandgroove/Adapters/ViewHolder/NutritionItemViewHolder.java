package com.app.agile_overlords.moveandgroove.Adapters.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import com.app.agile_overlords.moveandgroove.Models.NutritionItemModel;
import com.app.agile_overlords.moveandgroove.R;

/**
 * Created on 3/31/2016.
 */
public class NutritionItemViewHolder extends RecyclerView.ViewHolder {
    private TextView fields;
    private NutritionItemModel item;
    //private ImageView foodThumbnail;
    //todo add other elements here

    public NutritionItemViewHolder(final View itemView) {super(itemView);}

    public final void bind(final NutritionItemModel item) {

        fields = (TextView)itemView.findViewById(R.id.fields);
        //foodThumbnail = (ImageView)itemView.findViewById(R.id.foodThumbnail);
        //todo add other element id things here

        /*
        //used for preloading images
        Glide.with(itemView.getContext())
                .load(item.getSmallImageUrls().get(0))
                .into(foodThumbnail);
            */
        fields.setText(item.getFields().getItem_name());
    }

    public final void unbind() {
        //todo ?
        //For later with butterknife
    }

}
