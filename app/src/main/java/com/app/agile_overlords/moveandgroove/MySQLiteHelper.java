package com.app.agile_overlords.moveandgroove;

/**
 * Created by matthew on 4/17/16.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.app.agile_overlords.moveandgroove.Models.ExerciseModel;
import com.app.agile_overlords.moveandgroove.Models.Fields;
import com.app.agile_overlords.moveandgroove.Models.NutritionItemModel;

import java.util.ArrayList;
import java.util.List;

public class MySQLiteHelper extends SQLiteOpenHelper {

    // Exercise database info
    public static final String EXERCISE_TABLE = "exercise";
    public static final String E_ID = "_id";
    public static final String E_NAME = "name";
    public static final String E_TYPE = "type";
    public static final String E_INFO = "info";
    //public static final String E_SETS = "sets";
    //public static final String E_REPS = "reps";
    //public static final String E_DURATION = "duration";

    // Food database info
    public static final String FOOD_TABLE = "food";
    public static final String F_ID = "_id";
    public static final String F_ITEM_NAME = "item_name";
    public static final String F_BRAND_NAME = "brand_name";
    public static final String F_CALS = "cals";
    public static final String F_CALS_FAT = "cals_fat";
    public static final String F_TOTAL_FAT = "total_fat";
    public static final String F_SAT_FAT = "sat_fat";
    public static final String F_FAT_ACID = "fat_acid";
    public static final String F_CHOLESTEROL = "cholestoral";
    public static final String F_SODIUM = "sodium";
    public static final String F_CARBS = "carbs";
    public static final String F_FIBER = "fiber";
    public static final String F_SUGARS = "sugars";
    public static final String F_VIT_C = "vitamin_c";
    public static final String F_CALCIUM = "calcium";
    public static final String F_IRON = "iron";
    public static final String F_SERVING_GRAMS = "serving_grams";


    private final Context mCtx;
    private static final String DATABASE_NAME = "MoveAndGroove.db";
    private static final int DATABASE_VERSION = 1;

    // Exercise database SQL creation statement
    private static final String DATABASE_CREATE_EXERCISE = "create table "
            + EXERCISE_TABLE + "(" + E_ID
            + " integer primary key autoincrement, " + E_NAME + " text not null,"
            + E_TYPE + " text not null," + E_INFO + " text not null);";

    // Food database SQL creation statement
    private static final String DATABASE_CREATE_FOOD = "create table "
            + FOOD_TABLE + "(" + F_ID + " integer primary key autoincrement, " +
            F_ITEM_NAME + " text," + F_BRAND_NAME + " text," + F_CALS + " real,"
            + F_CALS_FAT + " real," + F_TOTAL_FAT + " real," + F_SAT_FAT + " real,"
            + F_FAT_ACID + " real," + F_CHOLESTEROL + " real," + F_SODIUM + " real,"
            + F_CARBS + " real," + F_FIBER + " real," + F_SUGARS + " real,"
            + F_VIT_C + " real," + F_CALCIUM + " real," + F_IRON + " real,"
            + F_SERVING_GRAMS + " real);";


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        this.mCtx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_EXERCISE);
        db.execSQL(DATABASE_CREATE_FOOD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EXERCISE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + FOOD_TABLE);
        onCreate(db);
    }

    public boolean insertExercise(String name, String type, String info) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(E_NAME, name);
        contentValues.put(E_TYPE, type);
        contentValues.put(E_INFO, info);
        //contentValues.put(E_REPS, reps);
        //contentValues.put(E_DURATION, duration);
        long result = db.insert(EXERCISE_TABLE, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean insertFood(String item_name, String brand_name, Double cals, Double fat_cals, Double total_fat,
                              Double sat_fat, Double fat_acid, Double cholesterol, Double sodium, Double carbs,
                              Double fiber, Double sugar, Double vit_c, Double calcium, Double iron, Double serving) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(F_ITEM_NAME, item_name);
        contentValues.put(F_BRAND_NAME, brand_name);
        contentValues.put(F_CALS, cals);
        contentValues.put(F_CALS_FAT, fat_cals);
        contentValues.put(F_TOTAL_FAT, total_fat);
        contentValues.put(F_SAT_FAT, sat_fat);
        contentValues.put(F_FAT_ACID, fat_acid);
        contentValues.put(F_CHOLESTEROL, cholesterol);
        contentValues.put(F_SODIUM, sodium);
        contentValues.put(F_CARBS, carbs);
        contentValues.put(F_FIBER, fiber);
        contentValues.put(F_SUGARS, sugar);
        contentValues.put(F_VIT_C, vit_c);
        contentValues.put(F_CALCIUM, calcium);
        contentValues.put(F_IRON, iron);
        contentValues.put(F_SERVING_GRAMS, serving);
        long result = db.insert(FOOD_TABLE, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public List<ExerciseModel> getExerciseData() {
        List<ExerciseModel> modelList = new ArrayList<ExerciseModel>();
        String query = "select * from " + EXERCISE_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()) {
            do{
                ExerciseModel model = new ExerciseModel();
                model.setName(cursor.getString(0));
                model.setType(cursor.getString(1));
                model.setInfo(cursor.getString(2));
                //model.setNumReps(cursor.getString(3));
                //model.setDuration(cursor.getString(4));
                modelList.add(model);
            }while (cursor.moveToNext());
        }
        return modelList;
    }

    public List<Fields> getFoodData() {
        List<Fields> modelList = new ArrayList<Fields>();
        String query = "select * from " + FOOD_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()) {
            do {
                Fields model = new Fields();
                model.setItem_name(cursor.getString(0));
                model.setBrand_name(cursor.getString(1));
                model.setNf_calories(cursor.getDouble(2));
                model.setNf_calories_from_fat(cursor.getDouble(3));
                model.setNf_total_fat(cursor.getDouble(4));
                model.setNf_saturated_fat(cursor.getDouble(5));
                model.setNf_trans_fatty_acid(cursor.getDouble(6));
                model.setNf_cholesterol(cursor.getDouble(7));
                model.setNf_sodium(cursor.getDouble(8));
                model.setNf_total_carbohydrate(cursor.getDouble(9));
                model.setNf_dietary_fiber(cursor.getDouble(10));
                model.setNf_sugars(cursor.getDouble(11));
                model.setNf_vitamin_c_dv(cursor.getDouble(12));
                model.setNf_calcium_dv(cursor.getDouble(13));
                model.setNf_iron_dv(cursor.getDouble(14));
                model.setNf_serving_weight_grams(cursor.getDouble(15));
            }while (cursor.moveToNext());
        }
        return modelList;
    }

    public Cursor getAllExerciseData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + EXERCISE_TABLE, null);
        return res;
    }

    public boolean updateExerciseData(String id, String name, String type, String info) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(E_NAME, name);
        contentValues.put(E_TYPE, type);
        contentValues.put(E_INFO, info);
//      contentValues.put(E_REPS, reps);
//      contentValues.put(E_DURATION, duration);
        db.update(EXERCISE_TABLE, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteExerciseData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(EXERCISE_TABLE, "ID = ?",new String[] {id});
    }
}

