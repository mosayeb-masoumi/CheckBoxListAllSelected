package com.example.checkboxlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Adapter adapter;
    RecyclerView recyclerView;
    List<Model> listnames=new ArrayList<>();

    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        checkBox=findViewById(R.id.chkbox_all);
        recyclerView =findViewById(R.id.recyclerview);

        listnames.add(new Model("hassan"));
        listnames.add(new Model("reza"));
        listnames.add(new Model("gholam"));

        init_recyclerview(false);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    init_recyclerview(true);
                }else{
                    init_recyclerview(false);
                }
            }
        });


    }

    private void init_recyclerview(boolean state) {
        adapter=new Adapter(listnames,this ,state);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }
}
