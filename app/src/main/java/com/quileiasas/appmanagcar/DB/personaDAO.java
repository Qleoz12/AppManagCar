package com.quileiasas.appmanagcar.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.quileiasas.appmanagcar.Controller.DataHolder;
import com.quileiasas.appmanagcar.Model.persona;
import com.quileiasas.appmanagcar.Model.vehiculo;

import java.util.ArrayList;


public class personaDAO
{

        static Context context;
        private static ManagerSQLite dbsqLite;
        private static ArrayList<persona> listapersonas;

        public personaDAO(Context context)
        {
            this.context = context;
            dbsqLite = new ManagerSQLite(context);
            listar();
        }

        public boolean insert(persona persona)
        {
            SQLiteDatabase db = dbsqLite.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(persona.CAMPO_Nombres, persona.getNombres());
            values.put(persona.CAMPO_Apellidos, persona.getApellidos());
            values.put(persona.CAMPO_FechaNacimiento, DataHolder.getInstance().DateToString(persona.getFechaNacimiento()));
            values.put(persona.CAMPO_Identificacion, persona.getIdentificacion());
            values.put(persona.CAMPO_ProfesionOficio, persona.getProfesionOficio());
            values.put(persona.CAMPO_EstadoCivil, persona.getEstadoCivil());
            values.put(persona.CAMPO_IngresoMensual, persona.getIngresoMensual());
            values.put(persona.CAMPO_VehiculoActual, persona.getVehiculoActual().getId());

            Long id = db.insert(persona.TABLA, null, values);
            db.close();
            if (id > 0)
            {
                persona.setId(DataHolder.getInstance().safeLongToInt(id));
                listapersonas.add(persona);
            }
            return id > 0;
        }

        public boolean update(persona persona)
        {
            SQLiteDatabase db = dbsqLite.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(persona.CAMPO_Nombres, persona.getNombres());
            values.put(persona.CAMPO_Apellidos, persona.getApellidos());
            values.put(persona.CAMPO_FechaNacimiento, DataHolder.getInstance().DateToString(persona.getFechaNacimiento()));
            values.put(persona.CAMPO_Identificacion, persona.getIdentificacion());
            values.put(persona.CAMPO_ProfesionOficio, persona.getProfesionOficio());
            values.put(persona.CAMPO_EstadoCivil, persona.getEstadoCivil());
            values.put(persona.CAMPO_IngresoMensual, persona.getIngresoMensual());
            values.put(persona.CAMPO_VehiculoActual, persona.getVehiculoActual().getId());
            String where = persona.CAMPO_ID + " = ?";

            int id = db.update(persona.TABLA, values, where, new String[]{String.valueOf(persona.getId())});
            db.close();
            if (id > 0)
                listapersonas.set(listapersonas.indexOf(localizaPorId(persona.getId())), persona);
            return id > 0;
        }

        public boolean delete(persona persona) {
            return remove(persona.getId());
        }

        public boolean remove(int id)
        {
            SQLiteDatabase db = dbsqLite.getWritableDatabase();
            String where = persona.CAMPO_ID + " = ?";
            int ret = db.delete(persona.TABLA, where, new String[]{String.valueOf(id)});
            db.close();

            if (ret > 0)
                listapersonas.remove(localizaPorId(id));

            return ret > 0;
        }

        public static void listar()
        {
            SQLiteDatabase db = dbsqLite.getReadableDatabase();
            listapersonas = new ArrayList<>();

            String selectQuery = "SELECT  * " +" FROM " + persona.TABLA;

            Cursor cursor = db.rawQuery(selectQuery, null);
            persona persona;

            if (cursor.moveToFirst())
            {
                do
                {
                    persona = new persona();
                    persona.setId(cursor.getInt(0));
                    persona.setNombres(cursor.getString(1));
                    persona.setApellidos(cursor.getString(2));
                    persona.setFechaNacimiento(DataHolder.getInstance().StringToDate(cursor.getString(3)));
                    persona.setIdentificacion(cursor.getString(4));
                    persona.setProfesionOficio(cursor.getString(5));

                    persona.setEstadoCivil(cursor.getInt(6));
                    persona.setIngresoMensual(cursor.getDouble(7));
                    persona.setVehiculoActual(localizaPorIdVehiculo(cursor.getInt(8)));
                    listapersonas.add(persona);
                } while (cursor.moveToNext());
                db.close();
            }
        }

        public static Cursor listarData()
        {
            SQLiteDatabase db = dbsqLite.getReadableDatabase();
            String selectQuery = "SELECT  * " +" FROM " + persona.TABLA;
            return db.rawQuery(selectQuery, null);
        }
        public static ArrayList<persona> getall()
        {
            listar();
            return listapersonas;
        }
        public persona localizaPorId(int id)
        {
            for (persona auto : listapersonas)
                if (auto.getId() == id)
                    return auto;
            return null;
        }

        //
        public static vehiculo localizaPorIdVehiculo(int id)
        {
            vehiculoDAO vehiculoDAO= new vehiculoDAO(context);
            ArrayList<vehiculo> listavehiculos=vehiculoDAO.getall();
            for (vehiculo auto : listavehiculos)
                if (auto.getId() == id)
                    return auto;
            return null;
        }

    public persona getlastpersona()
    {
        getall();
        return listapersonas.get(listapersonas.size()-1);

    }
    }