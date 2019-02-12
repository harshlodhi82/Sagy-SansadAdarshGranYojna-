package com.appdroid.admin.sagysansadadarshgramyojna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class start_pics extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_pics);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            //that means user is already logged in
            //so close this activity
            finish();

            //and open profile activity
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        /////button Sign in////////
        button = (Button) findViewById(R.id.buttonNext);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(start_pics.this,
                        LogInOrSignUP.class);
                finish();
                startActivity(myIntent);
            }
        });
    }
}
