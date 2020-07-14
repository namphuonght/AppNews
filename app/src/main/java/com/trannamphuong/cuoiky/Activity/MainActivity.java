package com.trannamphuong.cuoiky.Activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.trannamphuong.cuoiky.Adapter.ViewPagerAdapter;
import com.trannamphuong.cuoiky.Fragment.Fragment_Account;
import com.trannamphuong.cuoiky.Fragment.Fragment_Contact;
import com.trannamphuong.cuoiky.Fragment.Fragment_GocNhin;
import com.trannamphuong.cuoiky.Fragment.Fragment_MoiNhat;
import com.trannamphuong.cuoiky.Fragment.Fragment_Search;
import com.trannamphuong.cuoiky.Fragment.Fragment_ThoiSu;
import com.trannamphuong.cuoiky.Fragment.Fragment_TrangChu;
import com.trannamphuong.cuoiky.Fragment.Fragment_TrangNhat;
import com.trannamphuong.cuoiky.R;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FrameLayout frameLayout;
    private ViewPagerAdapter adapter;
    private BottomNavigationView MainNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MainNav = (BottomNavigationView) findViewById(R.id.main_nav);
        MainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("ResourceType")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectFragment = null;
                switch (menuItem.getItemId()){

                    case R.id.nav_home:
                        selectFragment = new Fragment_TrangChu();
                        break;

                    case R.id.nav_search:
                        selectFragment = new Fragment_Search();
                        break;

                    case R.id.nav_contact:
                        selectFragment = new Fragment_Contact();
                        break;

                    case R.id.nav_account:
                        selectFragment = new Fragment_Account();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, selectFragment).commit();
                return true;
            }
        });



        this.getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        //getSupportActionBar().setElevation(0);
        View view = getSupportActionBar().getCustomView();
        TextView name = view.findViewById(R.id.name);
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You have clicked tittle", Toast.LENGTH_LONG).show();
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        frameLayout = (FrameLayout) findViewById(R.id.framelayout);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //add fragment o day
        adapter.addFragment(new Fragment_TrangNhat(),"Trang nhất");
        adapter.addFragment(new Fragment_MoiNhat(),"Mới nhất");
        adapter.addFragment(new Fragment_ThoiSu(),"Thời sự");
        adapter.addFragment(new Fragment_GocNhin(),"Góc nhìn");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

}
