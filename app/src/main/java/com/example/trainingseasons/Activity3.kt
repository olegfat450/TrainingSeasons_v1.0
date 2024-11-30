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

class Activity3 : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var imageTv: ImageView
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_3)

        toolbar = findViewById(R.id.toolbar2)
        imageTv = findViewById(R.id.imageTv)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)

        setSupportActionBar(toolbar)
             imageTv.setImageResource(R.drawable.download)
         //  imageTv.setImageResource(R.drawable.bc1)
        imageTv

       //  imageTv.setOnClickListener { imageTv.pau }

         // imageTv.stopNestedScroll()













        button2.setOnClickListener { startActivity(Intent(this,MainActivity::class.java)); finish() }


        toolbar.setBackgroundColor(Color.BLUE)
        toolbar.setTitleTextColor(Color.WHITE)
        title = "   Тренировка"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.exitmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        AlertDialog.Builder(this).setTitle("Действительно выйти?")
            .setPositiveButton("Да") { s, v -> finishAffinity() }
            .setNegativeButton("Нет") { s, v -> s.cancel() }.create().show()
        return super.onOptionsItemSelected(item)
    }
}