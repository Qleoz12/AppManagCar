package com.quileiasas.appmanagcar.Model;

import java.util.Date;

public class historial
{

        public static final String TABLA = "Tbhistorial";
        public static final String CAMPO_ID = "id";
        public static final String CAMPO_id_persona = "id_persona";
        public static final String CAMPO_id_vehiculo = "id_vehiculo";
        public static final String CAMPO_fechaRegistro = "fechaRegistro";


        public int id;
        public int id_persona;
        public int id_vehiculo;
        public Date fechaRegistro;


    public historial(int id, int id_persona, int id_vehiculo, Date fechaRegistro)
    {
        this.id = id;
        this.id_persona = id_persona;
        this.id_vehiculo = id_vehiculo;
        this.fechaRegistro = fechaRegistro;
    }
}

