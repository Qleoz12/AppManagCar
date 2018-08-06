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


        private int id;
        private String nombres;
        private String apellidos;
        private Date fechaNacimiento;
        private String identificacion;
        private String profesionOficio;
        private boolean estadoCivil;
        private Double IngresoMensual;
        private vehiculo vehiculoActual;


    public persona(int id, String nombres, String apellidos, Date fechaNacimiento, String identificacion, String profesionOficio, boolean estadoCivil, Double ingresoMensual, vehiculo vehiculoActual) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.identificacion = identificacion;
        this.profesionOficio = profesionOficio;
        this.estadoCivil = estadoCivil;
        this.IngresoMensual = ingresoMensual;
        this.vehiculoActual = vehiculoActual;
    }

    public persona(String nombres,
                   String apellidos,
                   Date fechaNacimiento,
                   String identificacion,
                   String profesionOficio,
                   boolean estadoCivil,
                   Double ingresoMensual,
                   vehiculo vehiculoActual) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.identificacion = identificacion;
        this.profesionOficio = profesionOficio;
        this.estadoCivil = estadoCivil;
        IngresoMensual = ingresoMensual;
        this.vehiculoActual = vehiculoActual;
    }

    public persona() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getProfesionOficio() {
        return profesionOficio;
    }

    public void setProfesionOficio(String profesionOficio) {
        this.profesionOficio = profesionOficio;
    }

    public boolean isEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(boolean estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Double getIngresoMensual() {
        return IngresoMensual;
    }

    public void setIngresoMensual(Double ingresoMensual) {
        IngresoMensual = ingresoMensual;
    }

    public vehiculo getVehiculoActual() {
        return vehiculoActual;
    }

    public void setVehiculoActual(vehiculo vehiculoActual) {
        this.vehiculoActual = vehiculoActual;
    }
}

