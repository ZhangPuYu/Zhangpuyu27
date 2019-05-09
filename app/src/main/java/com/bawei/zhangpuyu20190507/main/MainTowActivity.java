package com.bawei.zhangpuyu20190507.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bawei.zhangpuyu20190507.R;
import com.bawei.zhangpuyu20190507.base.BaseActivity;
//webView加载视图页面
public class MainTowActivity extends BaseActivity {

    private WebView webView;

    @Override
    protected int layoutId() {
        return R.layout.activity_main_tow;
    }

    @Override
    protected void initView() {
        webView = findViewById(R.id.web_view);

        webView.loadUrl("https://www.baidu.com/");

        webView.setWebViewClient(new WebViewClient());

        webView.setWebChromeClient(new WebChromeClient());

        webView.getSettings().setBuiltInZoomControls(true);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
