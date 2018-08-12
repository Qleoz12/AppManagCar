package com.quileiasas.appmanagcar.Views;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;


import com.quileiasas.appmanagcar.Controller.listenersVehiculo;
import com.quileiasas.appmanagcar.DB.vehiculoDAO;
import com.quileiasas.appmanagcar.Model.listVehiculo_adapter;
import com.quileiasas.appmanagcar.Model.vehiculo;
import com.quileiasas.appmanagcar.R;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ListVehiculos extends AppCompatActivity {

    private RecyclerView lista_R_vehiculos;
    private listVehiculo_adapter adp=null;
    private ArrayList<vehiculo> listvehiculos=null;
    vehiculoDAO Daovehiculo;
    listenersVehiculo handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vehiculos);

        //db
        Daovehiculo= new vehiculoDAO(this);

        //ac
        lista_R_vehiculos = (RecyclerView) findViewById(R.id.list_R);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lista_R_vehiculos.setLayoutManager(llm);

        load_data();
        inic_adapter();





    }



    public void AgreagarVehiculo(View v)
    {
        adp.AgreagarVehiculo();

        System.out.println("dddddd"+listvehiculos.toString());


    }


    public  void load_data()
    {
        //verify if exist list before

        if (Daovehiculo.getall().size()>0)
        {
            listvehiculos=vehiculoDAO.getall();
        }
        else
        {
            listvehiculos= new ArrayList<vehiculo>();
        }
    }

    public  void inic_adapter()
    {
        adp = new listVehiculo_adapter(this, lista_R_vehiculos, listvehiculos);
        lista_R_vehiculos.setAdapter(adp);
    }




}
