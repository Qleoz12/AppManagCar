package com.quileiasas.appmanagcar.Controller;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.quileiasas.appmanagcar.DB.vehiculoDAO;
import com.quileiasas.appmanagcar.Model.listVehiculo_adapter;
import com.quileiasas.appmanagcar.Model.vehiculo;
import com.quileiasas.appmanagcar.R;
import com.quileiasas.appmanagcar.Views.ListVehiculos;

import java.util.ArrayList;

import static com.quileiasas.appmanagcar.Controller.DataHolder.getActivity;

public class listenersVehiculo
{
    vehiculoDAO Daovehiculo;
    Activity activity;

    public listenersVehiculo(vehiculoDAO daovehiculo, Activity activity) {
        this.Daovehiculo = daovehiculo;
        this.activity = activity;
    }


    public Boolean AgreagarVehiculo(Activity activity,  final listVehiculo_adapter obj)
    {
        final Boolean[] resp = {false};
        final AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setCancelable(false);
        LinearLayout mView = (LinearLayout) activity.getLayoutInflater().inflate(R.layout.layout_addvehiculo, null);
        //elements
        alert.setView(mView);
        final AlertDialog dialog = alert.create();

        //get elements
        final EditText valplaca=(EditText)mView.getChildAt(1);
        final EditText valmarca=(EditText)mView.getChildAt(2);
        final EditText valmodelo=(EditText)mView.getChildAt(3);
        final EditText valNpuertas=(EditText)mView.getChildAt(4);
        final EditText valTipoVehiculo=(EditText)mView.getChildAt(5);




        //set listeners
        valplaca.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count)
            {
                final String placaval = valplaca.getText().toString();
                if (!DataHolder.getInstance().isValidPlaca(placaval))
                {
                    valplaca.setError("Placa Invalida");
                }
            }
        });

        valNpuertas.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count)
            {
                final String Npuertasval = valNpuertas.getText().toString();
                if (!DataHolder.getInstance().isValidNpuertas(Npuertasval)) {
                    valNpuertas.setError("numero invalido");
                }
            }
        });


        Button btnAceptar= (Button) mView.getChildAt(mView.getChildCount()-2);
        btnAceptar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Do stuff here
                Daovehiculo.insert(new vehiculo(valplaca.getText().toString(),valmarca.getText().toString(),valmodelo.getText().toString(),Integer.parseInt(valNpuertas.getText().toString()) ,valTipoVehiculo.getText().toString()));
                obj.notifyDataSetChanged();
                dialog.cancel();
                resp[0] = true;

            }
        });
        Button btnCancelar= (Button) mView.getChildAt(mView.getChildCount()-1);
        btnCancelar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Do stuff here
                System.out.println("cancelar estudiante");
                dialog.cancel();
                resp[0] = false;
            }
        });

        dialog.show();
        return resp[0];
    }

    public ArrayList<vehiculo> ModificarrVehiculo(final vehiculo vehiculo, final listVehiculo_adapter obj)
    {
        final AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setCancelable(false);
        LinearLayout mView = (LinearLayout) activity.getLayoutInflater().inflate(R.layout.layout_addvehiculo, null);
        //elements
        alert.setView(mView);
        final AlertDialog dialog = alert.create();

        //get elements
        final EditText valplaca=(EditText)mView.getChildAt(1);
        final EditText valmarca=(EditText)mView.getChildAt(2);
        final EditText valmodelo=(EditText)mView.getChildAt(3);
        final EditText valNpuertas=(EditText)mView.getChildAt(4);
        final EditText valTipoVehiculo=(EditText)mView.getChildAt(5);


        //set data
        valplaca.setText(vehiculo.getPlaca());
        valmarca.setText(vehiculo.getMarca());
        valmodelo.setText(vehiculo.getModelo());
        valNpuertas.setText(""+vehiculo.getNumeroPuertas());
        valTipoVehiculo.setText(vehiculo.getTipoVehiculo());

        //set listeners
        valplaca.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count)
            {
                final String placaval = valplaca.getText().toString();
                if (!DataHolder.getInstance().isValidPlaca(placaval))
                {
                    valplaca.setError("Placa Invalida");
                }
            }
        });

        valNpuertas.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count)
            {
                final String Npuertasval = valNpuertas.getText().toString();
                if (!DataHolder.getInstance().isValidNpuertas(Npuertasval)) {
                    valNpuertas.setError("numero invalido");
                }
            }
        });


        Button btnAceptar= (Button) mView.getChildAt(mView.getChildCount()-2);
        btnAceptar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Do stuff here
                Daovehiculo.update(new vehiculo(vehiculo.getId(),valplaca.getText().toString(),valmarca.getText().toString(),valmodelo.getText().toString(),Integer.parseInt(valNpuertas.getText().toString()) ,valTipoVehiculo.getText().toString()));
                obj.notifyDataSetChanged();
                dialog.cancel();
            }
        });
        Button btnCancelar= (Button) mView.getChildAt(mView.getChildCount()-1);
        btnCancelar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Do stuff here
                System.out.println("cancelar update vehiculo");
                dialog.cancel();
            }
        });

        dialog.show();
        return Daovehiculo.getall();
    }

    public void borrarVehiculo(final vehiculo vehiculo, final listVehiculo_adapter obj)
    {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage("Seguro que desea borrar este vehiculo")
                .setPositiveButton("acepto", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Daovehiculo.remove(vehiculo.getId());
                        obj.notifyDataSetChanged();

                    }
                })
                .setNegativeButton("Cancelo", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        builder.create();
        builder.show();
    }
}
