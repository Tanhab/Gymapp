package com.example.gymapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.GymApp.R;

import java.util.ArrayList;

public class AskForDetailsDialog extends DialogFragment {
    private static final String TAG = "AskForDetailsDialog";
    private EditText timeEdtText;
    private Button btnAdd ,btnCancel;
    private Spinner spinner;
    public  interface GetDetails{
        void onGettingDetailsResult(plan Plan);
    }
    private GetDetails getDetails;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_askfordetails,null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setTitle("Enter Details")
                .setView(view);
        init(view);
        ArrayList <String > days= new ArrayList<>();
        days.add("Monday");
days.add("Tuesday");
days.add("Wednesday");
days.add("Thursday");
days.add("Friday");
days.add("Saturday");
days.add("Sunday");
        ArrayAdapter<String> adapter= new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,days);
        spinner.setAdapter(adapter);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        try {
            getDetails= (GetDetails) getActivity();


        }catch (ClassCastException e){
            e.printStackTrace();
        }
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle= getArguments();
                GymTraining training= bundle.getParcelable("training");
                if (null != training) {
                    plan Plan= new plan();
                    Plan.setAccomplished(false);
                    Plan.setDate(spinner.getSelectedItem().toString());
                    Plan.setMinutes(Integer.valueOf(timeEdtText.getText().toString()));
                    Plan.setTraining(training);
                    getDetails.onGettingDetailsResult(Plan);
                }
            }
        });


        return builder.create();
    }
    private void init(View view ){
        timeEdtText= view.findViewById(R.id.edtTime);
        btnAdd= view.findViewById(R.id.btnAdd);
        btnCancel=view.findViewById(R.id.btnCancel);
        spinner= view.findViewById(R.id.spinner);
    }
}
