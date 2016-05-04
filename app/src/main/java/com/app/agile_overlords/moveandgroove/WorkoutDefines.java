package com.app.agile_overlords.moveandgroove;

/**
<<<<<<< HEAD
 * Created by Scott Williams on 4/19/2016.
=======
 * Created by matthew on 5/1/16.
>>>>>>> origin/BennettMatthew1
 */
public class WorkoutDefines {

    public double caloriesBurnedRunning(String sex, double weight, int age, int bpm,double time){
        //sex, weight, age are drawn from the users profile
        //bpm and time are entered by the user prior to calculation
        //time is minutes
        if (bpm == 0)
            bpm = 180;
        double calories;

       sex= sex.toLowerCase();

        if(sex == "male"){
            return ((age*.2017)-(weight*.09036)+(.6309*bpm)-55.0969)*time/4.184;
        }
        else{
            return ((age*.074) - (weight*.05741) + (.4472*bpm) - 20.4022)*time/4.184;
        }
    }


    public double caloriesBurnedBiking(double weight, double time, double speed){
        //weight is drawn from the users profile
        //time and average speed are entered by the user
        //time and average speed are entered by the user   for now will assume speed is 12
        //time is in minutes

        return ((0.046*speed*weight)+(.066*speed*speed*speed))*time/60;
    }


    public double caloriesBurnedOffSteps(int steps, int weight){
        //2000 steps is roughly a mile
        //formula for single mile is weight * .57
        return (weight*.57)*steps/2000;
    }

    public double caloriesBurnedWalking(double weight, double time, boolean fast){
        //http://ask.metafilter.com/48652/Walking-formula
        //moderate walking is burned = .029xweight*time
        //vigorous walking = .048 * same stuff
        //time is minutes
        if(fast == false){      //will assume not fast for now
            return .029*weight*time;
        }
        else
        {
            return .048*weight*time;
        }
    }

    public double caloriesBurnedSwimming(double time, double weight){
        //http://procalculators.info/calories-burned-swimming/
        //swimming
        //Calories Burned = Duration (in minutes) x (MET x 3.5 x weight in kg) / 200
        //met = 5.5 ish
        //lbs/2.2 = kilo
        double kiloWeight = weight/2.2;
        double met = 5.5;
        return (time)*(met*3.5*kiloWeight)/200;
    }

    public double caloriesBurnedFromSquats(double weight, double time){
        //http://www.newhealthadvisor.com/Calories-Burned-Doing-Squats.html
        //met = 5
        //time is in minutes
        double kiloWeight = weight/2.2;
        double met = 5;
        return (met*3.5*kiloWeight/200)*time;
    }

    public double caloriesBurnedFromSitupsAndPushups(double weight, double time) {
        //http://www.prohealth.com/weightloss/tools/exercise/calculator1_2.cfm
        //formula worked out from above
        //weight is lbs, time is minutes
        //formulas are the same for situp and pushup
        return (weight*3.62)*time/60;
    }

    public double caloriesBurnedJumping(double weight, double time, boolean isJumpJacks) {
        //(METs x 3.5 x weight in kilograms) ÷ 200) x amount of time in minutes.
        //http://www.livestrong.com/article/316542-calories-burned-jumping/
        double met = 12;
        if(isJumpJacks == true){
            met = 8;
        }
        double kiloWeight = weight/2.2;
        return ((met*3.5*kiloWeight)/200)*time;

    }


    public double caloriesBurnedFromBasketball(double time, double weight){
        //http://whatscookingamerica.net/Information/CalorieBurnChart.htm
        //weight lbs time minutes
        return .063*weight*time;

    }

    public double caloriesBurnedFromWeighLifting(double time, double weight, boolean vigorous){
        if (vigorous == true){
            return .55*time*weight;
        }
        return .28*time*weight;
    }

    public double caloriesBurnedSitting(double time, double weight){
        //for computer scientists busy programming away
        return .009*time*weight;
    }

    public double caloriesBurnedCustomExercise(String sex, double weight, int age, int bpm, double time){
        //sex, weight, age are drawn from the users profile
        //bpm and time are entered by the user prior to calculation
        //time is minutes
        //if bpm isnt specified, set to 180
        if (bpm == 0)
            bpm = 180;
        double calories;
        if(sex == "male"){
            return ((age*.2017)-(weight*.09036)+(.6309*bpm)-55.0969)*time/4.184;
        }
        else{
            return ((age*.074) - (weight*.05741) + (.4472*bpm) - 20.4022)*time/4.184;
        }
    }




    public static final String RUNNING_INFO = "You go out and run somewhere. Can be around the neighborhood, a park, " +
            "or whatever your heart desires.";
    public static final String BIKING_INFO = "You grab your bike and take it for a spin.";
    public static final String WALKING_INFO = "If you feel like going out for a stroll or hike";
    public static final String SWIMMING_INFO = "Jump on into the pool or some other body of water and use" +
            "whatever swimming style you prefer. Calorie count is a generalization for overall swimming" +
            ". Different styles may burn more or less.fwewefwefwefwefwefawef aawef awef awef awef aweg dfgxdf gzg xdfg dxfg xdfg xdfg xdfg erg erg sezrg zdxg xth rxth d";
    public static final String SQUAT_INFO = "Paste instructions for squating off wikipedia here";
    public static final String SITUP_INFO = "Paste instructions for situps off wikipedia here";
    public static final String PUSHUP_INFO = "Paste instructions for pushups off wikipedia here";
    public static final String JUMPJACK_INFO = "Paste instructions for jumping jacks off wikipedia here";
    public static final String JUMPROPE_INFO = "Paste instructions for jumprope off wikipedia here";
    public static final String BASKETBALL_INFO = "Shooting them hoops yo!";
    public static final String VIG_LIFT_INFO = "Heavy litfting";
    public static final String NOT_LIFT_INFO = "Not as intense lifting";
    public static final String SITTING_INFO = "For those of us programming away all day";


}

