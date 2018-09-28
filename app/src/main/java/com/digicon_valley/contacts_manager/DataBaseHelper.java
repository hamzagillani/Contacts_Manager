package com.digicon_valley.contacts_manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="Contact.db";
    private static final String TABLE_NAME="Contact";
    private static final String MOBILE_NUMBER="MOBILE_NUMBER";
    private static final String NAME="NAME";
    private static final String EMAIL="EMAIL";

    public DataBaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE_NUMBER INTEGER,EMAIL TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public  boolean inseatData(String name, String mobile, String email){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("NAME",name);
        contentValues.put("MOBILE_NUMBER",mobile);
        contentValues.put("EMAIL",email);

       long result= db.insert(TABLE_NAME,null,contentValues);
            if(result==-1)
                return false;
            else
                return true;
    }

    public Cursor getData(String mobile_number) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE MOBILE_NUMBER = '" + mobile_number+ "'";

        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }

    public Integer deleteData(String mobile_number) {
        SQLiteDatabase db = this.getWritableDatabase();

       return db.delete(TABLE_NAME, "MOBILE_NUMBER = '" + mobile_number + "'", null);

    }
    public Cursor getAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return  res;
    }
    public boolean updateData(String number,String name,String email){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("NAME",name);
        contentValues.put("EMAIL",email);

        db.update(TABLE_NAME,contentValues,"MOBILE_NUMBER = '"+number+"'",null);
        return  true;

    }
}
