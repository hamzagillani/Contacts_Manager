package com.digicon_valley.contacts_manager;

import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update_data extends AppCompatActivity {
    DataBaseHelper dataBaseHelper;
    EditText phn,nam,emailupdate;
    Button up_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_data);
        dataBaseHelper=new DataBaseHelper(this);
        phn=findViewById(R.id.uptade_phn);
        nam=findViewById(R.id.update_name);
        emailupdate=findViewById(R.id.update_email);
        up_btn=findViewById(R.id.update_btn);

        up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isupdated= dataBaseHelper.updateData(phn.getText().toString(),nam.getText().toString(),emailupdate.getText().toString());
                if (isupdated==true)
                    Toast.makeText(Update_data.this, "Data Update", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Update_data.this,"Data not Updated",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
