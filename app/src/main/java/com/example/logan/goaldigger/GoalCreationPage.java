package com.example.logan.goaldigger;

import android.content.Intent;
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
    Goal newgoal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_creation_page);
        submitButton = (Button) findViewById(R.id.Submit);
        submitButton.setOnClickListener(this);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        txtRatingValue = (TextView) findViewById(R.id.txtRatingValue);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {

                txtRatingValue.setText(String.valueOf(rating));
            }
            });
    }

    private void submitButtonClick(){
        //TODO: Takes goal description
        //TODO: Insert Goal description into DB w/ completed= = 'N', exp = rating * 100;

        startActivity(new Intent("android.intent.action.MAIN"));
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
