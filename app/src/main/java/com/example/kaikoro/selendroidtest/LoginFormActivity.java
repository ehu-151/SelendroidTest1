package com.example.kaikoro.selendroidtest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LoginFormActivity extends AppCompatActivity {
    WebView loginForm;
    String url;
    String id;
    String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        id = intent.getStringExtra("id");
        pass = intent.getStringExtra("pass");

        loginForm = (WebView) findViewById(R.id.longinView);
        loginForm.getSettings().setJavaScriptEnabled(true);
        //レシポンシブデザインがうまく映るように
        loginForm.getSettings().setLoadWithOverviewMode(true);
        loginForm.getSettings().setUseWideViewPort(true);

        loginForm.loadUrl(url);

        loginForm.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                String script ="javascript:document.getElementById('userId').value='" + id + "';" +
                        "document.getElementById('password').value='" + pass + "';" +
                        "document.getElementById('loginButton').click();" +
                        "window.onload = function(){location.reload()}";
                loginForm.loadUrl(script);
            }
        });
    }
}
