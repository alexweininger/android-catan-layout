package edu.up.weininge.testgui;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boardSurfaceView gameBoardSurfaceView = new boardSurfaceView(this);

        Canvas canvas = new Canvas();


        gameBoardSurfaceView.draw(canvas);

    }
}