package com.example.logan.goaldigger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John  Krieger on 7/8/2016.
 */

public class User {
    boolean loggedIn = true;
    List<User> userList = new ArrayList<User>();
    String userName;
    String passWord;

    public String getUsername(){

        return userName;
    }

    public void setUserName(String userName){

        this.userName = userName;

    }

    public String getPassWord(){

        return passWord;
    }

    public void setPassWord(String passWord){

        this.passWord = passWord;

    }

    void logIn() {


        loggedIn = true;

    }


    boolean doesUserExist(User aUser) {
        for (int i = 0; i < userList.size(); i++) {
            if (aUser == userList.get(i)) {
                return true;
            } else
                return false;
        }
        throw new AssertionError();
    }

    boolean doesUsernameExist(User aUser) {
        for (int i = 0; i < userList.size(); i++) {
            if (aUser.userName == userList.get(i).userName) {
                return true;
            } else
                return false;
        }
        throw new AssertionError();
    }

}