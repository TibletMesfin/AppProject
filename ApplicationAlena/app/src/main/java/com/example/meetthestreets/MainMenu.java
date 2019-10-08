package com.example.meetthestreets;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;

public class MainMenu extends AppCompatActivity {
    ImageButton myImageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_button);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        myImageButton = (ImageButton) findViewById(R.id.mapBtn);

        myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(MainMenu.this, MapActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });

    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection


            if(item.getItemId()== R.id.about){
            Intent intent3 = new Intent(this, About.class);
            this.startActivity(intent3);
            return true;
        }
        if(item.getItemId()== R.id.map) {
            Intent intent4 = new Intent(this, MapActivity.class);
            this.startActivity(intent4);
            onBackPressed();
            return true;
        }
        if(item.getItemId()== R.id.userProf){
            Intent intent5 = new Intent(this, ProfileActivity.class);
            this.startActivity(intent5);

            return true;
        }
            if((item.getItemId())== R.id.logout){
                logout();
            }

        return super.onOptionsItemSelected(item);
        }


    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainMenu.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
   public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
   }

}
