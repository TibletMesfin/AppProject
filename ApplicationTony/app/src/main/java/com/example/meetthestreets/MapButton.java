package com.example.meetthestreets;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MapButton extends AppCompatActivity {
        ImageButton myImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_button);//connects to the layout actoivity


        myImageButton = (ImageButton) findViewById(R.id.mapBtn);

       myImageButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intentLoadNewActivity = new Intent(MapButton.this, MapActivity.class);
               startActivity(intentLoadNewActivity);
           }
       });

    }
}
