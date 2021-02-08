package com.example.maze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.maze.model.SharedPreferencesManager;
import com.example.maze.model.userApp;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {
    Button restaurant,modern,sonati,exit;
    public static boolean flag_play = false;
    MediaPlayer music;
    ImageView btn_play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*for music*/
        music = MediaPlayer.create(MainActivity.this, R.raw.music2);
        music.start();
        flag_play = true;
        music.setLooping(true);
        btn_play = findViewById(R.id.btn_play);
        btn_play.setImageResource(R.drawable.ic_baseline_pause);
        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag_play) {
                    btn_play.setImageResource(R.drawable.ic_baseline_play);
                    music.pause();
                    flag_play = false;
                } else {
                    btn_play.setImageResource(R.drawable.ic_baseline_pause);
                    music.start();
                    flag_play = true;
                }
            }
        });
        /*end music*/
        restaurant=findViewById(R.id.restaurant);
        modern=findViewById(R.id.btn_modern);
        sonati=findViewById(R.id.btn_sonati);
        exit=findViewById(R.id.exit);
        sonati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, com.example.maze.sonati.class));
            }
        });
        modern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, com.example.maze.modern.class));
            }
        });
        restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, com.example.maze.restaurant.class));
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String exit = "exit";
                SharedPreferences userDetails = getApplicationContext().getSharedPreferences("Exit", MODE_PRIVATE);
                SharedPreferences.Editor edit = userDetails.edit();
                edit.putString("exit", exit);
                edit.apply();
                finish();
                userApp user = new userApp();
                final SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(MainActivity.this);
                user = sharedPreferencesManager.get_shared_preferences();
                user.setFirst_time_run(true);
                sharedPreferencesManager.set_false_first_time(user);
            }
        });
    }
    //======================change font===============================
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    //====================for stop music=======================
    @Override
    protected void onPause() {
        super.onPause();
        music.pause();
        flag_play = false;
    }
    @Override
    protected void onResume() {
        super.onResume();
        btn_play.setImageResource(R.drawable.ic_baseline_pause);
        music.start();
        flag_play = true;
    }
}