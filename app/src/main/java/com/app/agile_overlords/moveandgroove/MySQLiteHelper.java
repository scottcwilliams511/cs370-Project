package com.app.agile_overlords.moveandgroove;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.app.agile_overlords.moveandgroove.Fragments.UserFragment;
import com.app.agile_overlords.moveandgroove.Models.ExerciseModel;


public class MySQLiteHelper extends SQLiteOpenHelper {


    public static final String EXERCISE_TABLE = "exercise";
    public static final String E_ID = "_id";
    public static final String E_NAME = "NAME";


    /* Bloack of user database info
    *
    */
    public static final String USER_TABLE1 = "user1";
    public static final String KEY_ID = "_id";
    public static final String USER_NAME = "user_name";
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

    private static final String DATABASE_NAME = "MoveAndGroove.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE_EXERCISE = "create table "
            + EXERCISE_TABLE + "(" + E_ID
            + " integer primary key autoincrement, " + E_NAME
            + " text not null);";

    private static final String DATABASE_CREATE_USER = "CREATE TABLE " + USER_TABLE1 + "(" + KEY_ID + " integer primary key autoincrement," + USER_NAME +
            " TEXT not null," + FIRST_NAME + " TEXT not null," + LAST_NAME + " TEXT not null," + WEIGHT + " REAL not null," +
            SEX + " TEXT not null," + AGE + " INTEGER not null," + HEIGHT_FEET + " INTEGER not null," + HEIGHT_INCHES + " INTEGER not null," +
            DATE_JOINED + " DATETIME," + WEEKLY_GOAL + " INTEGER not null," + GOAL_WEIGHT + " INTEGER not null);";

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

        SQLiteDatabase db = this.getWritableDatabase();


    }





    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DATABASE_CREATE_EXERCISE);
        db.execSQL(DATABASE_CREATE_USER);
        //db.execSQL(DATABASE_CREATE_WORKOUT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EXERCISE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS" + USER_TABLE1);
        onCreate(db);
    }

    public boolean insertExercise(String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(E_NAME, name);
        long result = db.insert(EXERCISE_TABLE, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }



    public long insertUser(String user_name, String first_name, String last_name, String weight, String sex, String age, String height_feet,
                              String height_inches, String weekly_goal, String goal_weight){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();



        contentValues.put(USER_NAME, user_name);
        contentValues.put(FIRST_NAME, first_name);
        contentValues.put(LAST_NAME, last_name);
        contentValues.put(WEIGHT, weight);
        contentValues.put(SEX, sex);
        contentValues.put(AGE, age);
        contentValues.put(HEIGHT_FEET, height_feet);
        contentValues.put(HEIGHT_INCHES, height_inches);
        contentValues.put(WEEKLY_GOAL, weekly_goal);
        contentValues.put(GOAL_WEIGHT, goal_weight);

        /*
        .SetFirstName(first_name);
        user.SetLastName(last_name);
        Float convertWeight = Float.parseFloat(weight);
        user.SetWeight(convertWeight);
        Integer convertAge = Integer.parseInt(age);
        user.SetAge(convertAge);
        Integer convertHft = Integer.parseInt(height_feet);
        user.SetHeightFeet(convertHft);
        Integer convertHin = Integer.parseInt(height_inches);
        user.SetHeightInches(convertHin);
        Integer convertWeek = Integer.parseInt(weekly_goal);
        user.SetWeeklyGoal(convertWeek);
        Integer convertGoal = Integer.parseInt(goal_weight);
        user.SetGoalWeight(convertGoal);
    */
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

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + EXERCISE_TABLE, null);
        return res;
    }

    public  boolean updateUserData(String id, String user_name, String first_name, String last_name, String weight, String sex, String age, String height_feet,
                                   String height_inches, String weekly_goal, String goal_weight ){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(USER_NAME, user_name);
        contentValues.put(FIRST_NAME, first_name);
        contentValues.put(LAST_NAME, last_name);
        contentValues.put(WEIGHT, weight);
        contentValues.put(SEX, sex);
        contentValues.put(AGE, age);
        contentValues.put(HEIGHT_FEET, height_feet);
        contentValues.put(HEIGHT_INCHES, height_inches);
        contentValues.put(WEEKLY_GOAL, weekly_goal);
        contentValues.put(GOAL_WEIGHT, goal_weight);

        db.update(USER_TABLE1, contentValues, "ID = ?", new String[] { id});
        return true;
    }

    public boolean updateData(String id, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(E_NAME, name);
        db.update(EXERCISE_TABLE, contentValues, "ID = ?",new String[] { id });
        return true;
    }






    public Integer deleteUserData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(USER_TABLE1, "ID = ?", new String[] {id});
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(EXERCISE_TABLE, "ID = ?",new String[] {id});
    }


    public void insertSingleUser() {
        //UserModel user;
        insertUser("movengroove", "will", "navidson", "140", "male", "23", "5", "10", "2", "130");


    }





    public Cursor fetchUsersByName(String inputText) throws SQLException {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor mCursor = null;
        if (inputText == null  ||  inputText.length () == 0)  {
            mCursor = db.query(USER_TABLE1, new String[] {KEY_ID,
                            USER_NAME, FIRST_NAME, LAST_NAME, WEIGHT, SEX, AGE, HEIGHT_FEET,
                    HEIGHT_INCHES, WEEKLY_GOAL, GOAL_WEIGHT},
                    null, null, null, null, null);

        }
        else {
            mCursor = db.query(true, USER_TABLE1, new String[] {KEY_ID,
                            USER_NAME, FIRST_NAME, LAST_NAME, WEIGHT, SEX, AGE, HEIGHT_FEET,
                            HEIGHT_INCHES, WEEKLY_GOAL, GOAL_WEIGHT},
                    USER_NAME + " like '%" + inputText + "%'", null,
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


}





