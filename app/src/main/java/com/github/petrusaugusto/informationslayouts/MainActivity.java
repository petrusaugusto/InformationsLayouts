package com.github.petrusaugusto.informationslayouts;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.github.petrusaugusto.informationslayouts.fragments.BaseFragmentClass;
import com.github.petrusaugusto.informationslayouts.fragments.EmptyWindow;
import com.github.petrusaugusto.informationslayouts.fragments.ErrorWindow;
import com.github.petrusaugusto.informationslayouts.fragments.LoadingWindow;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tabLayout = (TabLayout) findViewById(R.id.tabs);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.viewPager = (ViewPager) findViewById(R.id.pager);
        this.viewPager.setAdapter(new MyFragmentPager(getSupportFragmentManager()));
    }

    @Override
    public void onStart() {
        super.onStart();
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        this.tabLayout.setupWithViewPager(viewPager);
    }

    private class MyFragmentPager extends FragmentPagerAdapter {
        private BaseFragmentClass[] fragmentList;
        public MyFragmentPager(FragmentManager fm) {
            super(fm);
            this.fragmentList = new BaseFragmentClass[] {
                    new EmptyWindow(),
                    new LoadingWindow(),
                    new ErrorWindow()
            };
        }

        @Override
        public Fragment getItem(int position) {
            return this.fragmentList[position];
        }

        @Override
        public int getCount() {
            return this.fragmentList.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = "";
            switch (position) {
                case 0:
                    title = "Empty";
                    break;
                case 1:
                    title = "Loading";
                break;
                case 2:
                    title = "Error";
                break;
            }

            return title;
        }
    }
}
