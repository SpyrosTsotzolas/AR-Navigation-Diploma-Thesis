package com.example.indoornavigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.indoornavigation.mapping.Location;
import com.example.indoornavigation.mapping.LocationFactory;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;

public class CurrentLocationActivity extends AppCompatActivity {

    private ArrayList<Integer> coordinates;
    public static final String COORDS_OF_ENTRANCE = "coordsOfEntrance";
    public static final String COORDS_OF_LOCATION = "coordsOfLocation";
    public static String SELECT_LOCATION_FROM = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_location);

        Button btnScanBarcode = findViewById(R.id.qrCodeButton);
        Button btnBlekasOffice = findViewById(R.id.btnBlekasOffice);
        Button btnVlachosOffice = findViewById(R.id.btnVlachosOffice);
        Button btnLykasOffice = findViewById(R.id.btnLykasOffice);
        Button btnZarrasOffice = findViewById(R.id.btnZarrasOffice);
        Button btnPolenakisOffice = findViewById(R.id.btnPolenakisOffice);
        Button btnMamoulisOffice = findViewById(R.id.btnMamoulisOffice);

        btnScanBarcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(CurrentLocationActivity.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Scan a barcode or QR code");
                integrator.setBeepEnabled(true);
                integrator.setBarcodeImageEnabled(true);
                integrator.initiateScan();
            }
        });

        clickButton(btnBlekasOffice, "blekasOffice");

        clickButton(btnVlachosOffice, "vlachosOffice");

        clickButton(btnLykasOffice, "lykasOffice");

        clickButton(btnZarrasOffice, "zarrasOffice");

        clickButton(btnPolenakisOffice, "polenakisOffice");

        clickButton(btnMamoulisOffice, "mamoulisOffice");

    }

    private void clickButton(Button locationButton, String location) {
        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocationFactory locationFactory = new LocationFactory();
                Location point = locationFactory.getLocation("CURRENTLOCATION", location);
                coordinates = point.getCoordinates();
                Intent intent = new Intent(CurrentLocationActivity.this, DestinationActivity.class);
                intent.putIntegerArrayListExtra(COORDS_OF_LOCATION, coordinates);
                SELECT_LOCATION_FROM = "fromMenu";
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "You set your location successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result  = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result!=null)
        {
            if(result.getContents()==null)
            {
                Toast.makeText(getBaseContext(), "Cancelled", Toast.LENGTH_LONG).show();
            }
            else
            {

                Intent intent = new Intent(CurrentLocationActivity.this, DestinationActivity.class);
                ArrayList<Integer> coordsOfEntrance = new ArrayList<>();
                coordsOfEntrance.add(6);
                coordsOfEntrance.add(958);
                coordsOfEntrance.add(229);
                intent.putIntegerArrayListExtra(COORDS_OF_ENTRANCE, coordsOfEntrance);
                SELECT_LOCATION_FROM = "fromQRCode";
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "You set your location successfully", Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), String.valueOf(result.getFormatName()), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), String.valueOf(result.getContents()), Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}