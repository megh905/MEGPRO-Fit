package com.megpro.fitness;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.widget.TextView;
import android.view.Gravity;
import android.graphics.Color;

public class MainActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            webView = new WebView(this);

            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setAllowFileAccess(true);

            webView.setWebViewClient(new WebViewClient());
            webView.setWebChromeClient(new WebChromeClient());

            setContentView(webView);

            webView.loadUrl(
                "file:///android_asset/index.html"
            );

        } catch (Exception e) {
            showError(e.getMessage());
        }
    }

    private void showError(String message) {
        TextView error = new TextView(this);
        error.setText(
            "MEGPRO Fitness could not start.\n\n"
            + (message == null ? "Unknown error" : message)
        );
        error.setTextColor(Color.WHITE);
        error.setBackgroundColor(Color.rgb(16, 20, 28));
        error.setTextSize(16);
        error.setGravity(Gravity.CENTER);
        error.setPadding(24, 24, 24, 24);
        setContentView(error);
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
