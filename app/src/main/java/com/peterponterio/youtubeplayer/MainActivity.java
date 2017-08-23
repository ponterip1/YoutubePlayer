package com.peterponterio.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonSingle = (Button) findViewById(R.id.buttonPlaySingle);
        Button buttonStandalone = (Button) findViewById(R.id.buttonStandalone);
        buttonSingle.setOnClickListener(this);
        buttonStandalone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        /* whenever you want to use an intent to launch a new activity in your app, use 2 parameters
         * the first is the context of the application that contains the activity that we want to start
         * the second is the activity. YoutubeActivity.class and StandaloneAtivity.class are called class literals and its a way to pass
         * a reference to a class as a parameter. We need to pass an object of type class whose value is the Youtube Activity class and this
         * is how we do it in Java.
         */
        switch(v.getId()) {
            case R.id.buttonPlaySingle:
                intent = new Intent(this, YoutubeActivity.class);
                break;
            case R.id.buttonStandalone:
                intent = new Intent(this, StandaloneActivity.class);
            default:
        }

        //checks that intent isnt null before calling the start activity method
        //its good practice to make sure youre not calling methods on null objects
        if(intent != null) {
            startActivity(intent);
        }
    }
}
