package com.quileiasas.appmanagcar.Controller;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.llancheros.kcpestudiantes.Model.Estudiante;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

    //crud Estudent



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
}