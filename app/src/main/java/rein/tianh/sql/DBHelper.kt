package rein.tianh.sql

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log
import rein.tianh.contractClass.ReinDBContracts
import java.lang.Exception

//variables used to create and maintain database

//create
private const val SQL_CREATE_DETAILS_TABLE_ENTRIES = "CREATE TABLE ${ReinDBContracts.DetailsEntry.TABLE_NAME} (" +
        "${BaseColumns._ID} INTEGER PRIMARY KEY," + "${ReinDBContracts.DetailsEntry.COLUMN_NAME} TEXt," +
        "${ReinDBContracts.DetailsEntry.COLUMN_MAJOR} TEXT)"

//maintain
private const val SQL_DELETE_DETAILS_ENTRIES = "DROP TABLE IF EXISTS ${ReinDBContracts.DetailsEntry.TABLE_NAME}"

//The version should be changed everytime a change is made on the database
private const val DATABASE_VERSION = 1

//database name
private const val DATABASE_NAME = "studentDetails"

class DBHelper(context : Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {


    //function executed to create table, initialization of app
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(SQL_CREATE_DETAILS_TABLE_ENTRIES)
    }

    //when a change is made on the db
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is to simply to discard the data and start over
        db?.execSQL(SQL_DELETE_DETAILS_ENTRIES)
        onCreate(db)

    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    fun addStudentNameAndMajor(name: String, major: String){
        val cv = ContentValues()
        cv.put(ReinDBContracts.DetailsEntry.COLUMN_NAME, name)
        cv.put(ReinDBContracts.DetailsEntry.COLUMN_MAJOR, major)


        val db = this.writableDatabase
        try {
            db.insert(ReinDBContracts.DetailsEntry.TABLE_NAME,null,cv)
        }catch(e: Exception){
            e.printStackTrace()
        }finally {
            Log.i("Success", "Success")
        }
        db.close()
    }
    fun getNameAndMajor(): Cursor? {
        val db = this.writableDatabase
        return db.query(ReinDBContracts.DetailsEntry.TABLE_NAME,null,null,null,null,null,null)
    }

    
}