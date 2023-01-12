package com.aquari.gymapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PlanActivity extends AppCompatActivity {

    private TextView mondayEdit, tuesdayEdit,wednesdayEdit,thursdayEdit,fridayEdit,saturdayEdit,sundayEdit;
    private RecyclerView mondayRecView, tuesdayRecView, wednesdayRecView,thursdayRecView,fridayRecView, saturdayRecView,sundayRecView;
    private RelativeLayout noPlanRelLayout;
    private NestedScrollView nestedScrollView;
    private Button btnAddPlan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        initViews();
        ArrayList<Plan>plans=Utils.getPlans();
        if(plans!=null){
            if(plans.size()>0){
                noPlanRelLayout.setVisibility(View.GONE);
                nestedScrollView.setVisibility(View.VISIBLE);

            }
            else{
                noPlanRelLayout.setVisibility(View.VISIBLE);
                nestedScrollView.setVisibility(View.GONE);
                btnAddPlan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent =new Intent(PlanActivity.this,AllTrainingsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
            }
        }else{
            noPlanRelLayout.setVisibility(View.VISIBLE);
            nestedScrollView.setVisibility(View.GONE);
            btnAddPlan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent =new Intent(PlanActivity.this,AllTrainingsActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            });
        }
    }

    private void initViews() {
        mondayEdit=findViewById(R.id.mondayEdit);
        tuesdayEdit=findViewById(R.id.tuesdayEdit);
        wednesdayEdit=findViewById(R.id.wednesdayEdit);
        thursdayEdit=findViewById(R.id.thursdayEdit);
        fridayEdit=findViewById(R.id.fridayEdit);
        saturdayEdit=findViewById(R.id.saturdayEdit);
        sundayEdit=findViewById(R.id.sundayEdit);

        mondayRecView=findViewById(R.id.mondayRecView);
        tuesdayRecView=findViewById(R.id.tuesdayRecView);
        wednesdayRecView=findViewById(R.id.wednesdayRecView);
        thursdayRecView=findViewById(R.id.thursdayRecView);
        fridayRecView=findViewById(R.id.fridayRecView);
        saturdayRecView=findViewById(R.id.saturdayRecView);
        sundayRecView=findViewById(R.id.sundayRecView);

        noPlanRelLayout=findViewById(R.id.noPlanRelLayout);

        nestedScrollView=findViewById(R.id.nestedScrollView);

        btnAddPlan=findViewById(R.id.btnAddPlan);

    }
}