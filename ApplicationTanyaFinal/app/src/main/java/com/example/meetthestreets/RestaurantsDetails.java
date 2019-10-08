package com.example.meetthestreets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class RestaurantsDetails extends MainMenu {

    TextView mNameTv, mAddress,mContact,mHours;
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_details);

        mNameTv = findViewById(R.id.aName);
        mAddress = findViewById(R.id.aAddress);
        mContact = findViewById(R.id.aContact);
        mHours =findViewById(R.id.aHours);
        mImageView =findViewById(R.id.aImageView);

        String image = getIntent().getStringExtra("image");
        String name = getIntent().getStringExtra("name");
        String contact = getIntent().getStringExtra("contact");
        String address = getIntent().getStringExtra("address");
        String hours = getIntent().getStringExtra("hours");

        mNameTv.setText(name);
        mHours.setText(hours);
        mContact.setText(contact);
        mAddress.setText(address);
        Picasso.get().load(image).into(mImageView);



    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
