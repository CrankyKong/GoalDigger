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
   private static final int DATABASE_VERSION = 1;
   private static final String DATABASE_NAME = "goalDigger";
   private static final String TABLE_USER = "theUser";
   private static final String USER_ID = "id";
   private static final String USER_NAME = "name";
   private static final String USER_PASSWORD = "password";
   private static final String TABLE_AVATAR = "avatar";

    public database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    //SQLiteDatabase goalDiggerDB = SQLiteDatabase.openOrCreateDatabase("goalDigger",null );
    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_THEUSER_TABLE = "CREATE TABLE " + TABLE_USER + "(" + USER_ID +
                " INTEGER PRIMARY KEY, " + USER_NAME + " TEXT," + USER_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_THEUSER_TABLE);

       // db.execSQL("create table user" + "(id interger primary key, name text, password text)");
       // db.execSQL("create table avatar " +
       //                 "(id integer primary key, name text,level integer,experience integer, cap_experience integer, user_id integer, FOREIGN KEY(user_id) REFERENCES user(id))"
       // );
       // db.execSQL("create table goal" + "(id integer primary, goal_desc text, rewardExp integer, completed text CHECK ('Y', 'N'), user_id integer, FOREIGN KEY(user_id) REFERENCES user(id) )");

    }

    void addUser(User user){


        SQLiteDatabase goalDiggerDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", user.getUsername());
        contentValues.put("password", user.getPassWord());
        goalDiggerDB.insert("theUser", null, contentValues);
        goalDiggerDB.close();

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE  IF EXISTS" + TABLE_USER);

    onCreate(db);

    }




}
