package com.example.chongbin.mobilehci;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView mTextMessage;

    public final Fragment fragment1 = new HomeFragment();
    public final Fragment fragment2 = new JourneyFragment();
    public final Fragment fragment3 = new MapFragment();
    public final FragmentManager fm = getSupportFragmentManager();
    public Fragment active = fragment1;

    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    fm.beginTransaction().hide(active).show(fragment1).commit();
                    active = fragment1;
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    fm.beginTransaction().hide(active).show(fragment2).commit();
                    active = fragment2;
                    return true;
                case R.id.navigation_notifications:
                    fm.beginTransaction().hide(active).show(fragment3).commit();
                    active = fragment3;
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        /*NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm.beginTransaction().add(R.id.main_container, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.main_container, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.main_container,fragment1, "1").commit();

        ImageButton button1 = (ImageButton) findViewById(R.id.delete_btn_1);
        final android.support.v7.widget.LinearLayoutCompat layout1 = (android.support.v7.widget.LinearLayoutCompat) findViewById(R.id.linear_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(layout1.getVisibility() == View.VISIBLE){
                    layout1.setVisibility(View.GONE);
                } else {
                    layout1.setVisibility(View.VISIBLE);
                }
            }
        });
        ImageButton button2 = (ImageButton) findViewById(R.id.delete_btn_2);
        final android.support.v7.widget.LinearLayoutCompat layout2 = (android.support.v7.widget.LinearLayoutCompat) findViewById(R.id.linear_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(layout2.getVisibility() == View.VISIBLE){
                    layout2.setVisibility(View.GONE);
                } else {
                    layout2.setVisibility(View.VISIBLE);
                }
            }
        });
        ImageButton button3 = (ImageButton) findViewById(R.id.delete_btn_3);
        final android.support.v7.widget.LinearLayoutCompat layout3 = (android.support.v7.widget.LinearLayoutCompat) findViewById(R.id.linear_3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(layout3.getVisibility() == View.VISIBLE){
                    layout3.setVisibility(View.GONE);
                } else {
                    layout3.setVisibility(View.VISIBLE);
                }
            }
        });
        ImageButton button4 = (ImageButton) findViewById(R.id.delete_btn_4);
        final android.support.v7.widget.LinearLayoutCompat layout4 = (android.support.v7.widget.LinearLayoutCompat) findViewById(R.id.linear_4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(layout4.getVisibility() == View.VISIBLE){
                    layout4.setVisibility(View.GONE);
                } else {
                    layout4.setVisibility(View.VISIBLE);
                }
            }
        });
        ImageButton button5 = (ImageButton) findViewById(R.id.delete_btn_5);
        final android.support.v7.widget.LinearLayoutCompat layout5 = (android.support.v7.widget.LinearLayoutCompat) findViewById(R.id.linear_5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(layout5.getVisibility() == View.VISIBLE){
                    layout5.setVisibility(View.GONE);
                } else {
                    layout5.setVisibility(View.VISIBLE);
                }
            }
        });
        Button button_clear = (Button) findViewById(R.id.clear_btn);
        final android.support.v7.widget.LinearLayoutCompat layoutAll = (android.support.v7.widget.LinearLayoutCompat) findViewById(R.id.linear_all);
        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutAll.setVisibility(View.GONE);

            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

/*
        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        //drawer.closeDrawer(GravityCompat.START);*/
        return true;
    }
    public void myFancyMethod(View v) {
        // does something very interesting
       v.setEnabled(false);
    }
}
