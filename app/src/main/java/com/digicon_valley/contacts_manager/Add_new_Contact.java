package com.digicon_valley.contacts_manager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_new_Contact extends AppCompatActivity {
    private  DataBaseHelper dataBaseHelper;
    EditText v_name,v_mobile,v_email;
    Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new__contact);

        dataBaseHelper=new DataBaseHelper(this);

        v_name=findViewById(R.id.name_edit);
        v_mobile=findViewById(R.id.mobile_edit);
        v_email=findViewById(R.id.email_edit);
        btn_save=(Button) findViewById(R.id.save_btn);




        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean result= dataBaseHelper.inseatData(v_name.getText().toString(),v_mobile.getText().toString(),v_email.getText().toString());
                if (result)
                    Toast.makeText(Add_new_Contact.this, "Insert Data", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Add_new_Contact.this,"Data not Inserted",Toast.LENGTH_SHORT).show();



            }
        });

    }
}
