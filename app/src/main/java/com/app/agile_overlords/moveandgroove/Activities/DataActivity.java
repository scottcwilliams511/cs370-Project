package com.app.agile_overlords.moveandgroove.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import com.app.agile_overlords.moveandgroove.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;



/**
 * Created by Scott Williams on 4/14/2016.
 */
public class DataActivity extends AppCompatActivity{
    Button b1,b2;
    TextView tv;
    EditText ed1;

    String data;
    private String file = "mydata";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_main);

        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);

        ed1 = (EditText)findViewById(R.id.editText);
        //tv=(TextView)findViewById(R.id.textView2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data=ed1.getText().toString();
                try {
                    FileOutputStream fOut = openFileOutput(file,MODE_WORLD_READABLE);
                    fOut.write(data.getBytes());
                    fOut.close();
                    Toast.makeText(getBaseContext(),"weight saved",Toast.LENGTH_SHORT).show();;
                }
                catch (Exception e) {
                    //put something here
                    e.printStackTrace();
                }
            }
        });



        //Todo rework function to auto load the stored weight
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {
                try{
                    FileInputStream fin = openFileInput(file);
                    int c;
                    String temp="";
                    while((c=fin.read()) != -1) {
                        temp = temp + Character.toString((char)c);
                    }
                    tv.setText(temp);
                    Toast.makeText(getBaseContext(),"file read",Toast.LENGTH_SHORT).show();;
                }
                catch(Exception e) {

                }
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }
}
