package com.example.cem_lab02_myvehicleapp;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyOwnVehicleActivity 123-";
    private EditText vehicleMakeEditText;  // link this to xml's EditText in onCreate()
    private EditText yearEditText;
    private EditText colourEditText;
    private EditText engineCapacityEditText;
    private Vehicle vehicle;
    private ArrayList<Vehicle> vehicleArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vehicleMakeEditText = findViewById(R.id.vehicleMakeEditText);  // link to xml's EditText
        yearEditText = findViewById(R.id.yearEditText);
        colourEditText = findViewById(R.id.colourEditText);
        engineCapacityEditText = findViewById(R.id.engineCapacityEditText);

        vehicleArrayList = new ArrayList<>();  // initialize to empty arrayList
    }

    public void onCreateVehicleButtonClick(View view) {
        // 1. Capture input from vehicleMakeEditText and yearEditText
        String vehicleMake = vehicleMakeEditText.getText().toString();
        String strYear = yearEditText.getText().toString();

        // Lab 03
        String colour = colourEditText.getText().toString();
        String strEngineCapacity = engineCapacityEditText.getText().toString();

        // 2. Create a Vehicle object based on the info above
        String message;
        if (isNotEmpty(vehicleMake) && isNotEmpty(strYear)
                && isNotEmpty(colour) && isNotEmpty(strEngineCapacity)) {  // if vehicle make is not empty, then we create obj
            // convert strYear to number
            int year = convertNumber(strYear, 2021);
            int engineCapacity = convertNumber(strEngineCapacity, 1598);
            vehicle = new Vehicle(vehicleMake, year, colour, engineCapacity);
            vehicleArrayList.add(vehicle);   // add vehicle to vehicleArrayList
            message = vehicle.getMessage();
            message += "\nYou have " + vehicleArrayList.size() + " vehicles now";
        } else {
            message = "Please enter a valid Vehicle Make, Year, Colour and Engine Capacity!";
        }

        // 3. Display the vehicle information using a Toast
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

        // 4. Log the application
        Log.d(TAG, "Number of times clicked: " + Vehicle.counter + "!");
    }

    public boolean isNotEmpty(String text) {
        return !text.trim().equals("");
    }

    public int convertNumber(String textNumber, int defaultNumber) {
        int number;
        try {
            number = Integer.parseInt(textNumber);
        } catch (NumberFormatException nfe) {
            number = defaultNumber;
        }
        return number;
    }

    public void onViewCarButtonClick(View view) {
        Intent intent = new Intent(this, DisplayVehicleActivity.class);
        intent.putExtra("allCars", vehicleArrayList);
        startActivity(intent);
    }
}