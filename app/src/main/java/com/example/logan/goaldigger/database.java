package com.example.logan.goaldigger;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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
   private static final String COMPLETED = "completed";
   private static final String GOAL_USERID = "user_id";
   private static final String GOAL_FK = "FOREIGN KEY(user_id) REFERENCES user(id)";
   private static final String TABLE_ITEM = "item";
   private static final String ITEM_ID = "id";
   private static final String ITEM_NAME = "name";
    private static final String ITEM_TYPE = "type";
   private static final String ITEM_AVATAR_ID = "avatar_id";
    private static final String ITEM_FK = "FOREIGN KEY(avatar_id) REFERENCES avatar(id)";

    public database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
   // SQLiteDatabase goalDiggerDB = SQLiteDatabase.openOrCreateDatabase("goalDigger",null );

    private static final String CREATE_THEUSER_TABLE = "CREATE TABLE " + TABLE_USER + "(" + USER_ID +
            " INTEGER PRIMARY KEY, " + USER_NAME + " TEXT," + USER_PASSWORD + " TEXT" + ")";


    private static final String CREATE_AVATAR_TABLE = "CREATE TABLE " + TABLE_AVATAR + "(" + AVATAR_ID +
            " INTEGER PRIMARY KEY," + AVATAR_NAME + " TEXT," + AVATAR_LEVEL + " INTEGER," +
            AVATAR_EXP + " INTEGER," + AVATAR_CEXP + " INTEGER," + AVATAR_USERID  + " INTEGER, " +
            AVATAR_FK + ")";


    private static final String CREATE_GOAL_TABLE = "CREATE TABLE " + TABLE_GOAL + "(" + GOAL_ID +
            " INTEGER PRIMARY KEY, " + GOAL_DESC + " TEXT, " + REWARD_EXP +
            " INTEGER, " + COMPLETED + "TEXT, "+ GOAL_USERID + " INTEGER, " + GOAL_FK + ")";

    private static final String CREATE_ITEM_TABLE = "CREATE TABLE " + TABLE_ITEM + "(" + ITEM_ID +
            " INTEGER PRIMARY KEY, " + ITEM_NAME+ " TEXT, " + ITEM_TYPE +
            " TEXT, " + ITEM_AVATAR_ID +" INTEGER, " + ITEM_FK + ")";

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_THEUSER_TABLE);
        db.execSQL(CREATE_AVATAR_TABLE);
        db.execSQL(CREATE_GOAL_TABLE);
        db.execSQL(CREATE_ITEM_TABLE);

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
        User foundUser = new User(Integer.parseInt(cursor.getString(0)),cursor.getString(0), cursor.getString(0));

        return foundUser;
    }

    public Avatar getAvatar(int id){

        SQLiteDatabase goalDiggerDB = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_AVATAR + " WHERE "
                + AVATAR_ID + " = " + id;

        Cursor c = goalDiggerDB.rawQuery(selectQuery, null);

        if(c != null)
            c.moveToFirst();
        Avatar foundAvatar = new Avatar();
        foundAvatar.setName(c.getString(c.getColumnIndex(AVATAR_NAME)));
        foundAvatar.setLevel(c.getInt(c.getColumnIndex(AVATAR_LEVEL)));
        // It's done?
        return foundAvatar;
    }

    public int updateAvatar(Avatar avatar){
        SQLiteDatabase goalDiggerDB = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(AVATAR_NAME, avatar.getName());
        contentValues.put(AVATAR_ID, 1);

        return goalDiggerDB.update(TABLE_AVATAR, contentValues, AVATAR_ID + " =?",
                new String[] {String.valueOf(1)});


    }

    public List<Goal> getAllGoals(){
        List<Goal> goals = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_GOAL;
        SQLiteDatabase goalDiggerDB = this.getReadableDatabase();
        Cursor c = goalDiggerDB.rawQuery(selectQuery,null);
        if(c.moveToFirst()){
            do{
                Goal goal = new Goal();
                goal.setGoal_id(c.getInt(c.getColumnIndex(GOAL_ID)));
                goal.setGoal_desc(c.getString(c.getColumnIndex(GOAL_DESC)));
                goal.setComplete(c.getInt(c.getColumnIndex(COMPLETED)));
                goal.setDifficulty(c.getFloat(c.getColumnIndex(REWARD_EXP)));

                goals.add(goal);
            }while(c.moveToNext());

        }
        return goals;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE  IF EXISTS" + TABLE_USER);
        db.execSQL("DROP TABLE  IF EXISTS" + TABLE_AVATAR);
        db.execSQL("DROP TABLE  IF EXISTS" + TABLE_GOAL);
    onCreate(db);

    }




}
