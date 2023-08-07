package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class CekPerkembanganP3Bulan00Sampai03 : AppCompatActivity() {

    var tvEmptyAlert: TextView? = null
    var radio01: RadioGroup? = null
    var radio02: RadioGroup? = null
    var radio03: RadioGroup? = null
    private lateinit var btnLanjut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cek_perkembangan_p3_bulan00_sampai03)

        var hasilKPSP = intent.getStringExtra("hasilKPSP")
        val umur = intent.getIntExtra("umur", 0)
        val nama = intent.getStringExtra("nama")
        val tglLahir = intent.getStringExtra("tglLahir")
        val tglHariIni = intent.getStringExtra("tglHariIni")
        radio01 = findViewById(R.id.radio_tdd1Q1)
        radio02 = findViewById(R.id.radio_tdd1Q2)
        radio03 = findViewById(R.id.radio_tdd1Q3)
        btnLanjut = findViewById(R.id.btn_tdd1)
        tvEmptyAlert = findViewById(R.id.tv_alertTDD1)
        tvEmptyAlert!!.text = ""

        btnLanjut.setOnClickListener {
            if (radio01!!.checkedRadioButtonId > -1 &&
                radio02!!.checkedRadioButtonId > -1 &&
                radio03!!.checkedRadioButtonId > -1) {

                tvEmptyAlert!!.text = ""
                var hasilTDD = "sesuai"
                val selected01: RadioButton = findViewById(radio01!!.checkedRadioButtonId)
                val selected02: RadioButton = findViewById(radio02!!.checkedRadioButtonId)
                val selected03: RadioButton = findViewById(radio03!!.checkedRadioButtonId)
                if (selected01.getText().toString().equals("Tidak")) hasilTDD = "penyimpangan"
                if (selected02.getText().toString().equals("Tidak")) hasilTDD = "penyimpangan"
                if (selected03.getText().toString().equals("Tidak")) hasilTDD = "penyimpangan"

                // tidak perlu TDL; langsung ke hasil tes
                if (umur<3) { // hanya TDD 0-3 bulan (batal, anak <3 bulan tidak tes apa pun)
                    val intent = Intent(this, HasilTesPerkembanganHanyaTDDActivity::class.java)
                    intent.putExtra("hasilTDD", hasilTDD)
                    intent.putExtra("nama", nama)
                    startActivity(intent)
                } else if (umur==3) { // KPSP dan TDD
                    val kasar = intent.getIntExtra("kasar", 0)
                    val halus = intent.getIntExtra("halus", 0)
                    val bicara = intent.getIntExtra("bicara", 0)
                    val sosialisasi = intent.getIntExtra("sosialisasi", 0)
                    val intent = Intent(this, HasilTesPerkembanganTanpaTDLActivity::class.java)
                    intent.putExtra("hasilKPSP", hasilKPSP)
                    intent.putExtra("hasilTDD", hasilTDD)
                    intent.putExtra("kasar", kasar)
                    intent.putExtra("halus", halus)
                    intent.putExtra("bicara", bicara)
                    intent.putExtra("sosialisasi", sosialisasi)
                    intent.putExtra("nama", nama)
                    intent.putExtra("tglLahir", tglLahir)
                    intent.putExtra("tglHariIni", tglHariIni)
                    startActivity(intent)
                }

            } else {
                tvEmptyAlert!!.text = "Mohon jawab seluruh pertanyaan."
            }
        }
    }
}