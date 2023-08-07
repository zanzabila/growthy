package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HasilTesPerkembanganTDLActivity : AppCompatActivity() {

    var tvKPSP: TextView? = null
    var tvTDD: TextView? = null
    var tvTDL: TextView? = null
    private lateinit var btnHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_tes_perkembangan_tdl)

        val hasilKPSP = intent.getStringExtra("hasilKPSP")
        val hasilTDD = intent.getStringExtra("hasilTDD")
        val hasilTDL = intent.getStringExtra("hasilTDL")
        tvKPSP = findViewById(R.id.tv_hasilEmoMCHAT2)
        tvTDD = findViewById(R.id.tv_hasilTDD4)
        tvTDL = findViewById(R.id.tv_hasilTDL2)

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

        // Tampilkan hasil TDL
        when {
            hasilTDL.equals("normal") -> {
                tvTDL!!.text = "Selamat! Anak Anda mendapatkan hasil yang NORMAL pada Tes Daya Lihat kali ini. Silakan lanjutkan stimulasi sesuai umur dan lakukan tes berikutnya 6 bulan lagi."
            }
            hasilTDL.equals("normal kiri") -> {
                tvTDL!!.text = "Terdapat indikasi anak Anda mengalami gangguan pada mata kanan. Segera rujuk anak Anda ke rumah sakit untuk pemeriksaan lebih lanjut dan lebih akurat."
            }
            hasilTDL.equals("normal kanan") -> {
                tvTDL!!.text = "Terdapat indikasi anak Anda mengalami gangguan pada mata kiri. Segera rujuk anak Anda ke rumah sakit untuk pemeriksaan lebih lanjut dan lebih akurat."
            }
            hasilTDL.equals("mungkin gangguan") -> {
                tvTDL!!.text = "Terdapat indikasi mengalami gangguan pada kedua mata anak. Segera rujuk anak anda ke rumah sakit untuk pemeriksaan lebih lanjut dan lebih akurat."
            }
        }

        btnHome = findViewById(R.id.btn_keBerandaPerkembangan_TDL)

        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}