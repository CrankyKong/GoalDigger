package com.example.logan.goaldigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    Button avatarButton;
    Button summaryButton;
    Button goalButton;
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

        }
    }

    class User{
        boolean loggedIn = true;
        List<User> userList = new ArrayList<User>();
        String userName;
        String passWord;
       void logIn(){



    loggedIn = true;

       }


       boolean doesUserExist(User aUser) {
           for (int i = 0; i < userList.size(); i++) {
            if(aUser == userList.get(i)) {
                return true;
            }
            else
                return false;
           }
           throw new AssertionError();
       }

       boolean doesUsernameExist(User aUser){
           for (int i = 0; i < userList.size(); i++) {
               if (aUser.userName == userList.get(i).userName) {
                    return true;
               }
               else
                   return false;
           }throw new AssertionError();
       }

    }


}
