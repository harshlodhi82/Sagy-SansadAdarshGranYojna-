package com.appdroid.admin.sagysansadadarshgramyojna;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class LogInOrSignUP extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_or_sign_up);
        //////image////
        //////////////////////////
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() != null){
            //that means user is already logged in
            //so close this activity
            finish();

            //and open profile activity
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        /////button Sign in////////
        button = (Button) findViewById(R.id.buttonLogin);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(LogInOrSignUP.this,
                        LoginActivity.class);
                finish();
                startActivity(myIntent);
            }
        });
        /////Button Sign UP////////
        button = (Button) findViewById(R.id.buttonSignup);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(LogInOrSignUP.this,
                        Signup.class);
                finish();
                startActivity(myIntent);
            }
        });
    }
}
