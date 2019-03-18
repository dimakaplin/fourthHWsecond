package com.dimakaplin143.appbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_open_notes) {
            Intent intent = new Intent(MainActivity.this, NotesActivity.class);
            startActivity(intent);

            return true;
        }
        else if (id == R.id.action_first) {
            Intent intent = new Intent(MainActivity.this, FirstActivity.class);
            startActivity(intent);

            return true;
        }
        else if (id == R.id.action_skull) {
            Intent intent = new Intent(MainActivity.this, SkullActivity.class);
            startActivity(intent);

            return true;
        }
        else if (id == R.id.edit_group) {
            Intent intent = new Intent(MainActivity.this, EditGroup.class);
            startActivity(intent);

            return true;
        }
        else if (id == R.id.photo) {
            Intent intent = new Intent(MainActivity.this, PhotoAlbum.class);
            startActivity(intent);

            return true;
        }
        else if (id == R.id.checkboxes) {
            Intent intent = new Intent(MainActivity.this, CheckBoxes.class);
            startActivity(intent);

            return true;
        }
        else if (id == R.id.calendar) {
            Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
            startActivity(intent);

            return true;
        }
        else if (id == R.id.spinner) {
            Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
