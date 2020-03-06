package com.example.gymapp;

import android.util.Log;

import java.util.ArrayList;

public class Utils {
    private static final String TAG = "Utils";

    public static  ArrayList<GymTraining> allTrainings;
    public static  ArrayList<plan> userPlans;
    public Utils()
    {

    }

    public static ArrayList<GymTraining> getAllTrainings() {
        return allTrainings;
    }

    public static void setAllTrainings(ArrayList<GymTraining> allTrainings) {
        Utils.allTrainings = allTrainings;
    }

    public static ArrayList<plan> getUserPlans() {
        return userPlans;
    }

    public static void setUserPlans(ArrayList<plan> userPlans) {
        Utils.userPlans = userPlans;
    }

    public static void initialize(){
        Log.d(TAG, "initialize: started");
        if(null == allTrainings)
        {allTrainings= new ArrayList<>();}
        if(null==userPlans)
        {userPlans=new ArrayList<>();}

        GymTraining pushup= new GymTraining();
        pushup.setName("Pushup");
        pushup.setShortdes("Short description of push up");
        pushup.setLongdes("push up is good for muscles.bluh bluh  fjdfndcnvcbxvnbvbhfkjsfkjdsnfmnd vnc xvkbdjfsbfkjsdkdksngsdgsngdm");
        pushup.setImageUrl("https://qph.fs.quoracdn.net/main-qimg-72e74b9dc1fb0aa14a4e24c060cca8be");//TODO
        allTrainings.add(pushup);
        GymTraining squat= new GymTraining();
        squat.setName("Squat");
        squat.setShortdes("Short description of Squat");
        squat.setLongdes("squat is good for muscles.bluh bluh  fjdfndcnvcbxvnbvbhfkjsfkjdsnfmnd vnc xvkbdjfsbfkjsdkdksngsdgsngdm");
        squat.setImageUrl("https://i.guim.co.uk/img/media/658505caaecacb623bf0ec3b4f5fd19284f2e00c/0_1659_3840_3725/master/3840.jpg?width=300&quality=85&auto=format&fit=max&s=e6394f4be76f22371dabbaa0c950c03f");//TODO
        allTrainings.add(squat);
        GymTraining longPress= new GymTraining();
        longPress.setName("longPress");
        longPress.setShortdes("Short description of longPress");
        longPress.setLongdes("longPress is good for muscles.bluh bluh  fjdfndcnvcbxvnbvbhfkjsfkjdsnfmnd vnc xvkbdjfsbfkjsdkdksngsdgsngdm");
        longPress.setImageUrl("https://i.ytimg.com/vi/pZe9O0bi7xg/maxresdefault.jpg");//TODO
        allTrainings.add(longPress);
        GymTraining chinup= new GymTraining();
        chinup.setName("chinup");
        chinup.setShortdes("Short description of chinup");
        chinup.setLongdes("chinup is good for muscles.bluh bluh  fjdfndcnvcbxvnbvbhfkjsfkjdsnfmnd vnc xvkbdjfsbfkjsdkdksngsdgsngdm");
        chinup.setImageUrl("https://images.squarespace-cdn.com/content/v1/570adf3a62cd9478edc35b2f/1461022928854-5Z6P1OFUXH9LL8BNEV47/ke17ZwdGBToddI8pDm48kP0Vv6CiGDUT65G3NYBc34YUqsxRUqqbr1mOJYKfIPR7XPdMUwapbohRe1EFhjG6J2hHDNYzZTczX2oi4eYWLs1CRW4BPu10St3TBAUQYVKc_Xm2sNmCu7PGx_bnt8AhEzViI1jneWORWQVVNMq7IwdS9pCEWUqYCz6PYJuhmQWc/image-asset.jpeg");//TODO
        allTrainings.add(chinup);




    }
    public static  boolean addToUserPlan(plan a){
        Log.d(TAG, "addToUserPlan: Started");
        return userPlans.add(a);
    }
    public static boolean removeFromPlan(plan a){
        Log.d(TAG, "removeFromPlan: started");
        return userPlans.remove(a);
    }

}
