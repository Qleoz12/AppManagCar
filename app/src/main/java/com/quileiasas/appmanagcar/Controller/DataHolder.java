package com.quileiasas.appmanagcar.Controller;

import android.app.Activity;
import android.content.Intent;

import com.quileiasas.appmanagcar.Views.ListPersonas;
import com.quileiasas.appmanagcar.Views.ListVehiculos;
import com.quileiasas.appmanagcar.Views.LobbyAccess;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by k.key on 22/04/2018.
 */

public class DataHolder
{

    private static Activity activity;
    private static String data_dates="";



    //dont touch
    private static final DataHolder holder = new DataHolder();
    public static DataHolder getInstance() {return holder;}

    public static Activity getActivity() {
        return activity;
    }
    public static void setActivity(Activity activity) {
        DataHolder.activity = activity;
    }


    //utils
    public static int safeLongToInt(long l)
    {
        if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE)
        {
            throw new IllegalArgumentException
                    (l + " cannot be cast to int without changing its value.");
        }
        return (int) l;
    }

    public static String DateToString(Date dt)
    {
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");

        String strDt = simpleDate.format(dt);
        return strDt;
    }

    public static Date StringToDate(String dt)
    {

        DateFormat sourceFormat = new SimpleDateFormat("dd/MM/yyyy");

        Date date = null;
        try {
            date = sourceFormat.parse(dt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  date;
    }
    public static String EstadocivilToString(Boolean estado)
    {
        String res;
        if (estado)
        {
            res="Casado";
        }
        else
        {
            res="No Casado";
        }
        return res;
    }

    public static Boolean StringToEstadocivil(String estado)
    {

        if (estado.equals("Casado"))
        {
           return true;
        }
        else
        {
            return false;
        }

    }

    //utils to move
    public static void gotoListVehiculos()
    {
        Intent intent = new Intent(activity, ListVehiculos.class);
        activity.startActivity(intent);
    }

    public static void gotoListPersonas()
    {
        Intent intent = new Intent(activity, ListPersonas.class);
        activity.startActivity(intent);
    }

    public static void gotoLobby()
    {
        Intent intent = new Intent(activity, LobbyAccess.class);
        activity.startActivity(intent);
    }

    //utils
    //set validation
    protected boolean isValidPlaca(String placa)
    {
        String placa_PATTERN = "^[A-Za-z]{1,3}[0-9]{3,5}"+"$";

        Pattern pattern = Pattern.compile(placa_PATTERN);
        Matcher matcher = pattern.matcher(placa);
        return matcher.matches() && (placa.length()==6) ;
    }

    protected boolean isValidNpuertas(String n)
    {
        String placa_PATTERN = "^[0-9]{1,2}"+"$";

        Pattern pattern = Pattern.compile(placa_PATTERN);
        Matcher matcher = pattern.matcher(n);
        return matcher.matches() && (n.length()>0) ;
    }
}