package com.nopalyer.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detailed extends AppCompatActivity {

    TextView tvTitle,tvSource,tvTime,tvDesc;
    ImageView imageView;
    WebView webView;
    ProgressBar loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        tvTitle = findViewById(R.id.tvTitle);
        tvSource = findViewById(R.id.tvSource);
        tvTime = findViewById(R.id.tvDate);
        tvDesc = findViewById(R.id.tvDesc);

        imageView = findViewById(R.id.imageView);

        webView = findViewById(R.id.webView);

        loader = findViewById(R.id.webViewLoader);
        loader.setVisibility(View.VISIBLE);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String source = intent.getStringExtra("source");
        String time = intent.getStringExtra("time");
        String desc = intent.getStringExtra("desc");
        String imageUrl = intent.getStringExtra("imageUrl");
        String url = intent.getStringExtra("url");


        tvTitle.setText(title);
        tvSource.setText(source);
        tvTime.setText(time);
        tvDesc.setText(desc);

        Picasso.with(Detailed.this).load(imageUrl).into(imageView);

        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);
        if (webView.isShown()){
            loader.setVisibility(View.INVISIBLE);
        }
    }
}
