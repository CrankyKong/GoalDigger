package com.example.logan.goaldigger;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Activity for Character summary
 * Querys the DB
 *
 * @author Logan Skidmore & John Krieger
 *
 */
public class summaryPage extends AppCompatActivity {

    ListView listView;
    TextView avatarName;
    TextView levelView;
    String dbName;
    int dblevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_page);

        Avatar a;
        User u;
        database DatabaseAccess = new database(this);

        SharedPreferences prefs = getPreferences((MODE_PRIVATE));

        String storedPrefences = prefs.getString("Yo",null);

        a = DatabaseAccess.getAvatar(1);
        avatarName = (TextView) findViewById(R.id.avatarNameView);
        levelView = (TextView) findViewById(R.id.levelView);
        //Queury DB for level
         dblevel = a.getLevel();

        //Queury DB for name
        if(a != null) {
            dbName = a.getName();
        }
        else
            dbName = "AshKetchum";

        avatarName.setText("Name: " + dbName);
        levelView.setText("Level: " + dblevel);

    }
}
