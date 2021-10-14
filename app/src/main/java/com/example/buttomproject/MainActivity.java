package com.example.buttomproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView Navbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.main_drawer_layout);
        navigationView=findViewById(R.id.navigation_main_drawer);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.start,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);


        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new HomeFragment()).commit();
        Navbar=findViewById(R.id.navigationBar);
        Navbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id= item.getItemId();
                switch (item.getItemId()){
                    case R.id.homeID:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new HomeFragment()).commit();
                        return true;
                    case R.id.videoID:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ScreenFragment()).commit();
                        return true;
                    case R.id.settingID:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new SettingFragment()).commit();
                        return true;
                }
                return false;
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addmision:
                Toast.makeText(this, "Admission is Click", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),TestActivity.class);
                startActivity(intent);
                break;
            case R.id.addmision_one:
                Toast.makeText(this, "This is Admission one", Toast.LENGTH_SHORT).show();
                break;
            case R.id.addmision_two:
                Toast.makeText(this, "This is admission two", Toast.LENGTH_SHORT).show();
                break;
            case R.id.addmision_three:
                Toast.makeText(this, "This is admission three", Toast.LENGTH_SHORT).show();
                break;
            case R.id.addmision_four:
                Toast.makeText(this, "This is admission four", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}