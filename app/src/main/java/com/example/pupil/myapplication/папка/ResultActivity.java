package com.example.pupil.myapplication.папка;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.pupil.myapplication.MainActivity;
import com.example.pupil.myapplication.Pupil;
import com.example.pupil.myapplication.R;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    Button btnClear;
    Button btnBack;
    ImageView btnCloseResult;
    RecyclerView list;
    ArrayList<Pupil> arr;
    private MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        arr = getIntent().getParcelableArrayListExtra("list");
        btnClear = findViewById(R.id.btnClear);
        btnBack = findViewById(R.id.btnBack);
        btnBack = findViewById(R.id.btnBack);
        btnCloseResult = findViewById(R.id.btnCloseResult);
        myAdapter = new MyAdapter(arr);
        list = findViewById(R.id.list);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMainActivity();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAdapter.clear();
            }
        });
        btnCloseResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                }
        });
                list.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        list.setAdapter(myAdapter);
        list.getAdapter().notifyDataSetChanged();


    }


    private void startMainActivity() {
        Intent a = new Intent(this, MainActivity.class);
        startActivity(a);
        finish();
    }
}
