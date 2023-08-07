package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PerkembanganActivity : AppCompatActivity() {

    private lateinit var btnCekPerkembangan: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perkembangan)

        btnCekPerkembangan = findViewById(R.id.btn_cekPerkembangan)

        btnCekPerkembangan.setOnClickListener {
            val intent = Intent(this, CekPerkembanganP1Activity::class.java)
            startActivity(intent)
        }

    }
}