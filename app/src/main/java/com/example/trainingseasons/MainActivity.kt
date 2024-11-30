package com.example.trainingseasons

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

      private lateinit var imageTv: ImageView
      private lateinit var toolbar: Toolbar
      private lateinit var button1: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        button1 = findViewById(R.id.button1)


        // imageTv = findViewById(R.id.imageView)

        //  imageTv.setImageResource(R.drawable.unnamed)
        // Glide,whis(this)








        button1.setOnClickListener { startActivity(Intent(this,Activity3::class.java)) }

        toolbar.setBackgroundColor(Color.BLUE)
        toolbar.setTitleTextColor(Color.WHITE)
        title = "Тренировки по фитнесу"
      //  toolbar.setme



    }



        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.exitmenu,menu)
            return super.onCreateOptionsMenu(menu) }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
           AlertDialog.Builder(this).setTitle("Действительно выйти?")
               .setPositiveButton("Да") {s,v -> finishAffinity()}
               .setNegativeButton("Нет") {s,v -> s.cancel()}.create().show()
        return super.onOptionsItemSelected(item)
    }




    }
