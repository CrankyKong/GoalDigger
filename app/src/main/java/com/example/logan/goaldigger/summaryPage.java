package com.example.logan.goaldigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Activity for Character summary
 *
 * @author Logan Skidmore
 *
 */
public class summaryPage extends AppCompatActivity {

    ListView listView;
    TextView avatarName;
    TextView levelView;
    String dbName;
    int dblevel;
    String[] goalArray = {"Android","IPhone","WindowsMobile","Blackberry","WebOS","Ubuntu","Windows7","Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_page);

        Avatar a;
        User u;
        database DatabaseAccess = new database(this);

        a = DatabaseAccess.getAvatar(1);
        avatarName = (TextView) findViewById(R.id.avatarNameView);
        levelView = (TextView) findViewById(R.id.levelView);
        //TODO: Queury DB for level

         dblevel = a.getLevel();
        //TODO: Queury DB for name

        if(a != null) {
            dbName = a.getName();
        }
        else
            dbName = "AshKetchum";
        avatarName.setText("Name: " + dbName);
        levelView.setText("Level: " + dblevel);

//        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_summary_page, goalArray);
//
//        ListView listView = (ListView) findViewById(R.id.summaryGoalsListview);
//        listView.setAdapter(adapter);
    }
}
