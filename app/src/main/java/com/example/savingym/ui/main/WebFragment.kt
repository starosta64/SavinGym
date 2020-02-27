package com.example.savingym.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.arellomobile.mvp.MvpAppCompatFragment
import com.example.savingym.R
import kotlinx.android.synthetic.main.web_fragment.*

class WebFragment :MvpAppCompatFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.web_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val webSettings = web_view.settings
        webSettings.javaScriptEnabled = true
        web_view.loadUrl("http://dailyworkoutapps.com/privacy-policy.html")
        web_view.webViewClient = WebViewClient()
        WebView.setWebContentsDebuggingEnabled(false)
    }
}