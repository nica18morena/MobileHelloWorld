package com.example.jessi.helloworld;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import layout.First;
import layout.Second;

public class MainActivity extends AppCompatActivity
    implements First.OnFragmentInteractionListener, Second.OnFragmentInteractionListener {
    public final static String EXTRA_MESSAGE = "com.example.HelloWorld.MESSAGE";

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the ViewPager and set it's PagerAdapter so that it can display items
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),
                getApplicationContext()));

        // Give the TabLayout the ViewPager
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){//.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener()){
           public void onTabSelected(TabLayout.Tab tab){
                viewPager.setCurrentItem(tab.getPosition());
            }
            public void onTabUnselected(TabLayout.Tab tab){
                viewPager.setCurrentItem(tab.getPosition());
            }
            public void onTabReselected(TabLayout.Tab tab){
                viewPager.setCurrentItem(tab.getPosition());
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        private String tabTitles[] = new String[] { "Tab1", "Tab2"};
        private Context context;

        public MyFragmentPagerAdapter(FragmentManager fm, Context context){
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount(){
            return tabTitles.length;
        }

        @Override
        public Fragment getItem(int position){
            switch(position){
                case 0:
                    return new First();
                case 1:
                    return new Second();
                default:
                    return null;
            }
            //return layout.First.newInstance(position + 1);
        }

        @Override
        public CharSequence getPageTitle(int position){
        /*switch(position){
            case 0:
                return getString(R.string.home_page_title);
            case 1:
                return getString(R.string.page_2_title);
            default:
                return null;
        }*/
            return tabTitles[position];
        }
    }

    /** Called when the user clicks the Send button */
   /* public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }*/

}
