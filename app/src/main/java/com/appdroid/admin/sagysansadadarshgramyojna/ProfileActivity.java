package com.appdroid.admin.sagysansadadarshgramyojna;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.view.View.OnClickListener;

public class ProfileActivity extends AppCompatActivity  {

    private FirebaseAuth firebaseAuth;
    private TextView textViewUserEmail;
    private Button buttonLogout,button;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile);

            //initializing firebase authentication object
            firebaseAuth = FirebaseAuth.getInstance();

            //if the user is not logged in
            //that means current user will return null
            /*if(firebaseAuth.getCurrentUser() == null){
                //closing this activity
                finish();
                //starting login activity
                startActivity(new Intent(this, LoginActivity.class));
            }*/

            //getting current user
            FirebaseUser user = firebaseAuth.getCurrentUser();

            //initializing views
            textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
            //buttonLogout = (Button) findViewById(R.id.buttonLogout);

            //displaying logged in user name
            textViewUserEmail.setText("Hello "+user.getEmail());

            //adding listener to button
           //buttonLogout.setOnClickListener(this);
        //button reset
        button = (Button) findViewById(R.id.buttonreset);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(ProfileActivity.this,
                        ResetPassward.class);
                startActivity(myIntent);
            }
        });

        //button log out
        button = (Button) findViewById(R.id.buttonLogout);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent intent = new Intent(getApplicationContext(), LogInOrSignUP.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                firebaseAuth.signOut();
                finish();
                startActivity(intent);
            }
        });

    }

        /*@Override
        public void onClick(View view) {
            //if logout is pressed
            if(view == buttonLogout){
                //logging out the user
                firebaseAuth.signOut();
                //closing activity
                finish();
                //starting login activity
                startActivity(new Intent(this, LogInOrSignUP.class));
            }
        }*/
}
