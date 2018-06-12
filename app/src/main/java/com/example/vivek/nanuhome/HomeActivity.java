package com.example.vivek.nanuhome;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends AppCompatActivity {


    NavHostFragment navhost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);


         navhost= (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);


         NavigationUI.setupActionBarWithNavController( this,navhost.getNavController());

    }

    @Override
    public boolean onSupportNavigateUp() {
        return navhost.getNavController().navigateUp();
    }
}
