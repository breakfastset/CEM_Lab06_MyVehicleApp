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
    private EditText colourEditText;
    private EditText engineCapacityEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vehicleMakeEditText = findViewById(R.id.vehicleMakeEditText);  // link to xml's EditText
        yearEditText = findViewById(R.id.yearEditText);
        colourEditText = findViewById(R.id.colourEditText);
        engineCapacityEditText = findViewById(R.id.engineCapacityEditText);
    }

    public void onCreateVehicleButtonClick(View view) {
        // 1. Capture input from vehicleMakeEditText and yearEditText
        String vehicleMake = vehicleMakeEditText.getText().toString();
        String strYear = yearEditText.getText().toString();

        // Lab 03
        String colour = colourEditText.getText().toString();
        String strEngineCapacity = engineCapacityEditText.getText().toString();

        // 2. Create a Vehicle object based on the info above
        Vehicle vehicle;
        String message;
        if (isNotEmpty(vehicleMake) && isNotEmpty(strYear)
                && isNotEmpty(colour) && isNotEmpty(strEngineCapacity)) {  // if vehicle make is not empty, then we create obj
            // convert strYear to number
            int year = convertNumber(strYear, 2021);
            int engineCapacity = convertNumber(strEngineCapacity, 1598);
            vehicle = new Vehicle(vehicleMake, year, colour, engineCapacity);
            message = vehicle.getMessage();
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

}