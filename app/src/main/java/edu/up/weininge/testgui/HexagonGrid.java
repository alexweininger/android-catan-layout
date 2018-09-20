package edu.up.weininge.testgui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import java.util.ArrayList;

public class HexagonGrid extends boardSurfaceView {

    int x, y;
    ArrayList<Hexagon> hexagons = new ArrayList<Hexagon>();



    public HexagonGrid (Context context, int x, int y, int size){
        super(context);

        this.x = x;
        this.y = y;

        this.hexagons = getHexagons(x, y, size);

        setWillNotDraw(false);
    }

    public HexagonGrid (Context context, AttributeSet attrs, int x, int y, int size) {
        super(context, attrs);

        this.x = x;
        this.y = y;

        this.hexagons = getHexagons(x, y, size);

        setWillNotDraw(false);
    }

    protected void drawGrid(Canvas canvas) {

        for(Hexagon h: hexagons) {
            h.draw(canvas);
        }

    }

    protected ArrayList<Hexagon> getHexagons(int x, int y, int size) {
        ArrayList<Hexagon> hexagons = new ArrayList<Hexagon>();

        for(int i = 0; i < 5; i++) {
            Hexagon hexagon = new Hexagon(this.getContext(), (87*i), 100);
            hexagons.add(hexagon);
        }

        return hexagons;
    }





}
