package com.quileiasas.appmanagcar.Model;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.quileiasas.appmanagcar.Controller.DataHolder;
import com.quileiasas.appmanagcar.Controller.listenersPersona;
import com.quileiasas.appmanagcar.Controller.listenersVehiculo;
import com.quileiasas.appmanagcar.R;

import java.util.ArrayList;

/**
 * Created by LLancheros on 24/04/2018.
 */

public class listPersona_adapter extends RecyclerView.Adapter<listPersona_adapter.Holder>
{
    Activity activity;
    RecyclerView lista;
    ArrayList<persona> _ArrayList;
    listenersPersona handler;
    listPersona_adapter adp;


    public listPersona_adapter(Activity activity, RecyclerView lista, ArrayList<persona>_ArrayList, listenersPersona handler)
    {
        this.activity = activity;
        this.lista=lista;
        this._ArrayList=_ArrayList;
        this.handler=handler;
        this.adp= this;
    }



    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_row_persona, parent, false);
        return new Holder(v);
    }


    @Override
    public void onBindViewHolder(final listPersona_adapter.Holder holder, final int position)
    {
        final persona persona = _ArrayList.get(position);
        holder.txtvalNombres.setText(persona.getNombres());
        holder.txtvalApellido.setText(persona.getApellidos());
        holder.txtvalFechanacimiento.setText(DataHolder.getInstance().DateToString(persona.getFechaNacimiento()));
        holder.txtvalIdentificacion.setText(""+persona.getIdentificacion());
        holder.txtvalProfesionuoficio.setText(persona.getProfesionOficio());
        holder.txtvalEstadocivil.setText(persona.getEstadoCivil()> 0 ? "Casado" : "No Casado");
        holder.txtvalIngresosMensuales.setText(""+persona.getIngresoMensual());
        holder.txtvalVehículoActual.setText(persona.getVehiculoActual().getModelo()+" --"+persona.getVehiculoActual().getMarca()+" --"+persona.getVehiculoActual().getPlaca());


        holder.btnBorrar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                System.out.println("borrar");
                handler.borrarpersona(persona, adp);


            }
        });

        holder.btnEditar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                _ArrayList=handler.ModificarrPersona(persona,adp);

            }
        });

        holder.btnHistorial.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                DataHolder.getInstance().setIDPersona(persona.getId());
                DataHolder.getInstance().gotoListHistorial();

            }
        });

    }


    @Override
    public int getItemCount() {
        return _ArrayList.size();
    }


    public static class Holder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView txtvalNombres;
        private TextView txtvalApellido;
        private TextView txtvalFechanacimiento;
        private TextView txtvalIdentificacion;
        private TextView txtvalProfesionuoficio;
        private TextView txtvalEstadocivil;
        private TextView txtvalIngresosMensuales;
        private TextView txtvalVehículoActual;
        //
        private Button btnEditar;
        private Button btnBorrar;
        private Button btnHistorial;


        public Holder(View itemView)
        {

            super(itemView);
            this.txtvalNombres = (TextView) itemView.findViewById(R.id.txtvalNombres);
            this.txtvalApellido =    (TextView) itemView.findViewById(R.id.txtvalApellido);
            this.txtvalFechanacimiento = (TextView) itemView.findViewById(R.id.txtvalFechanacimiento);
            this.txtvalIdentificacion = (TextView) itemView.findViewById(R.id.txtvalIdentificacion);
            this.txtvalProfesionuoficio = (TextView) itemView.findViewById(R.id.txtvalProfesionuoficio);
            this.txtvalEstadocivil = (TextView) itemView.findViewById(R.id.txtvalEstadocivil);
            this.txtvalIngresosMensuales = (TextView) itemView.findViewById(R.id.txtvalIngresosMensuales);
            this.txtvalVehículoActual = (TextView) itemView.findViewById(R.id.txtvalVehículoActual);

            this.btnBorrar= (Button) itemView.findViewById(R.id.btnBorrar);
            this.btnEditar= (Button) itemView.findViewById(R.id.btnEditar);
            this.btnHistorial= (Button) itemView.findViewById(R.id.btnHistorial);

            itemView.setOnClickListener(this);

        }




        @Override
        public void onClick(View v)
        {
            System.out.println("click");
        }
    }





}
