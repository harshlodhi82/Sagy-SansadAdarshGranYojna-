package com.appdroid.admin.sagysansadadarshgramyojna;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

public class button5act extends AppCompatActivity {
    private WebView mywebViewyoj;
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button5act);
        //webview
        mywebViewyoj = (WebView) findViewById(R.id.webViewyoj);
        progress = (ProgressBar) findViewById(R.id.progressBaryoj);
        progress.setMax(100);

        WebSettings webSettings= mywebViewyoj.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mywebViewyoj.loadUrl("https://sagyappdroid.blogspot.in/p/yojana-2018.html");
        mywebViewyoj.setWebChromeClient(new button5act.myWebViewClient());
        button5act.this.progress.setProgress(0);
        mywebViewyoj.setWebViewClient(new WebViewClient());
    }

    private class myWebViewClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            button5act.this.setValue(newProgress);
            super.onProgressChanged(view, newProgress);
        }
    }
    public void setValue(int progress) {
        this.progress.setProgress(progress);
    }

    @Override
    public void onBackPressed() {
        if(mywebViewyoj.canGoBack())
        {
            mywebViewyoj.goBack();
        }

        else{
            super.onBackPressed();
        }
    }
}
