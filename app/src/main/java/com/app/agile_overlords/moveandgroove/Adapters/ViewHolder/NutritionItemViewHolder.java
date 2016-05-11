package com.app.agile_overlords.moveandgroove.Adapters.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import com.app.agile_overlords.moveandgroove.Models.NutritionItemModel;
import com.app.agile_overlords.moveandgroove.R;

import org.w3c.dom.Text;

/**
 * Created on 3/31/2016.
 */


public class NutritionItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView foodName;
    private ImageView foodThumbnail;
    private NutritionItemModel item;
    private TextView item_name;
    private TextView brand_name;
    private OnNutritionItemClicked onNutritionItemClicked;

    //todo add other elements here

    public NutritionItemViewHolder(final View itemView) {super(itemView);}

    public final void bind(final NutritionItemModel item) {

        item_name = (TextView)itemView.findViewById(R.id.item_name);
        brand_name = (TextView)itemView.findViewById(R.id.brand_name);

        item_name.setText(item.getFields().getItem_name());
        brand_name.setText(String.valueOf(item.getFields().getBrand_name()));
    }

    public final void unbind() {
        //todo ?
        //For later with butterknife
    }

    @Override
    public void onClick(View v) {
        if(onNutritionItemClicked != null) {
            onNutritionItemClicked.onClick(item);
        }

    }

    // The setter that allows other classes to create a reference to the listener.
    public void setOnRecipeItemClicked(OnNutritionItemClicked onNutritionItemClicked) {
        this.onNutritionItemClicked = onNutritionItemClicked;
    }

    // An interface is added as an internal implementation in our ViewHolder.  This will allow
    // classes that instantiate a new instance of this ViewHolder to subscribe to this interface
    // and listen for events.
    public interface OnNutritionItemClicked {
        void onClick(NutritionItemModel item);
    }

}
