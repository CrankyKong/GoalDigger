package com.example.logan.goaldigger;

import android.content.Intent;
import android.content.SharedPreferences;
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
    }

    private void avatarNameCreate() {
        //TODO: change to add to database
        //SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        //SharedPreferences.Editor editor = settings.edit();
        Log.v("EditText", mEdit.getText().toString());
        System.out.println(mEdit.getText().toString());
        startActivity(new Intent("android.intent.action.MAIN"));

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.avatarCreate:
                avatarNameCreate();
                break;
        }
    }
}
