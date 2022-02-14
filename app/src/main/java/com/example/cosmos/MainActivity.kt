package com.example.cosmos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    fun sendMessage() {
        val editTextFirstName: EditText = findViewById<EditText>(R.id.editTextFirstName)
        val editTextLastName: EditText = findViewById<EditText>(R.id.editTextLastName)
        val editTextEmailAddress: EditText = findViewById<EditText>(R.id.editTextEmailAddress)
        val editTextSubject: EditText = findViewById<EditText>(R.id.editTextSubject)
        val editTextTextMultiLine: EditText = findViewById<EditText>(R.id.editTextTextMultiLine)
        val imageView7: ImageView = findViewById<ImageView>(R.id.imageView7)
        val imageView8: ImageView = findViewById<ImageView>(R.id.imageView8)
        val imageView9: ImageView = findViewById<ImageView>(R.id.imageView9)
        imageView7.setImageResource(R.drawable.download6)
        //imageView8.setImageResource(R.drawable.stat_sys_phone_call)
        //imageView9.setImageResource(R.drawable.ic_menu_mylocation)
        Log.i("Info", "Button pressed")
        Log.i("First Name", editTextFirstName.text.toString())
        Log.i("Last Name", editTextLastName.text.toString())
        Log.i("Email Address", editTextEmailAddress.text.toString())
        Log.i("Subject", editTextSubject.text.toString())
        Log.i("Your Message", editTextTextMultiLine.text.toString())
        Toast.makeText(this, "Message sent!", Toast.LENGTH_SHORT).show()
    }

    fun clickFunction() {
        val imageButton: ImageButton = findViewById<ImageButton>(R.id.imageButton)
        val imageButton2: ImageButton = findViewById<ImageButton>(R.id.imageButton2)
        val imageButton3: ImageButton = findViewById<ImageButton>(R.id.imageButton3)
        val imageButton8: ImageButton = findViewById<ImageButton>(R.id.imageButton8)

        imageButton.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "Facebook Button",
                Toast.LENGTH_LONG
            ).show()
        }
        imageButton2.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "Twitter Button",
                Toast.LENGTH_LONG
            ).show()
        }
        imageButton3.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "Youtube Button",
                Toast.LENGTH_LONG
            ).show()
        }
        imageButton8.setOnClickListener {
            Toast.makeText(
                applicationContext,
                "Instagram Button",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout : DrawerLayout= findViewById(R.id.drawerLayout)
        val navView : NavigationView=findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.isHideOnContentScrollEnabled
        supportActionBar?.title
        //supportActionBar?.hide()

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> replaceFragment(Home(),it.title.toString())
                R.id.nav_aboutUS -> replaceFragment(AboutUs(),it.title.toString())
                R.id.nav_career -> Toast.makeText(applicationContext,"join us",Toast.LENGTH_SHORT).show()
                R.id.nav_services -> Toast.makeText(applicationContext,"Projects",Toast.LENGTH_SHORT).show()
                R.id.nav_contactUs -> replaceFragment(ContactUs(),it.title.toString())

            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment,title: String){
        val fragmentManager= supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()

        //drawerLayout.closeDrawers()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}