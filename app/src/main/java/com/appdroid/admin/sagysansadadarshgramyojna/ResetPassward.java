package com.appdroid.admin.sagysansadadarshgramyojna;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;
import android.content.Intent;
import android.content.UriMatcher;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class ResetPassward extends AppCompatActivity {

    Button button;
    private EditText inputEmail;
    private Button btnReset;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_passward);
        ////////////////////
        inputEmail = (EditText) findViewById(R.id.reseteditText);
        btnReset = (Button) findViewById(R.id.resetbtn);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        btnReset.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            String email = inputEmail.getText().toString().trim();

                                            if (TextUtils.isEmpty(email)) {
                                                Toast.makeText(getApplication(), "Please Enter Registered Email Id", Toast.LENGTH_SHORT).show();
                                                return;
                                            }
                                            progressDialog.setMessage("Connecting Please Wait...");
                                            progressDialog.show();
                                            firebaseAuth.sendPasswordResetEmail(email)

                                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            if (task.isSuccessful()) {
                                                                Toast.makeText(ResetPassward.this, "We sent you a Email, Please Check it.", Toast.LENGTH_SHORT).show();
                                                            } else {
                                                                Toast.makeText(ResetPassward.this, "Please Enter Valid Email id!", Toast.LENGTH_SHORT).show();
                                                            }
                                                            progressDialog.dismiss();
                                                        }
                                                    });
                                        }
        });
        //button2
        button = (Button) findViewById(R.id.backbtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(ResetPassward.this,
                        LoginActivity.class);
                startActivity(myIntent);
            }
        });

    }
}
