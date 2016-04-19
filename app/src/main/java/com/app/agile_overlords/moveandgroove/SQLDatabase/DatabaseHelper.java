package com.app.agile_overlords.moveandgroove.SQLDatabase;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.util.Log;

/**
 * Created by Never Forget on 4/14/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int database_version = 1;
    // Logcat tag
    private static final String LOG = "DatabaseHelper";
    private static final String DATABASE_NAME = "370_proj";

    // table names
    public static final String TABLE_USER = "user";
    // workout here later
    public static final String TABLE_EXERCISE = "exercise";
    public static final String TABLE_FOOD = "food";

    // common columns
    public static final String KEY_ID = "id";
    public static final String KEY_CREATED_AT = "created_at";

    // USER column names

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

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, database_version);
    }


    // TABLE CREATES STATEMENTS

    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + "(" + KEY_ID + "INTEGER PRIMARY KEY," + USER_NAME +
                                                    " TEXT," + FIRST_NAME + " TEXT," + LAST_NAME + " TEXT," + WEIGHT + " REAL," +
                                                    SEX + " TEXT," + AGE + " INTEGER," + HEIGHT_FEET + " INTEGER," + HEIGHT_INCHES + " INTEGER," +
                                                    DATE_JOINED + " DATETIME," + WEEKLY_GOAL + " INTEGER," + GOAL_WEIGHT + " INTEGER," +
                                                    KEY_CREATED_AT + " DATETIME" + ")";



    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");

        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);


        // create new tables
        onCreate(db);
    }
    /*
    public String CREATE_QUERY = "CREATE TABLE " + TableData.UserInfo.TABLE_NAME + "(" + TableData.UserInfo.userName + " TEXT,"+
            TableData.UserInfo.firstName + " TEXT," + TableData.UserInfo.lastName + "TEXT," + TableData.UserInfo.weight +
            "INTEGER );";

    public DatabaseHelper(Context context) {
        super(context, TableData.UserInfo.DATABASE_NAME, null, database_version);
        Log.d("Database operations", "Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    */
}
