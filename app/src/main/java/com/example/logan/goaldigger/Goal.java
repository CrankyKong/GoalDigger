package com.example.logan.goaldigger;

import java.io.Serializable;

/**
 * Created by John  Krieger on 7/11/2016.
 */
public class Goal implements Serializable {
    int goal_id;
    String goal_desc;
    Boolean complete;
    float difficulty;

    public int getGoal_id(){
        return goal_id;
    }

    public float getDifficulty() { return difficulty;  }

    public Boolean isComplete() { return complete; }

    public void setGoal_id(int goal_id){
        this.goal_id = goal_id;
    }

    public String getGoal_desc(){
        return goal_desc;
    }

    public void setGoal_desc(String goal_desc){
        this.goal_desc = goal_desc;
    }

    public void setComplete(Boolean complete) { this.complete = complete; }

    public void setDifficulty(float difficulty) { this.difficulty = difficulty;  }
}
