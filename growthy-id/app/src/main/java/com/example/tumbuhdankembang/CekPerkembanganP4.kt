package com.example.tumbuhdankembang

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CekPerkembanganP4 : AppCompatActivity() {

    var tvEmptyAlert: TextView? = null
    private lateinit var etKiri : EditText
    private lateinit var etKanan : EditText
    private lateinit var btnDownload: Button
    private lateinit var btnTDL: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cek_perkembangan_p4)

        val hasilKPSP = intent.getStringExtra("hasilKPSP")
        val hasilTDD = intent.getStringExtra("hasilTDD")

        btnDownload = findViewById(R.id.btn_download)
        btnTDL = findViewById(R.id.btn_tdl)
        etKiri = findViewById(R.id.et_mataKiri)
        etKanan = findViewById(R.id.et_mataKanan)
        tvEmptyAlert = findViewById(R.id.tv_alertTDL)
        tvEmptyAlert!!.text = ""


        btnDownload.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://onedrive.live.com/download?cid=E0945A22A5FF9E7C&resid=E0945A22A5FF9E7C%21168&authkey=AC3zb003jRaE4hI&em=2"))
            startActivity(i)
        }

        btnTDL.setOnClickListener {
            val kiri = etKiri.text.toString()
            val kanan = etKanan.text.toString()
            if (kiri.length==0 || kanan.length==0) {
                tvEmptyAlert!!.text = "Mohon lengkapi isian yang diminta."
            } else {
                tvEmptyAlert!!.text = ""

                val hasilTDL: String
                val barisKiri = kiri.toInt()
                val barisKanan = kanan.toInt()
                if (barisKiri>=3 && barisKanan>=3) {
                    hasilTDL = "normal"
                } else if (barisKiri>=3) {
                    hasilTDL = "normal kiri"
                } else if (barisKanan>=3) {
                    hasilTDL = "normal kanan"
                } else {
                    hasilTDL = "mungkin gangguan"
                }

                val intent = Intent(this, HasilTesPerkembanganTDLActivity::class.java)
                intent.putExtra("hasilKPSP", hasilKPSP)
                intent.putExtra("hasilTDD", hasilTDD)
                intent.putExtra("hasilTDL", hasilTDL)
                startActivity(intent)
            }
        }
    }
}