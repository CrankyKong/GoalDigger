package com.example.logan.goaldigger;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
   private static final String AVATAR_ID = "id";
   private static final String AVATAR_NAME = "name";
   private static final String AVATAR_LEVEL = "level";
   private static final String AVATAR_EXP = "exp";
   private static final String AVATAR_CEXP = "cap_exp";
   private static final String AVATAR_USERID = "user_id";
   private static final String AVATAR_FK = "FOREIGN KEY(user_id) REFERENCES user(id)";
   private static final String TABLE_GOAL ="goal";
   private static final String GOAL_ID = "id";
   private static final String GOAL_DESC = "goal_desc";
   private static final String REWARD_EXP = "reward_exp";
   private static final String COMPLETED = "completed text CHECK ('Y', 'N'),";
   private static final String GOAL_USERID = "user_id";
   private static final String GOAL_FK = "FOREIGN KEY(user_id) REFERENCES user(id)";

    public database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
   // SQLiteDatabase goalDiggerDB = SQLiteDatabase.openOrCreateDatabase("goalDigger",null );

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_THEUSER_TABLE = "CREATE TABLE " + TABLE_USER + "(" + USER_ID +
                " INTEGER PRIMARY KEY, " + USER_NAME + " TEXT," + USER_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_THEUSER_TABLE);

        String CREATE_AVATAR_TABLE = "CREATE TABLE " + TABLE_AVATAR + "(" + AVATAR_ID +
                " INTEGER PRIMARY KEY," + AVATAR_NAME + " TEXT," + AVATAR_LEVEL + " INTEGER," +
                AVATAR_EXP + " INTEGER," + AVATAR_CEXP + " INTEGER," + AVATAR_USERID  + " INTEGER, " +
                AVATAR_FK + ")";
        db.execSQL(CREATE_AVATAR_TABLE);

        String CREATE_GOAL_TABLE = "CREATE TABLE " + TABLE_GOAL + "(" + GOAL_ID +
                " INTEGER PRIMARY KEY, " + GOAL_DESC + " TEXT, " + REWARD_EXP +
                " INTEGER, " + COMPLETED + " " + GOAL_USERID + " INTEGER, " + GOAL_FK + ")";
        db.execSQL(CREATE_GOAL_TABLE);
       // db.execSQL("create table goal" + "(id integer primary key, goal_desc text, rewardExp integer, completed text CHECK ('Y', 'N'), user_id integer, FOREIGN KEY(user_id) REFERENCES user(id) )");

    }



    void addUser(User user){


        SQLiteDatabase goalDiggerDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", user.getUsername());
        contentValues.put("password", user.getPassWord());
        goalDiggerDB.insert("theUser", null, contentValues);
        //goalDiggerDB.close();

    }

    void addAvatar(Avatar avatar){
     SQLiteDatabase goalDiggerDB = this.getWritableDatabase();
     ContentValues contentValues = new ContentValues();
     contentValues.put("name", avatar.getName());
     contentValues.put("level", 1);
     contentValues.put("exp", 0);
     contentValues.put("cap_exp", 100);
     goalDiggerDB.insert("avatar", null ,contentValues);
     //goalDiggerDB.close();

    }

    void addGoal(Goal goal){
        SQLiteDatabase goalDiggerDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("goal_desc", goal.getGoal_desc());
        contentValues.put("reward_exp", goal.getDifficulty());
        contentValues.put("completed", "N");
        goalDiggerDB.insert("goal", null, contentValues);
       // goalDiggerDB.close();
    }

    public User getUser(int id){

        SQLiteDatabase goalDiggerDB = this.getReadableDatabase();
        Cursor cursor  = goalDiggerDB.query(TABLE_USER, new String[] {USER_ID, USER_NAME}, USER_ID + "=?",
                new String[] {String.valueOf(id) }, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        User foundUser = new User(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));

       // It's done?
        return foundUser;
    }

    public Avatar getAvatar(int id){

        SQLiteDatabase goalDiggerDB = this.getReadableDatabase();
        Cursor cursor  = goalDiggerDB.query(TABLE_AVATAR, new String[] {AVATAR_ID, AVATAR_LEVEL, AVATAR_NAME, AVATAR_EXP ,AVATAR_CEXP, AVATAR_USERID}, AVATAR_ID + "=?",
                new String[] {String.valueOf(id) }, null, null, null, null);
        if(cursor != null)
            cursor.moveToFirst();
        Avatar foundAvatar = new Avatar(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));

        // It's done?
        return foundAvatar;
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE  IF EXISTS" + TABLE_USER);
        db.execSQL("DROP TABLE  IF EXISTS" + TABLE_AVATAR);
        db.execSQL("DROP TABLE  IF EXISTS" + TABLE_GOAL);
    onCreate(db);

    }




}
