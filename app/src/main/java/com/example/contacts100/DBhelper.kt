package com.example.contacts100

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.lang.Exception

class DBhelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " (" +
                ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                FIRSTNAME_COL + " TEXT, " + LASTNAME_COL + " TEXT, " +
                COMPANY_COL + " TEXT, " + ADDRESS_COL + " TEXT, " +
                CITY_COL + " TEXT, " + COUNTRY_COL + " TEXT, " +
                STATE_COL + " TEXT, " + ZIP_COL + " TEXT, " +
                PHONE1_COL + " TEXT, " + PHONE2_COL + " TEXT, " +
                EMAIL_COL + " TEXT")
        db.execSQL(query)

    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addLine(line: String) {
        val myList: List<String> = line.split(",")
        val values = ContentValues()
        values.put(FIRSTNAME_COL, myList[0])
        values.put(LASTNAME_COL,myList[1])
        values.put(COMPANY_COL, myList[2])
        values.put(ADDRESS_COL, myList[3])
        values.put(CITY_COL, myList[4])
        values.put(COUNTRY_COL, myList[5])
        values.put(STATE_COL, myList[6])
        values.put(ZIP_COL, myList[7])
        values.put(PHONE1_COL, myList[8])
        values.put(PHONE2_COL, myList[9])
        values.put(EMAIL_COL, myList[10])


        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getLine(id: String): Cursor? {
        val db = this.readableDatabase
        return db.rawQuery("SELECT  *  FROM $TABLE_NAME WHERE $ID_COL = $id", null)
    }
    companion object{
        private val DATABASE_NAME = "CONTACTS_HOMEWORK"
        private val DATABASE_VERSION = 1
        val TABLE_NAME = "contacts"
        val ID_COL = "id"

        val FIRSTNAME_COL = "first_name"
        val LASTNAME_COL = "last_name"
        val COMPANY_COL = "company_name"
        val ADDRESS_COL = "address"
        val CITY_COL = "city"
        val COUNTRY_COL = "country"
        val STATE_COL = "state"
        val ZIP_COL = "zip"
        val PHONE1_COL = "first_phone"
        val PHONE2_COL = "second_phone"
        val EMAIL_COL = "email"
    }
}



/*
class DBhelper(context: Context, factory: SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + person_ID +" INTEGER PRIMARY KEY AUTOINCREMENT , " +
                first_name  + " TEXT, " +
                last_name   + " TEXT, " +
                comp_name +  " TEXT, " +
                address  +  " TEXT, " +
                city  + " TEXT, " +
                county + " TEXT, " +
                state + " TEXT, " +
                zip + " TEXT," +
                phone_one + "  TEXT," +
                phone_two + "  TEXT," +
                email + " TEXT " + ")")

        db.execSQL(query)
    }


    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addLine(line: String) {
        val myList: List<String> = line.split(",")
        val values = ContentValues()
        //ugly hardcoding
        values.put(first_name, myList[0])
        values.put(last_name,myList[1])
        values.put(comp_name, myList[2])
        values.put(address, myList[3])
        values.put(city, myList[4])
        values.put(county, myList[5])
        values.put(state, myList[6])
        values.put(zip, myList[7])
        values.put(phone_one, myList[8])
        values.put(phone_two, myList[9])
        values.put(email, myList[10])


        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getLine(id: String): Cursor?{
        val db = this.readableDatabase
        return db.rawQuery("SELECT  *  FROM $TABLE_NAME WHERE $person_ID = $id", null)
    }


    companion object{
        private const val DATABASE_NAME = "CONTACTS_HOMEWORK"
        private val DATABASE_VERSION = 1
        val TABLE_NAME = "contacts"
        val person_ID =  "id"
        val first_name = "first_name"
        val last_name = "last_name"
        val comp_name = "company_name"
        val address = "address"
        val city = "city"
        val county = "county"
        val state = "state"
        val zip = "zip"
        val phone_one = "phone_one"
        val phone_two = "phone_two"
        val email = "email"
    }

}*/
