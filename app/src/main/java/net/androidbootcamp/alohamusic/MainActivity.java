///Name: Keyanna Frost
//Date: 8/17/2020
package net.androidbootcamp.alohamusic;

import android.media.MediaPlayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnUkulele, btnDrums;
    MediaPlayer mpUkulele, mpDrums;
    int playing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get an instance of each button
        btnUkulele = findViewById(R.id.btnUkulele);
        btnDrums = findViewById(R.id.btnDrums);
        btnUkulele.setOnClickListener(bUkulele);
        btnDrums.setOnClickListener(bDrums);

        //instantiate the media players
        mpUkulele =new MediaPlayer();
        mpUkulele = MediaPlayer.create(this, R.raw.ukulele);
        mpDrums =new MediaPlayer();
        mpDrums = MediaPlayer.create(this,R.raw.drums);

        playing = 0; //set the playing flag
    }

    Button.OnClickListener bUkulele = new Button.OnClickListener() {

        @Override
        public void onClick(View v) {
            //handle the click based on the playing state
            switch(playing){
                case 0:
                    mpUkulele.start();
                    playing = 1;
                    btnUkulele.setText("Pause Ukulele Song"); //update button text
                    btnDrums.setVisibility(View.INVISIBLE); //hide the drums button
                    break;
                case 1:
                    mpUkulele.pause();
                    playing = 0;
                    btnUkulele.setText("Play Ukulele Song"); //update button text
                    btnDrums.setVisibility(View.VISIBLE); //show button text
                    break;
            }
        }
    };

    Button.OnClickListener bDrums = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(playing){
                case 0:
                    mpDrums.start();
                    playing = 1;
                    btnDrums.setText("Pause Drums Song"); //update button next
                    btnUkulele.setVisibility(View.INVISIBLE); //hide the ukulele button
                    break;
                case 1:
                    mpDrums.pause();
                    playing = 0;
                    btnDrums.setText("Play Drums Song"); //update button next
                    btnUkulele.setVisibility(View.VISIBLE); //show the ukulele button
                    break;
            }
        }
    };
}