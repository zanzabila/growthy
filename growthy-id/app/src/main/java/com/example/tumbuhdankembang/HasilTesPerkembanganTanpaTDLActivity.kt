package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HasilTesPerkembanganTanpaTDLActivity : AppCompatActivity() {

    var tvKPSP: TextView? = null
    var tvTDD: TextView? = null
    private lateinit var btnHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_tes_perkembangan_tanpa_tdl)

        val hasilKPSP = intent.getStringExtra("hasilKPSP")
        val hasilTDD = intent.getStringExtra("hasilTDD")
        tvKPSP = findViewById(R.id.tv_hasilKPSP2)
        tvTDD = findViewById(R.id.tv_hasilTDD2)

        // Tampilkan hasil KPSP
        when {
            hasilKPSP.equals("sesuai") -> {
                tvKPSP!!.text = "Selamat! Anak Anda mendapatkan hasil “Sangat Baik” untuk tes kali ini. Harap lanjutkan kembali stimulasi sesuai umur."
            }
            hasilKPSP.equals("meragukan") -> {
                tvKPSP!!.text = "Lakukan tes ulang 2 minggu lagi dan lakukan stimulasi lebih sering dengan penuh kasih sayang."
            }
            hasilKPSP.equals("penyimpangan") -> {
                tvKPSP!!.text = "Segera rujuk anak Anda ke rumah sakit untuk pemeriksaan lebih lanjut dan akurat."
            }
        }

        // Tampilkan hasil TDD
        when {
            hasilTDD.equals("sesuai") -> {
                tvTDD!!.text = "Selamat! Anak Anda mendapatkan hasil “Sangat Baik” untuk tes kali ini. Harap lanjutkan kembali stimulasi sesuai umur."
            }
            hasilTDD.equals("penyimpangan") -> {
                tvTDD!!.text = "Segera rujuk anak Anda ke rumah sakit untuk pemeriksaan lebih lanjut dan akurat."
            }
        }

        btnHome = findViewById(R.id.btn_keBerandaPerkembangan_tanpaTDL)

        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}