package com.smb5.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.smb5.R

class Web : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        val webview = findViewById<WebView>(R.id.webView)
        webview.loadUrl("https://www.pja.edu.pl")
    }
}