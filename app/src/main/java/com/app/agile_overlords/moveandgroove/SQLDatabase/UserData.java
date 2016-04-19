package com.app.agile_overlords.moveandgroove.SQLDatabase;

/**
 * Created by Never Forget on 4/18/2016.
 */
public class UserData {
    private long id;
    private String user_name;
    private String first_name;
    private String last_name;
    private Double weight;
    private String sex;
    private Integer age;
    private Integer height_feet;
    private Integer height_inches;
    private String created_at;
    private String date_joined;
    private  Integer weekly_goal;
    private  Integer goal_weight;

    // constructor.....

    /*
    public UserData(long id, String user_name, String first_name, String last_name, Double weight, String sex, Integer age, Integer height_feet, Integer height_inches, String created_at, String date_joined, Integer weekly_goal, Integer goal_weight) {
        this.id = id;
        this.user_name = user_name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.weight = weight;
        this.sex = sex;
        this.age = age;
        this.height_feet = height_feet;
        this.height_inches = height_inches;
        this.created_at = created_at;
        this.date_joined = date_joined;
        this.weekly_goal = weekly_goal;
        this.goal_weight = goal_weight;
    }
    */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight_feet() {
        return height_feet;
    }

    public void setHeight_feet(Integer height_feet) {
        this.height_feet = height_feet;
    }

    public Integer getHeight_inches() {
        return height_inches;
    }

    public void setHeight_inches(Integer height_inches) {
        this.height_inches = height_inches;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(String date_joined) {
        this.date_joined = date_joined;
    }

    public Integer getWeekly_goal() {
        return weekly_goal;
    }

    public void setWeekly_goal(Integer weekly_goal) {
        this.weekly_goal = weekly_goal;
    }

    public Integer getGoal_weight() {
        return goal_weight;
    }

    public void setGoal_weight(Integer goal_weight) {
        this.goal_weight = goal_weight;
    }
}
