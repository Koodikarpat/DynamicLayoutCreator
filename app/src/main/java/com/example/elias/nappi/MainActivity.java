package com.example.elias.nappi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.Menu;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button nappi = (Button) findViewById(R.id.nappi);
           nappi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               addbutton();



            }
        });
    }
    public void addbutton() {
        Button b = new Button(this);
        b.setText("Tekstiä");
        b.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT));
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.layout);
        rl.addView(b);
    }


}

