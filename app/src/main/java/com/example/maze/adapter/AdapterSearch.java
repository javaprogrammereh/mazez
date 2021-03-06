package com.example.maze.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.maze.R;
import com.example.maze.model.Item_recycler;
import com.example.maze.tozihat;

import java.util.ArrayList;


public class AdapterSearch extends ArrayAdapter {

    public int resourceId;
    public Activity activity;
    public ArrayList<Item_recycler> data;
    TextView txtName;
    public static boolean flag_serch=false;

    public AdapterSearch(Activity activity, int resourceId, ArrayList<Item_recycler> object) {
        super(activity, resourceId, object);
        this.resourceId = resourceId;
        this.activity = activity;
        this.data = object;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        view = this.activity.getLayoutInflater().inflate(this.resourceId, null);
        txtName = view.findViewById(R.id.txt_search);
        Item_recycler foods = new Item_recycler(position);
        foods =data.get(position);
        txtName.setText(foods.getuName());

        /*1.click to show tozihat */
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag_serch=true;
                Intent intent  = new Intent(activity, tozihat.class);
                intent.putExtra("title_search",data.get(position).getuName());
                intent.putExtra("img_search",data.get(position).getuAvatar());
                intent.putExtra("mavad_search",data.get(position).getMavad());
                intent.putExtra("tahaieh_search",data.get(position).getTahaieh());
                activity.startActivity(intent);
            }
        });
        return view;
    }
}
