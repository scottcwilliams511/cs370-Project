package com.app.agile_overlords.moveandgroove.Models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Scott Williams on 3/31/2016.
 */

public class NutritionItemModel implements Serializable {

    private String _id;
    private Fields fields;

    public String get_id() {
        return _id;
    }

    public Fields getFields() {
        return fields;
    }
}