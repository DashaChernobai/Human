package com.example.pupil.myapplication.папка;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.pupil.myapplication.MainActivity;
import com.example.pupil.myapplication.Pupil;
import com.example.pupil.myapplication.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    Button btnClear;
    Button btnBack;
    EditText search;
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
        search = findViewById(R.id.search);
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

search.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
filter(s.toString());
    }
});
    }
  private void filter(String s) {
      ArrayList<Pupil> arrTmp = new ArrayList<>();
      for (Pupil p:arr){
          if ((p.getName().toLowerCase().contains(s.toLowerCase())) || (p.getSurname().toLowerCase().contains(s.toLowerCase()))){
              arrTmp.add(p);
          }
      }
      list.setAdapter(new MyAdapter(arrTmp));
      list.getAdapter().notifyDataSetChanged();
  }

    private void startMainActivity() {
        Intent a = new Intent(this, MainActivity.class);
        startActivity(a);
        finish();
    }
}
