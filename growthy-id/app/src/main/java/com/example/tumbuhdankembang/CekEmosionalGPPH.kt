package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class CekEmosionalGPPH : AppCompatActivity() {

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
        setContentView(R.layout.activity_cek_emosional_gpph)

        var umur = intent.getIntExtra("umur", 0)
        val nama = intent.getStringExtra("nama")
        val tglLahir = intent.getStringExtra("tglLahir")
        val tglHariIni = intent.getStringExtra("tglHariIni")
        var hasilKMPE = intent.getStringExtra("hasilKMPE")
        radio01 = findViewById(R.id.radio_gpphQ1)
        radio02 = findViewById(R.id.radio_gpphQ2)
        radio03 = findViewById(R.id.radio_gpphQ3)
        radio04 = findViewById(R.id.radio_gpphQ4)
        radio05 = findViewById(R.id.radio_gpphQ5)
        radio06 = findViewById(R.id.radio_gpphQ6)
        radio07 = findViewById(R.id.radio_gpphQ7)
        radio08 = findViewById(R.id.radio_gpphQ8)
        radio09 = findViewById(R.id.radio_gpphQ9)
        radio10 = findViewById(R.id.radio_gpphQ10)
        btnLanjut = findViewById(R.id.btn_gpph)
        tvEmptyAlert = findViewById(R.id.tv_alertGPPH)
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
                count += selected01.getText().toString().toInt()
                count += selected02.getText().toString().toInt()
                count += selected03.getText().toString().toInt()
                count += selected04.getText().toString().toInt()
                count += selected05.getText().toString().toInt()
                count += selected06.getText().toString().toInt()
                count += selected07.getText().toString().toInt()
                count += selected08.getText().toString().toInt()
                count += selected09.getText().toString().toInt()
                count += selected10.getText().toString().toInt()

                var hasilGPPH: String
                if (count < 13) {
                    hasilGPPH = "normal"
                } else {
                    hasilGPPH = "kemungkinan gpph"
                }

                if (umur<42) {
                    var hasilMCHAT = intent.getStringExtra("hasilMCHAT")
                    val intent = Intent(this, HasilTesEmosional2Activity::class.java)
                    intent.putExtra("hasilMCHAT", hasilMCHAT)
                    intent.putExtra("hasilKMPE", hasilKMPE)
                    intent.putExtra("hasilGPPH", hasilGPPH)
                    intent.putExtra("nama", nama)
                    intent.putExtra("tglLahir", tglLahir)
                    intent.putExtra("tglHariIni", tglHariIni)
                    startActivity(intent)
                } else {
                    val intent = Intent(this, HasilTesEmosional3Activity::class.java)
                    intent.putExtra("hasilKMPE", hasilKMPE)
                    intent.putExtra("hasilGPPH", hasilGPPH)
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