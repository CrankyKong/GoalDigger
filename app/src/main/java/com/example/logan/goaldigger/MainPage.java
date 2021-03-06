package com.example.logan.goaldigger;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity for MainPage
 *
 * This is where the magic happens
 *
 * @author John Krieger
 *
 */
public class MainPage extends AppCompatActivity implements View.OnClickListener{
    public static database datbaseAccess;
    Button avatarButton;
    Button summaryButton;
    Button goalButton;
    Button accountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main_page);
        avatarButton = (Button) findViewById(R.id.Avatars);
        avatarButton.setOnClickListener(this);
        summaryButton = (Button) findViewById(R.id.Summary);
        summaryButton.setOnClickListener(this);
        goalButton = (Button) findViewById(R.id.Goals);
        goalButton.setOnClickListener(this);
        accountButton = (Button) findViewById(R.id.Account);
        accountButton.setOnClickListener(this);
    }

    private void avatarButtonClick(){
        startActivity(new Intent("android.intent.action.CharacterPage"));

    }

    private void summaryButtonClick(){
        startActivity(new Intent("android.intent.action.summaryPage"));
    }

    private void goalButtonClick(){
        startActivity(new Intent("android.intent.action.goalPage"));
    }

    private void accountButtonClick(){
        startActivity(new Intent("android.intent.action.userCreationPage"));
    }

    /**
     * OnClick
     *
     * Look at this beautiful Switch Statement. It tells the butons to do different things
     *
     * @author Logan Skidmore
     * @param v
     *
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Avatars:
                    avatarButtonClick();
                    break;
            case  R.id.Summary:
                    summaryButtonClick();
                    break;
            case  R.id.Goals:
                goalButtonClick();
                break;
            case R.id.Account:
                accountButtonClick();
                break;

        }
    }




}
