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
    Canvas canvas;
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
        //canvas.drawColor(Color.LTGRAY);
        this.canvas=canvas;

        paint = new Paint();
        Path path = new Path();

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor(this.color));


        canvas.drawRect(0,0,200,200, paint);

        path.moveTo(20, 0);
        path.lineTo(50, 0); // Bottom left
        path.lineTo(50, 50); // Bottom left

        canvas.save();
        canvas.clipRect(0,0,40,30);
        canvas.restore();

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

    public void drawCapoBaul(Canvas canvas,Path path)
    {
        path.moveTo(20, canvas.getHeight() /2 - 30); // Top
        path.lineTo(20, canvas.getHeight() /2 + 30); // Bottom left
        path.lineTo(canvas.getWidth()/2-50, canvas.getHeight()-80); // Bottom right
        path.lineTo(canvas.getWidth()/2-50, 80); // Back to Top

        canvas.drawPath(path, paint);

        path.moveTo(canvas.getWidth()-20, canvas.getHeight() /2 - 30); // Top
        path.lineTo(canvas.getWidth()-20, canvas.getHeight() /2 + 30); // Bottom left
        path.lineTo(canvas.getWidth()/2+50, canvas.getHeight()-80); // Bottom right
        path.lineTo(canvas.getWidth()/2+50, 80); // Back to Top

        canvas.drawPath(path, paint);
    }




    public void reDraw()

    {
        this.invalidate();
    }



}
