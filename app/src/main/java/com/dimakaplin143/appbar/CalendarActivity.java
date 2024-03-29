package com.dimakaplin143.appbar;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.GregorianCalendar;

public class CalendarActivity extends AppCompatActivity {

    private Button mChooseStartDate;
    private Button mChooseEndDate;
    private CalendarView mStartDateCalendar;
    private CalendarView mEndtDateCalendar;
    private Button mBtnOK;

    private long mStartDate;
    private String mStartDateTxt;
    private long mEndDate;
    private String mEndDateTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        initViews();

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mChooseStartDate.setOnClickListener(v-> {
            mStartDateCalendar.setVisibility(View.VISIBLE);
            mEndtDateCalendar.setVisibility(View.GONE);
        });
        mChooseEndDate.setOnClickListener(v-> {
            mEndtDateCalendar.setVisibility(View.VISIBLE);
            mStartDateCalendar.setVisibility(View.GONE);
        });
        mStartDateCalendar.setOnDateChangeListener((@NonNull CalendarView calendarView, int i, int i1, int i2)-> {
            mStartDateTxt = i+"-"+i1+"-"+i2;
            mChooseStartDate.setText("Дата-время старта задачи: " + mStartDateTxt);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.set(i, i1, i2);
            mStartDate = gregorianCalendar.getTimeInMillis();
            calendarView.setVisibility(View.GONE);
        });

        mEndtDateCalendar.setOnDateChangeListener((@NonNull CalendarView calendarView, int i, int i1, int i2)-> {
            mEndDateTxt = i+"-"+i1+"-"+i2;
            mChooseEndDate.setText("Дата-время окончания задачи: " + mEndDateTxt);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.set(i, i1, i2);
            mEndDate = gregorianCalendar.getTimeInMillis();
            calendarView.setVisibility(View.GONE);
        });
        mBtnOK.setOnClickListener(v-> {
            if (mStartDate > mEndDate){
                Toast.makeText(CalendarActivity.this, "Ошибка", Toast.LENGTH_LONG).show();
                mChooseStartDate.setText("Дата-время старта задачи:");
                mChooseEndDate.setText("Дата-время окончания задачи:");
            } else {
                Toast.makeText(CalendarActivity.this, "старт: " + mStartDateTxt + " окончаниe: " + mEndDateTxt, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initViews() {
        mChooseStartDate = findViewById(R.id.chooseStartDate);
        mChooseEndDate = findViewById(R.id.chooseEndDate);
        mStartDateCalendar = findViewById(R.id.startDateCalendar);
        mEndtDateCalendar = findViewById(R.id.endtDateCalendar);
        mBtnOK = findViewById(R.id.btnOK);

        mStartDateCalendar.setVisibility(View.GONE);
        mEndtDateCalendar.setVisibility(View.GONE);

    }

}
