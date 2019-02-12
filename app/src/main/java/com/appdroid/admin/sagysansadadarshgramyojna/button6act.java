package com.appdroid.admin.sagysansadadarshgramyojna;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.net.Uri;
import android.view.View;
import android.content.Intent;
import android.content.Context;


public class button6act extends AppCompatActivity {
    private WebView mywebViewYT;
    private final String url = "https://goo.gl/T5HZ4v";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button6act);
        /*mywebViewYT = (WebView) findViewById(R.id.webviewfyt);
        WebSettings webSettings= mywebViewYT.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebViewYT.loadUrl("http://saanjhi.gov.in/");
       // mywebViewYT.setWebViewClient(new WebViewClient());*/

        Uri uri = Uri.parse(url);
        Intent intent = new Intent();
        intent.setData(uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
