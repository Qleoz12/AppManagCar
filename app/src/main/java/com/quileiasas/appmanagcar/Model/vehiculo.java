package com.quileiasas.appmanagcar.Model;

public class vehiculo
{

        public static final String TABLA = "TbVehiculo";
        public static final String CAMPO_ID = "id";
        public static final String CAMPO_Placa = "placa";
        public static final String CAMPO_Marca = "marca";
        public static final String CAMPO_Modelo = "modelo";
        public static final String CAMPO_NumeroPuertas = "numeroPuertas";
        public static final String CAMPO_TipoVehiculo = "tipoVehiculo";



        private int id;
        private String placa;
        private String marca;
        private String modelo;
        private int numeroPuertas;
        private String tipoVehiculo;


    public vehiculo(int id, String placa, String marca, String modelo, int numeroPuertas, String tipoVehiculo) {
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroPuertas = numeroPuertas;
        this.tipoVehiculo = tipoVehiculo;
    }

    public vehiculo(String placa, String marca, String modelo, int numeroPuertas, String tipoVehiculo)
    {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroPuertas = numeroPuertas;
        this.tipoVehiculo = tipoVehiculo;
    }

    public vehiculo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }
}

