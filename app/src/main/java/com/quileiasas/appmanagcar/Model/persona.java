package com.quileiasas.appmanagcar.Model;

import java.util.Date;

public class persona
{

        public static final String TABLA = "Tbpersona";
        public static final String CAMPO_ID = "id";
        public static final String CAMPO_Nombres = "nombres";
        public static final String CAMPO_Apellidos = "apellidos";
        public static final String CAMPO_FechaNacimiento = "fechaNacimiento";
        public static final String CAMPO_Identificacion = "identificacion";
        public static final String CAMPO_ProfesionOficio = "profesionOficio";
        public static final String CAMPO_EstadoCivil = "estadoCivil";
        public static final String CAMPO_IngresoMensual = "ingresoMensual";
        public static final String CAMPO_VehiculoActual = "vehiculoActual";


        public int id;
        public String nombres;
        public String apellidos;
        public Date fechaNacimiento;
        public String identificacion;
        public int profesionOficio;
        public boolean estadoCivil;
        public Double IngresoMensual;
        public vehiculo vehiculoActual;


    public persona(int id, String nombres, String apellidos, Date fechaNacimiento, String identificacion, int profesionOficio, boolean estadoCivil, Double ingresoMensual, vehiculo vehiculoActual) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.identificacion = identificacion;
        this.profesionOficio = profesionOficio;
        this.estadoCivil = estadoCivil;
        IngresoMensual = ingresoMensual;
        this.vehiculoActual = vehiculoActual;
    }




}

