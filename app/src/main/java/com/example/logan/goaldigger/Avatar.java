package com.example.logan.goaldigger;

/**
 * Created by John  Krieger on 7/11/2016.
 */
public class Avatar {

    String name;
    int avatar_id;
    int level;
    int exp;
    int cap_exp;


    public Avatar() {
        setName("Bob");
        setAvatar_id(1);
        setCap_exp(200);
    }

    public Avatar(int i, String string, String string1) {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCap_exp() {
        return cap_exp;
    }

    public int getExp() {
        return exp;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {

        return name;
    }

    public int getAvatar_id() {
        return avatar_id;
    }

    public void setAvatar_id(int avatar_id) {
        this.avatar_id = avatar_id;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setCap_exp(int cap_exp) {
        this.cap_exp = cap_exp;
    }

}