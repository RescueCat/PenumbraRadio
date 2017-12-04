package com.example.jonathan.penumbraradio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class Login extends AppCompatActivity {

    Button logButton, regButton;
    EditText userName, userPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Define Buttons and Text Fields
        logButton = (Button) findViewById(R.id.logButton);
        regButton = (Button)findViewById(R.id.regButton);
        userName = (EditText)findViewById(R.id.userName);
        userPass = (EditText)findViewById(R.id.userPass);

        //Create Listener for Login Button
        //Converts EditText fields to String
        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check if username and password are correct, currently set to admin
                if(userName.getText().toString().equals("admin") &&
                        userPass.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(),
                            "Logging now...",Toast.LENGTH_SHORT).show();
                    Intent mainMenu = new Intent(Login.this, Menu.class);
                    startActivity(mainMenu);
                }else{
                    Toast.makeText(getApplicationContext(),
                            "Wrong Credentials",Toast.LENGTH_SHORT).show();
                     /*Used for Login Attempts, Not Complete
                    tx1.setVisibility(View.VISIBLE);
                    tx1.setBackgroundColor(Color.RED);
                    counter--;
                    tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        b1.setEnabled(false);
                    }*/

                }
            }
        });

        //Create Listener for Register Button
        //This will direct to registration menu
        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
/*
    //Method to Hiding Navigation Bar
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }*/
}
