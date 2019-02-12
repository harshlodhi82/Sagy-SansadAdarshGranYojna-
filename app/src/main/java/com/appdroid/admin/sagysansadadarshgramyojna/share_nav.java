package com.appdroid.admin.sagysansadadarshgramyojna;

import android.content.pm.ApplicationInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import java.io.File;

public class share_nav extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_nav);
        ApplicationInfo app = getApplicationContext().getApplicationInfo();
        String filepath = app.sourceDir;
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("application/vnd.android.package-archive");
        sharingIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(filepath)));
      ///  sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,app.sourceDir );
       /// sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, r);
        finish();
        startActivity(Intent.createChooser (sharingIntent, "Share via"));
    }
}
