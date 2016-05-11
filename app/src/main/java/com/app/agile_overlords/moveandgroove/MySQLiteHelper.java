package com.app.agile_overlords.moveandgroove;

/**
 * Created by matthew on 4/17/16.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.app.agile_overlords.moveandgroove.Models.ExerciseModel;
import com.app.agile_overlords.moveandgroove.Models.Fields;
import com.app.agile_overlords.moveandgroove.Models.NutritionItemModel;
import java.util.ArrayList;
import java.util.List;

public class MySQLiteHelper extends SQLiteOpenHelper {


    String name;
    Integer myweight;
    Integer myage;
    Integer myhtft;
    Integer myhtin;
    Float myweek;
    Float mygoal;

    public static final String USER_TABLE1 = "user1";
    public static final String KEY_ID = "_id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String WEIGHT = "weight";
    public static final String SEX = "sex";
    public static final String AGE = "age";
    public static final String HEIGHT_FEET = "height_feet";
    public static final String HEIGHT_INCHES = "height_inches";
    public static final String DATE_JOINED = "date_joined";
    public static final String WEEKLY_GOAL = "weekly_goal";
    public static final String GOAL_WEIGHT = "goal_weight";

    public static final String CALORIE_TABLE = "calories_table";
    public static final String CAL_ID = "_id";
    public static final String TOTAL_CALORIES = "calories";

    //private final Context mCtx;

    private static final String DATABASE_CREATE_CALORIE = "CREATE TABLE " + CALORIE_TABLE + "(" + CAL_ID + " integer primary key " +
            TOTAL_CALORIES + " real not null);";

    private static final String DATABASE_CREATE_USER = "CREATE TABLE " + USER_TABLE1 + "(" + KEY_ID + " integer primary key autoincrement," + FIRST_NAME + " TEXT not null," + LAST_NAME + " TEXT not null," + WEIGHT + " REAL not null," +
            SEX + " TEXT not null," + AGE + " INTEGER not null," + HEIGHT_FEET + " INTEGER not null," + HEIGHT_INCHES + " INTEGER not null," +
            DATE_JOINED + " DATETIME," + WEEKLY_GOAL + " INTEGER not null," + GOAL_WEIGHT + " INTEGER not null);";


    public static final String E_TABLE_NAME = "exercise";
    // public static final String E_ID = "_id";
    //public static final String E_NAME = "NAME";


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
        SQLiteDatabase db = this.getWritableDatabase(); //
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_EXERCISE);
        db.execSQL(DATABASE_CREATE_FOOD);
        db.execSQL(DATABASE_CREATE_USER);
        db.execSQL(DATABASE_CREATE_CALORIE);
        //db.execSQL(DATABASE_CREATE_WORKOUT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //TODO: Check ME!!!!
        db.execSQL("DROP TABLE IF EXISTS " + EXERCISE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + FOOD_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + E_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE1);

        db.execSQL("DROP TABLE IF EXISTS " + CALORIE_TABLE);
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
        if (result == -1)
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
        if (result == -1)
            return false;
        else
            return true;
    }

    public List<ExerciseModel> getExerciseData() {
        List<ExerciseModel> modelList = new ArrayList<ExerciseModel>();
        String query = "select * from " + EXERCISE_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                ExerciseModel model = new ExerciseModel();
                model.setName(cursor.getString(1));
                model.setType(cursor.getString(2));
                model.setInfo(cursor.getString(3));
                //model.setNumReps(cursor.getString(3));
                //model.setDuration(cursor.getString(4));
                modelList.add(model);
            } while (cursor.moveToNext());
        }
        return modelList;
    }

    public List<Fields> getFoodData() {
        List<Fields> modelList = new ArrayList<Fields>();
        String query = "select * from " + FOOD_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                Fields model = new Fields();
                model.setItem_name(cursor.getString(0));
                model.setBrand_name(cursor.getString(1));
                model.setNf_calories(cursor.getString(2));
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
            } while (cursor.moveToNext());
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
        db.update(EXERCISE_TABLE, contentValues, "ID = ?", new String[]{id});

        db.update(E_TABLE_NAME, contentValues, "ID = ?", new String[]{id});

        return true;
    }

    public Integer deleteExerciseData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(EXERCISE_TABLE, "ID = ?", new String[]{id});
    }

    // initialize calorie table
    public long insertCalorie() {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(CAL_ID, 1);
        contentValues.put(TOTAL_CALORIES, 0);
        CalorieSingleton.setCalorieSingleton(0.0);

        long result = db.insert(CALORIE_TABLE, null, contentValues);

        return result;

    }

    public boolean updateCalorie(String calorie) {

        //name = MoveAndGrooveApplication.getUserModel().GetFirstName();

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(TOTAL_CALORIES, calorie);

        db.update(CALORIE_TABLE, contentValues, "first_name = ?", new String[]{name});


//        myweight = Integer.parseInt(weight);
//        MoveAndGrooveApplication.getUserModel().SetWeight(myweight);

        return true;


    }


    public long insertUser(String first_name, String last_name, String weight, String sex, String age, String height_feet,
                           String height_inches) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put(FIRST_NAME, first_name);
        contentValues.put(LAST_NAME, last_name);
        contentValues.put(WEIGHT, weight);
        contentValues.put(SEX, sex);
        contentValues.put(AGE, age);
        contentValues.put(HEIGHT_FEET, height_feet);
        contentValues.put(HEIGHT_INCHES, height_inches);


        Cursor c = db.rawQuery("select * from user1", null);
        if (c.getCount() > 0) {

            int clength = c.getCount();

        }

        while (c.moveToNext()) {
            String tes0 = Integer.toString(c.getInt(c.getColumnIndex("_id")));

            String tes1 = c.getString(c.getColumnIndex("first_name"));

            name = tes1;

        }

        myweight = Integer.parseInt(weight);
        myage = 0;
        myage = Integer.parseInt(age);
        myhtft = 0;
        myhtft = Integer.parseInt(height_feet);
        myhtin = 0;
        myhtin = Integer.parseInt(height_inches);
        MoveAndGrooveApplication.getUserModel().SetFirstName(first_name);
        MoveAndGrooveApplication.getUserModel().SetLastName(last_name);
        MoveAndGrooveApplication.getUserModel().SetSex(sex);
        MoveAndGrooveApplication.getUserModel().SetAge(myage);
        MoveAndGrooveApplication.getUserModel().SetWeight(myweight);
        MoveAndGrooveApplication.getUserModel().SetHeightFeet(myhtft);
        MoveAndGrooveApplication.getUserModel().SetHeightInches(myhtin);

        //MoveAndGrooveApplication.getUserModel().setUserId(MySQLiteHelper.KEY_ID);
//        MoveAndGrooveApplication.getUserModel().SetFirstName(first_name);
//        MoveAndGrooveApplication.getUserModel().SetLastName(last_name);
//        Float convertWeight = Float.parseFloat(weight);
//        MoveAndGrooveApplication.getUserModel().SetWeight(convertWeight);
//        MoveAndGrooveApplication.getUserModel().SetSex(sex);
//        Integer convertAge = Integer.parseInt(age);
//        MoveAndGrooveApplication.getUserModel().SetAge(convertAge);
//        Integer convertHtft = Integer.parseInt(height_feet);
//        MoveAndGrooveApplication.getUserModel().SetHeightFeet(convertHtft);
//        Integer convertHtin = Integer.parseInt(height_inches);
//        MoveAndGrooveApplication.getUserModel().SetHeightInches(convertHtin);
//        Float convertWeek = Float.parseFloat(weekly_goal);
//        MoveAndGrooveApplication.getUserModel().SetWeeklyGoal(convertWeek);
//        Float convertGoal = Float.parseFloat(goal_weight);
//        MoveAndGrooveApplication.getUserModel().SetGoalWeight(convertGoal);

        //return db.insert(USER_TABLE1, null, contentValues);

        long result = db.insert(USER_TABLE1, null, contentValues);

        return result;
        /*
        if(result == -1)
            return false;
        else
            return  true;
    */
    }

    public Cursor getAllUserData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + USER_TABLE1, null);
        return res;
    }


    public boolean updateUserWeight(String weight) {

        name = MoveAndGrooveApplication.getUserModel().GetFirstName();

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(WEIGHT, weight);

        db.update(USER_TABLE1, contentValues, "first_name = ?", new String[]{name});


        myweight = Integer.parseInt(weight);
        MoveAndGrooveApplication.getUserModel().SetWeight(myweight);

        return true;


    }


    public boolean updateUserData(String first_name, String last_name, String weight, String sex, String age, String height_feet,
                                  String height_inches) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(FIRST_NAME, first_name);
        contentValues.put(LAST_NAME, last_name);
        contentValues.put(WEIGHT, weight);
        contentValues.put(SEX, sex);
        contentValues.put(AGE, age);
        contentValues.put(HEIGHT_FEET, height_feet);
        contentValues.put(HEIGHT_INCHES, height_inches);


        db.update(USER_TABLE1, contentValues, "first_name = ?", new String[]{first_name});


        MoveAndGrooveApplication.getUserModel().SetFirstName(first_name);
        MoveAndGrooveApplication.getUserModel().SetLastName(last_name);
        myweight = Integer.parseInt(weight);
        MoveAndGrooveApplication.getUserModel().SetWeight(myweight);
        MoveAndGrooveApplication.getUserModel().SetSex(sex);
        myage = Integer.parseInt(age);
        MoveAndGrooveApplication.getUserModel().SetAge(myage);
        myhtft = Integer.parseInt(height_feet);
        MoveAndGrooveApplication.getUserModel().SetHeightFeet(myhtft);
        myhtin = Integer.parseInt(height_inches);
        MoveAndGrooveApplication.getUserModel().SetHeightInches(myhtin);


        return true;
    }

    public Integer deleteUserData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(USER_TABLE1, "ID = ?", new String[]{id});
    }


    public void insertSingleUser() {

        insertUser("Jeff", "Fisher", "180", "male", "35", "5", "11");


    }


    public Cursor fetchUsersByName(String inputText) throws SQLException {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor mCursor = null;
        if (inputText == null || inputText.length() == 0) {
            mCursor = db.query(USER_TABLE1, new String[]{KEY_ID,
                            FIRST_NAME, LAST_NAME, WEIGHT, SEX, AGE, HEIGHT_FEET,
                            HEIGHT_INCHES, WEEKLY_GOAL, GOAL_WEIGHT},
                    null, null, null, null, null);

        } else {
            mCursor = db.query(true, USER_TABLE1, new String[]{KEY_ID,
                            FIRST_NAME, LAST_NAME, WEIGHT, SEX, AGE, HEIGHT_FEET,
                            HEIGHT_INCHES, WEEKLY_GOAL, GOAL_WEIGHT},
                    FIRST_NAME + " like '%" + inputText + "%'", null,
                    null, null, null, null);
        }
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }


    public void close() {
        SQLiteDatabase db = this.getWritableDatabase();
        if (db != null) {
            db.close();
        }
    }

    public MySQLiteHelper open() throws SQLException {
        MySQLiteHelper db = new MySQLiteHelper(mCtx);
        SQLiteDatabase mDb = db.getWritableDatabase();
        return this;
    }


    public boolean deleteAllUsers() {

        SQLiteDatabase db = this.getWritableDatabase();
        int doneDelete = 0;
        doneDelete = db.delete(USER_TABLE1, null, null);
        return doneDelete > 0;

    }


    public MySQLiteHelper openToRead() throws android.database.SQLException {
        MySQLiteHelper db = new MySQLiteHelper(mCtx);
        SQLiteDatabase sdb = db.getReadableDatabase();
        return this;
    }

    public Float getWeight(String first_name) {
        Float weight = null;
        Cursor cursor = null;
        if (cursor.moveToFirst()) {
            do {
                weight = cursor.getFloat(cursor.getColumnIndex(MySQLiteHelper.WEIGHT));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return weight;
    }


    public boolean updateUserFirstName(String first) {

        name = MoveAndGrooveApplication.getUserModel().GetLastName();

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(FIRST_NAME, first);

        db.update(USER_TABLE1, contentValues, "last_name = ?", new String[]{name});


        //myweight = Integer.parseInt(weight);
        MoveAndGrooveApplication.getUserModel().SetFirstName(first);

        return true;


    }
}
