package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView game_tv;
        Button sglplaybtn;
        Button dualplaybtn ;

        game_tv=(TextView) findViewById(R.id.game_tv);
        sglplaybtn=(Button) findViewById(R.id.sglplaybtn);
        dualplaybtn=(Button) findViewById(R.id.dualplaybtn);

        sglplaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this , singleinfo.class) ;
                startActivity( intent);
            }
        });

        dualplaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(MainActivity.this , dual.class) ;
                startActivity( intent);
            }
        });


    }
}
