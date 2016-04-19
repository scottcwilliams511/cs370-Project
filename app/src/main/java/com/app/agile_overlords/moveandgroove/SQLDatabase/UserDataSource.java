package com.app.agile_overlords.moveandgroove.SQLDatabase;

/**
 * Created by Never Forget on 4/18/2016.
 */

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UserDataSource {

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    private String[] allColumns = { DatabaseHelper.KEY_ID,
            DatabaseHelper.USER_NAME, DatabaseHelper.FIRST_NAME,
            DatabaseHelper.LAST_NAME, DatabaseHelper.WEIGHT, DatabaseHelper.AGE,
            DatabaseHelper.SEX, DatabaseHelper.HEIGHT_INCHES, DatabaseHelper.HEIGHT_FEET,
            DatabaseHelper.DATE_JOINED, DatabaseHelper.GOAL_WEIGHT};

    public UserDataSource(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public UserData createUserData(UserData userdata) {
        //SQLiteDatabase db = DatabaseHelper.this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.USER_NAME, userdata.getUser_name());
        values.put(DatabaseHelper.FIRST_NAME, userdata.getFirst_name());
        values.put(DatabaseHelper.LAST_NAME, userdata.getLast_name());
        values.put(DatabaseHelper.AGE, userdata.getAge());
        values.put(DatabaseHelper.SEX, userdata.getSex());
        values.put(DatabaseHelper.WEIGHT, userdata.getWeight());
        values.put(DatabaseHelper.HEIGHT_FEET, userdata.getHeight_feet());
        values.put(DatabaseHelper.HEIGHT_INCHES, userdata.getHeight_inches());
        values.put(DatabaseHelper.DATE_JOINED, userdata.getDate_joined());
        values.put(DatabaseHelper.WEEKLY_GOAL, userdata.getWeekly_goal());
        values.put(DatabaseHelper.GOAL_WEIGHT, userdata.getGoal_weight());

        // insert row
        long insertID = database.insert(DatabaseHelper.TABLE_USER, null, values);

        Cursor cursor = database.query(DatabaseHelper.TABLE_USER, allColumns,
                                        DatabaseHelper.KEY_ID + " = " + insertID,
                                        null, null, null, null);
        cursor.moveToFirst();
        UserData newUserData = cursorToUserData(cursor);
        cursor.close();
        return userdata;
    }

    private UserData cursorToUserData(Cursor cursor){
        UserData userdata = new UserData();
        userdata.setId(cursor.getLong(0));
        userdata.setUser_name(cursor.getString(1));
        userdata.setFirst_name(cursor.getString(2));
        userdata.setLast_name(cursor.getString(3));
        userdata.setAge(cursor.getInt(4));
        userdata.setSex(cursor.getString(5));
        userdata.setWeight(cursor.getDouble(6));
        userdata.setHeight_feet(cursor.getInt(7));
        userdata.setHeight_inches(cursor.getInt(8));
        userdata.setDate_joined(cursor.getString(9));
        userdata.setWeekly_goal(cursor.getInt(10));
        userdata.setGoal_weight(cursor.getInt(11));

        return userdata;
    }
}
