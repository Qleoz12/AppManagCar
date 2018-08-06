package com.quileiasas.appmanagcar.Controller;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.quileiasas.appmanagcar.DB.personaDAO;
import com.quileiasas.appmanagcar.Model.listPersona_adapter;
import com.quileiasas.appmanagcar.Model.persona;
import com.quileiasas.appmanagcar.R;

import java.util.ArrayList;

public class listenersPersona
{
    personaDAO personaDAO;
    Activity activity;

    public listenersPersona(personaDAO personaDAO, Activity activity) {
        personaDAO = personaDAO;
        this.activity = activity;
    }


    public void agreagarPersona(Activity activity,  final listPersona_adapter obj)
    {

        final AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setCancelable(false);
        LinearLayout mView = (LinearLayout) activity.getLayoutInflater().inflate(R.layout.layout_addpersona, null);
        //elements
        alert.setView(mView);
        final AlertDialog dialog = alert.create();

        //get elements
        final EditText valnombres=(EditText)mView.getChildAt(1);
        final EditText valapellidos=(EditText)mView.getChildAt(2);
        final EditText valfechaNacimiento=(EditText)mView.getChildAt(3);
        final EditText validentificacion=(EditText)mView.getChildAt(4);
        final EditText valprofesionOficio=(EditText)mView.getChildAt(5);
        final EditText valestadoCivil=(EditText)mView.getChildAt(6);
        final EditText valIngresoMensual=(EditText)mView.getChildAt(7);
        final EditText valpersonaActual=(EditText)mView.getChildAt(8);








        Button btnAceptar= (Button) mView.getChildAt(mView.getChildCount()-2);
        btnAceptar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Do stuff here
                personaDAO.insert(new persona(valnombres.getText().toString(),
                                              valapellidos.getText().toString(),
                                                DataHolder.getInstance().StringToDate(valfechaNacimiento.getText().toString()),
                                                validentificacion.getText().toString() ,
                                                valprofesionOficio.getText().toString(),
                                                DataHolder.getInstance().StringToEstadocivil(valestadoCivil.getText().toString()),
                                                Double.parseDouble(valIngresoMensual.getText().toString()),
                                                personaDAO.localizaPorIdVehiculo(Integer.parseInt(valpersonaActual.getText().toString())))
                                );
                dialog.cancel();
            }
        });
        Button btnCancelar= (Button) mView.getChildAt(mView.getChildCount()-1);
        btnCancelar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Do stuff here
                System.out.println("cancelar ");
                dialog.cancel();
            }
        });

        dialog.show();
    }

    public ArrayList<persona> ModificarrPersona(final persona persona, final listPersona_adapter obj)
    {
        final AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setCancelable(false);
        LinearLayout mView = (LinearLayout) activity.getLayoutInflater().inflate(R.layout.layout_addpersona, null);
        //elements
        alert.setView(mView);
        final AlertDialog dialog = alert.create();

        //get elements
        final EditText valnombres=(EditText)mView.getChildAt(1);
        final EditText valapellidos=(EditText)mView.getChildAt(2);
        final EditText valfechaNacimiento=(EditText)mView.getChildAt(3);
        final EditText validentificacion=(EditText)mView.getChildAt(4);
        final EditText valprofesionOficio=(EditText)mView.getChildAt(5);
        final EditText valestadoCivil=(EditText)mView.getChildAt(6);
        final EditText valIngresoMensual=(EditText)mView.getChildAt(7);
        final EditText valvehiculoActual=(EditText)mView.getChildAt(8);


        //set data
        valnombres.setText(persona.getNombres());
        valapellidos.setText(persona.getApellidos());
        valfechaNacimiento.setText(DataHolder.getInstance().DateToString(persona.getFechaNacimiento()));
        validentificacion.setText(""+persona.getIdentificacion());
        valprofesionOficio.setText(persona.getProfesionOficio());
        valestadoCivil.setText(DataHolder.getInstance().EstadocivilToString(persona.isEstadoCivil()));
        valIngresoMensual.setText(""+persona.getIngresoMensual());
        valvehiculoActual.setText(persona.getVehiculoActual().getModelo()+" --"+persona.getVehiculoActual().getMarca()+" --"+persona.getVehiculoActual().getPlaca());

        //set listeners


        Button btnAceptar= (Button) mView.getChildAt(mView.getChildCount()-2);
        btnAceptar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Do stuff here
                personaDAO.update(new persona(persona.getId(),
                                            valnombres.getText().toString(),
                                            valapellidos.getText().toString(),
                                            DataHolder.getInstance().StringToDate(valfechaNacimiento.getText().toString()),
                                            validentificacion.getText().toString() ,
                                            valprofesionOficio.getText().toString(),
                                            DataHolder.getInstance().StringToEstadocivil(valestadoCivil.getText().toString()),
                                            Double.parseDouble(valIngresoMensual.getText().toString()),
                                            personaDAO.localizaPorIdVehiculo(Integer.parseInt(valvehiculoActual.getText().toString()))
                                            ));
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
                System.out.println("cancelar update persona");
                dialog.cancel();
            }
        });

        dialog.show();
        return personaDAO.getall();
    }

    public void borrarpersona(final persona persona, final listPersona_adapter obj)
    {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage("Seguro que desea borrar esta persona")
                .setPositiveButton("acepto", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        personaDAO.remove(persona.getId());
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
