package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HasilTesEmosional2Activity : AppCompatActivity() {

    var tvHasilMCHAT: TextView? = null
    var tvHasilKMPE: TextView? = null
    var tvHasilGPPH: TextView? = null
    private lateinit var btnHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_tes_emosional2)

        // Hasil M-CHAT
        val hasilMCHAT = intent.getStringExtra("hasilMCHAT")
        tvHasilMCHAT = findViewById(R.id.tv_hasilEmoMCHAT4)
        if (hasilMCHAT.equals("risiko")) {
            tvHasilMCHAT!!.text = "Terdapat indikasi anak Anda memiliki RISIKO TINGGI AUTISME. Segera minta rujukan ke rumah sakit rujukan tumbuh kembang level 1 untuk pemeriksaan yang lebih lanjut dan lebih akurat."
        } else if (hasilMCHAT.equals("normal")) {
            tvHasilMCHAT!!.text = "Selamat! Anak Anda mendapatkan hasil NORMAL untuk tes kali ini. Harap lanjutkan kembali stimulasi sesuai umur dan silakan melakukan tes berikutnya 3 bulan lagi sampai umur 2 tahun, tiap 6 bulan sampai umur 72 bulan."
        }

        // Hasil KMPE
        val hasilKMPE = intent.getStringExtra("hasilKMPE")
        tvHasilKMPE = findViewById(R.id.tv_hasilEmoKMPE2)
        if (hasilKMPE.equals("normal")) {
            tvHasilKMPE!!.text = "Selamat! Anak Anda mendapatkan hasil NORMAL untuk tes kali ini. Harap lanjutkan kembali stimulasi sesuai umur dan silakan melakukan tes berikutnya 6 bulan lagi."
        } else if (hasilKMPE.equals("terindikasi ringan")) {
            tvHasilKMPE!!.text = "Terdapat indikasi anak Anda mengalami masalah mental emosional. Silahkan lakukan konseling dan lakukan tes serta konseling berikutnya 3 bulan lagi. Bila tidak ada perubahan minta rujukan ke rumah sakit rujukan tumbuh kembang level 1 untuk menjalani pemeriksaan yang lebih akurat."
        } else if (hasilKMPE.equals("terindikasi berat")) {
            tvHasilKMPE!!.text = "Terdapat indikasi anak Anda mengalami masalah mental emosional. Silahkan minta rujukan ke rumah sakit rujukan tumbuh kembang level 1 untuk menjalani pemeriksaan yang lebih lanjut dan lebih akurat."
        }

        // Hasil GPPH
        val hasilGPPH = intent.getStringExtra("hasilGPPH")
        tvHasilGPPH = findViewById(R.id.tv_hasilEmoGPPH2)
        if (hasilGPPH.equals("normal")) {
            tvHasilGPPH!!.text = "Selamat! Anak Anda mendapatkan hasil NORMAL untuk tes kali ini. Harap lanjutkan kembali stimulasi sesuai umur dan silakan  melakukan tes berikutnya 6 bulan lagi. Apabila ragu-ragu, ulangi pemeriksaan 1 bulan lagi."
        } else if (hasilGPPH.equals("kemungkinan gpph")) {
            tvHasilGPPH!!.text = "Terdapat indikasi anak Anda memiliki kemungkinan GPPH, segera minta rujukan ke rumah sakit rujukan tumbuh kembang level 1 untuk pemeriksaan yang lebih lanjut dan lebih akurat."
        }

        // Button BerAnda
        btnHome = findViewById(R.id.btn_keBerandaEmosional2)
        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}