package com.example.jonathan.penumbraradio;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import android.widget.Toast;

public class News extends AppCompatActivity {

    private TextView textView;
    private StringBuilder text = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //For Hiding Navigation Bar
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        //Render View
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        //Load fragment into SlideUpPanel
        loadFragment(new MusicPlayer());

        /*
        //Read In Text File to Display on Text View
        BufferedReader reader = null;

        try
        {
            reader = new BufferedReader(new InputStreamReader(getAssets().open("Article1.txt")));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null)
            {
                text.append(mLine);
                text.append('\n');
            }
        }
        catch (IOException e)
        {
            Toast.makeText(getApplicationContext(), "Error reading file!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        finally
        {
            if (reader != null)
            {
                try
                {
                    reader.close();
                }
                catch (IOException e)
                {
                    //log the exception
                }
            }

            TextView output = (TextView) findViewById(R.id.newsFrame2);
            output.setText((CharSequence) text);
        }*/
    }

    //FragmentManager(fm) swaps out the fragments
    private void loadFragment(Fragment fragment)
    {
        // create a FragmentManager
        FragmentManager fm = getFragmentManager();

        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();

        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.slideLayoutNews, fragment);
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
