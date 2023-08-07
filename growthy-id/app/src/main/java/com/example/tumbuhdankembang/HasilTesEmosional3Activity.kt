package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HasilTesEmosional3Activity : AppCompatActivity() {

    var tvHasilKMPE: TextView? = null
    var tvHasilGPPH: TextView? = null
    private lateinit var btnHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_tes_emosional3)

        val nama = intent.getStringExtra("nama")
        val tglLahir = intent.getStringExtra("tglLahir")
        val tglHariIni = intent.getStringExtra("tglHariIni")

        // Hasil KMPE
        val hasilKMPE = intent.getStringExtra("hasilKMPE")
        tvHasilKMPE = findViewById(R.id.tv_hasilEmoKMPE4)
        if (hasilKMPE.equals("normal")) {
            tvHasilKMPE!!.text = "Selamat! $nama mendapatkan hasil NORMAL untuk tes kali ini. Harap lanjutkan kembali stimulasi sesuai umur dan silakan melakukan tes berikutnya 6 bulan lagi."
        } else if (hasilKMPE.equals("terindikasi ringan")) {
            tvHasilKMPE!!.text = "Terdapat indikasi $nama mengalami masalah mental emosional. Silakan lakukan konseling dan lakukan tes serta konseling berikutnya 3 bulan lagi. Bila tidak ada perubahan minta rujukan ke rumah sakit rujukan tumbuh kembang level 1 untuk menjalani pemeriksaan yang lebih akurat."
        } else if (hasilKMPE.equals("terindikasi berat")) {
            tvHasilKMPE!!.text = "Terdapat indikasi $nama mengalami masalah mental emosional. Silakan minta rujukan ke rumah sakit rujukan tumbuh kembang level 1 untuk menjalani pemeriksaan yang lebih lanjut dan lebih akurat."
        }

        // Hasil GPPH
        val hasilGPPH = intent.getStringExtra("hasilGPPH")
        tvHasilGPPH = findViewById(R.id.tv_hasilEmoGPPH4)
        if (hasilGPPH.equals("normal")) {
            tvHasilGPPH!!.text = "Selamat! $nama mendapatkan hasil NORMAL untuk tes kali ini. Harap lanjutkan kembali stimulasi sesuai umur dan silakan  melakukan tes berikutnya 6 bulan lagi. Apabila ragu-ragu, ulangi pemeriksaan 1 bulan lagi."
        } else if (hasilGPPH.equals("kemungkinan gpph")) {
            tvHasilGPPH!!.text = "Terdapat indikasi $nama memiliki kemungkinan GPPH, segera minta rujukan ke rumah sakit rujukan tumbuh kembang level 1 untuk pemeriksaan yang lebih lanjut dan lebih akurat."
        }

        val k = KeyResult(nama!!, tglLahir!!)
        var v: ValueResult
        if (MyApplication.listHasilTes.containsKey(k)) {
            v = MyApplication.listHasilTes.get(k)!!
        } else {
            v = ValueResult()
        }
        v.setHasilEmosional(tglHariIni!!, "", hasilKMPE!!, hasilGPPH!!)
        MyApplication.listHasilTes.put(k, v)

        // Button Beranda
        btnHome = findViewById(R.id.btn_keBerandaEmosional3)
        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}