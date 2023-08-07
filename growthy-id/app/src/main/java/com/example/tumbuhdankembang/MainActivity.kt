package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var btnPertumbuhan: Button
    private lateinit var btnPerkembangan: Button
    private lateinit var btnEmosional: Button
    private lateinit var btnAbout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPertumbuhan = findViewById(R.id.btn_pertumbuhan)
        btnPerkembangan = findViewById(R.id.btn_perkembangan)
        btnEmosional = findViewById(R.id.btn_emosional)
        btnAbout = findViewById(R.id.btn_about)

        btnPertumbuhan.setOnClickListener {
            val intent = Intent(this, PertumbuhanActivity::class.java)
            startActivity(intent)
        }

        btnPerkembangan.setOnClickListener {
            val intent = Intent(this, PerkembanganActivity::class.java)
            startActivity(intent)
        }

        btnEmosional.setOnClickListener {
            val intent = Intent(this, EmosionalActivity::class.java)
            startActivity(intent)
        }

        btnAbout.setOnClickListener {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
        }

    }
}