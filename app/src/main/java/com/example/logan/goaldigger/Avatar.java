package com.example.logan.goaldigger;

/**
 * Created by John  Krieger on 7/11/2016.
 */
public class Avatar {

    String name;
    int avatar_id;

    public Avatar (){
        setName("Bob");
        setAvatar_id(1);
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName(){

        return name;
    }

    public int getAvatar_id(){
        return avatar_id;
    }

    public void setAvatar_id(int avatar_id) {
        this.avatar_id = avatar_id;
    }
}
