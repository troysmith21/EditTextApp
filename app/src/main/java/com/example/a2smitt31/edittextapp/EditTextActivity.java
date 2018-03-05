package com.example.a2smitt31.edittextapp;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class EditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_texteditor, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.loadmenutext) {
            try
            {
                FileReader fr = new FileReader(Environment.getExternalStorageDirectory().getAbsolutePath() + "/textedit.txt");
                BufferedReader reader = new BufferedReader(fr);
                String line = "", wholeFile = "";
                while((line = reader.readLine()) != null)
                {
                 wholeFile += line + "\n";
                }
                EditText et1 = (EditText)findViewById(R.id.et1);
                et1.setText(wholeFile);
                reader.close();
            }
            catch(IOException e)
            {
                new AlertDialog.Builder(this).setPositiveButton("OK", null).
                        setMessage("ERROR: " + e).show();

            }
            return true;
        }
        if (item.getItemId() == R.id.savemenutext) {
            EditText et1 = (EditText)findViewById(R.id.et1);
            try {
                PrintWriter pw = new PrintWriter( new FileWriter(Environment.getExternalStorageDirectory().getAbsolutePath() + "/textedit.txt"));
                pw.println(et1.getText().toString());
                pw.close();}
            catch(IOException e)
            {
                new AlertDialog.Builder(this).setPositiveButton("OK", null).
                        setMessage("ERROR: " + e).show();
            }

                return true;
        }


        return false;
    }

}



