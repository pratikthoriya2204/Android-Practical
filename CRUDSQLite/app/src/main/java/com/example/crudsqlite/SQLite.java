package com.example.crudsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLite extends SQLiteOpenHelper {
    public SQLite(Context context) {
        super(context,"gym",null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table gymMember(" +
                "ID integer primary key autoincrement," +
                "NAME TEXT," +
                "PHONE TEXT," +
                "EMAIL TEXT" +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists gymMember");
        onCreate(db);
    }

    public  boolean insertData(String Name,String Phone,String Email){
        SQLiteDatabase database =this.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("NAME",Name);
        values.put("PHONE",Phone);
        values.put("EMAIL",Email);
        long res = database.insert("gymMember",null,values);
        if(res == -1){
            return false;
        }else {
            return true;
        }
    }

    public boolean updateData(String Name,String Phone,String Email){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("NAME",Name);
        values.put("PHONE",Phone);
        values.put("EMAIL",Email);
        database.update("gymMember",values,"PHONE="+Phone,null);
        return true;
    }
    public  boolean deleteData(String Phone){
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete("gymMember","PHONE="+Phone,null);
        return true;
    }

    public Cursor ShowData(){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor =database.rawQuery("select * from gymMember",null);
        return cursor;
    }
}
