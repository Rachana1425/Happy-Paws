package com.example.rachana.happypaww;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Navigation extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        showHome();
    }


    @Override
    public void onBackPressed(){
        DrawerLayout drawer =(DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (fragment instanceof HomeFragment){
                super.onBackPressed();
            }
            else {
                showHome();
            }
        }
        }

    private void showHome(){
        fragment = new HomeFragment();
        if (fragment !=null){
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment_container,fragment,fragment.getTag()).commit();
        }
    }
    Fragment fragment = null;


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        int id = menuItem.getItemId();
        if (id==R.id.nav_home){
            fragment = new HomeFragment();
            }else if (id==R.id.nav_grooming){
            fragment = new GroomingFragment();
        }else if (id==R.id.nav_veterinary){
            fragment = new VeterinaryFragment();
        }else if (id==R.id.nav_cemetery){
            fragment = new CemeteryFragment();

        } else if (id==R.id.nav_exe){
            fragment = new Exercisefragment();

        }else if (id==R.id.nav_logout) {
            FirebaseAuth.getInstance().signOut();
            finish();
            Toast.makeText(this, "Logout Successful.", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, Login.class));
        }


        if (fragment !=null){
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.fragment_container,fragment,fragment.getTag()).commit();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}