package com.example.logan.goaldigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


/**
 * Activity for Character Display
 *
 * @author John Krieger
 * @deprecated this page wasn't used but we kept it like whales kept their leg bones fomr when they evolved from wolves
 *
 */
public class CharacterPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_page);
    }
}

class Character {
        int level = 0;
        double experience = 0;
        String name = "";
        void testAttributes(){
            if(level != 0 && experience != 0 && name != "") {
                //everything seems A-OK
            }
            else {
                throw new AssertionError("The attributes did not get received");
            }
        }



}