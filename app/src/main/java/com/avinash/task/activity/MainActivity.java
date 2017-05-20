package com.avinash.task.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.avinash.task.Model.BannerModel;
import com.avinash.task.R;
import com.avinash.task.adpater.SlidingImage_Adapter;
import com.avinash.task.fragments.ImagesFragment;
import com.avinash.task.fragments.MilestoneFragment;
import com.avinash.task.fragments.VideoFragment;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

import static com.avinash.task.R.id.inner_img_vp;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager, bannerViewPager;
    ArrayList<BannerModel> arrayList;
    CirclePageIndicator indicator;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViews();
    }

    void initViews() {
        context = this;
        setupToolbar();
        findViews();
        fillDummyData();
        setupViewpager();
    }


    /**
     * finding views from xml by id
     */
    void findViews(){
        bannerViewPager = (ViewPager) findViewById(inner_img_vp);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
    }


    /**
     * Dummy data setup for listing
     */
    void fillDummyData() {
        arrayList = new ArrayList<>();
        arrayList.add(new BannerModel(
                getResources().getString(R.string.dummy_album1),
                getResources().getString(R.string.dummy_artist1),
                context.getResources().getDrawable(R.drawable.dummy)));
        arrayList.add(new BannerModel(
                getResources().getString(R.string.dummy_album2),
                getResources().getString(R.string.dummy_artist2),
                context.getResources().getDrawable(R.drawable.dummy1)));
        arrayList.add(new BannerModel(
                getResources().getString(R.string.dummy_album3),
                getResources().getString(R.string.dummy_artist3),
                context.getResources().getDrawable(R.drawable.dummy3)));
        arrayList.add(new BannerModel(
                getResources().getString(R.string.dummy_album4),
                getResources().getString(R.string.dummy_artist4),
                context.getResources().getDrawable(R.drawable.dummy4)));
        arrayList.add(new BannerModel(
                getResources().getString(R.string.dummy_album5),
                getResources().getString(R.string.dummy_artist5),
                context.getResources().getDrawable(R.drawable.dummy5)));
    }


    /**
     * Navigation drawer setup
     */
    void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toolbar.setTitle("HOME");
        toolbar.setTitleTextColor(Color.WHITE);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }


    /**
     * Adding custom view to tab
     */
    void setupViewpager() {
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        bannerViewPager.setAdapter(new SlidingImage_Adapter(this, arrayList));
        indicator.setViewPager(bannerViewPager);

        setupTabIcons();
    }


    /**
     * Adding custom view to tab
     */
    private void setupTabIcons() {
        View tabVideo = LayoutInflater.from(this).inflate(R.layout.custom_tab_icon, null);
        ImageView imageView = (ImageView) tabVideo.findViewById(R.id.icon);
        TextView textView = (TextView) tabVideo.findViewById(R.id.txt);
        textView.setText(R.string.video);
        imageView.setBackgroundResource(R.drawable.video_selector);
        tabLayout.getTabAt(0).setCustomView(tabVideo);

        View tabVideo1 = LayoutInflater.from(this).inflate(R.layout.custom_tab_icon, null);
        ImageView imageView1 = (ImageView) tabVideo1.findViewById(R.id.icon);
        TextView textView1 = (TextView) tabVideo1.findViewById(R.id.txt);
        textView1.setText(R.string.IMAGES);
        imageView1.setBackgroundResource(R.drawable.image_selector);
        tabLayout.getTabAt(1).setCustomView(tabVideo1);

        View tabVideo2 = LayoutInflater.from(this).inflate(R.layout.custom_tab_icon, null);
        ImageView imageView2 = (ImageView) tabVideo2.findViewById(R.id.icon);
        TextView textView2 = (TextView) tabVideo2.findViewById(R.id.txt);
        textView2.setText(R.string.MILESTONE);
        imageView2.setBackgroundResource(R.drawable.milestone_selector);
        tabLayout.getTabAt(2).setCustomView(tabVideo2);
    }


    /**
     * Adding fragments to ViewPager
     *
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new VideoFragment(), "Video");
        adapter.addFrag(new ImagesFragment(), "Images");
        adapter.addFrag(new MilestoneFragment(), "Milestone");
        viewPager.setAdapter(adapter);
    }

    /**
     * Creating adapter for viewpager to show listing
     */
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
