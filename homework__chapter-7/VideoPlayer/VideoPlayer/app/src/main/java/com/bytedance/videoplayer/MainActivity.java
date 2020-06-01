package com.bytedance.videoplayer;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;


public class MainActivity extends AppCompatActivity {

    private JzvdStd jzvdStd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jzvdStd = findViewById(R.id.mainVideo);
        findViewById(R.id.mainPlay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jzvdStd.mediaInterface == null){
                    jzvdStd.startVideo();
                }else {
                    jzvdStd.mediaInterface.start();
                    jzvdStd.onStatePlaying();
                }

            }
        });
        findViewById(R.id.mainStop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jzvdStd.mediaInterface.pause();
                jzvdStd.onStatePause();
            }
        });

        jzvdStd.setUp("http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4"
                , "");
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

 
}
