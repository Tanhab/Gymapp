package com.example.gymapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import com.example.GymApp.R;

import java.util.ArrayList;

public class PlanRecViewAdapter extends  RecyclerView.Adapter<PlanRecViewAdapter.ViewHolder>{
    private static final String TAG = "PlanRecViewAdapter";



    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView activityName,activityTime,activityshortdes;
        private ImageView activityImage,emptyCheckBox,filledCheckBox;
        private CardView parent;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            activityName= itemView.findViewById(R.id.txtName);
            activityTime= itemView.findViewById(R.id.txtTime);
            parent = itemView.findViewById(R.id.parent);
            activityImage= itemView.findViewById(R.id.activityImage);
            emptyCheckBox= itemView.findViewById(R.id.emptyCheckBox);
            filledCheckBox= itemView.findViewById(R.id.filledCheckBox);
            activityshortdes= itemView.findViewById(R.id.longdes);

        }
    }
    private Context mContext;
    ArrayList <plan> plans = new ArrayList<>();
    private String type= "";
    public  interface  DeletePlan{
        void onDeletingPlan(String day);
    }
    private  DeletePlan deletePlan;

    public void setType(String type) {
        this.type = type;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public ArrayList<plan> getPlans() {
        return plans;
    }

    public void setPlans(ArrayList<plan> plans) {
        this.plans = plans;
        notifyDataSetChanged();
    }

    public PlanRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public PlanRecViewAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int pos ) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.plan_list_item, viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: planrecview Started");
        holder.activityName.setText(plans.get(position).getTraining().getName());
        Glide.with(mContext)
                .asBitmap()
                .load(plans.get(position).getTraining().getImageUrl())
                .into(holder.activityImage);
        holder.activityshortdes.setText(plans.get(position).getTraining().getShortdes());
        holder.activityTime.setText(String.valueOf(plans.get(position).getMinutes())+" Minutes");
        if(plans.get(position).isAccomplished()){
            holder.emptyCheckBox.setVisibility(View.GONE);
            holder.filledCheckBox.setVisibility(View.VISIBLE);
        }else {
            holder.emptyCheckBox.setVisibility(View.VISIBLE);
            holder.filledCheckBox.setVisibility(View.GONE);
        }
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mContext,TrainingActivity.class);
                intent.putExtra("training",plans.get(position).getTraining());
                mContext.startActivity(intent);
            }
        });
        if(type.equals("edit") ){
            holder.emptyCheckBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder= new AlertDialog.Builder(mContext);
                    builder.setTitle("Accomplished?")
                            .setMessage("Have you finished your "+ plans.get(position).getTraining().getName())
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    plans.get(position).setAccomplished(true);
                                    for(plan Plan: Utils.getUserPlans()){
                                        if(plans.get(position).equals(Plan)){
                                            Plan.setAccomplished(true);
                                        }
                                    }
                                    notifyDataSetChanged();
                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.create().show();

                }
            });
            try{
                deletePlan= (DeletePlan)mContext;

            }catch(ClassCastException e){
                e.printStackTrace();
            }
            holder.parent.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    AlertDialog.Builder builder= new AlertDialog.Builder(mContext);
                    builder.setTitle("Delete")
                            .setMessage("Are toy sure you want to delete "+ plans.get(position).getTraining().getName()+" "+
                            "from your weekly plans?")
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            }).setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Utils.removeFromPlan(plans.get(position));
                            deletePlan.onDeletingPlan(plans.get(position).getDate());
                        }
                    });
                    builder.create().show();

                    return true;
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return plans.size();
    }




}
