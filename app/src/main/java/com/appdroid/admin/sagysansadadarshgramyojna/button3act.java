package com.appdroid.admin.sagysansadadarshgramyojna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;


public class button3act extends AppCompatActivity {
    private WebView mywebViewmp;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button3act);
        mywebViewmp = (WebView) findViewById(R.id.webViewmp);
        progress = (ProgressBar) findViewById(R.id.progressBarmp);
        progress.setMax(100);

        WebSettings webSettings= mywebViewmp.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebViewmp.loadUrl("http://sagyappdroid.blogspot.com/p/maps.html");
        mywebViewmp.setWebChromeClient(new button3act.myWebViewClient());
        button3act.this.progress.setProgress(0);
        mywebViewmp.setWebViewClient(new WebViewClient());
    }

    private class myWebViewClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            button3act.this.setValue(newProgress);
            super.onProgressChanged(view, newProgress);
        }
    }

    public void setValue(int progress) {
        this.progress.setProgress(progress);
    }

    @Override
    public void onBackPressed() {
        if(mywebViewmp.canGoBack())
        {
            mywebViewmp.goBack();
        }

        else{
            super.onBackPressed();
        }
    }
}
