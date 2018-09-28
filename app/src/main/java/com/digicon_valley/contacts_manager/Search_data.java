package com.digicon_valley.contacts_manager;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Search_data extends AppCompatActivity {

    DataBaseHelper dataBaseHelper;
    EditText edit_s;
    Button btn_s;
    TextView textView_name,textView_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_data);
        dataBaseHelper=new DataBaseHelper(this);

        edit_s=(EditText)findViewById(R.id.edit_search);

        btn_s=(Button)findViewById(R.id.search_btn);

        textView_name=(TextView)findViewById(R.id.t_name);
        textView_email=findViewById(R.id.t_email);



        btn_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor=dataBaseHelper.getData(edit_s.getText().toString());

                while (cursor.moveToNext()){

                    textView_name.setText(cursor.getString(1));
                    textView_email.setText(cursor.getString(3));
                }

            }
        });
    }
}
