package com.peterponterio.youtubeplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

/**
 * Created by peterponterio on 8/19/17.
 */

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);

        Button buttonPlayVideo = (Button) findViewById(R.id.buttonPlayVideo);
        Button buttonPlayList = (Button) findViewById(R.id.buttonPlayList);

        buttonPlayVideo.setOnClickListener(this);
        buttonPlayList.setOnClickListener(this);
    }


    /* - The code checks to see which buttons been tapped to call the onClick method, then sets the data for a particular intent
    *  before calling startActivity
    *  - To start an activity we use the startActivity method and pass an intent which is an messaging object you can use to request
    *  an action from another app component
    *  - You can use an intent to launch an activity without linking your code directly to the activity you want to launch (Ex. if you wanted to start the
    *  devices email app, you can just specify an email in the intent without having to know which app the user has installed to handle emails)
    *  - The most significant use of intents is launching activities. Intents bind activities together.
    */


    @Override
    public void onClick(View v) {
        Intent intent = null;

        /* Youtube standalone activity creates intent for us
         * If we want an intent to play video, we just call the createVideoIntent method and play list used createPlaylistIntent
         * Both methods return an intent we can use to start an activity to perform the operation that we want
         * Both methods need to know which activity is starting the intent, and thats why we're providing "this" as the activity as the first parameter
         *
        */
        switch(v.getId()) {
            case R.id.buttonPlayVideo:
                //3rd parameter is how far into the video playback should start (in milliseconds) 0 being at the beginning
                //4th parameter is autoplay option. True meaning autoplay on
                //5th parameter is lightbox mode. Set to false to play video in full screen. allows orientation to change
                intent = YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_VIDEO_ID, 0, true, false);
                break;
            case R.id.buttonPlayList:
                //3rd parameter is which video in playlist we start with. 0 being the first
                //4th parameter is how far into the video playback should start (in milliseconds) 0 being at the beginning
                //5th parameter is autoplay option. True meaning autoplay on
                //6th parameter is lightbox mode. Set to false to play video in full screen. allows orientation to change
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_PLAYLIST,0, 0, true, true);
                break;
            default:

        }

        if(intent != null) {
            startActivity(intent);
        }

    }
}
