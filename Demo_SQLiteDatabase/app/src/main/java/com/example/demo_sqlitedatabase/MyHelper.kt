package com.example.demo_sqlitedatabase

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyHelper(context: Context) : SQLiteOpenHelper(context,"LOGIN",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE ACTABLE(_id integer primary key autoincrement,NAME TEXT, EMAIL TEXT,CONTACT TEXT,ADDRESS TEXT)")
        db?.execSQL("INSERT INTO ACTABLE(NAME, EMAIL, CONTACT,ADDRESS) VALUES ('khanh','khanh@gmail.com','vku','da nang')")


    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

}