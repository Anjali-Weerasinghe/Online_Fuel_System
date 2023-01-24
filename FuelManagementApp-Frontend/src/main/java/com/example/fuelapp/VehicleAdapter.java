package com.example.fuelapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.fuelapp.model.vehicalOwner;

import java.util.List;
//vehicle adapter
public class VehicleAdapter extends ArrayAdapter<vehicalOwner> {

    private Context context;
    private List<vehicalOwner> vehicalOwners;

    public VehicleAdapter(@NonNull Context context, int resource, @NonNull List<vehicalOwner> objects) {
        super(context, resource, objects);
        this.context = context;
        this.vehicalOwners = objects;

    }
//view
    @Override
    public View getView(final int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_vehicle, parent, false);

        TextView txtUserId = (TextView) rowView.findViewById(R.id.txtUserId);
        TextView txtUsername = (TextView) rowView.findViewById(R.id.txtUsername);
        TextView txtType = (TextView) rowView.findViewById(R.id.txtType);
        TextView txtId = (TextView) rowView.findViewById(R.id.txtId);

        txtId.setText(String.format("Vid: %s", vehicalOwners.get(pos).getId()));
        txtUserId.setText(String.format("ownerName: %s", vehicalOwners.get(pos).getOwnerName()));
        txtUsername.setText(String.format("VechicalId: %s", vehicalOwners.get(pos).getVechicalId()));
        txtType.setText(String.format("fuelType: %s", vehicalOwners.get(pos).getFuelType()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start activity vehicle form
                Intent intent = new Intent(context, VehicleRegistry.class);
                intent.putExtra("Vid", String.valueOf(vehicalOwners.get(pos).getId()));
                intent.putExtra("ownerName", String.valueOf(vehicalOwners.get(pos).getOwnerName()));
                intent.putExtra("VechicalId", String.valueOf(vehicalOwners.get(pos).getVechicalId()));
                intent.putExtra("fuelType", String.valueOf(vehicalOwners.get(pos).getFuelType()));
                context.startActivity(intent);


            }
        });

        return rowView;
    }


}
