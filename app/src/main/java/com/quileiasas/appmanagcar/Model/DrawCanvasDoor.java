package com.quileiasas.appmanagcar.Model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;

public class DrawCanvasDoor extends View {

    Paint paint;
    String color="Green";
    public DrawCanvasDoor(Context mContext)
    {
        super(mContext);



    }


    public DrawCanvasDoor(Context context, AttributeSet attrs)
    {
        super(context, attrs);

    }
    public DrawCanvasDoor(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int padding=30;
        int porportion=3;
        int porportionb=2;


        paint = new Paint();
        Path path = new Path();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor( color));

        path.moveTo((canvas.getWidth()/porportion)+padding,canvas.getHeight()/porportion); // topL
        path.lineTo(canvas.getWidth()*porportionb/porportion+padding , canvas.getHeight()/porportion); //TopR
        path.lineTo(canvas.getWidth()*porportionb/porportion+padding , canvas.getHeight()*porportionb/porportion+padding ); //buttomR
        path.lineTo(canvas.getWidth()/porportion, canvas.getHeight()*porportionb/porportion+padding ); //buttomL
        path.lineTo(canvas.getWidth()/porportion, canvas.getHeight()/porportion+padding); //buttomLF
        canvas.drawPath(path,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);
        paint.setColor(Color.parseColor( "Black"));
        path.moveTo((canvas.getWidth()/porportion)+padding,canvas.getHeight()/porportion); // topL
        path.lineTo(canvas.getWidth()*porportionb/porportion+padding , canvas.getHeight()/porportion); //TopR
        path.lineTo(canvas.getWidth()*porportionb/porportion+padding , canvas.getHeight()*porportionb/porportion+padding ); //buttomR
        path.lineTo(canvas.getWidth()/porportion, canvas.getHeight()*porportionb/porportion+padding ); //buttomL
        path.lineTo(canvas.getWidth()/porportion, canvas.getHeight()/porportion+padding); //buttomLF
        path.lineTo((canvas.getWidth()/porportion)+padding,canvas.getHeight()/porportion); // topL


        canvas.drawPath(path,paint);

    }


    public void changeColor(String color)
    {
        if (color.equals("Amarillo"))
        {
            this.color="Yellow";
        }
        if (color.equals("Azul"))
        {
            this.color="cyan";
        }
        if (color.equals("Rojo"))
        {
            this.color="Magenta";
        }
        if (color.equals("Verde"))
        {
            this.color="Green";
        }

    }






    public void reDraw()

    {
        this.invalidate();
    }



}
