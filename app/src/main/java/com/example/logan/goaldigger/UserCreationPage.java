package com.example.logan.goaldigger;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserCreationPage extends AppCompatActivity {
    public static final String PREFS_NAME ="UserInfo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_creation_page);
    }

    void createUser(View v){
        EditText user = (EditText)findViewById(R.id.usernameInput);
        EditText password = (EditText)findViewById(R.id.passwordInput);
        EditText cPassword = (EditText)findViewById(R.id.confirmPassword);

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("savedUsername", String.valueOf(user));
        editor.putString("savedPassword", String.valueOf(password));
        editor.commit();


    }


}


