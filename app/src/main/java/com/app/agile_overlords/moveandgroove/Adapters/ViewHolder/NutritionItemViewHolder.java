package com.app.agile_overlords.moveandgroove.Adapters.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import com.app.agile_overlords.moveandgroove.Models.NutritionItemModel;
import com.app.agile_overlords.moveandgroove.R;

import org.w3c.dom.Text;

/**
 * Created on 3/31/2016.
 */
public class NutritionItemViewHolder extends RecyclerView.ViewHolder {
    private NutritionItemModel item;
    private TextView item_name;
    private TextView brand_name;
    //todo add other elements here

    public NutritionItemViewHolder(final View itemView) {super(itemView);}

    public final void bind(final NutritionItemModel item) {

        item_name = (TextView)itemView.findViewById(R.id.item_name);
        brand_name = (TextView)itemView.findViewById(R.id.brand_name);


        //foodThumbnail = (ImageView)itemView.findViewById(R.id.foodThumbnail);
        //todo add other element id things here

        /*
        //used for preloading images
        Glide.with(itemView.getContext())
                .load(item.getSmallImageUrls().get(0))
                .into(foodThumbnail);
            */

        item_name.setText(item.getFields().getItem_name());
        brand_name.setText(item.getFields().getBrand_name());
    }

    public final void unbind() {
        //todo ?
        //For later with butterknife
    }

}
