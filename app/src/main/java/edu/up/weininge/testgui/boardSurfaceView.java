package edu.up.weininge.testgui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class boardSurfaceView extends SurfaceView {

    ArrayList<Hexagon> hexagons = new ArrayList<>();

    public boardSurfaceView(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public boardSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    public void createHexagons() {
        int offsetX;
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 10; i++) {
                offsetX = (j % 2 == 0)? 100:0;
                hexagons.add(new Hexagon(this.getContext(), offsetX + 100 + 200 * i, 150 + 200 * j, 50));
            }
        }
    }


    public void onDraw(Canvas canvas) {

        for (int i = 0; i < hexagons.size(); i++) {
            hexagons.get(i).drawHexagon(canvas);

            Log.d("user", "called draw on hexagon at " + hexagons.get(i).x + ", " + hexagons.get(i).y);
        }
    }
}
