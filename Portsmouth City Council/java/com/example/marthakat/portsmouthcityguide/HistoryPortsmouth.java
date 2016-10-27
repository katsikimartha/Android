package com.example.marthakat.portsmouthcityguide;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class HistoryPortsmouth extends AppCompatActivity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_portsmouth);

        System.out.println("History class - Opening...");

        //defining webView, enabling Javascript and loading the url we want to use from wikipedia
        webview = (WebView) this.findViewById(R.id.historyWiki);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("https://en.wikipedia.org/wiki/Portsmouth");

        webview.setWebViewClient(new WebViewClient());

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    //if you click on a link on the url that is opened by webview and then you want to return to the original page
    //you will need this method, you go back on the previous url while staying in the same activity
    @Override
    public void onBackPressed()
    {
        if(webview.canGoBack()){
            webview.goBack();
        }else {
            super.onBackPressed();
        }
    }

    //method called when the black arrow is pushed, it leads to the previous activity (MainActivity)
    public void goBack(View v){
        HistoryPortsmouth.this.onBackPressed();
    }
}
