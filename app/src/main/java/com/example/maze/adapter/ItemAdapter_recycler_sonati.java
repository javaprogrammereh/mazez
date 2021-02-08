package com.example.maze.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maze.R;
import com.example.maze.model.Item_recycler;
import com.example.maze.tozihat;

import java.util.List;


public class ItemAdapter_recycler_sonati extends RecyclerView.Adapter<ItemAdapter_recycler_sonati.MyViewHolder> {
    List<Item_recycler> itemList;
    Context mContext;
    public static boolean flag_recycler_sonati=false;
    public ItemAdapter_recycler_sonati(List<Item_recycler> itemList, Context mContext){
        this.itemList = itemList;
        this.mContext = mContext;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View aView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_recycler,parent,false);
        return new MyViewHolder(aView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.aName2.setText(itemList.get(position).getuName());
        holder.aAvatar2.setImageResource(itemList.get(position).getuAvatar());
        holder.aAvatar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag_recycler_sonati=true;
                Intent intent  = new Intent(mContext, tozihat.class);
                intent.putExtra("title_sonati",itemList.get(position).getuName());
                intent.putExtra("image_sonati",itemList.get(position).getuAvatar());
                intent.putExtra("mavad_sonati",itemList.get(position).getMavad());
                intent.putExtra("tahaieh_sonati",itemList.get(position).getTahaieh());
                mContext.startActivity(intent);            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView aAvatar2;
        public TextView aName2;

        public MyViewHolder(View itemView) {
            super(itemView);
            aAvatar2 = itemView.findViewById(R.id.img_avatar);
            aName2 = itemView.findViewById(R.id.txt_name);
        }
    }

}