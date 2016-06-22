package com.example.logan.goaldigger;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CharacterCreationPage extends AppCompatActivity {
    public static final String PREFS_NAME ="CharacterInfo";
    Button mButton;
    EditText mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creation_page);
        mButton = (Button)findViewById(R.id.avatarCreateButton);
        mEdit   = (EditText)findViewById(R.id.avatarName);

        mButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
                        SharedPreferences.Editor editor = settings.edit();
                        Log.v("EditText", mEdit.getText().toString());
                    }
                });

    }

}
