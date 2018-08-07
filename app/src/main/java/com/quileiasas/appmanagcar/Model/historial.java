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

    public historial(int id_persona, int id_vehiculo, Date fechaRegistro) {
        this.id_persona = id_persona;
        this.id_vehiculo = id_vehiculo;
        this.fechaRegistro = fechaRegistro;
    }

    public historial(int id, int id_persona, int id_vehiculo, Date fechaRegistro)
    {
        this.id = id;
        this.id_persona = id_persona;
        this.id_vehiculo = id_vehiculo;
        this.fechaRegistro = fechaRegistro;
    }

    public historial() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}

