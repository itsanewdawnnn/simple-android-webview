package com.itsanewdawnnn.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private val webUrl = "https://your-website.com/"
    private val errorPage = "file:///android_asset/error.html"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)

        setupWebView()
        webView.loadUrl(webUrl)
    }

    @SuppressLint("SetJavaScriptEnabled", "AddJavascriptInterface")
    private fun setupWebView() {
        val settings = webView.settings
        settings.javaScriptEnabled = true
        settings.domStorageEnabled = true
        settings.allowFileAccess = true

        webView.addJavascriptInterface(WebAppInterface(), "Android")

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return false
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                if (request?.isForMainFrame == true) {
                    view?.loadUrl(errorPage)
                }
            }
        }
    }

    inner class WebAppInterface {

        @JavascriptInterface
        @Suppress("unused")
        fun retryConnection() {
            runOnUiThread {
                webView.loadUrl(webUrl)
            }
        }
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            if (webView.url == errorPage) {
                webView.loadUrl(webUrl)
            } else {
                webView.goBack()
            }
        } else {
            super.onBackPressed()
        }
    }
}