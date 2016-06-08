package com.example.logan.goaldigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

   class User{
        boolean loggedIn = true;
        List<User> userList = new ArrayList<User>();
        String userName;
        String passWord;
       void logIn(){



    loggedIn = true;

       }


       boolean doesUserExist(User aUser) {
           for (int i = 0; i < userList.size(); i++) {
            if(aUser == userList.get(i)) {
                return true;
            }
            else
                return false;
           }
           throw new AssertionError();
       }

       boolean doesUsernameExist(User aUser){
           for (int i = 0; i < userList.size(); i++) {
               if (aUser.userName == userList.get(i).userName) {
                    return true;
               }
               else
                   return false;
           }throw new AssertionError();
       }

    }


}
