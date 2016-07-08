package com.example.logan.goaldigger;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
 * Created by John  Krieger on 6/22/2016.
 */
/**
 * Activity for database
 *
 * This activity is used to create the database.
 *
 * @author John Krieger
 * @version 1
 */
public class database extends SQLiteOpenHelper {

    public database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    SQLiteDatabase goalDiggerDB = SQLiteDatabase.openOrCreateDatabase("goalDigger",null );
    @Override
    public void onCreate(SQLiteDatabase db) {

        goalDiggerDB.execSQL("create table user" + "(id interger primary key, name text, password text)");
        goalDiggerDB.execSQL("create table avatar " +
                        "(id integer primary key, name text,level integer,experience integer, cap_experience integer, user_id integer, FOREIGN KEY(user_id) REFERENCES user(id))"
        );
        goalDiggerDB.execSQL("create table goal" + "(id integer primary, goal_desc text, rewardExp integer, completed text CHECK ('Y', 'N'), user_id integer, FOREIGN KEY(user_id) REFERENCES user(id) )");

    }

    void addUser(String userName, String password){


        SQLiteDatabase goalDiggerDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", userName);
        contentValues.put("password", password);
        goalDiggerDB.insert("user", null, contentValues);
        goalDiggerDB.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }




}
