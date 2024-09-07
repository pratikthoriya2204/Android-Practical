package com.example.foodorderapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.foodorderapp.Models.OrdersModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBNAME = "myData.db";
    final static int DBVERSION = 3;

    public DBHelper(@Nullable Context context) {
        super(context,DBNAME,null,DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table ordersTab(" +
                "id integer primary key autoincrement," +
                "name text," +
                "phone text," +
                "price int," +
                "image int," +
                "quantity int," +
                "description text," +
                "foodname text" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists ordersTab");
        onCreate(sqLiteDatabase);
    }

    public boolean insertOrder(String name,String phone,String description,String foodname,int image,int price,int quantity){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        /*
        id = 0 index
        name = 1 index
        phone = 2 index
        price = 3 index
        image = 4 index
        quantity = 5 index
        desc = 6 index
        foodname = 7 index

         */

        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("description",description);
        values.put("foodname",foodname);
        values.put("quantity",quantity);
        long id = database.insert("ordersTab",null,values);
        if(id <= 0){
            return false;
        }else{
            return true;
        }
    }

    public ArrayList<OrdersModel> getOrders(){
        ArrayList<OrdersModel> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id,foodname,image,price from ordersTab",null);

        if(cursor.moveToFirst()){
            while(cursor.moveToNext()){
                OrdersModel model = new OrdersModel();
                model.setOrderNumber(cursor.getInt(0) +"");
                model.setSoldItemName(cursor.getString(1));
                model.setOrderImage(cursor.getInt(2));
                model.setPrice(cursor.getInt(3) +"");
                orders.add(model);
            }
        }
        cursor.close();
        database.close();
        return orders;
      }

      public Cursor getOrderById(int id){
          SQLiteDatabase database = this.getWritableDatabase();
          Cursor cursor = database.rawQuery("Select * from ordersTab where id = " + id,null);
          if(cursor != null){
              cursor.moveToFirst();
          }
          return cursor;
      }

    public boolean updateOrder(String name, String phone, int price,int image,String description, String foodname, int quantity,int id){
        SQLiteDatabase database = getReadableDatabase();
        /*
        id = 0 index
        name = 1 index
        phone = 2 index
        price = 3 index
        image = 4 index
        quantity = 5 index
        desc = 6 index
        foodname = 7 index

         */
        ContentValues values = new ContentValues();

        values.put("name",name);
        values.put("phone",phone);
        values.put("price",price);
        values.put("image",image);
        values.put("quantity",quantity);
        values.put("description",description);
        values.put("foodname",foodname);
        long row = database.update("ordersTab",values,"id="+id,null);
        if(row <= 0){
            return false;
        }else{
            return true;
        }
    }

    public int deleteOrder(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("ordersTab","id="+id,null);
    }




}
