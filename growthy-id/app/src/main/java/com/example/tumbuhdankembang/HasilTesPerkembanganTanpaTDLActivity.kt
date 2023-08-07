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
        var nama = intent.getStringExtra("nama")
        val tglLahir = intent.getStringExtra("tglLahir")
        val tglHariIni = intent.getStringExtra("tglHariIni")
        tvKPSP = findViewById(R.id.tv_hasilKPSP2)
        tvTDD = findViewById(R.id.tv_hasilTDD2)

        // Tampilkan hasil KPSP
        when {
            hasilKPSP.equals("sesuai") -> {
                tvKPSP!!.text = "Selamat! $nama mendapatkan hasil “Sangat Baik” untuk tes kali ini. Harap lanjutkan kembali stimulasi sesuai umur."
            }
            hasilKPSP.equals("meragukan") -> {
                var s = "Hasil KPSP meragukan sehingga $nama harus melakukan tes KPSP 2 minggu lagi. Lakukan stimulasi lebih sering dengan penuh kasih sayang.\n\nLakukan stimulasi pada:"
                val kasar = intent.getIntExtra("kasar", 0)
                val halus = intent.getIntExtra("halus", 0)
                val bicara = intent.getIntExtra("bicara", 0)
                val sosialisasi = intent.getIntExtra("sosialisasi", 0)
                if (kasar > 0) s += "\n・Gerak kasar anak"
                if (halus > 0) s += "\n・Gerak halus anak"
                if (bicara > 0) s += "\n・Bicara dan bahasa anak"
                if (sosialisasi > 0) s += "\n・Sosialisasi dan kemandirian anak"
                tvKPSP!!.text = s
            }
            hasilKPSP.equals("penyimpangan") -> {
                var s = "Hasil KPSP menunjukkan indikasi adanya penyimpangan pada $nama. Segera rujuk $nama ke rumah sakit untuk pemeriksaan lebih lanjut dan akurat.\n\nLakukan stimulasi pada:"
                val kasar = intent.getIntExtra("kasar", 0)
                val halus = intent.getIntExtra("halus", 0)
                val bicara = intent.getIntExtra("bicara", 0)
                val sosialisasi = intent.getIntExtra("sosialisasi", 0)
                if (kasar > 0) s += "\n・Gerak kasar anak"
                if (halus > 0) s += "\n・Gerak halus anak"
                if (bicara > 0) s += "\n・Bicara dan bahasa anak"
                if (sosialisasi > 0) s += "\n・Sosialisasi dan kemandirian anak"
                tvKPSP!!.text = s
            }
        }

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
        v.setHasilPerkembangan(tglHariIni!!, hasilKPSP!!, hasilTDD!!, "")
        MyApplication.listHasilTes.put(k, v)

        btnHome = findViewById(R.id.btn_keBerandaPerkembangan_tanpaTDL)

        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}