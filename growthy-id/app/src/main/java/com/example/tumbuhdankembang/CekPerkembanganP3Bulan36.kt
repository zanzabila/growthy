package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class CekPerkembanganP3Bulan36 : AppCompatActivity() {

    var tvEmptyAlert: TextView? = null
    var radio01: RadioGroup? = null
    var radio02: RadioGroup? = null
    var radio03: RadioGroup? = null
    private lateinit var btnLanjut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cek_perkembangan_p3_bulan36)

        var hasilKPSP = intent.getStringExtra("hasilKPSP")
        var umur = intent.getIntExtra("umur", 0)
        val nama = intent.getStringExtra("nama")
        val tglLahir = intent.getStringExtra("tglLahir")
        val tglHariIni = intent.getStringExtra("tglHariIni")
        radio01 = findViewById(R.id.radio_tdd8Q1)
        radio02 = findViewById(R.id.radio_tdd8Q2)
        radio03 = findViewById(R.id.radio_tdd8Q3)
        btnLanjut = findViewById(R.id.btn_tdd8)
        tvEmptyAlert = findViewById(R.id.tv_alertTDD8)
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

                // lanjut ke TDL
                val kasar = intent.getIntExtra("kasar", 0)
                val halus = intent.getIntExtra("halus", 0)
                val bicara = intent.getIntExtra("bicara", 0)
                val sosialisasi = intent.getIntExtra("sosialisasi", 0)
                val intent = Intent(this, CekPerkembanganP4::class.java)
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

            } else {
                tvEmptyAlert!!.text = "Mohon jawab seluruh pertanyaan."
            }
        }
    }
}