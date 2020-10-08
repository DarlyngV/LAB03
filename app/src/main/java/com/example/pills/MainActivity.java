package com.example.pills;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button play_pause;
    MediaPlayer mp;
    private static final String TAG= "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play_pause=(Button)findViewById(R.id.play_pause);
        mp=MediaPlayer.create(this,R.raw.musica);
        play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp.isPlaying()){
                   mp.pause();
                   play_pause.setBackgroundResource(R.drawable.play);
                }
                else{
                    mp.start();
                    play_pause.setBackgroundResource(R.drawable.pause);
                }
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
       ReiniciarAudio();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }
    @Override
    protected void onStop() {
        super.onStop();
        pausarAudio();
        // La actividad ya no es visible (ahora está "detenida")
    }

    public  void pausarAudio(){
        if(mp.isPlaying()){
            mp.pause();
            play_pause.setBackgroundResource(R.drawable.pause);
        }
        Toast.makeText(this, "Audio Detenido", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"El audio ha sido pausado");

    }
    public  void ReiniciarAudio(){
        if (!mp.isPlaying()){
            mp.start();
            play_pause.setBackgroundResource(R.drawable.pause);
        }
        Toast.makeText(this, "Audio Reiniciado", Toast.LENGTH_SHORT).show();
        Log.d(TAG,"El audio ha sido reiniciado");
    }
}