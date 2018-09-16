package edu.up.weininge.testgui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceView;

public class boardSurfaceView extends SurfaceView {

    public boardSurfaceView(Context context) {
        super(context);


    }

    public void draw(Canvas canvas) {
        super.draw(canvas);

        Rect rect = new Rect(10, 10, 40, 40);
        Paint redRect = new Paint();

        canvas.drawRect(rect, redRect);

    }

}
