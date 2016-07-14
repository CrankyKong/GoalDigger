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
    int user_id;


    public User() {
    }
    public User(int i, String string, String string1) {
    }


    public Integer getUser_id(){
        return user_id;
    }

    public void setUser_id(int user_id){

        if(this.user_id == user_id)
            this.user_id = user_id + 1;
        else
            this.user_id = user_id;

    }

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
