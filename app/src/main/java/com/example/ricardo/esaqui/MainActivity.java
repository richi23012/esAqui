package com.example.ricardo.esaqui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {

    TableRow fer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fer = findViewById(R.id.fer);
        fer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ho = new Intent(MainActivity.this, General.class);
                startActivity(ho);
            }
        });
    }
}
