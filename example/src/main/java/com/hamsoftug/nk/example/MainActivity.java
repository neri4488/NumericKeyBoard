package com.hamsoftug.nk.example;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.hamsoftug.numerickeyboard.Nk_board;

public class MainActivity extends AppCompatActivity implements Nk_board.OnKeyBoard {

    private AppCompatEditText example_edit_text;
    private String typed_text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        example_edit_text = findViewById(R.id.example_edit_text);
    }

    private void appendText(String key){

        typed_text = typed_text.concat(key);

        example_edit_text.setText(typed_text);
    }

    private void clearText(){

        String str = typed_text;

        if (str != null && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }

        typed_text = str;

        example_edit_text.setText(typed_text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOnDeletePressed(View v) {
        clearText();
    }

    @Override
    public void onKeyPressed(int value) {
        appendText(String.valueOf(value));
    }

    @Override
    public void onOkPressed(View v) {
        Toast.makeText(v.getContext(), typed_text, Toast.LENGTH_SHORT).show();
    }
}
