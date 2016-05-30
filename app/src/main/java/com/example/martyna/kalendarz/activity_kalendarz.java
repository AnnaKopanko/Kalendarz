package com.example.martyna.kalendarz;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.Toast;

public class activity_kalendarz extends AppCompatActivity {


    CalendarView calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalendarz);

        calendar=(CalendarView) findViewById(R.id.calendar);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView view,int year, int month, int dayofMonth) {


                Intent myIntent = new Intent(activity_kalendarz.this, ActivityDay.class);
                activity_kalendarz.this.startActivity(myIntent);
                Toast.makeText(getApplicationContext(),dayofMonth+ "/" +month + "/" +year, Toast.LENGTH_LONG).show();


            }



        });
    }
}
