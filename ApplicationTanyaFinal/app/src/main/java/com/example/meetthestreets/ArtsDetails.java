package com.example.meetthestreets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ArtsDetails extends MainMenu {

    TextView mNameTv, mDetailTv,mPlace;
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arts_details);

        mNameTv = findViewById(R.id.rName);
        mPlace = findViewById(R.id.rPlace);
        mDetailTv = findViewById(R.id.rDescriptionTv);
        mImageView =findViewById(R.id.rImageView);

        String image = getIntent().getStringExtra("image");
        String name = getIntent().getStringExtra("name");
        String description = getIntent().getStringExtra("description");
        String place = getIntent().getStringExtra("place");

        mNameTv.setText(name);
        mPlace.setText(place);
        mDetailTv.setText(description);
        Picasso.get().load(image).into(mImageView);



    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
