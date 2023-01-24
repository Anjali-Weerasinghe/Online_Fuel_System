package com.example.fuelapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import com.example.fuelapp.model.queue;


import java.util.List;

public class QueueAdapter extends ArrayAdapter<queue> {

    private Context context;
    private List<queue> queues;

    public QueueAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<queue> objects) {
        super(context, resource, objects);
        this.context = context;
        this.queues = objects;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_queue, parent, false);

        TextView txtFcName = (TextView) rowView.findViewById(R.id.txtFcName);
        TextView txtVId = (TextView) rowView.findViewById(R.id.txtVId);
        TextView txtOwnerName = (TextView) rowView.findViewById(R.id.txtOwnerName);
        TextView txtFuelType = (TextView) rowView.findViewById(R.id.txtFuelType);
        TextView txtInTime = (TextView) rowView.findViewById(R.id.txtInTime);
        TextView txtOutTime = (TextView) rowView.findViewById(R.id.txtOutTime);

        txtFcName.setText(String.format("flueCenterName: %s", queues.get(pos).getFcName()));
        txtVId.setText(String.format("vehicleId: %s", queues.get(pos).getvId()));
        txtOwnerName.setText(String.format("OwnerName: %s", queues.get(pos).getOwnerName()));
        txtFuelType.setText(String.format("fuelType: %s", queues.get(pos).getFuelType()));
        txtInTime.setText(String.format("inTime: %s", queues.get(pos).getInTime()));
        txtOutTime.setText(String.format("outTime: %s", queues.get(pos).getOutTime()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start activity queue form
                Intent intent = new Intent(context, Queue.class);
                intent.putExtra("flueCenterName", String.valueOf(queues.get(pos).getFcName()));
                intent.putExtra("vehicleId", String.valueOf(queues.get(pos).getvId()));
                intent.putExtra("OwnerName", String.valueOf(queues.get(pos).getOwnerName()));
                intent.putExtra("fuelType", String.valueOf(queues.get(pos).getFuelType()));
                intent.putExtra("inTime", String.valueOf(queues.get(pos).getInTime()));
                intent.putExtra("outTime", String.valueOf(queues.get(pos).getOutTime()));
                context.startActivity(intent);

            }
        });

        return rowView;
    }
}
