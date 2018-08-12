package com.quileiasas.appmanagcar.Controller;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.quileiasas.appmanagcar.DB.personaDAO;
import com.quileiasas.appmanagcar.DB.historialDAO;
import com.quileiasas.appmanagcar.Model.historial;
import com.quileiasas.appmanagcar.Model.listPersona_adapter;
import com.quileiasas.appmanagcar.Model.persona;
import com.quileiasas.appmanagcar.Model.vehiculo;
import com.quileiasas.appmanagcar.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class listenersPersona
{
    personaDAO personaDAO;
    historialDAO historialDAO;
    Activity activity;

    private ArrayList<vehiculo> vehiculos;
    ArrayList<persona> listpersonas;
    vehiculo vehuculoselected;


    public listenersPersona( Activity activity,personaDAO personaDAO, ArrayList<persona> personas) {
        this.personaDAO = personaDAO;
        this.activity = activity;
        this.listpersonas = personas;
    }

    public void agreagarPersona(final listPersona_adapter obj)
    {

        final AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setCancelable(false);
        LinearLayout mView = (LinearLayout) activity.getLayoutInflater().inflate(R.layout.layout_addpersona, null);
        //elements
        alert.setView(mView);
        final AlertDialog dialogPadre = alert.create();

        //get elements
        final EditText valnombres=(EditText)mView.getChildAt(1);
        final EditText valapellidos=(EditText)mView.getChildAt(2);
        final EditText valfechaNacimiento=(EditText)mView.getChildAt(3);
        final EditText validentificacion=(EditText)mView.getChildAt(4);
        final EditText valprofesionOficio=(EditText)mView.getChildAt(5);
        LinearLayout mView2=(LinearLayout)mView.getChildAt(6);
        final Switch valestadoCivil=(Switch) mView2.findViewById(R.id.switch1);
        final EditText valIngresoMensual=(EditText)mView.getChildAt(7);
        valIngresoMensual.setInputType(InputType.TYPE_CLASS_NUMBER |
                InputType.TYPE_NUMBER_FLAG_DECIMAL );
        final EditText valVehiculoActual=(EditText)mView.getChildAt(8);


        //listener
        valfechaNacimiento.setFocusable(false);
        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                DataHolder.getInstance().setActivity(activity);
                DataHolder.getInstance().updateLabel(activity,valfechaNacimiento,myCalendar);

            }

        };

        valfechaNacimiento.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(activity, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();



            }
        });

        valVehiculoActual.setFocusable(false);
        valVehiculoActual.setOnClickListener(new View.OnClickListener()
        {@Override
            public void onClick(View v) {

                DataHolder.getInstance().setActivity(activity);
                vehiculos=DataHolder.getInstance().getCars(activity);
                String[] StringCars = new String[vehiculos.size()];

                if (vehiculos.size()>0)
                {
                    for (int i=0;i<vehiculos.size();i++)
                    {
                        StringCars[i]=vehiculos.get(i).toString();
                    }
                }
                else
                {
                    StringCars=new String[1];
                    StringCars[0]="No hay vehiculos disponibles";
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setTitle("Selecciona un vehiculo");
                builder.setCancelable(false);
                final String[] finalStringCars = StringCars;
                builder.setItems(StringCars, new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int item)
                    {

                        // will toast your selection
                        if (vehiculos.size()>0)
                        {
                            Toast.makeText(activity,"Seleccionaste: "+ item, Toast.LENGTH_LONG).show();
                            valVehiculoActual.setText(finalStringCars[item]);
                            vehuculoselected= vehiculos.get(item);
                        }
                        else
                        {
                            dialogPadre.dismiss();
                        }

                        dialog.dismiss();

                    }
                }).show();

            }
        });








        Button btnAceptar= (Button) mView.getChildAt(mView.getChildCount()-2);
        btnAceptar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Do stuff here

                personaDAO.insert(new persona(
                                                valnombres.getText().toString(),
                                                valapellidos.getText().toString(),
                                                DataHolder.getInstance().StringToDate(valfechaNacimiento.getText().toString()),
                                                validentificacion.getText().toString() ,
                                                valprofesionOficio.getText().toString(),
                                                (valestadoCivil.isChecked())? 1 : 0,
                                                Double.parseDouble(valIngresoMensual.getText().toString()),
                                                vehuculoselected));

                listpersonas.add((new persona(
                        valnombres.getText().toString(),
                        valapellidos.getText().toString(),
                        DataHolder.getInstance().StringToDate(valfechaNacimiento.getText().toString()),
                        validentificacion.getText().toString() ,
                        valprofesionOficio.getText().toString(),
                        (valestadoCivil.isChecked())? 1 : 0,
                        Double.parseDouble(valIngresoMensual.getText().toString()),
                        vehuculoselected)));

                obj.notifyItemInserted(listpersonas.size()-1);
                //h
                historialDAO = new historialDAO(activity,personaDAO.getlastpersona().getId());
                historialDAO.insert( new historial(personaDAO.getlastpersona().getId(), vehuculoselected.getId(),Calendar.getInstance().getTime()));
                dialogPadre.cancel();
            }
        });
        Button btnCancelar= (Button) mView.getChildAt(mView.getChildCount()-1);
        btnCancelar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Do stuff here
                System.out.println("cancelar ");
                dialogPadre.cancel();
            }
        });

        dialogPadre.show();
    }

    public ArrayList<persona> ModificarrPersona(final persona persona, final listPersona_adapter obj)
    {
        final AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setCancelable(false);
        LinearLayout mView = (LinearLayout) activity.getLayoutInflater().inflate(R.layout.layout_addpersona, null);
        alert.setView(mView);
        final AlertDialog dialogPadre = alert.create();



        //get elements
        final EditText valnombres=(EditText)mView.getChildAt(1);
        final EditText valapellidos=(EditText)mView.getChildAt(2);
        final EditText valfechaNacimiento=(EditText)mView.getChildAt(3);
        final EditText validentificacion=(EditText)mView.getChildAt(4);
        final EditText valprofesionOficio=(EditText)mView.getChildAt(5);
        LinearLayout mView2=(LinearLayout)mView.getChildAt(6);
        final Switch valestadoCivil=(Switch) mView2.findViewById(R.id.switch1);
        final EditText valIngresoMensual=(EditText)mView.getChildAt(7);
        final EditText valVehiculoActual=(EditText)mView.getChildAt(8);


        //set data
        valnombres.setText(persona.getNombres());
        valapellidos.setText(persona.getApellidos());
        valfechaNacimiento.setText(DataHolder.getInstance().DateToString(persona.getFechaNacimiento()));
        validentificacion.setText(""+persona.getIdentificacion());
        valprofesionOficio.setText(persona.getProfesionOficio());
        valestadoCivil.setChecked(persona.getEstadoCivil()> 0 ? true : false);
        valIngresoMensual.setText(""+persona.getIngresoMensual());
        valVehiculoActual.setText(persona.getVehiculoActual().toString());

        vehuculoselected=persona.getVehiculoActual();

        //set listeners
        //listener
        valfechaNacimiento.setFocusable(false);
        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {

                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                DataHolder.getInstance().setActivity(activity);
                DataHolder.getInstance().updateLabel(activity,valfechaNacimiento,myCalendar);

            }

        };

        valfechaNacimiento.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                new DatePickerDialog(activity, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();



            }
        });

        valVehiculoActual.setFocusable(false);
        valVehiculoActual.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick(View v) {

            DataHolder.getInstance().setActivity(activity);
            vehiculos=DataHolder.getInstance().getCars(activity);
            String[] StringCars = new String[vehiculos.size()];

            if (vehiculos.size()>0)
            {
                for (int i=0;i<vehiculos.size();i++)
                {
                    StringCars[i]=vehiculos.get(i).toString();
                }
            }
            else
            {
                StringCars=new String[1];
                StringCars[0]="No hay vehiculos disponibles";
            }
            final String[] finalStringCars = StringCars;

            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("Selecciona un vehiculo");
            builder.setItems(StringCars, new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int item) {

                    // will toast your selection
                    // will toast your selection
                    if (vehiculos.size()>0)
                    {
                        Toast.makeText(activity,"Seleccionaste: "+ item, Toast.LENGTH_LONG).show();
                        valVehiculoActual.setText(finalStringCars[item]);
                        vehuculoselected= vehiculos.get(item);
                    }
                    else
                    {
                        dialogPadre.dismiss();
                    }

                    dialog.dismiss();
                }
            }).show();

        }});

        Button btnAceptar= (Button) mView.getChildAt(mView.getChildCount()-2);
        btnAceptar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Do stuff here

                System.out.println("debug estado "+((valestadoCivil.isChecked())? 1 : 0));
                personaDAO.update(new persona(
                                persona.getId(),
                                valnombres.getText().toString(),
                                valapellidos.getText().toString(),
                                DataHolder.getInstance().StringToDate(valfechaNacimiento.getText().toString()),
                                validentificacion.getText().toString() ,
                                valprofesionOficio.getText().toString(),
                                (valestadoCivil.isChecked())? 1 : 0,
                                Double.parseDouble(valIngresoMensual.getText().toString()),
                                vehuculoselected));
                //h
                if (vehuculoselected.getId()!=persona.getVehiculoActual().getId())
                {
                    historialDAO = new historialDAO(activity,persona.getId());
                    historialDAO.insert( new historial( persona.getId(), vehuculoselected.getId(),Calendar.getInstance().getTime()));
                }

                obj.notifyDataSetChanged();
                dialogPadre.cancel();
            }
        });
        Button btnCancelar= (Button) mView.getChildAt(mView.getChildCount()-1);
        btnCancelar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Do stuff here
                System.out.println("cancelar update persona");
                dialogPadre.cancel();
            }
        });

        dialogPadre.show();
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
                        int itemindex=listpersonas.indexOf(persona);
                        listpersonas.remove(persona);
                        obj.notifyItemRemoved(itemindex);

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
