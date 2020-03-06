package com.example.gymapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.GymApp.R;

import java.util.ArrayList;

import android.os.Bundle;

public class PlanActivity extends AppCompatActivity {
    private static final String TAG = "PlanActivity";
    private  RecyclerView mondayRecView,tuesdayRecView,wednesdayRecView,fridayRecView,saturdayRecView,sundayRecView,thursdayRecView;
    private RelativeLayout notAddedRelLayout;
    private Button btnAddAPlan;
    private NestedScrollView nestedScrollView;
    private TextView mondayEdit,tuesdayEdit,wednesdayEdit,thursdayEdit,fridayEdit,saturdayEdit,sundayEdit;
    private PlanRecViewAdapter mondayAdapter,tuesdayAdapter,wednesdayAdapter,thursdayAdapter,fridayAdapter,saturdayAdapter,sundayAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        initViews();
        initAdapters();
        initREcViews();

        if(Utils.getUserPlans().size()>0)
        {
            notAddedRelLayout.setVisibility(View.GONE);
            nestedScrollView.setVisibility(View.VISIBLE);
        }else{
            notAddedRelLayout.setVisibility(View.VISIBLE);
            nestedScrollView.setVisibility(View.GONE);
        }
        setonClickListeners();

    }
    private void setonClickListeners(){
        Log.d(TAG, "setonClickListeners: strated");
        mondayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PlanActivity.this,EditActivity.class);
                intent.putExtra("day","Monday");
                startActivity(intent);
            }
        });
        tuesdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PlanActivity.this,EditActivity.class);
                intent.putExtra("day","Tuesday");
                startActivity(intent);
            }
        });
        wednesdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PlanActivity.this,EditActivity.class);
                intent.putExtra("day","Wednesday");
                startActivity(intent);
            }
        });
        thursdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PlanActivity.this,EditActivity.class);
                intent.putExtra("day","Thursday");
                startActivity(intent);
            }
        });
        fridayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PlanActivity.this,EditActivity.class);
                intent.putExtra("day","Friday");
                startActivity(intent);
            }
        });
        saturdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PlanActivity.this,EditActivity.class);
                intent.putExtra("day","Saturday");
                startActivity(intent);
            }
        });
        sundayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PlanActivity.this,EditActivity.class);
                intent.putExtra("day","Sunday");
                startActivity(intent);
            }
        });
        btnAddAPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(PlanActivity.this, AllTrainingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        
    }
    private void initREcViews(){
        Log.d(TAG, "initREcViews: Started");
        for(plan Plan : Utils.getUserPlans()){
            System.out.println(Plan.getDate().toString());
        }
        mondayRecView.setAdapter(mondayAdapter);
        mondayRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<plan> mondayPlans =new ArrayList<>();
        for( plan Plan : Utils.getUserPlans()){
            if( Plan.getDate().equals("Monday")){
                mondayPlans.add(Plan);
            }
        }
        mondayAdapter.setPlans(mondayPlans);

        tuesdayRecView.setAdapter(tuesdayAdapter);
        tuesdayRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<plan> tuesdayPlans = new ArrayList<>();
        for( plan Plan : Utils.getUserPlans()){
            if( Plan.getDate().equals("Tuesday")){
                tuesdayPlans.add(Plan);
            }
        }
        tuesdayAdapter.setPlans(tuesdayPlans);

        wednesdayRecView.setAdapter(wednesdayAdapter);
        wednesdayRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<plan> wednesdayPlans = new ArrayList<>();
        for( plan Plan : Utils.getUserPlans()){
            if( Plan.getDate().equals("Wednesday")){
                wednesdayPlans.add(Plan);
            }
        }
        wednesdayAdapter.setPlans(wednesdayPlans);
        fridayRecView.setAdapter(fridayAdapter);
        fridayRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<plan> fridayPlans = new ArrayList<>();
        for( plan Plan : Utils.getUserPlans()){
            if( Plan.getDate().equals("Friday")){
                fridayPlans.add(Plan);
            }
        }
        fridayAdapter.setPlans(fridayPlans);

        saturdayRecView.setAdapter(saturdayAdapter);
        saturdayRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<plan> saturdayPlans = new ArrayList<>();
        for( plan Plan : Utils.getUserPlans()){
            if( Plan.getDate().equals("Saturday")){
                saturdayPlans.add(Plan);
            }
        }
        saturdayAdapter.setPlans(saturdayPlans);

        thursdayRecView.setAdapter(thursdayAdapter);
        thursdayRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<plan> thursdayPlans = new ArrayList<>();
        for( plan Plan : Utils.getUserPlans()){
            if( Plan.getDate().equals("Thursday")){
                thursdayPlans.add(Plan);
            }
        }
        thursdayAdapter.setPlans(thursdayPlans);
        sundayRecView.setAdapter(sundayAdapter);
        sundayRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<plan> sundayPlans = new ArrayList<>();
        for( plan Plan : Utils.getUserPlans()){
            if( Plan.getDate().equals("Sunday")){
                sundayPlans.add(Plan);
            }
        }
        sundayAdapter.setPlans(sundayPlans);
    }
     private void initAdapters(){
         Log.d(TAG, "initAdapters: started");
        mondayAdapter= new PlanRecViewAdapter(this);
        tuesdayAdapter= new PlanRecViewAdapter(this);
        wednesdayAdapter= new PlanRecViewAdapter(this);
        thursdayAdapter= new PlanRecViewAdapter(this);
        fridayAdapter= new PlanRecViewAdapter(this);
        saturdayAdapter= new PlanRecViewAdapter(this);
        sundayAdapter= new PlanRecViewAdapter(this);


     }
    private void initViews(){
        Log.d(TAG, "initViews: planactivity started");
        mondayEdit= findViewById(R.id.editMonday);
        mondayRecView=findViewById(R.id.mondayRecView);
        tuesdayRecView=findViewById(R.id.tuesdayRecView);
        wednesdayRecView=findViewById(R.id.wednesdayRecView);
        thursdayRecView=findViewById(R.id.thursdayRecView);
        fridayRecView=findViewById(R.id.fridayRecView);
        saturdayRecView=findViewById(R.id.saturdayRecView);
        sundayRecView=findViewById(R.id.sundayRecView);
        tuesdayEdit= findViewById(R.id.editTuesday);
        wednesdayEdit= findViewById(R.id.editWednesday);
        thursdayEdit=findViewById(R.id.editThursday);
        fridayEdit=findViewById(R.id.editFriday);
        saturdayEdit= findViewById(R.id.editSaturday);
        sundayEdit= findViewById(R.id.editSunday);
        notAddedRelLayout= findViewById(R.id.notAddedRelLayout);
        btnAddAPlan= findViewById(R.id.btnAddAPlan);
        nestedScrollView= findViewById(R.id.nestedScrollView);


    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);

        super.onBackPressed();
    }
}
