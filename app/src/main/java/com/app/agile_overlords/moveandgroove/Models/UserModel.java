package com.app.agile_overlords.moveandgroove.Models;

/**
 * Created by matthew on 4/1/16.
 */
public class UserModel {

    public UserModel(){}
    //Todo: This was causing a conflict. Weight is a float here, but Integer else where
    public UserModel(String sex, int age, int weight){

  // public UserModel(String sex, int age, double weight){

        this.sex = sex;
        this.age = age;
        this.weight = weight;
    }


    private String userId;
    private String firstName;
    private String lastName;
    private String sex;
    private Integer age;
    private Integer weight;
    private Integer heightFeet;
    private Integer heightInches;
    private String dateJoined;
    private Float weeklyGoal;
    private Float goalWeight;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String GetFirstName() { return firstName; }
    public void SetFirstName(String firstName) { this.firstName = firstName;}
    public String GetLastName() { return lastName; }
    public void SetLastName(String lastName) { this.lastName = lastName; }
    public String GetSex() { return sex; }
    public void SetSex(String sex) { this.sex = sex; }
    public Integer GetAge() { return age; }
    public void SetAge(Integer age) { this.age = age; }
    public Integer GetWeight() { return weight; }
    public void SetWeight(Integer weight) { this.weight = weight; }
    public Integer GetHeightFeet() { return heightFeet; }
    public void SetHeightFeet(Integer heightFeet) { this.heightFeet = heightFeet; }
    public Integer GetHeightInches() { return heightInches; }
    public void SetHeightInches(Integer heightInches) { this.heightInches = heightInches; }
    public String GetDateJoined() { return dateJoined; }
    public void SetDateJoined(String dateJoined) { this.dateJoined = dateJoined; }
    public Float GetWeeklyGoal() { return weeklyGoal; }
    public void SetWeeklyGoal(Float weeklyGoal) { this.weeklyGoal = weeklyGoal; }
    public Float GetGoalWeight() { return goalWeight; }
    public void SetGoalWeight(Float goalWeight) { this.goalWeight = goalWeight; }
}
