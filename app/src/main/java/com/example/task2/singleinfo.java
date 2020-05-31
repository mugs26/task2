package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class singleinfo extends AppCompatActivity {

    TextView sglplayer_tv;
    TextView splayer1_tv;
    EditText splayer1_ed;
    Button sglplaybtn ;
    String name1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singleinfo);




        sglplayer_tv=(TextView) findViewById(R.id.sglplayer_tv);
        splayer1_tv=(TextView) findViewById(R.id.splayer1_tv);
        sglplaybtn=(Button) findViewById(R.id.sglplaybtn) ;








        sglplaybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name1 = splayer1_ed.getText().toString() ;


                Intent intent;
                intent = new Intent(singleinfo.this, single.class);
                intent.putExtra("Name" , name1);

                startActivity(intent) ;
            }
        });


    }
    }

