package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.GymApp.R;

public class TrainingActivity extends AppCompatActivity  implements AskForDetailsDialog.GetDetails{
    private static final String TAG = "TrainingActivity";
    private Button btnAddToPlan;
    private TextView trainingName,trainingLongDes;
    private ImageView trainingImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        Log.d(TAG, "onCreate: TrainingActivity Started");
        init();
        Intent intent = getIntent();
        try {
        final GymTraining incomingTraining= intent.getParcelableExtra("training");
        trainingName.setText(incomingTraining.getName());
        trainingLongDes.setText(incomingTraining.getLongdes());
            Glide.with(this)
                    .asBitmap()
                    .load(incomingTraining.getImageUrl())
                    .into(trainingImage);
            btnAddToPlan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AskForDetailsDialog askForDetailsDialog= new AskForDetailsDialog();
                    Bundle bundle= new Bundle();
                    bundle.putParcelable("training", incomingTraining);
                    askForDetailsDialog.setArguments(bundle);
                    askForDetailsDialog.show(getSupportFragmentManager(), "ask for details");


                }
            });
        }catch (NullPointerException e){
             e.getMessage();
        }
    }

    private  void init(){
        Log.d(TAG, "init: started");
        btnAddToPlan= findViewById(R.id.btnAddToPlan);
        trainingName=findViewById(R.id.trainingName);
        trainingLongDes=findViewById(R.id.trainingLongDes);
        trainingImage=findViewById(R.id.trainingImage);

    }

    @Override
    public void onGettingDetailsResult(plan Plan) {
        Log.d(TAG, "onGettingDetailsResult: we have a plan");
        Utils.addToUserPlan(Plan);
        Intent intent= new Intent(this,PlanActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("Plan",Plan);
        startActivity(intent);
    }
}
