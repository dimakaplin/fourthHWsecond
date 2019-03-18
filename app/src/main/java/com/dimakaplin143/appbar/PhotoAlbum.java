package com.dimakaplin143.appbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PhotoAlbum extends AppCompatActivity {

    public static int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        final int min = 1;
        final int max = 100;


        Button next = (Button) findViewById(R.id.next);
        Button back = (Button) findViewById(R.id.back);
        TextView number = (TextView) findViewById(R.id.numb);

        String s = String.format("%d", rnd(min, max));

        number.setText(s);

        next.setOnClickListener(v-> {
            count++;
            Intent intent = new Intent(PhotoAlbum.this,
                    PhotoAlbum.class);

            startActivity(intent);
        });

        back.setOnClickListener(v-> {
            if(count > 0) {
                count--;
                finish();
            }
            else {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Если вы закорете это окно то всему придет конец", Toast.LENGTH_LONG);
                toast.show();
            }

        });



    }

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }




}
