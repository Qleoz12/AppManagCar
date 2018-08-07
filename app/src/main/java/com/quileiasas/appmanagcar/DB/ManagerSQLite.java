package com.quileiasas.appmanagcar.DB;

/**
 * Created by k.key on 12/05/2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.quileiasas.appmanagcar.Model.historial;
import com.quileiasas.appmanagcar.Model.persona;
import com.quileiasas.appmanagcar.Model.vehiculo;

public class ManagerSQLite extends SQLiteOpenHelper
{
        private static final String nombre_BASE = "base.db";
        private static final int version = 1;

        public ManagerSQLite(Context context)
        {
            super(context, nombre_BASE, null, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {


            String create_table_vehiculos = "CREATE TABLE " + vehiculo.TABLA  + "("
                    + vehiculo.CAMPO_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + vehiculo.CAMPO_Placa  + " TEXT ,"
                    + vehiculo.CAMPO_Marca  + " TEXT ,"
                    + vehiculo.CAMPO_Modelo  + " TEXT ,"
                    + vehiculo.CAMPO_NumeroPuertas  + " INTEGER,"
                    + vehiculo.CAMPO_TipoVehiculo + " TEXT )";

            String create_table_persona = "CREATE TABLE " + persona.TABLA  + "("
                    + persona.CAMPO_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + persona.CAMPO_Nombres+ " TEXT, "
                    + persona.CAMPO_Apellidos + " TEXT, "
                    + persona.CAMPO_FechaNacimiento + " TEXT, "
                    + persona.CAMPO_Identificacion + " TEXT, "
                    + persona.CAMPO_ProfesionOficio + " TEXT, "
                    + persona.CAMPO_EstadoCivil + " INTEGER, "
                    + persona.CAMPO_IngresoMensual + " REAL, "
                    + persona.CAMPO_VehiculoActual + " INTEGER,"
                    + " FOREIGN KEY ("+persona.CAMPO_VehiculoActual+") REFERENCES "+vehiculo.TABLA+"("+vehiculo.CAMPO_ID+"));";

            String create_table_historial= "CREATE TABLE " + historial.TABLA  + "("
                    + historial.CAMPO_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + historial.CAMPO_id_persona+ " INTEGER, "
                    + historial.CAMPO_id_vehiculo+ " INTEGER, "
                    + historial.CAMPO_fechaRegistro+ " TEXT, "
                    + " FOREIGN KEY ("+historial.CAMPO_id_persona+") REFERENCES "+persona.TABLA+"("+persona.CAMPO_ID+"),"
                    + " FOREIGN KEY ("+historial.CAMPO_id_vehiculo+") REFERENCES "+vehiculo.TABLA+"("+vehiculo.CAMPO_ID+"));";


            db.execSQL(create_table_vehiculos);
            db.execSQL(create_table_persona);
            db.execSQL(create_table_historial);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
}
