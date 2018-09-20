package edu.up.weininge.testgui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;

import org.w3c.dom.Attr;

public class Hexagon extends boardSurfaceView {

    protected int x;
    protected int y;
    protected int size;
    protected int color;
    protected Path hexagonPath;

    public Hexagon(Context context, int x, int y) {
        super(context);
        setWillNotDraw(false);

        this.x = x;
        this.y = y;
        this.size = 100;
        this.color = Color.RED;
    }

    public Hexagon(Context context, int x, int y, int size) {
        super(context);
        setWillNotDraw(false);

        this.x = x;
        this.y = y;
        this.size = size;
        this.color = Color.GREEN;
    }

    protected void drawHexagon(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.color);
        paint.setStyle(Paint.Style.FILL);

        int[][] points = calculateHexagonPoints(this.x, this.y, 100);
        Log.d("draw", "drawing a hexagon at" + this.x + ", " + this.y);
        Path hexagonPath = createHexagonPath(points);
        canvas.drawPath(hexagonPath, paint);

    }

    protected int[][] calculateHexagonPoints(int x, int y, int size) {
        int[][] points = new int[6][2];
        double angle_deg, angle_rad;
        for (int i = 0; i < 6; i++) {

            angle_deg = 60 * i - 30;
            angle_rad = Math.PI / 180 * angle_deg;

            points[i][0] = (int) (x + size * Math.cos(angle_rad));
            points[i][1] = (int) (y + size * Math.sin(angle_rad));

        }
        return points;
    }

    protected Path createHexagonPath(int[][] corners) {
        hexagonPath = new Path();
        hexagonPath.moveTo(corners[0][0], corners[0][1]);

        for(int i = 1; i < corners.length; i++) {
            hexagonPath.lineTo(corners[i][0], corners[i][1]);
        }
        hexagonPath.close();

        return hexagonPath;
    }
}
