package com.example.contacts100


import android.annotation.SuppressLint
import android.database.Cursor
import com.example.contacts100.DBhelper.Companion.ADDRESS_COL
import com.example.contacts100.DBhelper.Companion.COMPANY_COL
import com.example.contacts100.DBhelper.Companion.FIRSTNAME_COL
import com.example.contacts100.DBhelper.Companion.LASTNAME_COL

/*import com.example.contacts100.DBhelper.Companion.address
import com.example.contacts100.DBhelper.Companion.comp_name
import com.example.contacts100.DBhelper.Companion.first_name
import com.example.contacts100.DBhelper.Companion.last_name*/

class CursorToString {

    companion object{
        @SuppressLint("Range")
        fun  returnString(cursor: Cursor):String{



            val a = "Name : " + (cursor.getString(cursor.getColumnIndex(FIRSTNAME_COL))) + " " + (cursor.getString(cursor.getColumnIndex(
                LASTNAME_COL )))


            val b = "Company : " + (cursor.getString(cursor.getColumnIndex(COMPANY_COL)))
            val c = "Address : " + (cursor.getString(cursor.getColumnIndex(ADDRESS_COL)))


            return "$a $b $c"
        }
    }
}

/*class CursorToString {

    companion object{
        @SuppressLint("Range")
        fun  returnString(cursor: Cursor):String{



            val a = "Name : " + (cursor.getString(cursor.getColumnIndex(first_name))) + " " + (cursor.getString(cursor.getColumnIndex(
                last_name )))


            val b = "Company : " + (cursor.getString(cursor.getColumnIndex(comp_name)))
            val c = "Address : " + (cursor.getString(cursor.getColumnIndex(address)))


            return "$a $b $c"
        }
    }
}*/
