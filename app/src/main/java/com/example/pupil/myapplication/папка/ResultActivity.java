package com.example.pupil.myapplication.папка;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pupil.myapplication.Pupil;
import com.example.pupil.myapplication.R;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    Button btnClose;
    RecyclerView list;
    ArrayList<Pupil> arr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        arr =getIntent().getParcelableArrayListExtra("list");
        btnClose = findViewById(R.id.btnClose);
        list = findViewById(R.id.list);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        list.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        list.setAdapter(new MyAdapter(arr));
        list.getAdapter().notifyDataSetChanged();
    }
}
