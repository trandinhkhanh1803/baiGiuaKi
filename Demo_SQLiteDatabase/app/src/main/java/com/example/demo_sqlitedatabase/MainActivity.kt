package com.example.demo_sqlitedatabase

import android.content.ContentValues
import android.content.DialogInterface
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var db : SQLiteDatabase
    lateinit var rs : Cursor
    lateinit var adapter: SimpleCursorAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


     var helper = MyHelper(applicationContext)
        var db = helper.readableDatabase

        var rs = db.rawQuery("SELECT * FROM ACTABLE",null)














        btInsert.setOnClickListener {
            var cv = ContentValues()
            cv.put("NAME", edName.text.toString())
            cv.put("EMAIL",edEmail.text.toString())
            cv.put("CONTACT",edContact.text.toString())
            cv.put("ADDRESS",edAddress.text.toString())
            db.insert("ACTABLE",null,cv)
            rs.requery()

            var ad = AlertDialog.Builder(this)
            ad.setTitle("Thong bao")
            ad.setMessage("Da them thanh cong")
            ad.setPositiveButton("OK",DialogInterface.OnClickListener { dialogInterface, i ->
                edName.setText("")
                edEmail.setText("")
                edContact.setText("")
                edAddress.setText("")
                edName.requestFocus()
            })
            ad.show()
        }





    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.add(101,11,1,"DELETE")
        menu?.setHeaderTitle("Removing Data")
    }




}