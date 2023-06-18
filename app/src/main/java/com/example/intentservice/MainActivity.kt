package com.example.intentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var btnStart: Button
    private lateinit var btnStop: Button
    private lateinit var tvService: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById(R.id.btnServiceStart)
        btnStop = findViewById(R.id.btnStopStart)
        tvService = findViewById(R.id.tvServiceInfo)


        btnStop.setOnClickListener {
            Intent(this,MyIntentService::class.java).also {
                startService(it)
                tvService.text = "Service Running"
            }
        }

        btnStart.setOnClickListener {
            MyIntentService.stopService()
            tvService.text = "Service Stopped"
        }
    }
}