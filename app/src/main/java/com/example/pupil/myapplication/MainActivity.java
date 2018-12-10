package com.example.pupil.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pupil.myapplication.папка.ResultActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnClose;
    Button createPupil;
    Button btnShowResult;
    EditText edName;
    EditText edSurname;
    ArrayList<Pupil> arr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arr = new ArrayList<>();
        final TextView name = findViewById(R.id.name);
        final TextView surname = findViewById(R.id.surname);

        btnClose = findViewById(R.id.btnBack);
        btnShowResult = findViewById(R.id.btnShowRelust);
        edName = findViewById(R.id.edName);
        edSurname = findViewById(R.id.edSurname);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        createPupil = findViewById(R.id.createPupil);
        createPupil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Pupil pupil = createPupil(edName.getText().toString(), edSurname.getText().toString());
                arr.add(pupil);
                name.setText(pupil.getName());
                surname.setText(pupil.getSurname());

            }
        });

        btnShowResult.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 showResult(arr);
                                             }
                                         }
        );
    }

    public Pupil createPupil(String name, String surname) {

        Pupil p = new Pupil(name, surname);
        return p;
    }

    void showResult(List<Pupil> list) {
        Intent i = new Intent(this, ResultActivity.class).putParcelableArrayListExtra("list", (ArrayList<? extends Parcelable>) list);
        startActivity(i);
        finish();
    }

}
