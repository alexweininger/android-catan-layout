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
    ArrayList<Ports> ports = new ArrayList<>();
    ArrayList<House> houses = new ArrayList<>();

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

    public void createPorts(){

        ports.add(new Ports(697, 50));
        ports.add(new Ports(1277, 50));
        ports.add(new Ports(230, 260));
        ports.add(new Ports(1450, 375));
        ports.add(new Ports(1450, 945));
        ports.add(new Ports(70, 650));
        ports.add(new Ports(270, 1210));
        ports.add(new Ports(697, 1400));
        ports.add(new Ports(1277, 1400));
    }

    public void createHouses(){

        Log.d("house", "yes");

        houses.add(new House(661, 272));
        houses.add(new House(1098, 529));
        houses.add(new House(516, 1043, Color.MAGENTA));
        houses.add(new House(661, 1300, Color.YELLOW));
    }
}
