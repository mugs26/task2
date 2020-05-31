package com.example.task2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class customviews extends View {

    private static final int LINE_THICK = 5;
    private static final int ELT_MARGIN = 20;
    private static final int ELT_STROKE_WIDTH = 15;
    private int width, height, eltW, eltH;

    private Paint lPaint;
    private Paint oPaint;
    private Paint xPaint;


    int eventX = 0, eventY = 0;

    int playerscore1 = 0;
    int playerscore2 = 0;

    Rect[][] rect = new Rect[3][3];
    int[][] status = new int[3][3];

    int count = 0 ;


    public customviews(Context context) {
        super(context);
        init(null);

    }

    public customviews(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public customviews(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);

    }

    public customviews(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {
        lPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        lPaint.setColor(Color.BLUE);
        lPaint.setStyle(Paint.Style.STROKE);
        lPaint.setStrokeWidth(ELT_STROKE_WIDTH);
        oPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        oPaint.setColor(Color.RED);
        oPaint.setStyle(Paint.Style.STROKE);
        oPaint.setStrokeWidth(ELT_STROKE_WIDTH);
        xPaint = new Paint(oPaint);
        xPaint.setColor(Color.BLUE);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        height = MeasureSpec.getSize(heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        eltW = (width - LINE_THICK) / 3;
        eltH = (height - LINE_THICK) / 3;

        setMeasuredDimension(width, height);
    }


    private void drawGrid(Canvas canvas) {
        for (int i = 0; i < 2; i++) {
            // vertical lines
            float left = eltW * (i + 1);
            float right = left + LINE_THICK;
            float top = 0;
            float bottom = height;

            canvas.drawRect(left, top, right, bottom, lPaint);

            // horizontal lines
            float left2 = 0;
            float right2 = width;
            float top2 = eltH * (i + 1);
            float bottom2 = top2 + LINE_THICK;

            canvas.drawRect(left2, top2, right2, bottom2, lPaint);


        }
    }


    public void drawElt(Canvas canvas) {


        rect[0][0] = new Rect(0, 0, eltH, eltW);
        rect[0][1] = new Rect(eltW, 0, eltW * 2, eltH);
        rect[0][2] = new Rect(eltW * 2, 0, eltH, height);
        rect[1][0] = new Rect(0, eltH, 2 * eltH, eltW);
        rect[1][1] = new Rect(eltW, eltH, 2 * eltW, 2 * eltH);
        rect[1][2] = new Rect(2 * eltW, eltH, eltH * 2, width);
        rect[2][0] =new Rect (0,2*eltH,width,eltW) ;
        rect[2][1]=new Rect(eltW,2*eltW,height,2*eltW) ;
        rect[2][2]=new Rect(2*eltW,eltH*2,height,width) ;

        int i,j ;
        for (i = 1; i < 3; i++)
            for  (j= 1; j < 3; j++)
            {
                if (rect[i][j].contains(eventX, eventY)) {
                    canvas.drawRect(20,30,40,50, lPaint);
                    if (count % 2 == 0) {
                        float cx = (eltW * i) + eltW / 2;
                        float cy = (eltW * j) + eltH / 2;

                        canvas.drawCircle(cx, cy, Math.min(eltW, eltH) / 2 - ELT_MARGIN * 2, oPaint);
                        status[i][j] = 0;
                        canvas.drawRect(20,30,40,50, lPaint);
                        count++;
                    } else if (count % 2 != 0) {
                        float startX = (eltW * i) + ELT_MARGIN;
                        float startY = (eltH * j) + ELT_MARGIN;
                        float endX = startX + eltW - ELT_MARGIN * 2;
                        float endY = startY + eltH - ELT_MARGIN;

                        canvas.drawLine(startX, startY, endX, endY, xPaint);

                        float startX2 = (eltW * (i + 1)) - ELT_MARGIN;
                        float startY2 = (eltH * j) + ELT_MARGIN;
                        float endX2 = startX2 - eltW + ELT_MARGIN * 2;
                        float endY2 = startY2 + eltH - ELT_MARGIN;
                        canvas.drawRect(20,30,40,50, lPaint);
                        canvas.drawLine(startX2, startY2, endX2, endY2, xPaint);
                        status[i][j] = 1;
                        count++;
                    }


                }

                if ((status[0][0] == 0) && (status[1][0] == 0) && (status[2][0] == 0))
                    playerscore1++;

                else if ((status[0][1] == 0) && (status[1][1] == 0) && (status[2][1] == 0))
                    playerscore1++;
                else if ((status[0][2] == 0) && (status[1][2] == 0) && (status[2][2] == 0))
                    playerscore1++;
                else if ((status[0][0] == 0) && (status[0][1] == 0) && (status[0][2] == 0))
                    playerscore1++;
                else if ((status[1][0] == 0) && (status[1][1] == 0) && (status[1][2] == 0))
                    playerscore1++;
                else if ((status[2][0] == 0) && (status[2][1] == 0) && (status[2][2] == 0))
                    playerscore1++;
                else if ((status[0][0] == 0) && (status[1][1] == 0) && (status[2][2] == 0))
                    playerscore1++;
                else if ((status[2][0] == 0) && (status[1][1] == 0) && (status[0][2] == 0))
                    playerscore1++;

                if ((status[0][0] == 1) && (status[1][0] == 1) && (status[2][0] == 1))
                    playerscore2++;
                else if ((status[0][1] == 1) && (status[1][1] == 1) && (status[2][1] == 1))
                    playerscore2++;
                else if ((status[0][2] == 1) && (status[1][2] == 1) && (status[2][2] == 1))
                    playerscore2++;
                else if ((status[0][0] == 1) && (status[0][1] == 1) && (status[0][2] == 1))
                    playerscore2++;
                else if ((status[1][0] == 1) && (status[1][1] == 1) && (status[1][2] == 1))
                    playerscore2++;
                else if ((status[2][0] == 1) && (status[2][1] == 1) && (status[2][2] == 1))
                    playerscore2++;
                else if ((status[0][0] == 1) && (status[1][1] == 1) && (status[2][2] == 1))
                    playerscore2++;
                else if ((status[2][0] == 1) && (status[1][1] == 1) && (status[0][2] == 1))
                    playerscore2++;
            }

            }


    public boolean onTouchEvent(MotionEvent event) {
        if ( event.getAction() == MotionEvent.ACTION_DOWN) {
            int eventX = (int) (event.getX());
            int eventY = (int) (event.getY());

            invalidate();


            }


        return true ;

    }



    @Override
    protected void onDraw(Canvas canvas) {
        drawGrid(canvas);
         drawElt(canvas);




        }





}