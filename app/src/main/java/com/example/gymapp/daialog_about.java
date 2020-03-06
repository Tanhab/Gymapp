package com.example.gymapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.GymApp.R;

public class daialog_about extends DialogFragment {
    private static final String TAG = "daialog_about";
    private TextView txtExplain;
    private Button btnGoBack;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view =getActivity().getLayoutInflater().inflate(R.layout.dialog_about,null);
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        builder.setTitle("About")
                .setView(view);
        txtExplain=view.findViewById(R.id.txtExplain);
        btnGoBack= view.findViewById(R.id.btnGoBack);

        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return builder.create();
    }
}
