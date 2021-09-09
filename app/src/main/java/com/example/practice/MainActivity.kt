package com.example.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var timerTask: Timer? = null
        var sec: Int = 0
        val tv: TextView = findViewById(R.id.tv_hello)
        val btn: Button = findViewById(R.id.btn_kor)
        var isRunning = false

        btn.setOnClickListener {
            isRunning = !isRunning
            if (isRunning) {
                timerTask = kotlin.concurrent.timer(period = 1000) {
                    sec++
                    runOnUiThread() {
                        tv.text = sec.toString()
                    }
                }
            }
            else {
                timerTask?.cancel()
            }
        }


    }
}