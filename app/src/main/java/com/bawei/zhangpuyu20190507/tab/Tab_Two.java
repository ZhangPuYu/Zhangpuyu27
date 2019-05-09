package com.bawei.zhangpuyu20190507.tab;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.zhangpuyu20190507.R;
import com.bawei.zhangpuyu20190507.base.BaseFragment;
import com.bawei.zhangpuyu20190507.main.MainTowActivity;

/**
 * webview
 * 头像上传
 * Toast时间
 */
public class Tab_Two extends BaseFragment {
    private ImageView imageView;
    private TextView text_jm,text_sz;
    @Override
    protected int layoutID() {
        return R.layout.tab_two;
    }

    @Override
    protected void initView(View view) {
        imageView = view.findViewById(R.id.image_icon);
        text_jm = view.findViewById(R.id.text_jm);
        text_sz = view.findViewById(R.id.text_sz);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

        text_jm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainTowActivity.class);
                startActivity(intent);
            }
        });
        //Toast时间
        text_sz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"2019/5/7 10:36",Toast.LENGTH_SHORT).show();
            }
        });


    }




}
