package rein.tianh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        //inflate menu with menu in /res/menu
        menuInflater.inflate(R.menu.action_bar_actions, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home -> {
                startActivity(Intent(this@MainActivity, MainActivity::class.java))
            }
            R.id.Edit -> {
                startActivity(Intent(this@MainActivity, EditAboutMe::class.java))
            }
            R.id.aboutUs -> {
                startActivity(Intent(this@MainActivity, AboutMe::class.java))
            }
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set actionBar title
        supportActionBar?.title = "Ren's App"

        //initialize the button
        val showEmailBtn = findViewById<MaterialButton>(R.id.showEmailBtn)

        //setup an on-Click listener to show my email address
        showEmailBtn?.setOnClickListener {
            showEmail()
        }

        //log info to logcat
        Log.i("Informational text", "This is an on-click function firing the showEmail function")

    }

    //private function to show toast
    private fun showEmail(){
        Toast.makeText(this@MainActivity, "ren.tianh@northeastern.edu", Toast.LENGTH_SHORT).show()

    }
}