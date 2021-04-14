package com.example.collegeappv02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class More extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);


        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case  R.id.dashboard:

                        Intent intent = new Intent(More.this, MainActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.staff:
                        Intent intent1 = new Intent(More.this , Staff.class);

                        startActivity(intent1);
                        break;
                    case R.id.hotlines:
                        Intent intent2 = new Intent(More.this , Hotlines.class);

                        startActivity(intent2);
                        break;
                    case R.id.aboutus:
                        Intent intent3 = new Intent(More.this , AboutUs.class);
                        startActivity(intent3);
                        break;

                    case R.id.logout:
                        Intent intent4 = new Intent(More.this , Login.class);
                        startActivity(intent4);
                        break;


                    case  R.id.policy:
                       Intent browserIntent  = new Intent(Intent.ACTION_VIEW , Uri.parse("https://university.sunway.edu.my/research/policies"));
                        startActivity(browserIntent);
                          break;

                    case  R.id.share:{

                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        String shareBody =  "http://play.google.com/store/apps/detail?id=my.edu.sunway.mycampus&hl=en&gl=US";
                        String shareSub = "Try now";
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(sharingIntent, "Share using"));

                    }
                    break;
                }
                return false;
            }
        });
    }

}