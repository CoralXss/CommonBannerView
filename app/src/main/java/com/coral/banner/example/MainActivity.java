package com.coral.banner.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.coral.banner.BannerWrapperView;
import com.coral.banner.example.adapter.BannerViewAdapter;


public class MainActivity extends AppCompatActivity {
    private BannerWrapperView bannerGalleryView;
    private BannerWrapperView bannerNormalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_LOW_PROFILE;
        decorView.setSystemUiVisibility(uiOptions);

        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        bannerGalleryView = findViewById(R.id.bannerGalleryView);
        bannerNormalView = findViewById(R.id.bannerNormalView);

        // 一个页面两个 banner，会用同一个 handler ,因为 view 中的 handler 是静态的，所以会造成混乱
        bannerGalleryView.setDataAdapter(DataSet.getImageUrls(), new BannerViewAdapter());
        bannerNormalView.setDataAdapter(DataSet.getImageUrls(), new BannerViewAdapter());
    }
}
