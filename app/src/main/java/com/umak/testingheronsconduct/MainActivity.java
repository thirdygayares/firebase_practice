package com.umak.testingheronsconduct;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FrameLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.nav);

        //Framelaout
        container = findViewById(R.id.container);

        Fragment selectedFragment = new StudentHomeFragment();




        //bottomNavigationView.set

        bottomNavigationView.setOnItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                selectedFragment).commit();

    }

    private NavigationBarView.OnItemSelectedListener navListener =
            item -> {

                Fragment selectedFragment = new StudentHomeFragment();
                switch(item.getItemId()){
                    case R.id.home:
                        selectedFragment = new StudentHomeFragment();
                        break;
                    case R.id.search:
                        selectedFragment = new StudentCSFDPortalFragment();
                        break;
                    case R.id.stats:
                        selectedFragment = new StudentNotifFragment();
                        break;
                    case R.id.settings:
                        selectedFragment = new StudentSettingsFragment();
                        break;

                    default:
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container, selectedFragment).commit();
                return true;
            };


}