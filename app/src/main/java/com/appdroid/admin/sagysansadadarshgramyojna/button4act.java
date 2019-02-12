package com.appdroid.admin.sagysansadadarshgramyojna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

public class button4act extends AppCompatActivity {
    private WebView mywebViewmp;
    private ProgressBar progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button4act);
        mywebViewmp = (WebView) findViewById(R.id.webViewmp);
        progress = (ProgressBar) findViewById(R.id.progressBarmp);
        progress.setMax(100);

        WebSettings webSettings= mywebViewmp.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebViewmp.loadUrl("http://sagyappdroid.blogspot.com/p/blog-page.html");
        mywebViewmp.setWebChromeClient(new myWebViewClient());
        button4act.this.progress.setProgress(0);
        mywebViewmp.setWebViewClient(new WebViewClient());
    }

    private class myWebViewClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            button4act.this.setValue(newProgress);
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
