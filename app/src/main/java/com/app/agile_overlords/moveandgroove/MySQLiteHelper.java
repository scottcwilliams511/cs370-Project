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

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String E_TABLE_NAME = "exercise";
    public static final String E_ID = "ID";
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

        SQLiteDatabase db = this.getWritableDatabase(); //
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DATABASE_CREATE_EXERCISE);
        //db.execSQL(DATABASE_CREATE_WORKOUT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + E_TABLE_NAME);
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
        db.update(E_TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(E_TABLE_NAME, "ID = ?",new String[] {id});
    }
}





