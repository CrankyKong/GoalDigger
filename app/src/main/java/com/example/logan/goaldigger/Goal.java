package com.example.logan.goaldigger;

/**
 * Created by John  Krieger on 7/11/2016.
 */
public class Goal {
    int goal_id;
    String goal_desc;

    public int getGoal_id(){
        return goal_id;
    }

    public void setGoal_id(int goal_id){
        this.goal_id = goal_id;
    }

    public String getGoal_desc(){
        return goal_desc;
    }

    public void setGoal_desc(String goal_desc){
        this.goal_desc = goal_desc;
    }

}
