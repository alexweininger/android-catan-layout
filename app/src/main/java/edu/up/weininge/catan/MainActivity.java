package edu.up.weininge.catan;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import edu.up.weininge.testgui.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boardSurfaceView board = (boardSurfaceView) findViewById(R.id.boardSurfaceView);

        Canvas canvas = new Canvas();






    }
}