package com.example.fuelapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;
//DBHelper
public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME="login.db";
    public DBHelper(Context context) {
        super(context, "login.db", null, 1);
    }

    //create database
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(username TEXT primary key, password TEXT)");
        db.execSQL("create table owners(usernames TEXT primary key, passwords TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists users");
    }
//insert
    public Boolean insertDatas(String usernames, String passwords){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("usernames", usernames);
        values.put("passwords", passwords);

        long result = db.insert("owners", null, values);
        if(result==-1) return false;
        else
            return true;
    }
//insert
    public Boolean insertData(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("username", username);
        values.put("password", password);

        long result = db.insert("users", null, values);
        if(result==-1) return false;
        else
            return true;
    }
//validate
    public Boolean checkusernames (String usernames){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from owners where usernames=?", new String[] {usernames});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

//validate
    public Boolean checkusername(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=?", new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    //validate checkusername password
    public Boolean checkusernamepasswords(String usernames, String passwords){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from owners where usernames=? and passwords=?", new String[] {usernames, passwords});

        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }


//validate check username
    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from users where username=? and password=?", new String[] {username, password});

        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }


}
