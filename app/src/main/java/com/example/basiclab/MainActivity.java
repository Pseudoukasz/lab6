package com.example.basiclab;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            Snackbar.make(this.findViewById(R.id.rootLayout), getText(R.string.snackbar_magic), Snackbar.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_finish) {
            Snackbar.make(this.findViewById(R.id.rootLayout), getText(R.string.snackbar_exit), Snackbar.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.action_info) {
            Snackbar.make(this.findViewById(R.id.rootLayout), getText(R.string.snackbar_info), Snackbar.LENGTH_LONG).show();
            return true;
        }*/
        String message = "";
        switch (id) {
            case R.id.action_settings: message = "Settings"; break;
            case R.id.action1:
                NavHostFragment.findNavController(getSupportFragmentManager().
                        findFragmentById(R.id.nav_host_fragment)).navigate(R.id.action_fragment_1_show);
                message = "Action 1";
                break;
            case R.id.action2:
                NavHostFragment.findNavController(getSupportFragmentManager().
                        findFragmentById(R.id.nav_host_fragment)).navigate(R.id.action_fragment_2_show);
                message = "Action 2";
                break;
            case R.id.action3:
                NavHostFragment.findNavController(getSupportFragmentManager().
                        findFragmentById(R.id.nav_host_fragment)).navigate(R.id.action_fragment_3_show);
                message = "Action 3";
                break;
        }

        Snackbar.make(findViewById(R.id.rootLayout), message, Snackbar.LENGTH_LONG).show();

        return super.onOptionsItemSelected(item);
    }
}