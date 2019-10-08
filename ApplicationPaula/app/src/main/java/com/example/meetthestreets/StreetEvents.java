package com.example.meetthestreets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class StreetEvents extends AppCompatActivity {

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_events);


        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("street_performers");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Event, ViewHolder>firebaseRecyclerAdapter=
                new FirebaseRecyclerAdapter<Event, ViewHolder>(
                        Event.class,
                        R.layout.event_items,
                        ViewHolder.class,
                        mRef
                ){
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Event event, int position){
                        viewHolder.setDetails(getApplicationContext(), event.getName(),event.getImage());
                    }

                    @Override
                    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);

                        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                String mName = getItem(position).getName();
                                String mPlace = getItem(position).getPlace();
                                String mDescription = getItem(position).getDescription();
                                String mType = getItem(position).getType();
                                String mImage = getItem(position).getImage();


                                Intent intent = new Intent(view.getContext(),StreetsDetails.class);

                                intent.putExtra("image", mImage);
                                intent.putExtra("name", mName);
                                intent.putExtra("place", mPlace);
                                intent.putExtra("description", mDescription);
                                intent.putExtra("type", mType);
                                startActivity(intent);

                            }

                            @Override
                            public void onItemLongClick(View view, int position) {

                            }
                        });
                        return viewHolder;
                    }
                };
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

}
