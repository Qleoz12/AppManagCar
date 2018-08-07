package com.quileiasas.appmanagcar.Model;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.quileiasas.appmanagcar.Controller.DataHolder;
import com.quileiasas.appmanagcar.DB.vehiculoDAO;
import com.quileiasas.appmanagcar.R;

import java.util.ArrayList;

/**
 * Created by LLancheros on 24/04/2018.
 */

public class listHistorial_adapter extends RecyclerView.Adapter<listHistorial_adapter.Holder>
{
    Activity activity;
    RecyclerView lista;
    ArrayList<historial> _ArrayList;
    listHistorial_adapter adp;
    vehiculoDAO vehiculoDao;


    public listHistorial_adapter(Activity activity, RecyclerView lista, ArrayList<historial>_ArrayList)
    {
        this.activity = activity;
        this.lista=lista;
        this._ArrayList=_ArrayList;
    }



    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_row_historial, parent, false);
        return new Holder(v);
    }


    @Override
    public void onBindViewHolder(final listHistorial_adapter.Holder holder, final int position)
    {
        final historial historial = _ArrayList.get(position);
        holder.txtvalfecha.setText(DataHolder.getInstance().DateToString(historial.getFechaRegistro()));
        holder.txtvalvehiculo.setText(vehiculoDao.localizaPorId(historial.getId_vehiculo()).toString());


    }


    @Override
    public int getItemCount() {
        return _ArrayList.size();
    }


    public static class Holder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView txtvalfecha;
        private TextView txtvalvehiculo;




        public Holder(View itemView)
        {

            super(itemView);
            this.txtvalfecha = (TextView) itemView.findViewById(R.id.txtvalFecha);
            this.txtvalvehiculo =    (TextView) itemView.findViewById(R.id.txtvalvehiculo);


            itemView.setOnClickListener(this);

        }




        @Override
        public void onClick(View v)
        {
            System.out.println("click");
        }
    }





}
