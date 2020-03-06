package com.example.gymapp;

import android.content.Context;
import android.content.Intent;

import com.example.GymApp.R;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class trainingRecViewAdapter extends  RecyclerView.Adapter<trainingRecViewAdapter.ViewHolder> {
    private static final String TAG = "trainingRecViewAdapter";

    private Context mContext;

    private ArrayList<GymTraining> trainings= new ArrayList<>();
    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName,txtShortDes;
        private ImageView image;
        private CardView parent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName=  itemView.findViewById(R.id.trainingName);
            txtShortDes= itemView.findViewById(R.id.shortDesc);
            image= itemView.findViewById(R.id.trainingImage);
            parent= itemView.findViewById(R.id.parent);
        }
    }

    public trainingRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public trainingRecViewAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.training_list_item,parent,false);
        ViewHolder  holder= new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Log.d(TAG, "onBindViewHolder: Started");
        viewHolder.txtName.setText(trainings.get(position).getName());
        viewHolder.txtShortDes.setText(trainings.get(position).getShortdes());

        Glide.with(mContext)
                .asBitmap()
                .load(trainings.get(position).getImageUrl())
                .into(viewHolder.image);

        viewHolder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO : onno kothao jabo
                Intent intent = new Intent(mContext,TrainingActivity.class);
                intent.putExtra("training",trainings.get(position));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return trainings.size();
    }

    public void setTrainings(ArrayList<GymTraining> trainings) {
        this.trainings = trainings;
        notifyDataSetChanged();
    }
}
