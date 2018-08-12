package com.quileiasas.appmanagcar.Model;


import android.app.Activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.quileiasas.appmanagcar.Controller.listenersVehiculo;
import com.quileiasas.appmanagcar.DB.vehiculoDAO;
import com.quileiasas.appmanagcar.R;

import java.util.ArrayList;

/**
 * Created by LLancheros on 24/04/2018.
 */

public class listVehiculo_adapter extends RecyclerView.Adapter<listVehiculo_adapter.Holder>
{
    Activity activity;
    RecyclerView lista;
    ArrayList<vehiculo> _ArrayList;
    listenersVehiculo handler;
    listVehiculo_adapter adp;


    public listVehiculo_adapter(Activity activity, RecyclerView lista, ArrayList<vehiculo>_ArrayList)
    {
        this.activity = activity;
        this.lista=lista;
        this._ArrayList=_ArrayList;
        this.handler= new listenersVehiculo(activity,new vehiculoDAO(activity),_ArrayList);
        this.adp= this;
    }



    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_row_vehiculo, parent, false);
        return new Holder(v);
    }


    @Override
    public void onBindViewHolder(final listVehiculo_adapter.Holder holder, final int position)
    {
        final vehiculo vehiculo = _ArrayList.get(position);
        holder.txtvalplaca.setText(vehiculo.getPlaca());
        holder.txtvalmarca.setText(vehiculo.getMarca());
        holder.txtvalmodelo.setText(vehiculo.getModelo());
        holder.txtvalNpuertas.setText(""+vehiculo.getNumeroPuertas());
        holder.txtvalTipoVehiculo.setText(vehiculo.getTipoVehiculo());

        holder.btnBorrar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("borrar");
                handler.borrarVehiculo(vehiculo, adp);


            }
        });

        holder.btnEditar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                _ArrayList=handler.ModificarrVehiculo(vehiculo,adp);

            }
        });

    }

    public void AgreagarVehiculo()
    {
        handler.AgreagarVehiculo(this);
    }

    @Override
    public int getItemCount() {
        return _ArrayList.size();
    }




    public static class Holder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView txtvalplaca;
        private TextView txtvalmarca;
        private TextView txtvalmodelo;
        private TextView txtvalNpuertas;
        private TextView txtvalTipoVehiculo;
        //
        private Button btnEditar;
        private Button btnBorrar;


        public Holder(View itemView)
        {

            super(itemView);
            this.txtvalplaca = (TextView) itemView.findViewById(R.id.txtvalPlaca);
            this.txtvalmarca =    (TextView) itemView.findViewById(R.id.txtvalmarca);
            this.txtvalmodelo = (TextView) itemView.findViewById(R.id.txtvalModelo);
            this.txtvalNpuertas = (TextView) itemView.findViewById(R.id.txtvalNPuertos);
            this.txtvalTipoVehiculo = (TextView) itemView.findViewById(R.id.txtvalTipoVehiculo);
            this.btnBorrar= (Button) itemView.findViewById(R.id.btnBorrar);
            this.btnEditar= (Button) itemView.findViewById(R.id.btnEditar);

            itemView.setOnClickListener(this);

        }




        @Override
        public void onClick(View v)
        {
            System.out.println("click");
        }
    }





}
