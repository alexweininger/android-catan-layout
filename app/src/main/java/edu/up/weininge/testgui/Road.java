package edu.up.weininge.testgui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

public class Road {

    protected int[][] points;
    int position;
    protected int[][] roadPoints = {{0,0},{0,0}, {0,0}, {0,0}};

    public Road(int[][] points, int position) {
        this.points = points;
        this.position = position;
    }

    public void drawRoad(Canvas canvas) {

        int inP = this.position;
        int outP = this.position + 1;

        Paint line = new Paint();
        line.setColor(Color.DKGRAY);
        line.setStyle(Paint.Style.FILL);
        line.setStrokeWidth(10);

        roadPoints[0][0] = this.points[outP][0];
        roadPoints[0][1] = this.points[outP][1];

        roadPoints[1][0] = this.points[inP][0];
        roadPoints[1][1] = this.points[inP][1];

        canvas.drawLine(roadPoints[0][0], roadPoints[0][1], roadPoints[1][0], roadPoints[1][1], line);

    }


}
