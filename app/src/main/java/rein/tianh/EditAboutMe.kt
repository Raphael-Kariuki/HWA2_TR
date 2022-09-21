package rein.tianh

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import rein.tianh.sql.DBHelper

class EditAboutMe : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_about_me)

        //set actionBar title
        supportActionBar?.title = "Edit about me"

        val studentNameView = findViewById<TextInputEditText>(R.id.name_textInput)
        val studentMajorView = findViewById<TextInputEditText>(R.id.major_textInput)
        val submitBtn = findViewById<MaterialButton>(R.id.btnSubmit)



        val dbHelper = DBHelper(this)
        submitBtn.setOnClickListener{
            val studentName = studentNameView.text.toString()
            val studentMajor = studentMajorView.text.toString()

            Log.i("name and major", studentName + studentMajor)

            dbHelper.addStudentNameAndMajor(studentName,studentMajor)
        }
    }
}
