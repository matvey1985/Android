package com.example.matvey.kotlintestapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends Activity
{

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
    }

    public void onBackToMainClick(View v){
        if (v.getId() == R.id.Bbacktomain) {
            Intent i = new Intent(SignUp.this, Main2Activity.class);
            startActivity(i);
        }
    }
    public void onSignUpClick(View v)
     {
        if(v.getId()== R.id.Brealsignup)
        {
            EditText name = (EditText)findViewById(R.id.TFuname);
            EditText email = (EditText)findViewById(R.id.TFemail);
            EditText pass1 = (EditText)findViewById(R.id.TFpass1);
            EditText pass2 = (EditText)findViewById(R.id.TFpass2);

            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if(!pass1str.equals(pass2str))
               {
//popup
                Toast pass = Toast.makeText(SignUp.this, "Пароли не совпадают", Toast.LENGTH_SHORT);
                pass.show();
               }
            else
                {
                    Contact c = new  Contact();
                    c.setName(namestr);
                    c.setEmail(emailstr);
                    c.setPass(pass1str);

                    helper.insertContact(c);
                }
        }

     }
}
