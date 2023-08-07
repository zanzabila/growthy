package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class CekPerkembanganP2b12Activity : AppCompatActivity() {

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
    private lateinit var btnLanjut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cek_perkembangan_p2b12)

        var umur = intent.getIntExtra("umur", 0)
        radio01 = findViewById(R.id.radio_kpsp4Q1)
        radio02 = findViewById(R.id.radio_kpsp4Q2)
        radio03 = findViewById(R.id.radio_kpsp4Q3)
        radio04 = findViewById(R.id.radio_kpsp4Q4)
        radio05 = findViewById(R.id.radio_kpsp4Q5)
        radio06 = findViewById(R.id.radio_kpsp4Q6)
        radio07 = findViewById(R.id.radio_kpsp4Q7)
        radio08 = findViewById(R.id.radio_kpsp4Q8)
        radio09 = findViewById(R.id.radio_kpsp4Q9)
        radio10 = findViewById(R.id.radio_kpsp4Q10)
        btnLanjut = findViewById(R.id.btn_kpsp4)
        tvEmptyAlert = findViewById(R.id.tv_alertKPSP4)
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
                radio10!!.checkedRadioButtonId > -1) {

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

                var hasilKPSP: String
                if (count >= 9) {
                    hasilKPSP = "sesuai"
                } else if (count >= 7) {
                    hasilKPSP = "meragukan"
                } else {
                    hasilKPSP = "penyimpangan"
                }

                // TDD 6-12 bulan
                val intent = Intent(this, CekPerkembanganP3Bulan06Sampai12::class.java)
                intent.putExtra("umur", umur)
                intent.putExtra("hasilKPSP", hasilKPSP)
                startActivity(intent)

            } else {
                tvEmptyAlert!!.text = "Mohon jawab seluruh pertanyaan."
            }
        }

    }
}