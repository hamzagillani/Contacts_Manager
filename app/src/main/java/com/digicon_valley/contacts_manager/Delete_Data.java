package com.digicon_valley.contacts_manager;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete_Data extends AppCompatActivity {
    DataBaseHelper dataBaseHelper;
    Button btn_del,btn_view;
    EditText edit_del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete__data);
        dataBaseHelper=new DataBaseHelper(this);

        btn_del=(Button)findViewById(R.id.btn_delete);
        edit_del=(EditText)findViewById(R.id.edit_delete);
        btn_view=(Button)findViewById(R.id.btn_view);



        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Integer deleteRow= dataBaseHelper.deleteData(edit_del.getText().toString());
                if (deleteRow>0)
                    Toast.makeText(Delete_Data.this,"Data Deleted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Delete_Data.this,"Data not Found",Toast.LENGTH_SHORT).show();
                
            }
        });


       btn_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res= dataBaseHelper.getAllData();
                if(res.getCount()==0){
                    showMessage("Error","Nothing found");
                    return;
                }StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("ID :"+res.getString(0)+"\n");
                    buffer.append("Name :"+res.getString(1)+"\n");
                    buffer.append("Mobile Number :"+res.getString(2)+"\n");
                    buffer.append("Email :"+res.getString(3)+"\n\n");

                }

                showMessage("Data",buffer.toString());


            }
        });
    }
    public  void showMessage(String title,String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);

        builder.show();


}}
