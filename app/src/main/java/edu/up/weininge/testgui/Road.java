package edu.up.weininge.testgui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class Road {

    int[][] points;

    public Road(int[][] points) {
        this.points = points;
    }

    public void drawRoad(Canvas canvas) {
        Path roadPath = new Path();

        roadPath = new Path();
        roadPath.moveTo(points[0][0], points[0][1]);

        for(int i = 1; i < points.length; i++) {
            roadPath.lineTo(points[i][0], points[i][1]);
        }
        roadPath.close();

        Paint roadPaint = new Paint();
        roadPaint.setColor(Color.DKGRAY);
        roadPaint.setStyle(Paint.Style.FILL);

        canvas.drawPath(roadPath, roadPaint);
    }


}
