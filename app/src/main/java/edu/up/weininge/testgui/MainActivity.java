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
import android.widget.ArrayAdapter;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /**
         External Citation
         Date: 20 September 2018
         Problem: Needed more screen space and wanted to get rid of the title bar and the
         notification bar
         Resource:
         https://stackoverflow.com/questions/2591036/how-to-hide-the-title-bar-for-an-activity-in-xml-with-existing-custom-theme
         Solution: I used the code from the stackoverflow post.
         */

        // remove title bar and notification bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // boardSurfaceView board is the custom SurfaceView
        boardSurfaceView board = (boardSurfaceView) findViewById(R.id.board);

        // create Canvas object
        Canvas canvas = new Canvas();

        // draw the board of hexagons and ports on the canvas
        board.createHexagons();
        board.createPorts();
        board.createHouses();


        board.draw(canvas);

        // the spinner that holds the development cards the player has
        Spinner developmentSpinner = (Spinner) findViewById(R.id.development_Card_Spinner);

        // spinner logic and handlers
        ArrayAdapter<CharSequence> developmentChoices = ArrayAdapter.createFromResource(this, R.array.resource_Card, android.R.layout.simple_spinner_item);
        developmentChoices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        developmentSpinner.setAdapter(developmentChoices);
    }
}
