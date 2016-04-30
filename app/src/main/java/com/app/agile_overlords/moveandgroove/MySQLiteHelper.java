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

import java.util.ArrayList;
import java.util.List;

public class MySQLiteHelper extends SQLiteOpenHelper {

    // Exercise database info
    public static final String EXERCISE_TABLE = "exercise";
    public static final String E_ID = "_id";
    public static final String E_NAME = "name";
    public static final String E_TYPE = "type";
    public static final String E_SETS = "sets";
    public static final String E_REPS = "reps";
    public static final String E_DURATION = "duration";



    private final Context mCtx;


    private static final String DATABASE_NAME = "MoveAndGroove.db";
    private static final int DATABASE_VERSION = 1;

    // Exercise database SQL creation statement
    private static final String DATABASE_CREATE_EXERCISE = "create table "
            + EXERCISE_TABLE + "(" + E_ID
            + " integer primary key autoincrement, " + E_NAME + " text not null,"
            + E_TYPE + " text not null," + E_SETS + " integer,"
            + E_REPS + " integer," + E_DURATION + " real);";


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        this.mCtx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_EXERCISE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EXERCISE_TABLE);
        onCreate(db);
    }

    public boolean insertExercise(String name, String type, String sets, String reps, String duration) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(E_NAME, name);
        contentValues.put(E_TYPE, type);
        contentValues.put(E_SETS, sets);
        contentValues.put(E_REPS, reps);
        contentValues.put(E_DURATION, duration);
        long result = db.insert(EXERCISE_TABLE, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    /*
    public void insertExercise(String name, String type, String sets, String reps, String duration) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(E_NAME, name);
        values.put(E_TYPE, type);
        values.put(E_SETS, sets);
        values.put(E_REPS, reps);
        values.put(E_DURATION, duration);
        db.insert(EXERCISE_TABLE, null, values);
        db.close();
    }
*/
    public List<ExerciseModel> getExerciseData() {
        List<ExerciseModel> modelList = new ArrayList<ExerciseModel>();
        String query = "select * from " + EXERCISE_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()) {
            do {
                ExerciseModel model = new ExerciseModel();
                model.setName(cursor.getString(1));
                model.setType(cursor.getString(2));
                model.setNumSets(cursor.getString(3));
                model.setNumReps(cursor.getString(4));
                model.setDuration(cursor.getString(5));
                modelList.add(model);
            }while (cursor.moveToNext());
        }
        return modelList;
    }


    public Cursor getAllExerciseData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + EXERCISE_TABLE, null);
        return res;
    }

    public boolean updateExerciseData(String id, String name, String type, String sets, String reps, String duration) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(E_NAME, name);
        contentValues.put(E_TYPE, type);
        contentValues.put(E_SETS, sets);
        contentValues.put(E_REPS, reps);
        contentValues.put(E_DURATION, duration);
        db.update(EXERCISE_TABLE, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteExerciseData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(EXERCISE_TABLE, "ID = ?",new String[] {id});
    }
}

