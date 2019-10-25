package com.mrk2.flameados;

import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FragmentDark.OnFragmentInteractionListener, FragmentLight.OnFragmentInteractionListener {

        boolean light;
        //Declare a variable that gets the text of the LightFragment
        String message="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //The default value on light is on, so, LightFragment is default
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.principalFrame,new FragmentLight())
                .commit();
        light=true;


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //                        .setAction("Action", null).show();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

                if(light){
                    if(message == null){
                        fragmentTransaction.replace(R.id.principalFrame,new FragmentDark());
                    }else{
                        fragmentTransaction.replace(R.id.principalFrame, FragmentDark.newInstance(message));
                    }
                }else{
                    if(message == null){
                        fragmentTransaction.replace(R.id.principalFrame,new FragmentLight());
                    }else{
                        fragmentTransaction.replace(R.id.principalFrame, FragmentLight.newInstance(message));
                    }
                }
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack(null);
                light=!light;

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
    public void onClick(View v) { //method created by implements

    }

        @Override
        public void onFragmentInteraction(String text) {
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
            message = text;
        }
    }
