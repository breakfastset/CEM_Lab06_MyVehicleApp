package com.example.cem_lab02_myvehicleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayVehicleActivity extends AppCompatActivity {
    private TextView displayVehicleMakeTextView;
    private TextView displayVehicleYearTextView;
    private TextView displayVehicleColourTextView;
    private TextView displayVehicleEngineCCTextView;
    private ArrayList<Vehicle>vehicleArrayList;
    private int currentCarIndex;
    private TextView carCountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_vehicle);

        displayVehicleMakeTextView = findViewById(R.id.displayVehicleMakeTextView);
        displayVehicleYearTextView = findViewById(R.id.displayVehicleYearTextView);
        displayVehicleColourTextView = findViewById(R.id.displayColourTextView);
        displayVehicleEngineCCTextView = findViewById(R.id.displayEngineCCTextView);
        carCountTextView = findViewById(R.id.carCountTextView);

        Intent intent = getIntent();
        vehicleArrayList = (ArrayList<Vehicle>) intent.getSerializableExtra("allCars");

        String vehicleMake = "";
        String vehicleYear = "";
        String vehicleColour = "";
        String vehicleEngineCC = "";
        currentCarIndex = -1;
        if (vehicleArrayList.size()!=0) {
            Vehicle currentVehicle = vehicleArrayList.get(0);
            vehicleMake = currentVehicle.getMake();  // get the first car
            vehicleYear = String.valueOf(currentVehicle.getYear());
            vehicleColour = currentVehicle.getColour();
            vehicleEngineCC = String.valueOf(currentVehicle.getEngineCapacity());
            currentCarIndex = 0;  // to indicate that there are cars in the ArrayList
        }

        updateLabels(currentCarIndex+1, vehicleMake, vehicleYear,
                vehicleColour, vehicleEngineCC);
    }

    public void onNextCarButtonClick(View view) {

        if (currentCarIndex != -1) {
            currentCarIndex++;   // to go the next car
            currentCarIndex = currentCarIndex%vehicleArrayList.size();  // get the remainder (4 items in the array list, index = 3++ = 4%4 = 0)

            Vehicle vehicle = vehicleArrayList.get(currentCarIndex);

            updateLabels(currentCarIndex+1, vehicle.getMake(), String.valueOf(vehicle.getYear()),
                    vehicle.getColour(), String.valueOf(vehicle.getEngineCapacity()));
        }
    }

    public void updateLabels(int carCount, String vehicleMake, String vehicleYear,
                             String vehicleColour,
                             String vehicleEngineCC) {
        carCountTextView.setText("Car: " + carCount + " / " + vehicleArrayList.size());
        displayVehicleMakeTextView.setText("Make: " + vehicleMake);
        displayVehicleYearTextView.setText("Year: " + vehicleYear);
        displayVehicleColourTextView.setText("Colour: " + vehicleColour);
        displayVehicleEngineCCTextView.setText("Engine CC: " + vehicleEngineCC);
    }
}