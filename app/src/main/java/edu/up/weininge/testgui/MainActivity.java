package edu.up.weininge.testgui;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.SurfaceView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boardSurfaceView board = (boardSurfaceView) findViewById(R.id.boardSurfaceView);

        Canvas canvas = new Canvas();


        board.draw(canvas);

        //Spinner
        /*
        Spinner developmentSpinner = (Spinner) findViewById(R.id.development_Card_Spinner);
        ArrayAdapter<CharSequence> developmentChoices = ArrayAdapter.createFromResource(this,R.array.resource_Card, android.R.layout.simple_spinner_item);
        developmentChoices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        developmentSpinner.setAdapter(developmentChoices);*/

    }
}
