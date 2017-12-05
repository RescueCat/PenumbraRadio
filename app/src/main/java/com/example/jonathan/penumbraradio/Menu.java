package com.example.jonathan.penumbraradio;
//My first commit

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
//For Fragments
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

public class Menu extends AppCompatActivity {

    Button newsButton, musicButton, alarmButton, profButton, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //For Hiding Navigation Bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        //Load fragment into SlideUpPanel
        loadFragment(new MusicPlayer());

        //Render View
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Define Buttons on View
        newsButton = (Button)findViewById(R.id.newsButton);
        musicButton = (Button)findViewById(R.id.musicButton);
        alarmButton = (Button)findViewById(R.id.alarmButton);
        profButton = (Button)findViewById(R.id.profButton);
        logoutButton = (Button)findViewById(R.id.logButton);

        //Navigation: Menu -> News
        newsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toNews = new Intent(Menu.this, News.class);
                startActivity(toNews);
            }
        });

        //Press a Button and go to a Vew/Function
        //Navigation Menu -> Music
        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMusic = new Intent(Menu.this, Music.class);
                startActivity(toMusic);
            }
        });

        //Navigation Menu -> Alarm
        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAlarm = new Intent(Menu.this, Alarm.class);
                startActivity(toAlarm);
            }
        });

        //Navigation Menu -> Profile
        profButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toProfiles = new Intent(Menu.this, Profiles.class);
                startActivity(toProfiles);
            }
        });

        /*
        //Navigation Menu -> Login
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toLogin = new Intent(Menu.this, Login.class);
                startActivity(toLogin);
            }
        });*/

    }

    //FragmentManager(fm) swaps out the fragments
    private void loadFragment(Fragment fragment)
    {
        // create a FragmentManager
        FragmentManager fm = getFragmentManager();

        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.slideLayoutMenu, fragment);
        fragmentTransaction.commit(); // save the changes
    }

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
    }
}
