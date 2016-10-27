package com.example.marthakat.portsmouthcityguide;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Weather_Portsmouth extends AppCompatActivity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather__portsmouth);

        System.out.println("Weather class - Opening...");

        webview = (WebView) this.findViewById(R.id.weatherP);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl("http://www.accuweather.com/en/gb/portsmouth/po1-2/weather-forecast/710325");

        webview.setWebViewClient(new WebViewClient());
    }

    //Return back to main activity when the ImageView (Black arrow) is pressed
    public void goBack(View v){
        Weather_Portsmouth.this.onBackPressed();
    }
}
