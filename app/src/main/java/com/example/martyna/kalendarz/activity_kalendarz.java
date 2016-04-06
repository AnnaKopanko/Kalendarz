package com.example.martyna.kalendarz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

public class activity_kalendarz extends AppCompatActivity {


    CalendarView calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalendarz);

        calendar=(CalendarView) findViewById(R.id.calendar);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView view,int year, int month, int dayofMonth) {
                Toast.makeText(getApplicationContext(),dayofMonth+ "/" +month + "/" +year, Toast.LENGTH_LONG).show();
            }
        });
    }
}
