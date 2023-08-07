package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HasilTesEmosional1Activity : AppCompatActivity() {

    var tvHasilMCHAT: TextView? = null
    private lateinit var btnHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_tes_emosional1)

        // Hasil M-CHAT
        val hasilMCHAT = intent.getStringExtra("hasilMCHAT")
        tvHasilMCHAT = findViewById(R.id.tv_hasilEmoMCHAT2)
        if (hasilMCHAT.equals("risiko")) {
            tvHasilMCHAT!!.text = "Terdapat indikasi anak Anda memiliki RISIKO TINGGI AUTISME. Segera minta rujukan ke rumah sakit rujukan tumbuh kembang level 1 untuk pemeriksaan yang lebih lanjut dan lebih akurat."
        } else if (hasilMCHAT.equals("normal")) {
            tvHasilMCHAT!!.text = "Selamat! Anak Anda mendapatkan hasil NORMAL untuk tes kali ini. Harap lanjutkan kembali stimulasi sesuai umur dan silakan melakukan tes berikutnya 3 bulan lagi sampai umur 2 tahun, tiap 6 bulan sampai umur 72 bulan."
        }

        // Button Beranda
        btnHome = findViewById(R.id.btn_keBerandaEmosional1)
        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}