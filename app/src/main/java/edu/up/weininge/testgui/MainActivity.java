package edu.up.weininge.testgui;

import android.app.Activity;
import android.graphics.Canvas;
import android.support.constraint.Group;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends Activity {

    // TODO dev branch

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
	    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // boardSurfaceView board is the custom SurfaceView
        boardSurfaceView board = (boardSurfaceView) findViewById(R.id.board);

        // create Canvas object
        Canvas canvas = new Canvas();

        // draw the board of hexagons and ports on the canvas
        board.createHexagons();

        // TODO
        board.createPorts();
        board.createHouses();


        board.draw(canvas);

        Button scoreButton = (Button) findViewById(R.id.sidebar_button_score);
	    final Group scoreBoardGroup = (Group) findViewById(R.id.group_scoreboard);
        scoreButton.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View view) {
	        	if (scoreBoardGroup.getVisibility() == View.GONE) {
			        scoreBoardGroup.setVisibility(View.VISIBLE);
		        } else {
			        scoreBoardGroup.setVisibility(View.GONE);
		        }
	        }
        });

	    Button developmentButton = (Button) findViewById(R.id.sidebar_button_devcards);
	    final Group developmentGroup = (Group) findViewById(R.id.group_development_card_menu);
	    developmentButton.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View view) {
			    if (developmentGroup.getVisibility() == View.GONE) {
				    developmentGroup.setVisibility(View.VISIBLE);
			    } else {
				    developmentGroup.setVisibility(View.GONE);
			    }
		    }
	    });

	    // build menu layout group
	    final Group buildMenuGroup = (Group) findViewById(R.id.group_build_menu);

	    Button roadButton = (Button) findViewById(R.id.sidebar_button_road);

	    roadButton.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View view) {
			    if (buildMenuGroup.getVisibility() == View.GONE) {
				    buildMenuGroup.setVisibility(View.VISIBLE);
			    } else {
				    buildMenuGroup.setVisibility(View.GONE);
			    }
		    }
	    });

        // the spinner that holds the development cards the player has
        Spinner developmentSpinner = (Spinner) findViewById(R.id.development_Card_Spinner);

        // spinner logic and handlers
        ArrayAdapter<CharSequence> developmentChoices = ArrayAdapter.createFromResource(this, R.array.resource_Card, android.R.layout.simple_spinner_item);
        developmentChoices.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        developmentSpinner.setAdapter(developmentChoices);
    }

    // TODO cite this https://stackoverflow.com/questions/46065897/android-studio-how-to-remove-navigation-bar-in-android-app-to-get-a-full-screen
	@Override
	public void onWindowFocusChanged (boolean hasFocus) {
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus) {
			getWindow().getDecorView().setSystemUiVisibility(
					View.SYSTEM_UI_FLAG_LAYOUT_STABLE
							| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
							| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
							| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
							| View.SYSTEM_UI_FLAG_FULLSCREEN
							| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		}
	}
}
