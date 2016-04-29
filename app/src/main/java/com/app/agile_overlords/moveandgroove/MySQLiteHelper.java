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

    private final Context mCtx;


    private static final String DATABASE_CREATE_USER = "CREATE TABLE " + USER_TABLE1 + "(" + KEY_ID + " integer primary key autoincrement,"  + FIRST_NAME + " TEXT not null," + LAST_NAME + " TEXT not null," + WEIGHT + " REAL not null," +
            SEX + " TEXT not null," + AGE + " INTEGER not null," + HEIGHT_FEET + " INTEGER not null," + HEIGHT_INCHES + " INTEGER not null," +
            DATE_JOINED + " DATETIME," + WEEKLY_GOAL + " INTEGER not null," + GOAL_WEIGHT + " INTEGER not null);";






    public static final String E_TABLE_NAME = "exercise";
    public static final String E_ID = "_id";
    public static final String E_NAME = "NAME";

    private static final String DATABASE_NAME = "MoveAndGroove.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE_EXERCISE = "create table "
            + E_TABLE_NAME + "(" + E_ID
            + " integer primary key autoincrement, " + E_NAME
            + " text not null);";

/*
    public static final String TABLE_WORKOUT = "workout";
    public static final String W_COLUMN_ID = "id";
    public static final String W_COLUMN_NAME = "name";

    private static final String DATABASE_CREATE_WORKOUT = "create table "
            + TABLE_WORKOUT + "(" + W_COLUMN_ID
            + " integer primary key autoincrement, " +W_COLUMN_NAME
            + " text not null);";
*/
    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        this.mCtx = context;

        SQLiteDatabase db = this.getWritableDatabase(); //
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DATABASE_CREATE_EXERCISE);
        db.execSQL(DATABASE_CREATE_USER);
        //db.execSQL(DATABASE_CREATE_WORKOUT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + E_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS" + USER_TABLE1);
        onCreate(db);
    }

    public boolean insertExercise(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(E_NAME, name);
        long result = db.insert(E_TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + E_TABLE_NAME, null);
        return res;
    }

    public boolean updateData(String id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(E_NAME, name);
        db.update(E_TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(E_TABLE_NAME, "ID = ?",new String[] {id});
    }







    public long insertUser( String first_name, String last_name, String weight, String sex, String age, String height_feet,
                           String height_inches, String weekly_goal, String goal_weight){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();



        contentValues.put(FIRST_NAME, first_name);
        contentValues.put(LAST_NAME, last_name);
        contentValues.put(WEIGHT, weight);
        contentValues.put(SEX, sex);
        contentValues.put(AGE, age);
        contentValues.put(HEIGHT_FEET, height_feet);
        contentValues.put(HEIGHT_INCHES, height_inches);
        contentValues.put(WEEKLY_GOAL, weekly_goal);
        contentValues.put(GOAL_WEIGHT, goal_weight);



        Cursor c = db.rawQuery("select * from user1", null);
        if(c.getCount() > 0)
        {

            int clength = c.getCount();

        }

        while(c.moveToNext())
        {
            String tes0 = Integer.toString(c.getInt(c.getColumnIndex("_id")));

            String tes1 = c.getString(c.getColumnIndex("first_name"));

            name = tes1;

        }
        myweight = 0;
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

    public  Cursor getAllUserData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + USER_TABLE1, null);
        return res;
    }


    public boolean updateUserWeight(String weight)
    {

        name = MoveAndGrooveApplication.getUserModel().GetFirstName();

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(WEIGHT, weight);

        db.update(USER_TABLE1, contentValues, "first_name = ?", new String[]{name});

        myweight = 0;
        myweight = Integer.parseInt(weight);
        MoveAndGrooveApplication.getUserModel().SetWeight(myweight);

        return true;



    }

    public  boolean updateUserData(String id, String first_name, String last_name, String weight, String sex, String age, String height_feet,
                                   String height_inches, String weekly_goal, String goal_weight ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(FIRST_NAME, first_name);
        contentValues.put(LAST_NAME, last_name);
        contentValues.put(WEIGHT, weight);
        contentValues.put(SEX, sex);
        contentValues.put(AGE, age);
        contentValues.put(HEIGHT_FEET, height_feet);
        contentValues.put(HEIGHT_INCHES, height_inches);
        contentValues.put(WEEKLY_GOAL, weekly_goal);
        contentValues.put(GOAL_WEIGHT, goal_weight);

        db.update(USER_TABLE1, contentValues, "_id = ?", new String[] { id});
        return true;
    }

    public Integer deleteUserData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(USER_TABLE1, "ID = ?", new String[] {id});
    }


    public void insertSingleUser() {
        //UserModel user;
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
        insertUser("will", "navidson", "140", "male", "23", "5", "10", "2", "130");


    }




    public Cursor fetchUsersByName(String inputText) throws SQLException {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor mCursor = null;
        if (inputText == null  ||  inputText.length () == 0)  {
            mCursor = db.query(USER_TABLE1, new String[] {KEY_ID,
                             FIRST_NAME, LAST_NAME, WEIGHT, SEX, AGE, HEIGHT_FEET,
                            HEIGHT_INCHES, WEEKLY_GOAL, GOAL_WEIGHT},
                    null, null, null, null, null);

        }
        else {
            mCursor = db.query(true, USER_TABLE1, new String[] {KEY_ID,
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
        doneDelete = db.delete(USER_TABLE1, null , null);
        return doneDelete > 0;

    }


    public MySQLiteHelper openToRead() throws android.database.SQLException {
        MySQLiteHelper db = new MySQLiteHelper(mCtx);
        SQLiteDatabase sdb = db.getReadableDatabase();
        return this;
    }


//    public MySQLiteHelper selectUserWeight() {
//
//        String q = "SELECT * FROM" + USER_TABLE1 + "WHERE "
//    }



    public Float getWeight(String first_name){
        Float weight = null;
        Cursor cursor = null;
        if (cursor.moveToFirst())
        {
            do {
                weight = cursor.getFloat(cursor.getColumnIndex(MySQLiteHelper.WEIGHT));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return weight;
    }

}





