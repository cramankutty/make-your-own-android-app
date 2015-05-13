package com.myswot;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class SecondActivity extends Activity {
     MediaPlayer mp;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        mp = new MediaPlayer();
        Button b = (Button) findViewById(R.id.button1);


        b.setOnClickListener(new View.OnClickListener()

                             {

                                 @Override
                                 public void onClick(View v) {

                                     if (mp.isPlaying()) {
                                         mp.stop();
                                     }

                                     try {
                                         mp.reset();
                                         AssetFileDescriptor afd;
                                         afd = getAssets().openFd("AudioFile.mp3");
                                         mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                                         mp.prepare();
                                         mp.start();
                                     } catch (IllegalStateException e) {
                                         e.printStackTrace();
                                     } catch (IOException e) {
                                         e.printStackTrace();
                                     }

                                 }
                             }


        );
    }

    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first

        // Release the Camera because we don't need it when paused
        // and other activities might need to use it.
        if (mp.isPlaying()) {
           mp.pause();
        }
    }
    public void onClickNext(View view) {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivityForResult(intent, 600);
        overridePendingTransition(R.anim.slide_in_bottom, R.anim.slide_out_top);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     //   overridePendingTransition(R.anim.slide_in_top, R.anim.slide_out_bottom);
    }
}
