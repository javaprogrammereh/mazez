package com.example.maze.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;


public class Database {

    private static DatabaseHelper databaseHelper;
    /*table name*/
    private static final String tbl_liked = "tbl_liked";
    /*field name*/
    private static final String Name = "title";

    public static boolean flagAdd,flagDel;

    public Database() {
    }

    public static SQLiteDatabase getInstance(Context context) {
        if (databaseHelper == null) {
            try {
                databaseHelper = new DatabaseHelper(context);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return databaseHelper.getWritableDatabase();
    }

    public static SQLiteDatabase getInstance2(Context context) {
        if (databaseHelper == null) {
            try {
                databaseHelper = new DatabaseHelper(context);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return databaseHelper.getReadableDatabase();
    }

    /*1.method get data foodsliked from database */
    /*2.add food to table liked*/
    public static void addLiked(String title, boolean like, String img
            , String mavad, String tahaieh, Context context) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("liked", like);
        contentValues.put("img", img);
        contentValues.put("mavad", mavad);
        contentValues.put("tahaieh", tahaieh);
        Long value = getInstance(context).insert(tbl_liked, null, contentValues);
        if (String.valueOf(value).equals("-1")) {
            flagAdd = false;
            getInstance(context).close(); // Closing database connection
        } else if (!(String.valueOf(value).equals("-1"))) {
            flagAdd = true;
        }
        getInstance(context).close(); // Closing database connection
    }
    /*3.deleted data food from table liked*/
    public static void delLiked(Context context, String name) {
        int valdel = getInstance(context).delete(tbl_liked,
                Name + " = ?", new String[]{"" + name});
        if (!String.valueOf(valdel).equals("1")) {
            flagDel = false;
            getInstance(context).close(); // Closing database connection
        } else if ((String.valueOf(valdel).equals("1"))) {
            flagDel = true;
        }
        getInstance(context).close();
    }

}