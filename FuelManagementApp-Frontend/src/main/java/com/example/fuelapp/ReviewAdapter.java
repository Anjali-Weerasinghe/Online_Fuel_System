package com.example.fuelapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.fuelapp.model.review;

import java.util.List;

//ReviewAdapter
public class ReviewAdapter extends ArrayAdapter<review> {

    private Context context;
    private List<review> reviews;

    public ReviewAdapter(@NonNull Context context, int resource, @NonNull List<review> objects) {
        super(context, resource, objects);
        this.context = context;
        this.reviews = objects;

    }
    //getView
    @Override
    public View getView(final int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_review, parent, false);

        TextView txtReviewerId = (TextView) rowView.findViewById(R.id.txtReviewerId);
        TextView txtFlueCenterId = (TextView) rowView.findViewById(R.id.txtFlueCenterId);
        TextView txtFlueCenterName = (TextView) rowView.findViewById(R.id.txtFlueCenterName);
        TextView txtComment = (TextView) rowView.findViewById(R.id.txtComment);

        txtReviewerId.setText(String.format("reviewerId: %s", reviews.get(pos).getReviewerId()));
        txtFlueCenterId.setText(String.format("flueCenterId: %s", reviews.get(pos).getFlueCenterId()));
        txtFlueCenterName.setText(String.format("flueCenterName: %s", reviews.get(pos).getFlueCenterName()));
        txtComment.setText(String.format("Comment: %s", reviews.get(pos).getComment()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ReviewRegistry.class);
                intent.putExtra("reviewerId", String.valueOf(reviews.get(pos).getReviewerId()));
                intent.putExtra("flueCenterId", String.valueOf(reviews.get(pos).getFlueCenterId()));
                intent.putExtra("flueCenterName", String.valueOf(reviews.get(pos).getFlueCenterName()));
                intent.putExtra("Comment", String.valueOf(reviews.get(pos).getComment()));
                context.startActivity(intent);


            }
        });

        return rowView;
    }
}
