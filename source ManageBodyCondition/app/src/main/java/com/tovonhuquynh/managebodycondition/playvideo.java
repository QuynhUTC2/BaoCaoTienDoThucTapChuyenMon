package com.tovonhuquynh.managebodycondition;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class playvideo extends AppCompatActivity {
  /*  String API_KEY ="AIzaSyACWk5tvbIL8X-9B5XOC1H7qOFVRL1SeqY";

    int REQUEST_VIDEO = 123;
    YouTubePlayerView ytbe_watchvideo;*/
    Button btn_quit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watchvideo_layout);
        btn_quit = findViewById(R.id.btn_quit);
       /* ytbe_watchvideo = (YouTubePlayerView) findViewById(R.id.youtube_player_view);
        ytbe_watchvideo.initialize(API_KEY,this);
*/
        btn_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

/*
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cuePlaylist("PNhYz6RmIr4");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(playvideo.this,REQUEST_VIDEO);
        }else {
            Toast.makeText(this,"Error!!!",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_VIDEO){
            ytbe_watchvideo.initialize(API_KEY, playvideo.this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }*/

}
