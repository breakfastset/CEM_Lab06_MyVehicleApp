package com.example.cem_lab02_myvehicleapp;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyOwnVehicleActivity 123-";
    private EditText vehicleMakeEditText;  // link this to xml's EditText in onCreate()
    private EditText yearEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vehicleMakeEditText = findViewById(R.id.vehicleMakeEditText);  // link to xml's EditText
        yearEditText = findViewById(R.id.yearEditText);
    }

    public void onCreateVehicleButtonClick(View view) {
        // 1. Capture input from vehicleMakeEditText and yearEditText
        String vehicleMake = vehicleMakeEditText.getText().toString();
        String strYear = yearEditText.getText().toString();

        // 2. Create a Vehicle object based on the info above
        Vehicle vehicle;
        String message;
        if (!vehicleMake.trim().equals("")) {  // if vehicle make is not empty, then we create obj
            // convert strYear to number
            int year;
            try {
                year = Integer.parseInt(strYear);
            } catch (NumberFormatException nfe) {
                year = 2021;  // default to 2021 if cannot be converted
            }
            vehicle = new Vehicle(vehicleMake, year);
            message = vehicle.getMessage();
        } else {
            message = "Please enter a valid Vehicle Make and Year!";
        }

        // 3. Display the vehicle information using a Toast
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();

        // 4. Log the application
        Log.d(TAG, "Number of times clicked: " + Vehicle.counter + "!");
    }
}