package com.quileiasas.appmanagcar.Model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class DrawCanvasCircle extends View
{
    Paint paint;
    String color="Yellow";
    Canvas canvas;
    public DrawCanvasCircle(Context mContext)
    {
        super(mContext);



    }


    public DrawCanvasCircle(Context context, AttributeSet attrs)
    {
        super(context, attrs);

    }
    public DrawCanvasCircle(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawColor(Color.LTGRAY);
        this.canvas=canvas;
        int paddingoval=6;
        int ypointoval=canvas.getWidth()/10;
        int xpointoval=6;

        int xpointc=2;
        int widthcircle=60;


        paint = new Paint();

        //draw border
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        RectF rect = new RectF(canvas.getWidth()/xpointoval,ypointoval,canvas.getWidth()-(canvas.getWidth()/xpointoval),canvas.getHeight()-ypointoval);
        canvas.drawOval(rect,paint);

        //big
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor(color));
        rect = new RectF(canvas.getWidth()/xpointoval+paddingoval,ypointoval+paddingoval,canvas.getWidth()-(canvas.getWidth()/xpointoval)-paddingoval,canvas.getHeight()-ypointoval-paddingoval);
        canvas.drawOval(rect,paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        //draw border
        canvas.drawCircle(canvas.getWidth()/xpointc, canvas.getHeight()/xpointc, widthcircle, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor(color));
        paint.setAntiAlias(true);
        canvas.drawCircle
                (
                canvas.getWidth() / xpointc, // cx
                canvas.getHeight() / xpointc, // cy
                widthcircle -8, // Radius
                paint // Paint
                );





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


    public void reDraw() {
        this.invalidate();
    }
}