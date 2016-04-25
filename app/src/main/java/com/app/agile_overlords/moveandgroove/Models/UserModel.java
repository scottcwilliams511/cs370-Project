package com.app.agile_overlords.moveandgroove.Models;

/**
 * Created by matthew on 4/1/16.
 */
public class UserModel {
    private String firstName;
    private String lastName;
    private String sex;
    private Integer age;
    private Float weight;
    private Integer heightFeet;
    private Integer heightInches;
    private String dateJoined;
    private Integer weeklyGoal;
    private Integer goalWeight;
    private UserModel user;

    public String GetFirstName() { return firstName; }
    public void SetFirstName(String firstName) { this.firstName = firstName; user.firstName = firstName;}
    public String GetLastName() { return lastName; }
    public void SetLastName(String lastName) { this.lastName = lastName; }
    public String GetSex() { return sex; }
    public void SetSex(String sex) { this.sex = sex; }
    public Integer GetAge() { return age; }
    public void SetAge(Integer age) { this.age = age; }
    public Float GetWeight() { return weight; }
    public void SetWeight(Float weight) { this.weight = weight; }
    public Integer GetHeightFeet() { return heightFeet; }
    public void SetHeightFeet(Integer heightFeet) { this.heightFeet = heightFeet; }
    public Integer GetHeightInches() { return heightInches; }
    public void SetHeightInches(Integer heightInches) { this.heightInches = heightInches; }
    public String GetDateJoined() { return dateJoined; }
    public void SetDateJoined(String dateJoined) { this.dateJoined = dateJoined; }
    public Integer GetWeeklyGoal() { return weeklyGoal; }
    public void SetWeeklyGoal(Integer weeklyGoal) { this.weeklyGoal = weeklyGoal; }
    public Integer GetGoalWeight() { return goalWeight; }
    public void SetGoalWeight(Integer goalWeight) { this.goalWeight = goalWeight; }

    // private workouts object
    // private meals object





    public UserModel getUserResults(){
        return user;
    }
}
