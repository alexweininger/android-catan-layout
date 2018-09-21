package edu.up.weininge.testgui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import java.util.ArrayList;

public class HexagonGrid extends boardSurfaceView {

    // instance variables
    protected int x, y;
    protected int height;
    protected double width;
    protected int margin;

    ArrayList<Hexagon> hexagons = new ArrayList<Hexagon>();

    public HexagonGrid (Context context, int x, int y, int size, int margin){
        super(context);
        setWillNotDraw(false);

        this.x = x;
        this.y = y;
        this.size = size;
        this.height = size * 2;
        this.width = size * Math.sqrt(3);
        this.margin = margin;

        getHexagons(x, y, size);

    }

    public HexagonGrid (Context context, AttributeSet attrs, int x, int y, int size, int margin) {
        super(context, attrs);
        setWillNotDraw(false);

        this.x = x;
        this.y = y;
        this.height = size * 2;
        this.width = size * (int) Math.sqrt(3);
        this.margin = margin;

        getHexagons(x, y, size);
    }

    protected void drawGrid(Canvas canvas) {
        for(Hexagon h: hexagons) {
            h.drawHexagon(canvas);
        }
    }

    protected void getHexagons(int x, int y, int size) {

        hexagons = new ArrayList<Hexagon>();

        int[] rows = {3, 4, 5, 4, 3};
        int offsetX;

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {

                offsetX = (j % 2 == 0)? (int) this.width/2 + margin/2:0;

                Hexagon hexagon = new Hexagon(this.getContext(), offsetX + x + (int) ((this.width + this.margin) * i), y + (((this.height) * 3)/4 + this.margin) * j, size);
                hexagons.add(hexagon);
            }
        }
    }





}
