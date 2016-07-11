package com.example.logan.goaldigger;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity for User Creation
 *
 * @author John Krieger
 *
 */
public class UserCreationPage extends AppCompatActivity implements View.OnClickListener {
    public static final String PREFS_NAME = "UserInfo";
    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_creation_page);
        Log.i("UserCreationPage", "Successfully Created Page!");
        submitButton = (Button) findViewById(R.id.submit);
        submitButton.setOnClickListener(this);
    }

    void createUser(View v) {
        User user = new User();
        EditText userName = (EditText) findViewById(R.id.usernameInput);
        EditText password = (EditText) findViewById(R.id.passwordInput);
        EditText cPassword = (EditText) findViewById(R.id.confirmPassword);
        user.setUserName(String.valueOf(userName));
        user.setPassWord(String.valueOf(password));
        database databaseAccess = new database(this);
        databaseAccess.addUser(user);
        Log.d("UserCreationPage", "This button works");
        //SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        //SharedPreferences.Editor editor = settings.edit();
        //editor.putString("savedUsername", String.valueOf(user));
        //editor.putString("savedPassword", String.valueOf(password));


        Log.i("UserCreationPage", "Did you know? Deer have no gall bladders!");

        //editor.commit();
        if (user == null) {
            Log.e("UserCreationPage", "User is NULL this is not good");
        }

        startActivity(new Intent("android.intent.action.CharacterCreationPage"));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit:
                createUser(v);
                break;
        }

    }
}


