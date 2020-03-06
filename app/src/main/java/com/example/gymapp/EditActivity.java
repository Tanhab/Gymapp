package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.GymApp.R;

import java.util.ArrayList;

public class EditActivity extends AppCompatActivity implements PlanRecViewAdapter.DeletePlan {
    private static final String TAG = "EditActivity";
    private RecyclerView recyclerView;
    private Button btnAddMorePlan;
    private TextView txtDay;
    private PlanRecViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        init();
        adapter = new PlanRecViewAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setType("edit");

        Intent intent = getIntent();
        try{
            String day= intent.getStringExtra("day");
            if(day != null) {
                txtDay.setText(day);
                ArrayList <plan > plans = new ArrayList<>();
                for(plan Plan: Utils.getUserPlans())
                {
                    plans.add(Plan);
                }
                adapter.setPlans(plans);
            }

        }catch (NullPointerException e)
        {
            e.printStackTrace();
        }
        btnAddMorePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(EditActivity.this, AllTrainingActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }
    private void init(){
        Log.d(TAG, "init: started");
        recyclerView= findViewById(R.id.recyclerView);
        btnAddMorePlan= findViewById(R.id.btnAddmorePlan);
        txtDay= findViewById(R.id.txtDay);
    }

    @Override
    public void onDeletingPlan(String day) {
        Log.d(TAG, "onDeletingPlan: started");

        txtDay.setText(day);
        ArrayList<plan> plans = new ArrayList<>();
        for(plan Plan : Utils.getUserPlans())
        {
            if(Plan.getDate().equals(day)){
                plans.add(Plan);
            }
        }
        adapter.setPlans(plans);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,PlanActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        super.onBackPressed();
    }
}
