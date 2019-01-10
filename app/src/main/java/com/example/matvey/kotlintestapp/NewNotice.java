package com.example.matvey.kotlintestapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import android.widget.TextView;
public class NewNotice extends Activity {
    DatabaseHelper helper = new DatabaseHelper(this);
    String date = getIntent().getStringExtra("SelectedDate");
    String useridstr = getIntent().getStringExtra("UserID");

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_notice);


        TextView tv = (TextView)findViewById(R.id.TVdatenotice);
        tv.setText(date);

    }

    int userid = Integer.parseInt(useridstr);

    EditText notice = (EditText)findViewById(R.id.TFnotice);
    String noticestr = notice.getText().toString();

    public void onNoticeSaveClick(View v)
    {
        if(v.getId()==R.id.Bsave)
        {
            helper.insertNotice(date,noticestr,userid);
        }

    }

}
