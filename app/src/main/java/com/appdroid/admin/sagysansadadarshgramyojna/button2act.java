package com.appdroid.admin.sagysansadadarshgramyojna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

public class button2act extends AppCompatActivity {
    private WebView mywebViewVil;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button2act);
        mywebViewVil = (WebView) findViewById(R.id.webViewVil);
        progress = (ProgressBar) findViewById(R.id.progressBarVil);
        progress.setMax(100);

        WebSettings webSettings= mywebViewVil.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebViewVil.loadUrl("https://sagyappdroid.blogspot.in/p/village-list.html");
        mywebViewVil.setWebChromeClient(new button2act.myWebViewClient());
        button2act.this.progress.setProgress(0);
        mywebViewVil.setWebViewClient(new WebViewClient());
    }
    private class myWebViewClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            button2act.this.setValue(newProgress);
            super.onProgressChanged(view, newProgress);
        }
    }

    public void setValue(int progress) {
        this.progress.setProgress(progress);
    }

    @Override
    public void onBackPressed() {
        if(mywebViewVil.canGoBack())
        {
            mywebViewVil.goBack();
        }

        else{
            super.onBackPressed();
        }
    }
}
