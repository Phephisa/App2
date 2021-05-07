package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //creating the variables
    Button add_btt;
    EditText name_edtt;
    ListView list_vieww;
    //array list to store the names
    ArrayList<String> names =new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //linking variables to xml code
        add_btt = findViewById(R.id.add_bt);
        name_edtt = findViewById(R.id.name_edt);
        list_vieww = findViewById(R.id.list_view);

        //adapter to feed the array list,
        final  ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        add_btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //creating a string variable to to store the input text
                String input = name_edtt.getText().toString();

                list_vieww.setAdapter(adapter);
                names.add(input);
                //updating the list view - for any changes
                adapter.notifyDataSetChanged();



        };
    });
        // ListView on item selected listener.
        list_vieww.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                //creating a varibale that will get index on the name you have clicked on
                String data=(String)parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "you clicked " + data, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
