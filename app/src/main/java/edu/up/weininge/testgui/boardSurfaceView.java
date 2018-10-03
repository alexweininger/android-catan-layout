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

    ArrayList<Ports> ports = new ArrayList<>();
    ArrayList<House> houses = new ArrayList<>();

    int size;
    HexagonGrid grid;

    // constructors
    public boardSurfaceView(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public boardSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
    }

    // TODO Alex
    public void createHexagons() {

    	grid = new HexagonGrid(this.getContext(), 100, 200, 145, 40);
    }

    public void onDraw(Canvas canvas) {
        canvas.drawARGB(255, 237, 237, 171);
        grid.drawGrid(canvas);
        for(int i = 0; i < 9; i++){
            Log.d("user1", "" + i);
            ports.get(i).drawPort(canvas);
        }
        Log.d("house", "yeet");
        for(int j = 0; j < 4; j++){
            Log.d("house", "h" + j);
            houses.get(j).drawHouse(canvas);
        }
    }
}
