package com.example.jonathan.penumbraradio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//For Fragments
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

public class Music extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //For Hiding Navigation Bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        //Render View
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        //Load fragment into SlideUpPanel
        loadFragment(new MusicPlayer());
    }

    //FragmentManager(fm) swaps out the fragments
    private void loadFragment(Fragment fragment)
    {
        // create a FragmentManager
        FragmentManager fm = getFragmentManager();

        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.slideLayoutMusic, fragment);
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
