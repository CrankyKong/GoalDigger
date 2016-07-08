package com.example.logan.goaldigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Activity for displaying goals
 *
 * @author Logan Skidmore
 *
 */

public class goalPage extends AppCompatActivity implements View.OnClickListener {

    Button addGoalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_page);
        addGoalButton = (Button) findViewById(R.id.addgoal);
        addGoalButton.setOnClickListener(this);
    }

    private void addGoalButtonClick() {
        startActivity(new Intent("android.intent.action.GoalCreationPage"));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Avatars:
                addGoalButtonClick();
                break;
        }
    }
}
//update again please
//class Goal{
//    int start;
//    int end;
//    String description;
//    void testDates(){
//        if(start > end){
//            throw new AssertionError("The end date is before start date");
//        }
//    }
//}