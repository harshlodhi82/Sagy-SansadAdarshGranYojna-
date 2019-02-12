package com.appdroid.admin.sagysansadadarshgramyojna;

import android.content.Context;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.app.NotificationManager;
import android.app.NotificationChannel;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.iid.FirebaseInstanceId;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FirebaseAuth firebaseAuth;
    Button button;
    private WebView mywebViewYT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();
        ////////webviev////////
        mywebViewYT = (WebView) findViewById(R.id.webviewyt);
        WebSettings webSettings= mywebViewYT.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebViewYT.loadUrl("https://www.youtube.com/results?search_query=sansad+adarsh+gram+yojana");
        mywebViewYT.setWebViewClient(new WebViewClient());
        //button2
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this,
                        button2act.class);
                startActivity(myIntent);
            }
        });
        //button3
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this,
                        button3act.class);
                startActivity(myIntent);
            }
        });
        //button4
        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this,
                        button4act.class);
                startActivity(myIntent);
            }
        });
        //button5
        button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this,
                        button5act.class);
                startActivity(myIntent);
            }
        });
        //button6
        button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this,
                        button6act.class);
                startActivity(myIntent);
            }
        });
        /////////////////////////////////////
        /////////////////////////////////////////////
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,
                        contact_form.class);
                startActivity(myIntent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        if(mywebViewYT.canGoBack())
        {
            mywebViewYT.goBack();
        }else {
            new AlertDialog.Builder(this)
                    .setMessage("Are you sure to exit SAGY?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
        }
       /* DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(mywebViewYT.canGoBack())
        {
            mywebViewYT.goBack();
        }else if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        if (id == R.id.nav_help) {
            // Handle the camera action
            startActivity(new Intent(this, helpline.class));
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(this, photo_gallery.class));

        } else if (id == R.id.nav_share) {
            startActivity(new Intent(this, share_nav.class));

        } else if (id == R.id.nav_send) {
            startActivity(new Intent(this, contact_form.class));

        }else if (id == R.id.mngac) {
            //starting login activity
            startActivity(new Intent(this, ProfileActivity.class));

        }else if (id == R.id.nav_sagy) {
            //starting login activity
            startActivity(new Intent(this, about_sagy.class));

        }else if (id == R.id.nav_appdroid) {
            //starting login activity
            startActivity(new Intent(this, about_page.class));

        }else if (id == R.id.navLogout) {
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LogInOrSignUP.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
