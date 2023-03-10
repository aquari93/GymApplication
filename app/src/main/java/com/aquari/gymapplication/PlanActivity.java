package com.aquari.gymapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
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
    private PlanAdapter mondayAdapter, tuesdayAdapter, wednesdayAdapter,thursdayAdapter, fridayAdapter , saturdayAdapter, sundayAdapter;

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

                initRecView();

                setEditOnClickListener();

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

    private void setEditOnClickListener() {
        Intent intent = new Intent(this, EditActivity.class);
        mondayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day","Monday");
                startActivity(intent);
            }
        });

        tuesdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day","Tuesday");
                startActivity(intent);
            }
        });

        wednesdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day","Wednesday");
                startActivity(intent);
            }
        });

        thursdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day","Thursday");
                startActivity(intent);
            }
        });

        fridayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day","Friday");
                startActivity(intent);
            }
        });

        saturdayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day","Saturday");
                startActivity(intent);

            }
        });

        sundayEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("day","Sunday");
                startActivity(intent);
            }
        });
    }

    private void initRecView() {
        mondayAdapter=new PlanAdapter(this);
        mondayRecView.setAdapter(mondayAdapter);
        mondayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        mondayAdapter.setPlans((getPlansByDay("Monday")));

        tuesdayAdapter=new PlanAdapter(this);
        tuesdayRecView.setAdapter(tuesdayAdapter);
        tuesdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        tuesdayAdapter.setPlans((getPlansByDay("Tuesday")));

        wednesdayAdapter=new PlanAdapter(this);
        wednesdayRecView.setAdapter(wednesdayAdapter);
        wednesdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        wednesdayAdapter.setPlans((getPlansByDay("Wednesday")));

        thursdayAdapter=new PlanAdapter(this);
        thursdayRecView.setAdapter(thursdayAdapter);
        thursdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        thursdayAdapter.setPlans((getPlansByDay("Thursday")));

        fridayAdapter=new PlanAdapter(this);
        fridayRecView.setAdapter(fridayAdapter);
        fridayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        fridayAdapter.setPlans((getPlansByDay("Friday")));

        saturdayAdapter=new PlanAdapter(this);
        saturdayRecView.setAdapter(saturdayAdapter);
        saturdayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        saturdayAdapter.setPlans((getPlansByDay("Saturday")));

        sundayAdapter=new PlanAdapter(this);
        sundayRecView.setAdapter(sundayAdapter);
        sundayRecView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        sundayAdapter.setPlans((getPlansByDay("Sunday")));
    }

    private ArrayList<Plan> getPlansByDay(String day){
        ArrayList<Plan> allPlans = Utils.getPlans();
        ArrayList<Plan> plans = new ArrayList<>();
        for(Plan p: allPlans){
            if(p.getDay().equalsIgnoreCase(day)){
                plans.add(p);

            }
        }
        return plans;
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