package com.app.agile_overlords.moveandgroove.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

import com.app.agile_overlords.moveandgroove.R;


/**
 * Created by Scott Williams on 4/12/2016.
 *
 * http://free-tutorials.org/android-calendar-application-example-part-1/
 */
public class CalendarActivity extends AppCompatActivity{
    CalendarView calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_main);
        //todo use a layout file to display the calendar

        calendar = (CalendarView) findViewById(R.id.calendar);
        calendar.setOnDateChangeListener((new OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(),dayOfMonth +"/"+ year,Toast.LENGTH_LONG).show();
            }
        }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




}
