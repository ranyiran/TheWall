package com.ran.thewal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ran.thewal.R;
import com.ran.thewal.adapter.MyFragmentPagerAdapter;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView;
    Toolbar toolbar;//Toolbar
    TabLayout.Tab tabFindAndLost;
    TabLayout.Tab tabNoname;
    TabLayout.Tab tabTheHert;

    //主界面ViewPager的实例化
    ViewPager mainViewPager;
    TabLayout mTabLayout;
    MyFragmentPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //右下角点击事件
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //初始化Adapter
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mainViewPager.setAdapter(pagerAdapter);
        //将TabLayout和ViewPager绑定在一起，使双方各自的改变都能直接影响另一方，解放了开发人员对双方变动事件的监听
        mTabLayout.setupWithViewPager(mainViewPager);

        //往tab里面传值。
        tabTheHert = mTabLayout.getTabAt(0);
        tabFindAndLost = mTabLayout.getTabAt(1);
        tabNoname = mTabLayout.getTabAt(2);
        //设置tab的图标
        //tabTheHert.setIcon(R.drawable.apptitle);
        navigationView.setNavigationItemSelectedListener(this);
        onNavigationViewClick();
    }


    /**
     * 初始化App数据
     */
    private void initData() {
        initControls();
    }

    /**
     * 初始化控制
     */
    private void initControls() {

    }

    /**
     * 实例化控件找到id。
     */
    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tableLayout);
        mainViewPager = (ViewPager) findViewById(R.id.vpager_four);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
    }

    /**
     * NavigationView顶部header的点击事件
     */
    private void onNavigationViewClick() {

        View indexHeader = navigationView.getHeaderView(0);
        LinearLayout mLayout = (LinearLayout) indexHeader.findViewById(R.id.background);
        ImageView mAvatar = (ImageView) indexHeader.findViewById(R.id.imageView);
        TextView mUsername = (TextView) indexHeader.findViewById(R.id.tvUsername);
        TextView mSignature = (TextView) indexHeader.findViewById(R.id.tvSignature);
        /**
         * NavigationView 背景点击事件
         */
        mLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("theWallLog", "mLayout is click");
            }
        });
        /**
         * NavigationView 头像点击事件
         */
        mAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("theWallLog", "mAvatar is click");
            }
        });
        /**
         * NavigationView 昵称点击事件
         */
        mUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("theWallLog", "mUsername is click");
            }
        });
        /**
         * NavigationView 签名点击事件
         */
        mSignature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("theWallLog", "mSignature is click");
            }
        });
    }

    /**
     * 返回键的监听
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 主界面title的样式 生命
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * 右上角setting图标
     *
     * @param item
     * @return
     */
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

    /**
     * 右侧 下方抽屉点击事件
     *
     * @param item
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            //照相机点击事件
            Intent intent = new Intent(this, CameraActivity.class);
            this.startActivity(intent);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
