package com.quileiasas.appmanagcar.Model;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class DrawCanvasCapoBaul extends View
{
    Paint paint;
    String color="Green";
    Canvas canvas;
    public DrawCanvasCapoBaul(Context mContext)
    {
        super(mContext);



    }


    public DrawCanvasCapoBaul(Context context, AttributeSet attrs)
    {
        super(context, attrs);

    }
    public DrawCanvasCapoBaul(Context context, AttributeSet attrs, int defStyle) {
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

        drawCapoBaul(canvas,path);







        path.close();


        canvas.drawPath(path, paint);

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




    public void reDraw() {
        this.invalidate();
    }
}
