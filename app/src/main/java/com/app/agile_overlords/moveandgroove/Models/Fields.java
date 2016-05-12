package com.app.agile_overlords.moveandgroove.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Never Forget on 4/7/2016.
 */
public class Fields {
    private String item_name;
    private String brand_name;
    @SerializedName("nf_calories")
    @Expose private Float nf_calories;
    private Double nf_calories_from_fat;
    private Double nf_total_fat;
    private Double nf_saturated_fat;
    private Double nf_trans_fatty_acid;
    private Double nf_serving_size_qty;
    //    private Double nf_polyunsaturated_fat;
//    private Double nf_monounsaturated_fat;
    private String nf_serving_size_unit;
    private Double nf_cholesterol;
    private Double nf_sodium;
    private Double nf_total_carbohydrate;
    private Double nf_dietary_fiber;
    private Double nf_sugars;
    private Double nf_vitamin_c_dv;
    private Double nf_calcium_dv;
    private Double nf_iron_dv;
//    private Double nf_servings_per_container;
//    private Double nf_serving_size_qty;
//    private String nf_serving_size_unit;

    private Double nf_serving_weight_grams;

    // TODO: Connect to NutritionItemModel and change some data types?
    public Fields() {};

    public String getItem_name() {
        return item_name;
    }
    public void setItem_name(String item_name) { this.item_name = item_name; }

    public String getBrand_name() {return brand_name;}
    public void setBrand_name(String brand_name) { this.brand_name = brand_name; }

    public Float getNf_calories() {
        return nf_calories;
    }
    public void setNf_calories(Float nf_calories) { this.nf_calories = nf_calories;}

    // ????
    public String get_calories(){
        String number = String.valueOf(nf_calories);
        return number;
    }

    //public String getNf_serving_size_unit() {return nf_serving_size_unit;}
    public Double getNf_calories_from_fat() {return nf_calories_from_fat;}
    public void setNf_calories_from_fat(Double nf_calories_from_fat) { this.nf_calories_from_fat = nf_calories_from_fat; }

    public Double getNf_total_fat() {return nf_total_fat;}
    public void setNf_total_fat(Double nf_total_fat) { this.nf_total_fat = nf_total_fat; }

    public Double getNf_saturated_fat() {
        return nf_saturated_fat;
    }
    public void setNf_saturated_fat(Double nf_saturated_fat) { this.nf_saturated_fat = nf_saturated_fat; }

    public Double getNf_trans_fatty_acid() {
        return nf_trans_fatty_acid;
    }
    public void setNf_trans_fatty_acid(Double nf_trans_fatty_acid) { this.nf_trans_fatty_acid = nf_trans_fatty_acid; }

    //public Double getNf_polyunsaturated_fat() {return nf_polyunsaturated_fat;}

    //public Double getNf_monounsaturated_fat() {return nf_monounsaturated_fat;}

    public Double getNf_cholesterol() {
        return nf_cholesterol;
    }
    public void setNf_cholesterol(Double nf_cholesterol) { this.nf_cholesterol = nf_cholesterol; }

    public Double getNf_sodium() {
        return nf_sodium;
    }
    public void setNf_sodium(Double nf_sodium) { this.nf_sodium = nf_sodium; }

    public Double getNf_total_carbohydrate() {
        return nf_total_carbohydrate;
    }
    public void setNf_total_carbohydrate(Double nf_total_carbohydrate) { this.nf_total_carbohydrate = nf_total_carbohydrate; }

    public Double getNf_dietary_fiber() {
        return nf_dietary_fiber;
    }
    public void setNf_dietary_fiber(Double nf_dietary_fiber) { this.nf_dietary_fiber = nf_dietary_fiber; }

    public Double getNf_sugars() {
        return nf_sugars;
    }
    public void setNf_sugars(Double nf_sugars) { this.nf_sugars = nf_sugars; }

    public Double getNf_vitamin_c_dv() {
        return nf_vitamin_c_dv;
    }
    public void setNf_vitamin_c_dv(Double nf_vitamin_c_dv) { this.nf_vitamin_c_dv = nf_vitamin_c_dv; }

    public Double getNf_calcium_dv() {
        return nf_calcium_dv;
    }
    public void setNf_calcium_dv(Double nf_calcium_dv) { this.nf_calcium_dv = nf_calcium_dv; }

    public Double getNf_iron_dv() {
        return nf_iron_dv;
    }
    public void setNf_iron_dv(Double nf_iron_dv) { this.nf_iron_dv = nf_iron_dv; }

    public String getNf_serving_size_unit() {return nf_serving_size_unit;}
    public void setNf_serving_size_unit(String string) {nf_serving_size_unit = string;}

    public Double getNf_serving_weight_grams() {
        return nf_serving_weight_grams;
    }
    public void setNf_serving_weight_grams(Double nf_serving_weight_grams) { this.nf_serving_weight_grams = nf_serving_weight_grams; }

    public Double getNf_serving_size_qty() {
        return nf_serving_size_qty;
    }
    void setNf_serving_size_qty(double serving_size_qty){
        this.nf_serving_size_qty = serving_size_qty;
    }


}
