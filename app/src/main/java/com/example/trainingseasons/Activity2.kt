package com.example.trainingseasons

import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ListAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {

     private lateinit var listTv: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)

         listTv = findViewById(R.id.ListTv)


          val study = SportBase.study

     val adapter = ListAdapter(this,study)
         listTv.adapter = adapter

        listTv.onItemClickListener = AdapterView.OnItemClickListener {s,v,position,id ->

            val intent = Intent(this,Activity3::class.java)
               intent.putExtra("key",position)

            startActivity(intent)

        }



        }
    }
