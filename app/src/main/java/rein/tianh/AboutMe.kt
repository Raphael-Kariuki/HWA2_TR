package rein.tianh

import android.database.Cursor
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textview.MaterialTextView
import rein.tianh.contractClass.ReinDBContracts
import rein.tianh.sql.DBHelper

class AboutMe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_me)

        //set action bar title
        supportActionBar?.title = "About me"

        val name = findViewById<MaterialTextView>(R.id.nameFromDbView)
        val major = findViewById<MaterialTextView>(R.id.majorFromDbView)
        val dbHelper = DBHelper(this)
        val cursor = dbHelper.getNameAndMajor()
        cursor!!.moveToFirst()
        name.text = cursor.getString(cursor.getColumnIndexOrThrow(ReinDBContracts.DetailsEntry.COLUMN_NAME))
        major.text = cursor.getString(cursor.getColumnIndexOrThrow(ReinDBContracts.DetailsEntry.COLUMN_MAJOR))




    }


}
