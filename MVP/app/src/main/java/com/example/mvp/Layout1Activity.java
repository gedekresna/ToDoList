package com.example.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mvp.Presenter.ILayout1Presenter;
import com.example.mvp.Presenter.Layout1Presenter;
import com.example.mvp.View.ILayout1View;

import java.util.ArrayList;

public class Layout1Activity extends AppCompatActivity implements ILayout1View {

    ILayout1Presenter layout1Presenter;

    ListView lvItems;
    Button btnAddItem, btnNextPage, btnUpdateItem;
    EditText newList;

    ArrayList<String> foods = new ArrayList<String>();
    ArrayAdapter myAdapter1;

    Integer indexVal;
    String item;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout1);

        //initialize view
        lvItems = (ListView)findViewById(R.id.lvItems);
        btnAddItem = (Button)findViewById(R.id.btnAddItem);
        btnNextPage = (Button)findViewById(R.id.btnNextPage);
        newList = (EditText)findViewById(R.id.newList);
        btnUpdateItem = (Button)findViewById(R.id.btnUpdateItem);



        //init
       layout1Presenter = new Layout1Presenter(this);
        myAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, foods);
        lvItems.setAdapter(myAdapter1);

        //Event ganti layout
        btnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openlayout2();
            }
        });

        //Add item list
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringval = newList.getText().toString();
                foods.add(stringval);

                newList.setText("");
            }
        });

        //Select Item list
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString() + " item has been selected";
                indexVal = position;
                Toast.makeText(Layout1Activity.this,item,Toast.LENGTH_SHORT).show();

            }
        });

        //Update Item list
        btnUpdateItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringval = newList.getText().toString();
                foods.set(indexVal,stringval);
            }
        });

        //Delete item list
        lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                item = parent.getItemAtPosition(position).toString() + " has been deleted";
                Toast.makeText(Layout1Activity.this,item,Toast.LENGTH_SHORT).show();

                foods.remove(position);
                myAdapter1.notifyDataSetChanged();

                return true;
            }
        });
    }

    public void openlayout2(){
        Intent intent = new Intent(this, Layout2Activity.class);
        startActivity(intent);
    }

    @Override
    public Context getContext() {
        return this;
    }
}