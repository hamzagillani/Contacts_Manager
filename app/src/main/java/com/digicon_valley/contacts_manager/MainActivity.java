package com.digicon_valley.contacts_manager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper dataBaseHelper;
    Button btn_inseart,btn_Sear,btn_del,btn_updat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBaseHelper=new DataBaseHelper(this);

        btn_inseart=findViewById(R.id.btn_addNew);
        btn_Sear=findViewById(R.id.btn_search);
        btn_del=findViewById(R.id.btn_delete);
        btn_updat=findViewById(R.id.btn_upgrade);

        btn_inseart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Add_new_Contact.class);
                startActivity(intent);
            }
        });

        btn_Sear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Search_data.class);
                startActivity(intent);

            }
        });

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Delete_Data.class);
                startActivity(intent);

            }
        });

        btn_updat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Update_data.class);
                startActivity(intent);

            }
        });
    }
}
