package com.app.agile_overlords.moveandgroove;


import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
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

import com.app.agile_overlords.moveandgroove.Models.UserModel;

import java.util.List;
import java.util.Random;

/**
 * Created by Never Forget on 4/21/2016.
 */
public class UserDB_Activity extends ActionBarActivity {

    MySQLiteHelper myDb;

    EditText editUser, editFirst, editLast, editWeight, editSex, editAge, editHeightFt, editHeightIn, editGoal, editWeekly, editTextId;

    UserModel user;

    Button btnAddData;
    Button btnviewAll;
    Button btnviewUpdate;
    Button btnDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_db);
        myDb = new MySQLiteHelper(this);

        editUser = (EditText) findViewById(R.id.editUser_name);
        editTextId = (EditText) findViewById(R.id.editId);
        editFirst = (EditText) findViewById(R.id.editFirst_name);
        editLast = (EditText) findViewById(R.id.editLast_name);
        editWeight = (EditText) findViewById(R.id.editWeight_text);
        editSex = (EditText) findViewById(R.id.editSex_text);
        editAge = (EditText) findViewById(R.id.editAge_text);
        editHeightFt = (EditText) findViewById(R.id.editHeight_ft);
        editHeightIn = (EditText) findViewById(R.id.editHeight_in);
        editWeekly = (EditText) findViewById(R.id.editWeekly_goal);
        editGoal = (EditText) findViewById(R.id.editGoal_text);

        btnAddData = (Button) findViewById(R.id.button_add);
        btnviewAll = (Button) findViewById(R.id.button_all);
        btnviewUpdate = (Button) findViewById(R.id.button_update);
        btnDelete = (Button) findViewById(R.id.button_delete);

        //AddData();
        viewAll();
        UpdateData();
        DeleteData();
    }


    public void DeleteData() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Integer deletedRows = myDb.deleteUserData(editTextId.getText().toString());
                                             if(deletedRows > 0)
                                                 Toast.makeText(UserDB_Activity.this,"User Deleted",Toast.LENGTH_LONG).show();
                                             else
                                                 Toast.makeText(UserDB_Activity.this,"User not Deleted",Toast.LENGTH_LONG).show();
                                         }
                                     }
        );
    }

    public void UpdateData() {
        btnviewUpdate.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 boolean isUpdate = myDb.updateUserData(editTextId.getText().toString(), editUser.getText().toString(),
                                                         editFirst.getText().toString(), editLast.getText().toString(), editWeight.getText().toString(),
                                                         editSex.getText().toString(), editAge.getText().toString(), editHeightFt.getText().toString(),
                                                         editHeightIn.getText().toString(), editWeekly.getText().toString(), editGoal.getText().toString());
                                                 if(isUpdate == true)
                                                     Toast.makeText(UserDB_Activity.this,"User Inserted",Toast.LENGTH_LONG).show();
                                                 else
                                                     Toast.makeText(UserDB_Activity.this,"User not Inserted",Toast.LENGTH_LONG).show();
                                             }
                                         }
        );
    }

    /*
    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertUser(editUser.getText().toString(),
                                editFirst.getText().toString(), editLast.getText().toString(), editWeight.getText().toString(),
                                editSex.getText().toString(), editAge.getText().toString(), editHeightFt.getText().toString(),
                                editHeightIn.getText().toString(), editWeekly.getText().toString(), editGoal.getText().toString());
                        if (isInserted == true)
                            Toast.makeText(UserDB_Activity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(UserDB_Activity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                });
    }
    */

    public void viewAll() {
        btnviewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDb.getAllUserData();
                if (res.getCount() == 0) {
                    // show message
                    showMessage("Error", "Nothing found");
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Id :" + res.getString(0)+"\n");
                    buffer.append("Username :"+ res.getString(1)+"\n");
                    buffer.append("First Name :"+ res.getString(2)+"\n");
                    buffer.append("Last Name :"+ res.getString(3)+"\n");
                    buffer.append("Weight :"+ res.getString(4)+"\n");
                    buffer.append("Sex :"+ res.getString(5)+"\n");
                    buffer.append("Age :"+ res.getString(6)+"\n");
                    buffer.append("Height feet :"+ res.getString(7)+"\n");
                    buffer.append("Height inches :"+ res.getString(8)+"\n");
                    buffer.append("Weekly goal :"+ res.getString(9)+"\n");
                    buffer.append("Goal weight :"+ res.getString(10)+"\n");


                }

                // show all data
                showMessage("User", buffer.toString());
            }

        });
    }

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
