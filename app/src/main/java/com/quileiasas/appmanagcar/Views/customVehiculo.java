package com.quileiasas.appmanagcar.Views;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.quileiasas.appmanagcar.Model.DrawCanvasCapoBaul;
import com.quileiasas.appmanagcar.Model.DrawCanvasCircle;
import com.quileiasas.appmanagcar.Model.DrawCanvasDoor;
import com.quileiasas.appmanagcar.R;

public class customVehiculo extends AppCompatActivity {


    DrawCanvasCircle pcc;
    DrawCanvasCapoBaul pcc2;
    DrawCanvasDoor pcc3;

    Spinner spinnerLLanta;
    Spinner spinnercapobaul;
    Spinner spinnerDoor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_vehiculo);
        //get the spinner from the xml.
        //create a list of items for the spinner.
        final String[] items = new String[]{"Amarillo", "Azul", "Rojo", "Verde"};

        pcc = findViewById(R.id.viewCircle);
        spinnerLLanta = findViewById(R.id.spinnerllanta);

        pcc2 = findViewById(R.id.viewcapobaul);
        spinnercapobaul = findViewById(R.id.spinnercapobaul);

        pcc3 = findViewById(R.id.viewpuerta);
        spinnerDoor = findViewById(R.id.spinnerpuerta);


        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        spinnerLLanta.setAdapter(adapter);
        spinnerLLanta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                pcc.changeColor(items[position]);
                pcc.reDraw();
                System.out.println("cambio "+items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adaptercapo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        spinnercapobaul.setAdapter(adaptercapo);
        spinnercapobaul.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                pcc2.changeColor(items[position]);
                pcc2.reDraw();
                System.out.println("cambio capo"+items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapterdoor = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        spinnerDoor.setAdapter(adapterdoor);
        spinnerDoor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                pcc3.changeColor(items[position]);
                pcc3.reDraw();
                System.out.println("cambio capo"+items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }


}
