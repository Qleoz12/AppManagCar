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

import com.quileiasas.appmanagcar.Model.DrawCanvasCircle;
import com.quileiasas.appmanagcar.R;

public class customVehiculo extends AppCompatActivity {


    DrawCanvasCircle pcc;
    Spinner spinnerLLanta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_vehiculo);
        //get the spinner from the xml.
        //create a list of items for the spinner.
        final String[] items = new String[]{"Amarillo", "Azul", "Rojo", "Verde"};

        pcc = findViewById(R.id.viewCircle);
        spinnerLLanta = findViewById(R.id.spinnerllanta);


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

    }


}
