package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HasilTesPerkembanganHanyaTDDActivity : AppCompatActivity() { //activity ini tidak jadi dipakai, bayi <3 bulan tidak tes apa pun

    var tvTDD: TextView? = null
    private lateinit var btnHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_tes_perkembangan_hanya_tdd)

        val hasilTDD = intent.getStringExtra("hasilTDD")
        var nama = intent.getStringExtra("nama")
        val tglLahir = intent.getStringExtra("tglLahir")
        val tglHariIni = intent.getStringExtra("tglHariIni")
        tvTDD = findViewById(R.id.tv_hasilTDD6)

        // Tampilkan hasil TDD
        when {
            hasilTDD.equals("sesuai") -> {
                tvTDD!!.text = "Selamat! $nama mendapatkan hasil “Sangat Baik” untuk tes kali ini. Harap lanjutkan kembali stimulasi sesuai umur."
            }
            hasilTDD.equals("penyimpangan") -> {
                tvTDD!!.text = "Hasil TDD menunjukkan indikasi adanya penyimpangan pada $nama. Segera rujuk $nama ke rumah sakit untuk pemeriksaan lebih lanjut dan akurat."
            }
        }

        val k = KeyResult(nama!!, tglLahir!!)
        var v: ValueResult
        if (MyApplication.listHasilTes.containsKey(k)) {
            v = MyApplication.listHasilTes.get(k)!!
        } else {
            v = ValueResult()
        }
        v.setHasilPerkembangan(tglHariIni!!, "", hasilTDD!!, "")
        MyApplication.listHasilTes.put(k, v)

        btnHome = findViewById(R.id.btn_keBerandaPerkembangan_hanyaTDD)

        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

    }
}