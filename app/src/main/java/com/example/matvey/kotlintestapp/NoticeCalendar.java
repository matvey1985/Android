package com.example.matvey.kotlintestapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import android.widget.CalendarView;
import android.widget.Toast;

public class NoticeCalendar extends Activity {

    DatabaseHelper helper = new DatabaseHelper(this);


    Notice n = new Notice();
    Contact c = new Contact();
    CalendarView calendar;
    TextView selectedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notice_calendar);

        String username = getIntent().getStringExtra("Username");
        String password = getIntent().getStringExtra("ActualPassword");
        c.setName(username);
        c.setPass(password);

        TextView tv = (TextView) findViewById(R.id.TVnameuser);
        tv.setText(username);

        selectedDate = (TextView)findViewById(R.id.TVdateselected);
        calendar = (CalendarView)findViewById(R.id.calendarView);


        calendar.setOnDateChangeListener(
                new CalendarView.OnDateChangeListener(){
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView calendar, int i, int i1, int i2)
                    {

                        String date =(i1+1)+"/"+i2+"/"+i;
                        n.setDate(date);
                        String strUserId = helper.searchId(c.getName(),c.getPass());
                        n.setId(Integer.parseInt(strUserId));
                        String notice = helper.searchNotice(date,strUserId);
                        Toast ShortNotice = Toast.makeText(NoticeCalendar.this,notice,Toast.LENGTH_SHORT);
                        ShortNotice.show();

                        selectedDate.setText(date);
                    }

                }



        );
    }




    public void onCreateNoticeClick(View v) {
        if(v.getId()==R.id.Bnoticecreate)
        {
            Intent i = new Intent(NoticeCalendar.this, NewNotice.class);
            i.putExtra("SelectedDate",selectedDate.getText().toString());
            i.putExtra("UserID",n.getId());
            startActivity(i);
        }
    }
}
