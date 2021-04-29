package com.example.recyclerdatabindingactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.recyclerdatabindingactivity.adapters.Adapter;
import com.example.recyclerdatabindingactivity.recycerview.items.UniverseItem;
import com.example.recyclerdatabindingactivity.viewmodels.MainActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    //private ArrayList<Item> items= new ArrayList<>();  //이렇게 안쓰고.... -> 데이터를 받아온다 생각하고
    public Adapter mAdapter;                                                // UniverseRepository 에서 불러옴..
    private FloatingActionButton fab;
    private FloatingActionButton codeFab;
    private ProgressBar progressBar;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab= findViewById(R.id.fab);
        codeFab= findViewById(R.id.code_button);
        codeFab.setOnClickListener(v -> {
            Intent i= new Intent(this, CodeActivity.class);
            startActivity(i);
        });
        recyclerView= findViewById(R.id.recycler);
        progressBar= findViewById(R.id.progress_bar);


        mainActivityViewModel= new ViewModelProvider(this).get(MainActivityViewModel.class);

        mainActivityViewModel.init();

        mainActivityViewModel.getUniverseItems().observe(this, new Observer<List<UniverseItem>>() {
            @Override
            public void onChanged(List<UniverseItem> universeItems) {
                mAdapter.notifyDataSetChanged();
            }
        });
        initRecyclerView();
    }


    private void initRecyclerView(){
        //mAdapter= new Adapter(this, new ArrayList<UniverseItem>());  //empty data right now..
        mAdapter= new Adapter(this, (ArrayList<UniverseItem>) mainActivityViewModel.getUniverseItems().getValue());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);
    }

    private void showProgressBar(){ progressBar.setVisibility(View.VISIBLE); }
    private void hideProgresBar(){ progressBar.setVisibility(View.GONE); }
}//Activity...