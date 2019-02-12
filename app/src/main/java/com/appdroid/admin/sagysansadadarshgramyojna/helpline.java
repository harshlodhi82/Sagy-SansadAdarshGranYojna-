package com.appdroid.admin.sagysansadadarshgramyojna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class helpline extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);
        //button airambu
        button = (Button) findViewById(R.id.airambu);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(helpline.this,
                        airambu_hl.class);
                startActivity(myIntent);
            }
        });
        //button police
        button = (Button) findViewById(R.id.police);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(helpline.this,
                        police_hl.class);
                startActivity(myIntent);
            }
        });
        //button fire
        button = (Button) findViewById(R.id.fire);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(helpline.this,
                        fire_hl.class);
                startActivity(myIntent);
            }
        });
        //button road
        button = (Button) findViewById(R.id.road);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(helpline.this,
                        road_hl.class);
                startActivity(myIntent);
            }
        });
        //button women
        button = (Button) findViewById(R.id.women);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(helpline.this,
                        women_hl.class);
                startActivity(myIntent);
            }
        });

    }
}
