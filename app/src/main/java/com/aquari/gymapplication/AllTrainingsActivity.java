package com.aquari.gymapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AllTrainingsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TrainingAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_trainings);

        recyclerView=findViewById(R.id.recyclerView);
        adapter = new TrainingAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        ArrayList<Training> allTrainings = Utils.getTrainings();
        adapter.setTrainings(allTrainings);

    }
}