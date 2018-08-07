package com.quileiasas.appmanagcar.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;


import com.quileiasas.appmanagcar.DB.historialDAO;
import com.quileiasas.appmanagcar.DB.historialDAO;
import com.quileiasas.appmanagcar.Model.listHistorial_adapter;
import com.quileiasas.appmanagcar.Model.historial;
import com.quileiasas.appmanagcar.R;

import java.util.ArrayList;

public class ListHistorial extends AppCompatActivity {

    private RecyclerView lista_R_historials;
    private listHistorial_adapter adp=null;
    private ArrayList<historial> listhistorials=null;
    historialDAO historialDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_historial);
    }

    public  void load_data()
    {
        //verify if exist list before

        if (historialDao.getall().size()>0)
        {
            listhistorials= historialDAO.getall();
        }
        else
        {
            listhistorials= new ArrayList<historial>();
        }
    }

    public  void inic_adapter()
    {
        adp = new listHistorial_adapter(this, lista_R_historials, listhistorials);
        lista_R_historials.setAdapter(adp);
    }

}
