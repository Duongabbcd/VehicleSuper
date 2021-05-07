package com.example.vehiclesuper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.vehiclesuper.Fragment.FragmentAdapter;
import com.example.vehiclesuper.model.Vehicle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;
    private ViewPager viewPager;
    private FragmentAdapter adapter;
    private FloatingActionButton bt;
    public List<Vehicle> list=new ArrayList<>();
//    public List<Vehicle> superCarList=new ArrayList<>();
    public List<Vehicle> motorList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.viewPager);
        navigationView=findViewById(R.id.navigation);
        bt=findViewById(R.id.fab);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Ban da click toi",Toast.LENGTH_SHORT).show();
            }
        });
      adapter=new FragmentAdapter(getSupportFragmentManager(),
                FragmentAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Super:viewPager.setCurrentItem(0);
                        break;
//                    case R.id.Hyper:viewPager.setCurrentItem(1);
//                        break;
//                    case R.id.Motor:viewPager.setCurrentItem(2);
//                        break;
                    case R.id.mSearch:viewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });

    }
}