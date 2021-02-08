package com.example.maze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class restaurant extends AppCompatActivity {
    private String latitude;
    private String longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        Button btnMap1 = (Button) findViewById(R.id.btn_map1);
        Button btnMap2 = (Button) findViewById(R.id.btn_map2);
        Button btnMap3 = (Button) findViewById(R.id.btn_map3);
        Button btnMap4 = (Button) findViewById(R.id.btn_map4);
        Button btnMap5 = (Button) findViewById(R.id.btn_map5);

        HashMap<String, Integer> imgMap = new HashMap<>();
        btnMap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "http://maps.google.com/maps?daddr=" + 36.662594 + "," + 53.074359;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        btnMap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "http://maps.google.com/maps?daddr=" + 36.559522 + "," + 53.067239;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        btnMap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "http://maps.google.com/maps?daddr=" + 36.507599 + "," + 53.058664;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        btnMap4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "http://maps.google.com/maps?daddr=" + 36.558176 + "," + 53.068169;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
        btnMap5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uri = "http://maps.google.com/maps?daddr=" + 36.579178 + "," + 53.061360;
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
    }
}
