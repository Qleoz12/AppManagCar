package com.quileiasas.appmanagcar.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.quileiasas.appmanagcar.Controller.listenersPersona;
import com.quileiasas.appmanagcar.Controller.listenersVehiculo;
import com.quileiasas.appmanagcar.DB.personaDAO;
import com.quileiasas.appmanagcar.DB.vehiculoDAO;
import com.quileiasas.appmanagcar.Model.listPersona_adapter;
import com.quileiasas.appmanagcar.Model.listVehiculo_adapter;
import com.quileiasas.appmanagcar.Model.persona;
import com.quileiasas.appmanagcar.Model.vehiculo;
import com.quileiasas.appmanagcar.R;

import java.util.ArrayList;

public class ListPersonas extends AppCompatActivity {

    private RecyclerView lista_R_vehiculos;
    private listPersona_adapter adp=null;
    private ArrayList<persona> listpersonas=null;
    personaDAO personaDAO;
    listenersPersona handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_personas);

        //db
        personaDAO= new personaDAO(this);
        //handler
        handler= new listenersPersona(personaDAO,this);

        lista_R_vehiculos = (RecyclerView) findViewById(R.id.list_R);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lista_R_vehiculos.setLayoutManager(llm);

        load_data();
        inic_adapter();

    }



    public void AgreagarPersona(View v)
    {
        handler.agreagarPersona(this,adp);
    }


    public  void load_data()
    {
        //verify if exist list before

        if (personaDAO.getall().size()>0)
        {
            listpersonas=personaDAO.getall();
        }
        else
        {
            listpersonas= new ArrayList<persona>();
        }
    }

    public  void inic_adapter()
    {
        adp = new listPersona_adapter(this, lista_R_vehiculos, listpersonas, handler);
        lista_R_vehiculos.setAdapter(adp);

    }




}
