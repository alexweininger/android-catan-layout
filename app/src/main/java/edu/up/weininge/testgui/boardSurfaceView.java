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

    int size;
    HexagonGrid grid;

    public boardSurfaceView(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public boardSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    public void createHexagons() {
        grid = new HexagonGrid(this.getContext(), 100, 150, 150, 40);
    }


    public void onDraw(Canvas canvas) {
            grid.drawGrid(canvas);
    }
}
