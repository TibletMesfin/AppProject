package com.example.meetthestreets;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View nView;

    public ViewHolder(View itemView) {
        super(itemView);
        nView = itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mClickListener.onItemClick(view, getAdapterPosition());
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mClickListener.onItemLongClick(view, getAdapterPosition());
                return true;
            }
        });


    }

    public void setDetails(Context ctx, String name, String image){
        TextView mNameTv = nView.findViewById(R.id.nNameTv);
        //TextView mDetails = nView.findViewById(R.id.rDescriptionTv);
        ImageView mImageIv = nView.findViewById(R.id.nImageViewTv);
        mNameTv.setText(name);
        //mDetails.setText(description);
        Picasso.get().load(image).into( mImageIv);
     }
     private ViewHolder.ClickListener mClickListener;
     public interface ClickListener{
         void onItemClick(View view, int position);
         void onItemLongClick(View view, int position);
     }

     public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
     }


}
