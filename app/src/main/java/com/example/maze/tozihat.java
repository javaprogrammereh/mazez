package com.example.maze;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.maze.adapter.AdapterSearch;
import com.example.maze.adapter.ItemAdapter_recycler_modern;
import com.example.maze.adapter.ItemAdapter_recycler_sonati;

//import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class tozihat extends AppCompatActivity {
    /*create object for xml*/
    private TextView txtTitle, txtMavad, txtTahaieh;
    ImageView imgTozihat,imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tozihat);
        /* Get object from xml file*/
        txtMavad = findViewById(R.id.mavad_lazem);
        txtTahaieh = findViewById(R.id.tarz_tahie);
        txtTitle = findViewById(R.id.title_tozihat);
        imgTozihat = findViewById(R.id.img_tozihat);
        imgBack = findViewById(R.id.img_back_tozihat);

        /*1.load from recycler_myanvade*/
        if (ItemAdapter_recycler_sonati.flag_recycler_sonati == true) {
            Bundle bundle = getIntent().getExtras();
            txtTitle.setText(bundle.getString("title_sonati"));
            txtMavad.setText(bundle.getString("mavad_sonati"));
            txtTahaieh.setText(bundle.getString("tahaieh_sonati"));
            imgTozihat.setImageResource(bundle.getInt("image_sonati"));
        }else if (ItemAdapter_recycler_modern.flag_recycler_modern==true){
            Bundle bundle = getIntent().getExtras();
            txtTitle.setText(bundle.getString("title_modern"));
            txtMavad.setText(bundle.getString("mavad_modern"));
            txtTahaieh.setText(bundle.getString("tahaieh_modern"));
            imgTozihat.setImageResource(bundle.getInt("image_modern"));
        }        /*1.load from AdapterSearch*/
        else if (AdapterSearch.flag_serch == true) {
            Bundle bundle = getIntent().getExtras();
            txtTitle.setText(bundle.getString("title_search"));
            imgTozihat.setImageResource(bundle.getInt("img_search"));
            txtMavad.setText(bundle.getString("mavad_search"));
            txtTahaieh.setText(bundle.getString("tahaieh_search"));
        }
        /*back and this finish*/
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ItemAdapter_recycler_sonati.flag_recycler_sonati = false;
                ItemAdapter_recycler_modern.flag_recycler_modern = false;
                finish();
            }
        });
    }
    //======================change font===============================
//    @Override
//    protected void attachBaseContext(Context newBase) {
//        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
//    }
}