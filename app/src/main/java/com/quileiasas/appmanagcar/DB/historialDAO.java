package com.quileiasas.appmanagcar.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.quileiasas.appmanagcar.Controller.DataHolder;
import com.quileiasas.appmanagcar.Model.persona;
import com.quileiasas.appmanagcar.Model.historial;

import java.util.ArrayList;


public class historialDAO
{

        Context context;
        private static ManagerSQLite dbsqLite;
        private static ArrayList<historial> listahistorials;
        private static int persona;

        public historialDAO(Context context, int id)
        {
            this.context = context;
            dbsqLite = new ManagerSQLite(context);
            this.persona=id;
            listar(this.persona);
        }

        public boolean insert(historial historial)
        {
            SQLiteDatabase db = dbsqLite.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(historial.CAMPO_id_persona, historial.getId_persona());
            values.put(historial.CAMPO_id_vehiculo, historial.getId_vehiculo());
            values.put(historial.CAMPO_fechaRegistro, DataHolder.getInstance().DateToString(historial.getFechaRegistro()) );

            Long id = db.insert(historial.TABLA, null, values);
            db.close();
            if (id > 0)
            {
                historial.setId(DataHolder.getInstance().safeLongToInt(id));
                listahistorials.add(historial);
            }
            return id > 0;
        }

        public boolean update(historial historial)
        {
            SQLiteDatabase db = dbsqLite.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(historial.CAMPO_id_persona, historial.getId_persona());
            values.put(historial.CAMPO_id_vehiculo, historial.getId_vehiculo());
            values.put(historial.CAMPO_fechaRegistro, DataHolder.getInstance().DateToString(historial.getFechaRegistro()) );
            String where = historial.CAMPO_ID + " = ?";

            int id = db.update(historial.TABLA, values, where, new String[]{String.valueOf(historial.getId())});
            db.close();
            if (id > 0)
                listahistorials.set(listahistorials.indexOf(localizaPorId(historial.getId())), historial);
            return id > 0;
        }

        public boolean delete(historial historial) {
            return remove(historial.getId());
        }

        public boolean remove(int id)
        {
            SQLiteDatabase db = dbsqLite.getWritableDatabase();
            String where = historial.CAMPO_ID + " = ?";
            int ret = db.delete(historial.TABLA, where, new String[]{String.valueOf(id)});
            db.close();

            if (ret > 0)
                listahistorials.remove(localizaPorId(id));

            return ret > 0;
        }

        public static void listar(int id)
        {
            SQLiteDatabase db = dbsqLite.getReadableDatabase();
            listahistorials = new ArrayList<>();

            String selectQuery = "SELECT  * " +" FROM " + historial.TABLA +" WHERE "+historial.CAMPO_id_persona+"="+id;

            Cursor cursor = db.rawQuery(selectQuery, null);
            historial historial;

            if (cursor.moveToFirst())
            {
                do
                {
                    historial = new historial();
                    historial.setId(cursor.getInt(0));
                    historial.setId_persona(cursor.getInt(1));
                    historial.setId_vehiculo(cursor.getInt(2));
                    historial.setFechaRegistro(DataHolder.getInstance().StringToDate(cursor.getString(3)));

                    listahistorials.add(historial);
                } while (cursor.moveToNext());
                db.close();
            }
        }


        public static Cursor listarData()
        {
            SQLiteDatabase db = dbsqLite.getReadableDatabase();
            String selectQuery = "SELECT  * " +" FROM " + historial.TABLA;
            return db.rawQuery(selectQuery, null);
        }
        public static ArrayList<historial> getall()
        {
            listar(persona);
            return listahistorials;
        }



        public historial localizaPorId(int id)
        {
            for (historial auto : listahistorials)
                if (auto.getId() == id)
                    return auto;
            return null;
        }


    }