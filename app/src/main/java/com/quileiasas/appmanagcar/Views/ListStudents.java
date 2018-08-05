package com.quileiasas.appmanagcar.Views;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;

import com.example.llancheros.kcpestudiantes.Controller.DataHolder;
import com.example.llancheros.kcpestudiantes.Model.Estudiante;
import com.example.llancheros.kcpestudiantes.Model.ListStudent_adapter;
import com.example.llancheros.kcpestudiantes.R;
import com.quileiasas.appmanagcar.Model.listVehiculo_adapter;
import com.quileiasas.appmanagcar.Model.vehiculo;
import com.quileiasas.appmanagcar.R;

import java.util.ArrayList;

public class ListStudents extends AppCompatActivity {

    private RecyclerView lista_R_vehiculos;
    private listVehiculo_adapter adp=null;
    private ArrayList<vehiculo> listvehiculos=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_vehiculos);

        //

        lista_R_vehiculos = (RecyclerView) findViewById(R.id.list_R);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lista_R_vehiculos.setLayoutManager(llm);

        load_data();
        inic_adapter();

    }



    public void AgreagarEstudiante(View v)
    {

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setCancelable(false);
        LinearLayout mView = (LinearLayout) getLayoutInflater().inflate(R.layout.layoutaddstudent, null);
        //elements
        final NumberPicker np;
        np=new NumberPicker(this);
        np.setMinValue(1);
        np.setMaxValue(11);
        mView.addView(np,mView.getChildCount()-2);
        alert.setView(mView);
        final AlertDialog dialog = alert.create();

        final EditText nombres=(EditText)mView.getChildAt(1);
        final EditText apeliidos=(EditText)mView.getChildAt(2);
        final EditText colegio=(EditText)mView.getChildAt(3);


        //set listeners
        Button btnAceptar= (Button) mView.getChildAt(mView.getChildCount()-2);
        btnAceptar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //Do stuff here

                adp.notifyDataSetChanged();
                dialog.cancel();
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
            }
        });

        dialog.show();
    }

    public  void load_data()
    {
        //verify if exist list before

        if (DataHolder.getInstance().getrows("Estudiante")>0)
        {
            listStudentData=DataHolder.get_Students();
        }
        else
        {
                listStudentData= new ArrayList<Estudiante>();
        }
    }

    public  void inic_adapter()
    {
        adp = new ListStudent_adapter(this, lista_R_students, (ArrayList<Estudiante>) listStudentData);
        lista_R_students.setAdapter(adp);

    }
}
