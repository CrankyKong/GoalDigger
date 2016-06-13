package com.example.logan.goaldigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class goalPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_page);
    }
}
//update please
class Goal{
    int start;
    int end;
    String description;
    void testDates(){
        if(start > end){
            throw new AssertionError("The end date is before start date");
        }
    }
}