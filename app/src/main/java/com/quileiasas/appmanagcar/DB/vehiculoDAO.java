package com.quileiasas.appmanagcar.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.quileiasas.appmanagcar.Controller.DataHolder;
import com.quileiasas.appmanagcar.Model.vehiculo;
import java.util.ArrayList;


public class vehiculoDAO
{

        Context context;
        private static ManagerSQLite dbsqLite;
        private static ArrayList<vehiculo> listaVehiculos;

        public vehiculoDAO(Context context)
        {
            this.context = context;
            dbsqLite = new ManagerSQLite(context);
            listar();
        }

        public boolean insert(vehiculo vehiculo)
        {
            SQLiteDatabase db = dbsqLite.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(vehiculo.CAMPO_Placa, vehiculo.getPlaca());
            values.put(vehiculo.CAMPO_Marca, vehiculo.getMarca());
            values.put(vehiculo.CAMPO_Modelo, vehiculo.getModelo());
            values.put(vehiculo.CAMPO_NumeroPuertas, vehiculo.getNumeroPuertas());
            values.put(vehiculo.CAMPO_TipoVehiculo, vehiculo.getTipoVehiculo());

            Long id = db.insert(vehiculo.TABLA, null, values);
            db.close();
            if (id > 0)
            {
                vehiculo.setId(DataHolder.getInstance().safeLongToInt(id));
                listaVehiculos.add(vehiculo);
            }
            return id > 0;
        }

        public boolean update(vehiculo vehiculo)
        {
            SQLiteDatabase db = dbsqLite.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(vehiculo.CAMPO_Placa, vehiculo.getPlaca());
            values.put(vehiculo.CAMPO_Marca, vehiculo.getMarca());
            values.put(vehiculo.CAMPO_Modelo, vehiculo.getModelo());
            values.put(vehiculo.CAMPO_NumeroPuertas, vehiculo.getNumeroPuertas());
            values.put(vehiculo.CAMPO_TipoVehiculo, vehiculo.getTipoVehiculo());
            String where = vehiculo.CAMPO_ID + " = ?";

            int id = db.update(vehiculo.TABLA, values, where, new String[]{String.valueOf(vehiculo.getId())});
            db.close();
            if (id > 0)
                listaVehiculos.set(listaVehiculos.indexOf(localizaPorId(vehiculo.getId())), vehiculo);
            return id > 0;
        }

        public boolean delete(vehiculo vehiculo) {
            return remove(vehiculo.getId());
        }

        public boolean remove(int id)
        {
            SQLiteDatabase db = dbsqLite.getWritableDatabase();
            String where = vehiculo.CAMPO_ID + " = ?";
            int ret = db.delete(vehiculo.TABLA, where, new String[]{String.valueOf(id)});
            db.close();

            if (ret > 0)
                listaVehiculos.remove(localizaPorId(id));

            return ret > 0;
        }

        public static void listar()
        {
            SQLiteDatabase db = dbsqLite.getReadableDatabase();
            listaVehiculos = new ArrayList<>();

            String selectQuery = "SELECT  * " +" FROM " + vehiculo.TABLA;

            Cursor cursor = db.rawQuery(selectQuery, null);
            vehiculo vehiculo;

            if (cursor.moveToFirst())
            {
                do
                {
                    vehiculo = new vehiculo();
                    vehiculo.setId(cursor.getInt(0));
                    vehiculo.setPlaca(cursor.getString(1));
                    vehiculo.setMarca(cursor.getString(2));
                    vehiculo.setModelo(cursor.getString(3));
                    vehiculo.setNumeroPuertas(cursor.getInt(4));
                    vehiculo.setTipoVehiculo(cursor.getString(5));
                    listaVehiculos.add(vehiculo);
                } while (cursor.moveToNext());
                db.close();
            }
        }

        public static ArrayList<vehiculo> getall()
        {
            listar();
            return listaVehiculos;
        }
        public vehiculo localizaPorId(int id)
        {
            for (vehiculo auto : listaVehiculos)
                if (auto.getId() == id)
                    return auto;
            return null;
        }

        public vehiculo getlastVehiculo()
        {
            getall();
            return listaVehiculos.get(listaVehiculos.size()-1);

        }
    }