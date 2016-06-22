package com.udacity.jinal.buildbigger.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.udacity.jinal.buildbigger.app.EndpointsAsyncTask;
import com.udacity.jinal.buildbigger.app.EndpointsAsyncTask.EndpoinrResponseInterface;
import com.udacity.jinal.buildbigger.app.R;
import com.udacity.jinal.buildbigger.mydisplayandroidlib.DisplayActivity;


/**
 * Created by Jinal Tandel on 6/10/2016.
 */


public class MainActivity extends AppCompatActivity implements EndpoinrResponseInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new EndpointsAsyncTask(MainActivity.this).execute();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResponse(boolean isSuccess, String result) {
        if (isSuccess) {
            Intent displayIntent = new Intent(this, DisplayActivity.class);
            displayIntent.putExtra("jokeToDisplay", result);
            startActivity(displayIntent);

            Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Some Error: " + result, Toast.LENGTH_LONG).show();
        }
    }
}
