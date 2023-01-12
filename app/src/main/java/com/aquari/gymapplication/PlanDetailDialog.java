package com.aquari.gymapplication;

import static com.aquari.gymapplication.TrainingActivity.TRAINING_KEY;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class PlanDetailDialog extends DialogFragment {

    public interface PassPlanInterface{
        void getPlan(Plan plan);
    }
    private PassPlanInterface passPlanInterface;
    private Button btnDismiss, btnAdd;
    private TextView txtName;
    private EditText edtTxtMinutes;
    private Spinner spinnerDay;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_plan_details,null);
        initView(view);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Enter details");

        Bundle bundle = getArguments();

        if(bundle !=null){
            Training training = bundle.getParcelable(TRAINING_KEY);
            if(training !=null ){
                txtName.setText(training.getName());
                btnDismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismiss();
                    }
                });

                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String day = spinnerDay.getSelectedItem().toString();
                        int minutes = Integer.valueOf(edtTxtMinutes.getText().toString());
                        Plan plan = new Plan(training,minutes, day,false);
                        try{
                            passPlanInterface = (PassPlanInterface) getActivity();
                            passPlanInterface.getPlan(plan);
                            dismiss();

                        }catch (ClassCastException e){
                            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
                            dismiss();
                        }

                    }
                });
            }
        }
        return builder.create();
    }

    private void initView(View view) {
        btnDismiss=view.findViewById(R.id.btnDismiss);
        btnAdd=view.findViewById(R.id.btnAdd);
        txtName=view.findViewById(R.id.txtName);
        edtTxtMinutes=view.findViewById(R.id.edtTxtMinutes);
        spinnerDay=view.findViewById(R.id.spinnerDays);

    }
}
