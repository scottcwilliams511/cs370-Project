package com.app.agile_overlords.moveandgroove.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Never Forget on 4/7/2016.
 */
public class Fields {
    @SerializedName("nf_calories")
    private String item_id;
    private String _id;
    private int nf_calories;
    private String item_name;
    private String brand_name;


    public int getNf_calories() {
        return nf_calories;
    }

    public void setItem_id(String item_id) {this.item_id = item_id; };

    public String getItem_id() {return item_id; };

    public void setId(String _id) {this._id = _id; };

    public String getId() {return _id; };

    public void setNf_calories(int nf_calories) {
        this.nf_calories = nf_calories;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }
}

