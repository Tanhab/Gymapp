package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.GymApp.R;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    private Button btnSeeAllActivities, btnAbout, btnSeeYourActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started");
        Utils.initialize();
        btnAbout = findViewById(R.id.btnAbout);
        btnSeeAllActivities = findViewById(R.id.btnSeeAllActivities);
        btnSeeYourActivity = findViewById(R.id.btnSeeYourPlan);

        setOnClicklistener();

    }

    private void setOnClicklistener() {
        Log.d(TAG, "setOnClicklistener: started");
        btnSeeAllActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllTrainingActivity.class);
                startActivity(intent);
            }
        });
        btnSeeYourActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,PlanActivity.class);
                startActivity(intent);

            }
        });
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daialog_about dialog =new daialog_about();
                dialog.show(getSupportFragmentManager(),"about dialog");
            }
        });
    }
}
