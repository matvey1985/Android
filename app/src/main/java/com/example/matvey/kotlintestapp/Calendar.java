package com.example.matvey.kotlintestapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;
import android.view.View;
import android.widget.CalendarView;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

//import static com.example.matvey.kotlintestapp.R.id.Bcreatenotice;

public class Calendar extends Activity
{

    /*TextView selectedDate = (TextView)findViewById(R.id.TVselecteddate);*/
    DatabaseHelper helper = new DatabaseHelper(this);
    //String name = getIntent().getStringExtra("Name");
    /*
    Notice n = new Notice();*/
    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

          String username = getIntent().getStringExtra("Username");
          TextView tv = (TextView) findViewById(R.id.TVname);
         tv.setText(username);
         /*Contact c = new Contact();
         String password = getIntent().getStringExtra("ActualPassword");
         CalendarView calendar = (CalendarView)findViewById(R.id.calendar);




        c.setName(username);
        c.setPass(password);*/

        /*calendar.setOnDateChangeListener(
                new CalendarView.OnDateChangeListener(){
                    @Override
                    public void onSelectedDayChange(@NonNull CalendarView calendar, int i, int i1, int i2)
                    {

                        String date =(i1+1)+"/"+i2+"/"+i;
                        n.setDate(date);
                        String strUserId = helper.searchId(username,password);
                        n.setId(Integer.parseInt(strUserId));
                        String notice = helper.searchNotice(date,strUserId);
                        Toast ShortNotice = Toast.makeText(Calendar.this,notice,Toast.LENGTH_SHORT);
                        ShortNotice.show();

                        selectedDate.setText(date);
                    }

                }



        );*/

    }
    /*public void onNoticeCreateClick(View v) {
        if(v.getId()==R.id.ButtonC)
        {
            Intent i = new Intent(Calendar.this, NewNotice.class);
            //i.putExtra("SelectedDate",selectedDate.getText().toString());
            //i.putExtra("UserID",n.getId());
            startActivity(i);
        }
    }*/

}
