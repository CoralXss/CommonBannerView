# CommonBannerView
Android Banner广告位控件，支持画廊和普通展示形式，可自动和手动循环轮播

画廊和普通轮播效果效果
![img](https://github.com/CoralXss/CommonBannerView/blob/master/banner.png)

1. gradle中添加依赖（稍后提供）


2. xml文件中使用
```
<com.coral.banner.BannerWrapperView
            android:id="@+id/bannerGalleryView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="20dp"
            app:showIndicator="true"
            app:playAuto="true"
            app:playLoop="true"
            app:viewPageMargin="8dp"
            app:viewPageHorizonMargin="20dp"
            app:bannerClipChildren="false"
            app:indicatorIconSelected="@drawable/bg_banner_indicator_selected"
            app:indicatorIconNormal="@drawable/bg_banner_indicator_normal"/>
```

3. BannerWrapperView属性说明
```
showIndicator         - 是否展示轮播指示器
playAuto              - 自动轮播
playLoop              - 循环轮播
playDelayTime         - 轮播时间间隔
indicatorIconSelected - 指示器选中时的图标
indicatorIconNormal   - 指示器未选中时的图标

bannerClipChildren    - 画廊效果时，false指定容器中的子控件可越界绘制，同 clipChildren 默认true
viewPageMargin        - 画廊效果时，指定ViewPager页与页之间的间距
viewPageHorizonMargin - 画廊效果时，指定ViewPager左右间距
heightRate            - 当没有指定高度时，banner宽度和高度比例（控件高度为计算得到的图片宽度，具体见onMeasure方法）

```

4. 定义数据源和布局适配器
```
// 由开发者自定义，使用泛型，可以提供任意数据源，可以使用自定制的banner布局样式
public class BannerViewAdapter extends BannerPagerAdapter<String> {

    @Override
    public BannerViewHolder createViewHolder(ViewGroup container) {
        return new BannerViewHolder();
    }

    public static class BannerViewHolder implements BannerPagerAdapter.BaseBannerViewHolder<String> {

        private RoundedImageView mImageView;
        private TextView mTvMsg;

        @Override
        public View createView(Context context) {
            View view = LayoutInflater.from(context).inflate(R.layout.adapter_banner_item_view, null);

            mImageView = view.findViewById(R.id.ivBanner);
            mTvMsg = view.findViewById(R.id.tvMsg);


            return view;
        }

        @Override
        public void bind(Context context, String data, int position) {
//            if (!TextUtils.isEmpty(data)) {
//                Glide.with(context).load(data).placeholder(R.drawable.ic_launcher_background).into(mImageView);
//            }
            mTvMsg.setText(position + "");
            mImageView.setImageResource(R.drawable.ic_launcher_background);
        }
    }

}
```

5. 画廊效果实现说明
```
1）主要使用以下三个属性：
bannerClipChildren    - 画廊效果时，false指定容器中的子控件可越界绘制，同 clipChildren 默认true
viewPageMargin        - 画廊效果时，指定ViewPager页与页之间的间距
viewPageHorizonMargin - 画廊效果时，指定ViewPager左右间距

2）clipChildren 说明：实现画廊效果的关键，需要设置 BannerWrapperView 和 其中的子控件 ViewPager 的 clipChildren 属性为false，
允许其中加载的 viewPager 子View绘制时可超过父边界。这个属性第一次用，很强大，想了解可查相关文档。
```

5. ViewPager 页面切换动画
```
调用方法：mViewPager.setPageTransformer(true, new GalleryTransformer());
这里可参看官方切换动画，网上有不同的动画实现，很炫酷。
```

6. 注意事项
```
关于轮播的停止和开始，这里是在setAdapter时就调用 startPlay()，在退出页面是监听 View.OnAttachStateChangeListener，
在 onViewDetachedFromWindow() 时调用 stopPlay 停止轮播并回收handler。
```
