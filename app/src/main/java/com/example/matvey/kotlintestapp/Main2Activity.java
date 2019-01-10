package com.example.matvey.kotlintestapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    DatabaseHelper helper = new DatabaseHelper(this);

    public void onMainSignUpClick(View v){
        if (v.getId() == R.id.Bmainsignup) {
            Intent i = new Intent(Main2Activity.this, SignUp.class);
            startActivity(i);
        }
    }

    public void onLoginClick(View v) {

        if (v.getId() == R.id.Bsignin) {

            EditText etUsername = (EditText) findViewById(R.id.TFuname);
            String str = etUsername.getText().toString();


            EditText etPassword = (EditText) findViewById(R.id.TFpassword);
            String pass = etPassword.getText().toString();

            String password = helper.searchPass(str);

            if (pass.equals(password)) {

                Intent i = new Intent(Main2Activity.this, NoticeCalendar.class);
                i.putExtra("Username", str);
                i.putExtra("ActualPassword",pass);
                startActivity(i);
            } else {
                Toast temp = Toast.makeText(Main2Activity.this, "Имя пользователя и пароль не подходят", Toast.LENGTH_SHORT);
                temp.show();
            }


        }
    }
}
