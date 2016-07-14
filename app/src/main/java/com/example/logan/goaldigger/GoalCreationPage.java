package com.example.logan.goaldigger;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class GoalCreationPage extends AppCompatActivity implements View.OnClickListener{

    RatingBar ratingBar;
    Button submitButton;
    TextView txtRatingValue;
    TextView desc;
    Goal newgoal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_creation_page);
        submitButton = (Button) findViewById(R.id.Submit);
        submitButton.setOnClickListener(this);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        txtRatingValue = (TextView) findViewById(R.id.txtRatingValue);
        newgoal = new Goal();
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                txtRatingValue.setText(String.valueOf(rating));
                newgoal.setDifficulty(rating);
            }
            });
        desc = (TextView) findViewById(R.id.Description);


    }

    private void submitButtonClick(){
        //TODO: Takes goal description
        //TODO: Insert Goal description into DB w/ completed= = 'N', exp = rating * 100;

        newgoal.setGoal_desc("hello");

        Intent i = new Intent("android.intent.action.goalPage");

        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Submit:
                submitButtonClick();
                break;
        }
    }
}
