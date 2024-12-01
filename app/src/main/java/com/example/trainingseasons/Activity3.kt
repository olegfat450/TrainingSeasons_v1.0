package com.example.trainingseasons

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pl.droidsonroids.gif.GifDrawable

class Activity3 : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var imageTv: ImageView
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var nameText: TextView
    private lateinit var descriptionText: TextView
    private lateinit var timeText: TextView

    lateinit var study: Sport
    var step = 0
    lateinit var gif: GifDrawable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_3)

        toolbar = findViewById(R.id.toolbar2)
        imageTv = findViewById(R.id.imageTv)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        nameText = findViewById(R.id.textTv1)
        descriptionText = findViewById(R.id.textTv2)
        timeText = findViewById(R.id.textTv3)



        setSupportActionBar(toolbar)

         step = intent.getIntExtra("key",0)

        val start = {

               timeText.setTextSize(16F)
               timeText.setTextColor(Color.BLACK)
                     if ( step >= SportBase.study.size-1 )  button3.setEnabled(false) else button3.setEnabled(true);
                     if ( step <= 0 ) button1.setEnabled(false) else button1.setEnabled(true)

                     study = SportBase.study[step]

                     nameText.setText("Упражнение ${step+1}: ${study.name}")
                     descriptionText.setText(study.description)
                     timeText.text = "${formatTime(study.time)} нажмите на картинку чтобы начать."

                   imageTv.setImageResource(SportBase.study[step].image)
                    gif = imageTv.drawable as GifDrawable

                  gif.pause()}

                            start()

                   imageTv.setOnClickListener { gif.start();display() }
                   button2.setOnClickListener { startActivity(Intent(this,MainActivity::class.java)); finish() }
                   button3.setOnClickListener { step++;  start() }
                   button1.setOnClickListener { step--;  start() }



        toolbar.setBackgroundColor(Color.BLUE)
        toolbar.setTitleTextColor(Color.WHITE)
        title = "   Тренировка"
    }






    fun display(){

        timeText.setTextSize(28F)
        timeText.setTextColor(Color.RED)

        val timer = object: CountDownTimer ( study.time*1000L,1000){
            override fun onTick(millisUntilFinished: Long) { timeText.text = formatTime((millisUntilFinished/1000).toInt());
                                                      button3.setEnabled(false); button1.setEnabled(false);imageTv.setEnabled(false) }
            override fun onFinish() { timeText.text = "Упражнение завершено"; gif.pause()
                if ( step > 0 ) button1.setEnabled(true); if ( step < SportBase.study.size) button3.setEnabled(true); imageTv.setEnabled(true) } }.start()
    }




    private fun formatTime(time: Int): String{

        val min = time/60
        val sec = time%60
        return String.format("%02d : %02d",min,sec)

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

