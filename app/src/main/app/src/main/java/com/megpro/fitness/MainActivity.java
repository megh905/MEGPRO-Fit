
package com.megpro.fitness;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import android.widget.TextView;
import android.view.Gravity;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            WebView webView = new WebView(this);
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("file:///android_asset/index.html");
            setContentView(webView);
        } catch (Exception e) {
            TextView error = new TextView(this);
            error.setText("MEGPRO Fitness could not start:\n" + e.getMessage());
            error.setGravity(Gravity.CENTER);
            setContentView(error);
        }
    }
}
