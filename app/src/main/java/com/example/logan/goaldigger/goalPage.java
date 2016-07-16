package com.example.logan.goaldigger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
 * This is where you add and complete goals to earn exp
 *
 * @author Logan Skidmore
 *
 */
public class goalPage extends AppCompatActivity implements View.OnClickListener {

    Button addGoalButton;
    Button homeButton;
    Goal goals;
    Avatar a;
    database DatabaseAccess;
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
        a = new Avatar();
        DatabaseAccess = new database(this);
        a = DatabaseAccess.getAvatar(1);
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
        setupListViewListener();
    }


    /**
     * addItem Function
     *When you press the button it takes the text from edit text and makes it a goal
     *
     * @param v the view
     *
     * @author Logan Skidmore
     *
     */
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

                        Log.d("before", "Level: " + a.getLevel());
                        Log.d("before", "Level: " + a.getCap_exp());
                        //add the exp to the avatar
                        int exp = a.getExp();
                        exp+= 100;
                        int capexp = a.getCap_exp();
                        if(exp >= capexp) {
                            exp = exp % capexp;
                            a.setCap_exp(capexp + 50);
                            a.setLevel(a.getLevel() + 1);
                            Log.d("after", "Level: " + a.getLevel());
                            Log.d("after", "Level: " + a.getCap_exp());
                        }
                        a.setExp(exp);
                        DatabaseAccess.updateAvatar(a);

                        return true;
                    }

                });
    }




    private void goHome() {
        startActivity(new Intent("android.intent.action.MainPage"));
    }


    /**
     * Onclick
     *
     * switch statements for buttons but we ended up only haven the home button
     *
     * @param v ET phone home
     * @author Logan Skidmore
     *
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home:
                goHome();
                break;
        }
    }
}