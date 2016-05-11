package com.app.agile_overlords.moveandgroove;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.app.agile_overlords.moveandgroove.Models.ExerciseModel;

import java.util.List;
import java.util.Random;

/**
 * Created by matthew on 4/19/16.
 */
public class TestExerciseDB_Activity extends ActionBarActivity {

    MySQLiteHelper myDb;

    EditText editName, editTextId;
    Button btnAddData;
    Button btnviewAll;
    Button btnviewUpdate;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_db);
        myDb = new MySQLiteHelper(this);

        editName = (EditText) findViewById(R.id.editText_name);
        editTextId = (EditText) findViewById(R.id.editId);
        btnAddData = (Button) findViewById(R.id.button_add);
        btnviewAll = (Button) findViewById(R.id.button_all);
        btnviewUpdate = (Button) findViewById(R.id.button_update);
        btnDelete = (Button) findViewById(R.id.button_delete);
       // AddData();
       // viewAll();
       // UpdateData();
        DeleteData();
    }

    public void DeleteData() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDb.deleteExerciseData(editTextId.getText().toString());
                if(deletedRows > 0)
                    Toast.makeText(TestExerciseDB_Activity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(TestExerciseDB_Activity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                }
            }
        );
    }
/*
    public void UpdateData() {
        btnviewUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = myDb.updateExerciseData(editTextId.getText().toString(), editName.getText().toString());
                if(isUpdate == true)
                    Toast.makeText(TestExerciseDB_Activity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(TestExerciseDB_Activity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                }
            }
        );
    }

    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertExercise(editName.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(TestExerciseDB_Activity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(TestExerciseDB_Activity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                });
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllData();
                if (res.getCount() == 0) {
                    // show message
                    showMessage("Error", "Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id :" + res.getString(0)+"\n");
                    buffer.append("Name :"+ res.getString(1)+"\n");
                }

                // show all data
                showMessage("Exercises", buffer.toString());
            }

        });
    }
*/
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


