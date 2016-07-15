package com.example.logan.goaldigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Activity for displaying goals
 *
 * @author Logan Skidmore
 *
 */

public class goalPage extends AppCompatActivity implements View.OnClickListener {

    Button addGoalButton;
    Button homeButton;
    Goal goals;
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;
    private PopupWindow pop;
    private LayoutInflater layoutInflater;
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal_page);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative);
        lvItems = (ListView) findViewById(R.id.listView);
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        items.add("Complete your first Kanye Quest by holding down!");
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = "Create your own goal!";
        itemsAdapter.add(itemText);
        etNewItem.setText("Click add goal!");
        addGoalButton = (Button) findViewById(R.id.addgoal);
        addGoalButton.setOnClickListener(this);
        homeButton = (Button) findViewById(R.id.home);
        homeButton.setOnClickListener(this);

        goals = new Goal();




       // ListView myList=
        //        (ListView) findViewById(R.id.listView);
        //myList.setAdapter(myAdapter);

        setupListViewListener();

    }

    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
    }

    // Attaches a long click listener to the listview
    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        // Remove the item within array at position
                        items.remove(pos);
                        // Refresh the adapter
                        itemsAdapter.notifyDataSetChanged();
                        // Return true consumes the long click event (marks it handled)
                        layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.popexp,null);
                        pop = new PopupWindow(container, 450 ,125, true);
                        pop.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, 300, 300);

                        container.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View v, MotionEvent event) {
                                pop.dismiss();
                                return true;
                            }
                        });


                        return true;
                    }

                });
    }


    private void addGoalButtonClick() {
        startActivity(new Intent("android.intent.action.GoalCreationPage"));
    }

    private void goHome() {
        startActivity(new Intent("android.intent.action.MainPage"));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addgoal:
                addGoalButtonClick();
                break;
            case R.id.home:
                goHome();
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