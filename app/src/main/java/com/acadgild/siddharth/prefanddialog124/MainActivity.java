package com.acadgild.siddharth.prefanddialog124;

import android.content.DialogInterface;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    ListView lv;
    ListView lvv;
    String gete1,gete2,gete3;
    private ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;
    String finalstring="";
    EditText et;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvv = (ListView) findViewById(R.id.lv);
        et = (EditText) findViewById(R.id.et);
        finalstring = "";

        Button btn= (Button) findViewById(R.id.btn);
        arrayList = new ArrayList<String>();
        arrayList.add("Welcome");
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
        lvv.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.add(et.getText().toString());
                adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
                lvv.setAdapter(adapter);
            }
        });

     //   getSupportActionBar();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuu = getMenuInflater();
        menuu.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();
        if (menuId == R.id.save) {
            AlertDialog.Builder ab = new AlertDialog.Builder(this);
            ab.setTitle("Enter the details");
            View v = getLayoutInflater().inflate(R.layout.optionmenu, null);
            ab.setView(v);
            //lvv = (ListView) v.findViewById(R.id.lv);
            final EditText e1 = (EditText) v.findViewById(R.id.name);
            final EditText e2 = (EditText) v.findViewById(R.id.pno);
            final EditText e3 = (EditText) v.findViewById(R.id.date);

//            arrayList.add("Try");
            ab.setPositiveButton("save", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    arrayList = null;
                    gete1 = e1.getText().toString();
                  //  Toast.makeText(getApplicationContext(),gete1,Toast.LENGTH_SHORT).show();
                    gete2 = e2.getText().toString();
                    gete3 = e3.getText().toString();


                    finalstring = finalstring + (gete1) + "\n" + gete2 + "\n" + gete3;
                    arrayList.add(finalstring);
                    adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);
                    lvv.setAdapter(adapter);

                }
            });
            ab.show();


        }
        return super.onOptionsItemSelected(item);
    }
}
