package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class CekEmosionalKMPE : AppCompatActivity() {

    var tvEmptyAlert: TextView? = null
    var radio01: RadioGroup? = null
    var radio02: RadioGroup? = null
    var radio03: RadioGroup? = null
    var radio04: RadioGroup? = null
    var radio05: RadioGroup? = null
    var radio06: RadioGroup? = null
    var radio07: RadioGroup? = null
    var radio08: RadioGroup? = null
    var radio09: RadioGroup? = null
    var radio10: RadioGroup? = null
    var radio11: RadioGroup? = null
    var radio12: RadioGroup? = null
    var radio13: RadioGroup? = null
    var radio14: RadioGroup? = null
    private lateinit var btnLanjut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cek_emosional_kmpe)

        var umur = intent.getIntExtra("umur", 0)
        val nama = intent.getStringExtra("nama")
        val tglLahir = intent.getStringExtra("tglLahir")
        val tglHariIni = intent.getStringExtra("tglHariIni")
        radio01 = findViewById(R.id.radio_kmpeQ1)
        radio02 = findViewById(R.id.radio_kmpeQ2)
        radio03 = findViewById(R.id.radio_kmpeQ3)
        radio04 = findViewById(R.id.radio_kmpeQ4)
        radio05 = findViewById(R.id.radio_kmpeQ5)
        radio06 = findViewById(R.id.radio_kmpeQ6)
        radio07 = findViewById(R.id.radio_kmpeQ7)
        radio08 = findViewById(R.id.radio_kmpeQ8)
        radio09 = findViewById(R.id.radio_kmpeQ9)
        radio10 = findViewById(R.id.radio_kmpeQ10)
        radio11 = findViewById(R.id.radio_kmpeQ11)
        radio12 = findViewById(R.id.radio_kmpeQ12)
        radio13 = findViewById(R.id.radio_kmpeQ13)
        radio14 = findViewById(R.id.radio_kmpeQ14)
        btnLanjut = findViewById(R.id.btn_kmpe)
        tvEmptyAlert = findViewById(R.id.tv_alertKMPE)
        tvEmptyAlert!!.text = ""

        btnLanjut.setOnClickListener {
            if (radio01!!.checkedRadioButtonId > -1 &&
                radio02!!.checkedRadioButtonId > -1 &&
                radio03!!.checkedRadioButtonId > -1 &&
                radio04!!.checkedRadioButtonId > -1 &&
                radio05!!.checkedRadioButtonId > -1 &&
                radio06!!.checkedRadioButtonId > -1 &&
                radio07!!.checkedRadioButtonId > -1 &&
                radio08!!.checkedRadioButtonId > -1 &&
                radio09!!.checkedRadioButtonId > -1 &&
                radio10!!.checkedRadioButtonId > -1 &&
                radio11!!.checkedRadioButtonId > -1 &&
                radio12!!.checkedRadioButtonId > -1 &&
                radio13!!.checkedRadioButtonId > -1 &&
                radio14!!.checkedRadioButtonId > -1) {

                tvEmptyAlert!!.text = ""
                var count = 0
                val selected01: RadioButton = findViewById(radio01!!.checkedRadioButtonId)
                val selected02: RadioButton = findViewById(radio02!!.checkedRadioButtonId)
                val selected03: RadioButton = findViewById(radio03!!.checkedRadioButtonId)
                val selected04: RadioButton = findViewById(radio04!!.checkedRadioButtonId)
                val selected05: RadioButton = findViewById(radio05!!.checkedRadioButtonId)
                val selected06: RadioButton = findViewById(radio06!!.checkedRadioButtonId)
                val selected07: RadioButton = findViewById(radio07!!.checkedRadioButtonId)
                val selected08: RadioButton = findViewById(radio08!!.checkedRadioButtonId)
                val selected09: RadioButton = findViewById(radio09!!.checkedRadioButtonId)
                val selected10: RadioButton = findViewById(radio10!!.checkedRadioButtonId)
                val selected11: RadioButton = findViewById(radio11!!.checkedRadioButtonId)
                val selected12: RadioButton = findViewById(radio12!!.checkedRadioButtonId)
                val selected13: RadioButton = findViewById(radio13!!.checkedRadioButtonId)
                val selected14: RadioButton = findViewById(radio14!!.checkedRadioButtonId)
                if (selected01.getText().toString().equals("Ya")) ++count
                if (selected02.getText().toString().equals("Ya")) ++count
                if (selected03.getText().toString().equals("Ya")) ++count
                if (selected04.getText().toString().equals("Ya")) ++count
                if (selected05.getText().toString().equals("Ya")) ++count
                if (selected06.getText().toString().equals("Ya")) ++count
                if (selected07.getText().toString().equals("Ya")) ++count
                if (selected08.getText().toString().equals("Ya")) ++count
                if (selected09.getText().toString().equals("Ya")) ++count
                if (selected10.getText().toString().equals("Ya")) ++count
                if (selected11.getText().toString().equals("Ya")) ++count
                if (selected12.getText().toString().equals("Ya")) ++count
                if (selected13.getText().toString().equals("Ya")) ++count
                if (selected14.getText().toString().equals("Ya")) ++count

                var hasilKMPE: String
                if (count == 0) {
                    hasilKMPE = "normal"
                } else if (count == 1) {
                    hasilKMPE = "terindikasi ringan"
                } else {
                    hasilKMPE = "terindikasi berat"
                }

                if (umur<42) {
                    var hasilMCHAT = intent.getStringExtra("hasilMCHAT")
                    val intent = Intent(this, CekEmosionalGPPH::class.java)
                    intent.putExtra("hasilMCHAT", hasilMCHAT)
                    intent.putExtra("hasilKMPE", hasilKMPE)
                    intent.putExtra("umur", umur)
                    intent.putExtra("nama", nama)
                    intent.putExtra("tglLahir", tglLahir)
                    intent.putExtra("tglHariIni", tglHariIni)
                    startActivity(intent)
                } else {
                    val intent = Intent(this, CekEmosionalGPPH::class.java)
                    intent.putExtra("hasilKMPE", hasilKMPE)
                    intent.putExtra("umur", umur)
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