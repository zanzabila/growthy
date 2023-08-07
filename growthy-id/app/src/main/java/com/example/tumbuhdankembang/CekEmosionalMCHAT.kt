package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class CekEmosionalMCHAT : AppCompatActivity() {

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
    var radio15: RadioGroup? = null
    var radio16: RadioGroup? = null
    var radio17: RadioGroup? = null
    var radio18: RadioGroup? = null
    var radio19: RadioGroup? = null
    var radio20: RadioGroup? = null
    var radio21: RadioGroup? = null
    var radio22: RadioGroup? = null
    var radio23: RadioGroup? = null
    private lateinit var btnLanjut: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cek_emosional_mchat)

        var umur = intent.getIntExtra("umur", 0)
        radio01 = findViewById(R.id.radio_mchatQ1)
        radio02 = findViewById(R.id.radio_mchatQ2)
        radio03 = findViewById(R.id.radio_mchatQ3)
        radio04 = findViewById(R.id.radio_mchatQ4)
        radio05 = findViewById(R.id.radio_mchatQ5)
        radio06 = findViewById(R.id.radio_mchatQ6)
        radio07 = findViewById(R.id.radio_mchatQ7)
        radio08 = findViewById(R.id.radio_mchatQ8)
        radio09 = findViewById(R.id.radio_mchatQ9)
        radio10 = findViewById(R.id.radio_mchatQ10)
        radio11 = findViewById(R.id.radio_mchatQ11)
        radio12 = findViewById(R.id.radio_mchatQ12)
        radio13 = findViewById(R.id.radio_mchatQ13)
        radio14 = findViewById(R.id.radio_mchatQ14)
        radio15 = findViewById(R.id.radio_mchatQ15)
        radio16 = findViewById(R.id.radio_mchatQ16)
        radio17 = findViewById(R.id.radio_mchatQ17)
        radio18 = findViewById(R.id.radio_mchatQ18)
        radio19 = findViewById(R.id.radio_mchatQ19)
        radio20 = findViewById(R.id.radio_mchatQ20)
        radio21 = findViewById(R.id.radio_mchatQ21)
        radio22 = findViewById(R.id.radio_mchatQ22)
        radio23 = findViewById(R.id.radio_mchatQ23)
        btnLanjut = findViewById(R.id.btn_mchat)
        tvEmptyAlert = findViewById(R.id.tv_alertMCHAT)
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
                radio14!!.checkedRadioButtonId > -1 &&
                radio15!!.checkedRadioButtonId > -1 &&
                radio16!!.checkedRadioButtonId > -1 &&
                radio17!!.checkedRadioButtonId > -1 &&
                radio18!!.checkedRadioButtonId > -1 &&
                radio19!!.checkedRadioButtonId > -1 &&
                radio20!!.checkedRadioButtonId > -1 &&
                radio21!!.checkedRadioButtonId > -1 &&
                radio22!!.checkedRadioButtonId > -1 &&
                radio23!!.checkedRadioButtonId > -1) {

                tvEmptyAlert!!.text = ""
                var kritis = 0
                var nonKritis = 0
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
                val selected15: RadioButton = findViewById(radio15!!.checkedRadioButtonId)
                val selected16: RadioButton = findViewById(radio16!!.checkedRadioButtonId)
                val selected17: RadioButton = findViewById(radio17!!.checkedRadioButtonId)
                val selected18: RadioButton = findViewById(radio18!!.checkedRadioButtonId)
                val selected19: RadioButton = findViewById(radio19!!.checkedRadioButtonId)
                val selected20: RadioButton = findViewById(radio20!!.checkedRadioButtonId)
                val selected21: RadioButton = findViewById(radio21!!.checkedRadioButtonId)
                val selected22: RadioButton = findViewById(radio22!!.checkedRadioButtonId)
                val selected23: RadioButton = findViewById(radio23!!.checkedRadioButtonId)
                if (selected01.getText().toString().equals("Tidak")) ++nonKritis
                if (selected02.getText().toString().equals("Tidak")) ++kritis
                if (selected03.getText().toString().equals("Tidak")) ++nonKritis
                if (selected04.getText().toString().equals("Tidak")) ++nonKritis
                if (selected05.getText().toString().equals("Tidak")) ++nonKritis
                if (selected06.getText().toString().equals("Tidak")) ++nonKritis
                if (selected07.getText().toString().equals("Tidak")) ++kritis
                if (selected08.getText().toString().equals("Tidak")) ++nonKritis
                if (selected09.getText().toString().equals("Tidak")) ++kritis
                if (selected10.getText().toString().equals("Tidak")) ++nonKritis
                if (selected11.getText().toString().equals("Tidak")) ++nonKritis
                if (selected12.getText().toString().equals("Tidak")) ++nonKritis
                if (selected13.getText().toString().equals("Tidak")) ++kritis
                if (selected14.getText().toString().equals("Tidak")) ++kritis
                if (selected15.getText().toString().equals("Tidak")) ++kritis
                if (selected16.getText().toString().equals("Tidak")) ++nonKritis
                if (selected17.getText().toString().equals("Tidak")) ++nonKritis
                if (selected18.getText().toString().equals("Tidak")) ++nonKritis
                if (selected19.getText().toString().equals("Tidak")) ++nonKritis
                if (selected20.getText().toString().equals("Tidak")) ++nonKritis
                if (selected21.getText().toString().equals("Tidak")) ++nonKritis
                if (selected22.getText().toString().equals("Tidak")) ++nonKritis
                if (selected23.getText().toString().equals("Tidak")) ++nonKritis

                var hasilMCHAT: String
                if (kritis>=2 || kritis+nonKritis>=3) {
                    hasilMCHAT = "risiko"
                } else {
                    hasilMCHAT = "normal"
                }

                if (umur < 36) {
                    val intent = Intent(this, HasilTesEmosional1Activity::class.java)
                    intent.putExtra("hasilMCHAT", hasilMCHAT)
                    intent.putExtra("umur", umur)
                    startActivity(intent)
                } else {
                    val intent = Intent(this, CekEmosionalKMPE::class.java)
                    intent.putExtra("hasilMCHAT", hasilMCHAT)
                    intent.putExtra("umur", umur)
                    startActivity(intent)
                }

            } else {
                tvEmptyAlert!!.text = "Mohon jawab seluruh pertanyaan."
            }
        }

    }
}