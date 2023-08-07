package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PertumbuhanActivity : AppCompatActivity() {

    private lateinit var btnCekPertumbuhan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pertumbuhan)

        btnCekPertumbuhan = findViewById(R.id.btn_cekPertumbuhan)

        btnCekPertumbuhan.setOnClickListener {
            val intent = Intent(this, CekPertumbuhanP1Activity::class.java)
            startActivity(intent)
        }

    }
}