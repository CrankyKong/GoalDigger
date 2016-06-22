package com.example.logan.goaldigger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by John  Krieger on 6/22/2016.
 */
public class database extends SQLiteOpenHelper {

    public database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        SQLiteDatabase goalDiggerDB = SQLiteDatabase.openOrCreateDatabase("goalDigger",null );
        goalDiggerDB.execSQL("create table user" + "()");
        goalDiggerDB.execSQL("create table avatar " +
                        "(id integer primary key, name text,level integer,experience integer, cap_experience integer, user_id integer, FOREIGN KEY(user_id) REFERENCES user(id))"
        );
        goalDiggerDB.execSQL("create table goal" + "()");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }




}
