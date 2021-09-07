package com.example.cem_lab02_myvehicleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayVehicleActivity extends AppCompatActivity {
    private TextView displayVehicleTextView;
    private ArrayList<Vehicle>vehicleArrayList;
    private int currentCarIndex;
    private TextView carCountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_vehicle);

        displayVehicleTextView = findViewById(R.id.displayVehicleTextView);
        carCountTextView = findViewById(R.id.carCountTextView);

        Intent intent = getIntent();
        vehicleArrayList = (ArrayList<Vehicle>) intent.getSerializableExtra("allCars");

        String message = "";
        currentCarIndex = -1;
        if (vehicleArrayList.size()!=0) {
            message = vehicleArrayList.get(0).getMessage();  // get the first car
            currentCarIndex = 0;  // to indicate that there are cars in the ArrayList
        }

        carCountTextView.setText("Car: " + (currentCarIndex + 1) + " / " + vehicleArrayList.size());
        displayVehicleTextView.setText(message);  // Display the first car
    }

    public void onNextCarButtonClick(View view) {

        if (currentCarIndex != -1) {
            currentCarIndex++;   // to go the next car
            currentCarIndex = currentCarIndex%vehicleArrayList.size();  // get the remainder (4 items in the array list, index = 3++ = 4%4 = 0)

            Vehicle vehicle = vehicleArrayList.get(currentCarIndex);

            carCountTextView.setText("Car: " + (currentCarIndex + 1) + " / " + vehicleArrayList.size());
            displayVehicleTextView.setText(vehicle.getMessage());
        }
    }
}