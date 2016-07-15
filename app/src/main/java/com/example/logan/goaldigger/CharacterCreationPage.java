package com.example.logan.goaldigger;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Activity for Character Creation
 *
 * @author Logan Skidmore
 *
 */
public class CharacterCreationPage extends AppCompatActivity implements View.OnClickListener {
    public static final String PREFS_NAME = "CharacterInfo";
    Button mButton;
    EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation_page);
        mButton = (Button) findViewById(R.id.avatarCreate);
        mEdit = (EditText) findViewById(R.id.avatarName);
        mButton.setOnClickListener(this);
    }

    void avatarNameCreate(View v) {
        //TODO: change to add to database

        Avatar avatar = new Avatar();

        avatar.setName(mEdit.getText().toString());
        database databaseAccess = new database(this);
        databaseAccess.updateAvatar(avatar);

        Log.d("Inserted into database", avatar.getName());

        Log.v("EditText", mEdit.getText().toString());
        System.out.println(mEdit.getText().toString());



        //TODO uncomment this after testing
        startActivity(new Intent("android.intent.action.MainPage"));


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.avatarCreate:
                avatarNameCreate(v);
                break;
        }
    }
}
