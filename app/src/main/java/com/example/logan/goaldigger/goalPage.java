package com.example.logan.goaldigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Activity for displaying goals
 *
 * @author Logan Skidmore
 *
 */

public class goalPage extends AppCompatActivity implements View.OnClickListener {

    Button addGoalButton;
    String[] myStringArray={"A","B","C"};
    Goal goals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_page);
        addGoalButton = (Button) findViewById(R.id.addgoal);
        addGoalButton.setOnClickListener(this);
        goals = new Goal();


        ArrayAdapter<String> myAdapter=new
                ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                myStringArray);

        ListView myList=
                (ListView) findViewById(R.id.listView);
        myList.setAdapter(myAdapter);

    }

    private void addGoalButtonClick() {
        startActivity(new Intent("android.intent.action.GoalCreationPage"));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addgoal:
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