package com.gzd.trainingcutomview.onDraw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TestDrawLayout extends View {

    public TestDrawLayout(@NonNull Context context) {
        this(context, null);
    }

    public TestDrawLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);  //不可去除
        //background color，可以用于画背景颜色，可以绘制带透明度的
        canvas.drawColor(Color.RED);
        //其他图形
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(10);
        canvas.drawCircle(100,100, 50, paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(200, 50, 400, 350, paint);
        paint.setStrokeWidth(30);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawPoint(100,100, paint);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setColor(Color.RED);
        canvas.drawPoint(300, 200, paint);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(Color.WHITE);
        canvas.drawOval(500, 100, 800, 200, paint);
        canvas.drawLine(300, 300, 500, 600, paint);
        paint.setStrokeCap(Paint.Cap.SQUARE);
        paint.setStrokeWidth(10);
        canvas.drawLine(500, 600, 200, 800, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRoundRect(200, 400, 400, 700, 25, 10, paint);
        canvas.drawArc(200, 800, 400, 1100, 30, 90, true, paint);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(450, 800, 650, 1100, 30, -90, true,paint);
        canvas.drawArc(700, 800, 900, 1100, 90, 90, false, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(950, 800, 1150, 1100, 90, 90, false, paint);
        //path
        Path path = new Path();
//        path.addArc();
//        path.lineTo();
//        path.rLineTo();
//        path.moveTo();
    }
}
