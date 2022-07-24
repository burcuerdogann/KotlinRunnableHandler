package com.burcuerdogan.kotlinrunnables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var number = 0
    lateinit var runnable : Runnable
    var handler : Handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun start(view: View){

        number = 0

        runnable = object : Runnable {
            override fun run() {

                number = number + 1
                textView.text = "Time: $number"

                handler.postDelayed(this,1000)

            }
        }
        handler.post(runnable)




    }

    fun stop(view: View){

        handler.removeCallbacks(runnable)
        number = 0
        textView.text = "Time: 0"

    }
}