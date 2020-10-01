package com.bash.mywebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()

        webView.settings.javaScriptEnabled = true
        
        this.webView.requestFocus()
        webView.loadUrl("https://www.dicoding.com")
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(event?.action == KeyEvent.ACTION_DOWN){
            when(keyCode){
                KeyEvent.KEYCODE_BACK -> {
                    if(webView.canGoBack()){
                        webView.goBack()
                    }else{
                        finish()
                    }
                    return true
                }
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}
