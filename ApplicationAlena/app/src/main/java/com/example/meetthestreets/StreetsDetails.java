package com.example.meetthestreets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class StreetsDetails extends AppCompatActivity {


    TextView mNameTv, mDescription,mPlace,mType;
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streets_details);

        mNameTv = findViewById(R.id.sName);
        mDescription = findViewById(R.id.sDescription);
        mPlace = findViewById(R.id.sPlace);
        mType =findViewById(R.id.sType);
        mImageView =findViewById(R.id.sImageView);

        String image = getIntent().getStringExtra("image");
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        String place = getIntent().getStringExtra("place");
        String type = getIntent().getStringExtra("type");

        mNameTv.setText(name);
        mPlace.setText(place);
        mDescription.setText(description);
        mType.setText(type);
        Picasso.get().load(image).into(mImageView);



    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
