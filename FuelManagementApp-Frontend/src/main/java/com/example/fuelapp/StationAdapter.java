package com.example.fuelapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.fuelapp.model.fuelAvailability;

import java.util.List;

//station adapter
public class StationAdapter extends ArrayAdapter<fuelAvailability> {
    private Context context;
    private List<fuelAvailability> fuelAvailabilities;

    public StationAdapter(@NonNull Context context, int resource, @NonNull List<fuelAvailability> objects) {
        super(context, resource, objects);
        this.context = context;
        this.fuelAvailabilities = objects;
    }

    //get view
    @Override
    public View getView(final int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_station, parent, false);

        TextView moID = (TextView) rowView.findViewById(R.id.moID);
        TextView uname = (TextView) rowView.findViewById(R.id.uname);
        TextView txtUserId1 = (TextView) rowView.findViewById(R.id.txtUserId1);
        TextView txtname1 = (TextView) rowView.findViewById(R.id.txtname1);
        TextView pavailable = (TextView) rowView.findViewById(R.id.pavailable);
        TextView davailable = (TextView) rowView.findViewById(R.id.davailable);
        TextView ftime = (TextView) rowView.findViewById(R.id.ftime);
        TextView atime = (TextView) rowView.findViewById(R.id.atime);

        moID.setText(String.format("fuID: %s", fuelAvailabilities.get(pos).getId()));
        uname.setText(String.format("usernames: %s", fuelAvailabilities.get(pos).getUsernames()));
        txtUserId1.setText(String.format("flueCenterId: %s", fuelAvailabilities.get(pos).getFlueCenterId()));
        txtname1.setText(String.format("flueCenterName: %s", fuelAvailabilities.get(pos).getFlueCenterName()));
        pavailable.setText(String.format("PetrolAvailable: %s", fuelAvailabilities.get(pos).getPetrolAvailable()));
        davailable.setText(String.format("Dieselvailable: %s", fuelAvailabilities.get(pos).getDieselvailable()));
        ftime.setText(String.format("FinishlTime: %s", fuelAvailabilities.get(pos).getFinishlTime()));
        atime.setText(String.format("ArrivalTime: %s", fuelAvailabilities.get(pos).getArrivalTime()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Station.class);
                intent.putExtra("fuID", String.valueOf(fuelAvailabilities.get(pos).getId()));
                intent.putExtra("usernames", String.valueOf(fuelAvailabilities.get(pos).getUsernames()));
                intent.putExtra("flueCenterId", String.valueOf(fuelAvailabilities.get(pos).getFlueCenterId()));
                intent.putExtra("flueCenterName", String.valueOf(fuelAvailabilities.get(pos).getFlueCenterName()));
                intent.putExtra("PetrolAvailable", String.valueOf(fuelAvailabilities.get(pos).getPetrolAvailable()));
                intent.putExtra("Dieselvailable", String.valueOf(fuelAvailabilities.get(pos).getDieselvailable()));
                intent.putExtra("FinishlTime", String.valueOf(fuelAvailabilities.get(pos).getFinishlTime()));
                intent.putExtra("ArrivalTime", String.valueOf(fuelAvailabilities.get(pos).getArrivalTime()));
                context.startActivity(intent);

            }
        });

        return rowView;

    }
}
