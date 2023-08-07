package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class EmosionalActivity : AppCompatActivity() {

    private lateinit var btnCekEmosional: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emosional)

        btnCekEmosional = findViewById(R.id.btn_cekEmosional)

        btnCekEmosional.setOnClickListener {
            val intent = Intent(this, CekEmosionalUmur::class.java)
            startActivity(intent)
        }

    }
}