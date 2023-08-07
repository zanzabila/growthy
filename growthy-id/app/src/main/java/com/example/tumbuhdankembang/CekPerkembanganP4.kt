package com.example.tumbuhdankembang

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView

class CekPerkembanganP4 : AppCompatActivity() {

    var tvEmptyAlert: TextView? = null
    private lateinit var checkKiri1: CheckBox
    private lateinit var checkKiri2: CheckBox
    private lateinit var checkKiri3: CheckBox
    private lateinit var checkKiri4: CheckBox
    private lateinit var checkKanan1: CheckBox
    private lateinit var checkKanan2: CheckBox
    private lateinit var checkKanan3: CheckBox
    private lateinit var checkKanan4: CheckBox
    private lateinit var btnDownload: Button
    private lateinit var btnTDL: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cek_perkembangan_p4)

        val hasilKPSP = intent.getStringExtra("hasilKPSP")
        val hasilTDD = intent.getStringExtra("hasilTDD")
        val kasar = intent.getIntExtra("kasar", 0)
        val halus = intent.getIntExtra("halus", 0)
        val bicara = intent.getIntExtra("bicara", 0)
        val sosialisasi = intent.getIntExtra("sosialisasi", 0)
        val nama = intent.getStringExtra("nama")
        val tglLahir = intent.getStringExtra("tglLahir")
        val tglHariIni = intent.getStringExtra("tglHariIni")

        btnDownload = findViewById(R.id.btn_download)
        btnTDL = findViewById(R.id.btn_tdl)
        checkKiri1 = findViewById(R.id.check_kiri1)
        checkKiri2 = findViewById(R.id.check_kiri2)
        checkKiri3 = findViewById(R.id.check_kiri3)
        checkKiri4 = findViewById(R.id.check_kiri4)
        checkKanan1 = findViewById(R.id.check_kanan1)
        checkKanan2 = findViewById(R.id.check_kanan2)
        checkKanan3 = findViewById(R.id.check_kanan3)
        checkKanan4 = findViewById(R.id.check_kanan4)

        btnDownload.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://onedrive.live.com/download?cid=E0945A22A5FF9E7C&resid=E0945A22A5FF9E7C%21168&authkey=AC3zb003jRaE4hI&em=2"))
            startActivity(i)
        }

        btnTDL.setOnClickListener {
            // Mata kiri
            var kiri: Int
            if (!checkKiri1.isChecked) kiri = 0
            else if (!checkKiri2.isChecked) kiri = 1
            else if (!checkKiri3.isChecked) kiri = 2
            else if (!checkKiri4.isChecked) kiri = 3
            else kiri = 4
            
            // Mata kanan
            var kanan: Int
            if (!checkKanan1.isChecked) kanan = 0
            else if (!checkKanan2.isChecked) kanan = 1
            else if (!checkKanan3.isChecked) kanan = 2
            else if (!checkKanan4.isChecked) kanan = 3
            else kanan = 4

            val hasilTDL: String
            if (kiri>=3 && kanan>=3) {
                hasilTDL = "normal"
            } else if (kiri>=3) {
                hasilTDL = "normal kiri"
            } else if (kanan>=3) {
                hasilTDL = "normal kanan"
            } else {
                hasilTDL = "mungkin gangguan"
            }

            val intent = Intent(this, HasilTesPerkembanganTDLActivity::class.java)
            intent.putExtra("hasilKPSP", hasilKPSP)
            intent.putExtra("hasilTDD", hasilTDD)
            intent.putExtra("hasilTDL", hasilTDL)
            intent.putExtra("kasar", kasar)
            intent.putExtra("halus", halus)
            intent.putExtra("bicara", bicara)
            intent.putExtra("sosialisasi", sosialisasi)
            intent.putExtra("nama", nama)
            intent.putExtra("tglLahir", tglLahir)
            intent.putExtra("tglHariIni", tglHariIni)
            startActivity(intent)

        }
    }
}