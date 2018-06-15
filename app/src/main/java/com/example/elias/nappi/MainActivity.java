package com.example.elias.nappi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.Menu;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Matrix matrix= new Matrix();
    Float scale = 1f;
    ScaleGestureDetector SGD;

    private float dX;
    private float dY;
    private ArrayList<Integer> buttons;
    private int lastAction;
    private ImageView nappi;

    private View.OnTouchListener onTouchListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = new ArrayList<>();
        nappi = (ImageView) findViewById(R.id.nappi);
        SGD = new ScaleGestureDetector(this, new ScaleListener());


        nappi.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                addbutton();
                return false;
            }

        });


        onTouchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        lastAction = MotionEvent.ACTION_DOWN;
                        dX = v.getX() - event.getRawX();
                        dY = v.getY() - event.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        lastAction = MotionEvent.ACTION_MOVE;
                        v.setX(event.getRawX() + dX);
                        v.setY(event.getRawY()  + dY);
                        break;
                }
                return true;
            }
        };

    }

private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    @Override
    public boolean onScale(ScaleGestureDetector detector) {
        scale = scale * detector.getScaleFactor();
        scale = Math.max(0.1f, Math.min(scale, 5f));
        matrix.setScale(scale, scale);
        nappi.setImageMatrix(matrix);
        return true;
    }

}



    public void addbutton() {
Button b = new Button(this);
int id = View.generateViewId();
        b.setText("nappi");
        b.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT));
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout);
        rl.addView(b);
        b.setOnTouchListener(onTouchListener);
        float Xpos = 800.0f;
        float Ypos = 800.0f;
        b.setX(Xpos);
        b.setY(Ypos);


        //float, X, Y




    }

    public void setLastAction(int lastAction) {
        this.lastAction = lastAction;
    }
}


