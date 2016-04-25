package com.app.agile_overlords.moveandgroove;

/**
 * Created by Never Forget on 4/24/2016.
 */

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FilterQueryProvider;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;

import java.util.List;


public class UserProfileActivity extends ActionBarActivity {

    private MySQLiteHelper myDb;
    private SimpleCursorAdapter dataAdapter;
    //private Button editButton;
    private LinearLayoutManager layoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        //editButton = (Button) findViewById(R.id.editButton);

        myDb = new MySQLiteHelper(this);

        myDb.open();



        // CLEAN
        myDb.deleteAllUsers();
        myDb.insertSingleUser();

        myDb.close();

//        SQLiteDatabase db = myDb.getReadableDatabase();
////        Cursor cur =  db.rawQuery( "select rowid _id,* FROM U_TABLE_NAME", null);
////



        myDb = new MySQLiteHelper(this);
        myDb.openToRead();


        displayListView();

        //editButton.setOnClickListener(this);

        myDb.close();

    }




    private void displayListView() {


        Cursor cursor = myDb.getAllUserData();

        // se adapter for list view

        startManagingCursor(cursor);
        // The desired columns to be bound
        String[] columns = new String[] {

                MySQLiteHelper.USER_NAME,
                MySQLiteHelper.FIRST_NAME,
                MySQLiteHelper.LAST_NAME,
                MySQLiteHelper.WEIGHT,
                MySQLiteHelper.SEX,
                MySQLiteHelper.AGE,
                MySQLiteHelper.HEIGHT_FEET,
                MySQLiteHelper.HEIGHT_INCHES,
                MySQLiteHelper.WEEKLY_GOAL,
                MySQLiteHelper.GOAL_WEIGHT
        };

// the XML defined views which the data will be bound to
        int[] to = new int[] {
                R.id.username,
                R.id.firstname,
                R.id.lastname,
                R.id.weight,
                R.id.sex,
                R.id.age,
                R.id.heightft,
                R.id.heightin,
                R.id.weeklygoal,
                R.id.goalweight,
        };

        // create the adapter using the cursor pointing to the desired data
        //as well as the layout information
        dataAdapter = new SimpleCursorAdapter(
                this,
                R.layout.user_info,
                cursor,
                columns,
                to,
                0);


        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view,
                                    int position, long id) {
                // Get the cursor, positioned to the corresponding row in the result set
                Cursor cursor = (Cursor) listView.getItemAtPosition(position);

                // Get the state's capital from this row in the database.
                String userName =
                        cursor.getString(cursor.getColumnIndexOrThrow("username"));
                Toast.makeText(getApplicationContext(),
                        userName, Toast.LENGTH_SHORT).show();

            }
        });


        EditText myFilter = (EditText) findViewById(R.id.myFilter);
        myFilter.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                dataAdapter.getFilter().filter(s.toString());
            }
        });

        dataAdapter.setFilterQueryProvider(new FilterQueryProvider() {
            public Cursor runQuery(CharSequence constraint) {
                return myDb.fetchUsersByName(constraint.toString());
            }
        });

    }}
//
//private void buttonClick()
//{
//    startActivity(new Intent(".UserDB_Activity"));
//}
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId())
//        {
//            case R.id.editButton:
//                buttonClick();
//                break;
//        }
//    }
//}



