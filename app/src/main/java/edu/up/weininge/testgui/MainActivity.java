package edu.up.weininge.testgui;

import android.app.Activity;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

//Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boardSurfaceView board = (boardSurfaceView) findViewById(R.id.board);

        Canvas canvas = new Canvas();

//        Button buildMenuButton

        board.createHexagons();
        board.createPorts();


        board.draw(canvas);




        /*
        need to create listeners for every single button
         */

        //Spinner
        /*
        Spinner developmentSpinner = (Spinner) findViewById(R.id.development_Card_Spinner);
        ArrayAdapter<CharSequence> developmentChoices = ArrayAdapter.createFromResource(this,R.array.resource_Card, android.R.layout.simple_spinner_item);
        developmentChoices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        developmentSpinner.setAdapter(developmentChoices);*/

    }
}
