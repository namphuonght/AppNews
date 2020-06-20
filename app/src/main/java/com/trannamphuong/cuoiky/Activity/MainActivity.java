package com.trannamphuong.cuoiky.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.trannamphuong.cuoiky.Adapter.ViewPagerAdapter;
import com.trannamphuong.cuoiky.Fragment.Fragment_MoiNhat;
import com.trannamphuong.cuoiky.Fragment.Fragment_ThoiSu;
import com.trannamphuong.cuoiky.Fragment.Fragment_TrangChu;
import com.trannamphuong.cuoiky.R;


public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //add fragment o day
        adapter.addFragment(new Fragment_TrangChu(),"Trang nhất");
        adapter.addFragment(new Fragment_MoiNhat(),"Mới nhất");
        adapter.addFragment(new Fragment_ThoiSu(),"Thời sự");
        adapter.addFragment(new Fragment_ThoiSu(),"Góc nhìn");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

}
