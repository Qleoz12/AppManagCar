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
        paint.setAntiAlias(true);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor(this.color));

        drawCapoBaul(canvas,path);







        path.close();


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
        paint.setStyle(Paint.Style.FILL);

        path.moveTo(50, canvas.getHeight() /2 - 30); // Top
        path.lineTo(50, canvas.getHeight() /2 + 30); // Bottom left
        path.lineTo(canvas.getWidth()/2-50, canvas.getHeight()-50); // Bottom right
        path.lineTo(canvas.getWidth()/2-50, 50); // Back to Top
        canvas.drawPath(path, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(8);
        path.moveTo(50, canvas.getHeight() /2 - 30); // Top
        path.lineTo(50, canvas.getHeight() /2 + 30); // Bottom left
        path.lineTo(canvas.getWidth()/2-50, canvas.getHeight()-50); // Bottom right
        path.lineTo(canvas.getWidth()/2-50, 50); // Back to Top
        path.lineTo(48, canvas.getHeight() /2 - 30); // Top
        canvas.drawPath(path, paint);


        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor(color));
        path.moveTo(canvas.getWidth()-50, canvas.getHeight() /2 - 30); // Top
        path.lineTo(canvas.getWidth()-50, canvas.getHeight() /2 + 30); // Bottom left
        path.lineTo(canvas.getWidth()/2+50, canvas.getHeight()-50); // Bottom right
        path.lineTo(canvas.getWidth()/2+50, 50); // Back to Top
        canvas.drawPath(path, paint);

        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(8);
        path.moveTo(canvas.getWidth()-50, canvas.getHeight() /2 - 30); // Top
        path.lineTo(canvas.getWidth()-50, canvas.getHeight() /2 + 30); // Bottom left
        path.lineTo(canvas.getWidth()/2+50, canvas.getHeight()-50); // Bottom right
        path.lineTo(canvas.getWidth()/2+50, 50); // Back to Top
        path.lineTo(canvas.getWidth()-48, canvas.getHeight() /2 - 30); // Top
        canvas.drawPath(path, paint);
    }




    public void reDraw() {
        this.invalidate();
    }
}
