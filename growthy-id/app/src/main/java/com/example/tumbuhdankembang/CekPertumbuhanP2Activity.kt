package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class CekPertumbuhanP2Activity : AppCompatActivity() {

    private lateinit var etKg : EditText
    private lateinit var  etCm1 : EditText
    private lateinit var  etCm2 : EditText
    private lateinit var btnPertumbuhan2: Button
    var tvEmptyAlert: TextView? = null
    lateinit var hasil1: String
    lateinit var hasil2: String
    lateinit var hasil3: String
    lateinit var hasil4: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cek_pertumbuhan_p2)

        var jk = intent.getStringExtra("jk")
        var umur = intent.getIntExtra("umur", 0)

        etKg = findViewById(R.id.et_kg)
        etCm1 = findViewById(R.id.et_cm1)
        etCm2 = findViewById(R.id.et_cm2)
        btnPertumbuhan2 = findViewById(R.id.btn_pertumbuhan2)
        tvEmptyAlert = findViewById(R.id.tv_emptyAlertPertumbuhan)

        tvEmptyAlert!!.text = ""

        btnPertumbuhan2.setOnClickListener {
            if (umur <= 72) {
                var berat = etKg.text.toString()
                var tinggi = etCm1.text.toString()
                var lingkar = etCm2.text.toString()
                if (berat.length == 0 || tinggi.length == 0 || lingkar.length == 0) {
                    tvEmptyAlert!!.text = "Mohon lengkapi data anak."
                } else {
                    tvEmptyAlert!!.text = ""
                    val intent = Intent(this, HasilTesPertumbuhanActivity::class.java)
                    this.getHasil(
                        jk.toString(),
                        umur,
                        berat.toDouble(),
                        tinggi.toDouble(),
                        lingkar.toDouble()
                    )
                    intent.putExtra("hasil1", hasil1)
                    intent.putExtra("hasil2", hasil2)
                    intent.putExtra("hasil3", hasil3)
                    intent.putExtra("hasil4", hasil4)
                    intent.putExtra("umur", umur)
                    startActivity(intent)
                }
            } else {
                tvEmptyAlert!!.text = "Mohon maaf, tes pertumbuhan hanya dapat dilakukan untuk anak berumur 72 bulan ke bawah."
            }
        }

    }

    private fun getHasil(jk: String, umur: Int, berat: Double, tinggi: Double, lingkar: Double) {
        if (jk.equals("Laki-laki")) {
            hasil1 = heightForAgeLakilaki(tinggi, umur)
            hasil2 = weightForAge1Lakilaki(berat, umur)
            hasil3 = weightForLengthLakilaki(tinggi, umur)
            hasil4 = headCircumferenceForAgeLakilaki(lingkar, umur)
        } else if (jk.equals("Perempuan")) {
            hasil1 = heightForAgePerempuan(tinggi, umur)
            hasil2 = weightForAge1Perempuan(berat, umur)
            hasil3 = weightForLengthPerempuan(tinggi, umur)
            hasil4 = headCircumferenceForAgePerempuan(lingkar, umur)
        }
    }

    private fun heightForAgePerempuan(tinggi: Double, umur: Int): String {
        if (umur==0) {
            if (tinggi<43.6) {
                return "sangat pendek"
            } else if (tinggi<45.4) {
                return "pendek"
            } else if (tinggi<52.9) {
                return "normal"
            } else if (tinggi<54.7) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==1) {
            if (tinggi<47.8) {
                return "sangat pendek"
            } else if (tinggi<49.8) {
                return "pendek"
            } else if (tinggi<57.6) {
                return "normal"
            } else if (tinggi<59.5) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==2) {
            if (tinggi<51.0) {
                return "sangat pendek"
            } else if (tinggi<53.0) {
                return "pendek"
            } else if (tinggi<61.1) {
                return "normal"
            } else if (tinggi<63.2) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }

        } else if (umur==3) {
            if (tinggi<53.5) {
                return "sangat pendek"
            } else if (tinggi<55.6) {
                return "pendek"
            } else if (tinggi<64.0) {
                return "normal"
            } else if (tinggi<66.1) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }

        }else if (umur==4) {
            if (tinggi<55.6) {
                return "sangat pendek"
            } else if (tinggi<57.8) {
                return "pendek"
            } else if (tinggi<66.4) {
                return "normal"
            } else if (tinggi<68.6) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }

        }else if (umur==5) {
            if (tinggi<57.4) {
                return "sangat pendek"
            } else if (tinggi<59.6) {
                return "pendek"
            } else if (tinggi<68.5) {
                return "normal"
            } else if (tinggi<70.7) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        }else if (umur==6) {
            if (tinggi<58.9) {
                return "sangat pendek"
            } else if (tinggi<61.2) {
                return "pendek"
            } else if (tinggi<70.3) {
                return "normal"
            } else if (tinggi<72.5) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==7) {
            if (tinggi<60.3) {
                return "sangat pendek"
            } else if (tinggi<62.7) {
                return "pendek"
            } else if (tinggi<71.9) {
                return "normal"
            } else if (tinggi<74.2) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==8) {
            if (tinggi<61.7) {
                return "sangat pendek"
            } else if (tinggi<64.0) {
                return "pendek"
            } else if (tinggi<73.5) {
                return "normal"
            } else if (tinggi<75.8) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==9) {
            if (tinggi<62.9) {
                return "sangat pendek"
            } else if (tinggi<65.3) {
                return "pendek"
            } else if (tinggi<75.0) {
                return "normal"
            } else if (tinggi<77.4) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==10) {
            if (tinggi<64.1) {
                return "sangat pendek"
            } else if (tinggi<66.5) {
                return "pendek"
            } else if (tinggi<76.4) {
                return "normal"
            } else if (tinggi<78.9) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==11) {
            if (tinggi<65.2) {
                return "sangat pendek"
            } else if (tinggi<67.7) {
                return "pendek"
            } else if (tinggi<77.8) {
                return "normal"
            } else if (tinggi<80.3) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==12) {
            if (tinggi<66.3) {
                return "sangat pendek"
            } else if (tinggi<68.9) {
                return "pendek"
            } else if (tinggi<79.2) {
                return "normal"
            } else if (tinggi<81.7) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==13) {
            if (tinggi<67.3) {
                return "sangat pendek"
            } else if (tinggi<70.0) {
                return "pendek"
            } else if (tinggi<80.5) {
                return "normal"
            } else if (tinggi<83.1) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==14) {
            if (tinggi<68.3) {
                return "sangat pendek"
            } else if (tinggi<71.0) {
                return "pendek"
            } else if (tinggi<81.7) {
                return "normal"
            } else if (tinggi<84.4) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==15) {
            if (tinggi<69.3) {
                return "sangat pendek"
            } else if (tinggi<72.0) {
                return "pendek"
            } else if (tinggi<83.0) {
                return "normal"
            } else if (tinggi<85.7) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==16) {
            if (tinggi<70.2) {
                return "sangat pendek"
            } else if (tinggi<73.0) {
                return "pendek"
            } else if (tinggi<84.2) {
                return "normal"
            } else if (tinggi<87.0) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==17) {
            if (tinggi<71.1) {
                return "sangat pendek"
            } else if (tinggi<74.0) {
                return "pendek"
            } else if (tinggi<85.4) {
                return "normal"
            } else if (tinggi<88.2) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==18) {
            if (tinggi<72.0) {
                return "sangat pendek"
            } else if (tinggi<74.9) {
                return "pendek"
            } else if (tinggi<86.5) {
                return "normal"
            } else if (tinggi<89.4) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==19) {
            if (tinggi<72.8) {
                return "sangat pendek"
            } else if (tinggi<75.8) {
                return "pendek"
            } else if (tinggi<87.6) {
                return "normal"
            } else if (tinggi<90.6) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==20) {
            if (tinggi<73.7) {
                return "sangat pendek"
            } else if (tinggi<76.7) {
                return "pendek"
            } else if (tinggi<88.7) {
                return "normal"
            } else if (tinggi<91.7) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==21) {
            if (tinggi<74.5) {
                return "sangat pendek"
            } else if (tinggi<77.5) {
                return "pendek"
            } else if (tinggi<89.8) {
                return "normal"
            } else if (tinggi<92.9) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==22) {
            if (tinggi<75.2) {
                return "sangat pendek"
            } else if (tinggi<78.4) {
                return "pendek"
            } else if (tinggi<90.8) {
                return "normal"
            } else if (tinggi<94.0) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==23) {
            if (tinggi<76.0) {
                return "sangat pendek"
            } else if (tinggi<79.2) {
                return "pendek"
            } else if (tinggi<91.9) {
                return "normal"
            } else if (tinggi<95.0) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==24) {
            if (tinggi<76.0) {
                return "sangat pendek"
            } else if (tinggi<79.3) {
                return "pendek"
            } else if (tinggi<92.3) {
                return "normal"
            } else if (tinggi<95.4) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==25) {
            if (tinggi<76.8) {
                return "sangat pendek"
            } else if (tinggi<80.0) {
                return "pendek"
            } else if (tinggi<93.1) {
                return "normal"
            } else if (tinggi<96.4) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==26) {
            if (tinggi<77.5) {
                return "sangat pendek"
            } else if (tinggi<80.8) {
                return "pendek"
            } else if (tinggi<94.1) {
                return "normal"
            } else if (tinggi<97.4) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==27) {
            if (tinggi<78.1) {
                return "sangat pendek"
            } else if (tinggi<81.5) {
                return "pendek"
            } else if (tinggi<95.0) {
                return "normal"
            } else if (tinggi<98.4) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==28) {
            if (tinggi<78.8) {
                return "sangat pendek"
            } else if (tinggi<82.2) {
                return "pendek"
            } else if (tinggi<96.0) {
                return "normal"
            } else if (tinggi<99.4) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==29) {
            if (tinggi<79.5) {
                return "sangat pendek"
            } else if (tinggi<82.9) {
                return "pendek"
            } else if (tinggi<96.9) {
                return "normal"
            } else if (tinggi<100.3) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==30) {
            if (tinggi<80.1) {
                return "sangat pendek"
            } else if (tinggi<83.6) {
                return "pendek"
            } else if (tinggi<97.7) {
                return "normal"
            } else if (tinggi<101.3) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==31) {
            if (tinggi<80.7) {
                return "sangat pendek"
            } else if (tinggi<84.3) {
                return "pendek"
            } else if (tinggi<98.6) {
                return "normal"
            } else if (tinggi<102.2) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==32) {
            if (tinggi<81.3) {
                return "sangat pendek"
            } else if (tinggi<84.9) {
                return "pendek"
            } else if (tinggi<99.4) {
                return "normal"
            } else if (tinggi<103.1) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==33) {
            if (tinggi<81.9) {
                return "sangat pendek"
            } else if (tinggi<85.6) {
                return "pendek"
            } else if (tinggi<100.3) {
                return "normal"
            } else if (tinggi<103.9) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==34) {
            if (tinggi<82.5) {
                return "sangat pendek"
            } else if (tinggi<86.2) {
                return "pendek"
            } else if (tinggi<101.1) {
                return "normal"
            } else if (tinggi<104.8) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==35) {
            if (tinggi<83.1) {
                return "sangat pendek"
            } else if (tinggi<86.8) {
                return "pendek"
            } else if (tinggi<101.9) {
                return "normal"
            } else if (tinggi<105.6) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==36) {
            if (tinggi<83.6) {
                return "sangat pendek"
            } else if (tinggi<87.4) {
                return "pendek"
            } else if (tinggi<102.7) {
                return "normal"
            } else if (tinggi<106.5) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==37) {
            if (tinggi<84.2) {
                return "sangat pendek"
            } else if (tinggi<88.0) {
                return "pendek"
            } else if (tinggi<103.4) {
                return "normal"
            } else if (tinggi<107.3) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==38) {
            if (tinggi<84.7) {
                return "sangat pendek"
            } else if (tinggi<88.6) {
                return "pendek"
            } else if (tinggi<104.2) {
                return "normal"
            } else if (tinggi<108.1) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==39) {
            if (tinggi<85.3) {
                return "sangat pendek"
            } else if (tinggi<89.2) {
                return "pendek"
            } else if (tinggi<105.0) {
                return "normal"
            } else if (tinggi<108.9) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==40) {
            if (tinggi<85.8) {
                return "sangat pendek"
            } else if (tinggi<89.8) {
                return "pendek"
            } else if (tinggi<105.7) {
                return "normal"
            } else if (tinggi<109.7) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==41) {
            if (tinggi<86.3) {
                return "sangat pendek"
            } else if (tinggi<90.4) {
                return "pendek"
            } else if (tinggi<106.4) {
                return "normal"
            } else if (tinggi<110.5) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==42) {
            if (tinggi<86.3) {
                return "sangat pendek"
            } else if (tinggi<90.9) {
                return "pendek"
            } else if (tinggi<107.2) {
                return "normal"
            } else if (tinggi<111.2) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==43) {
            if (tinggi<87.4) {
                return "sangat pendek"
            } else if (tinggi<91.5) {
                return "pendek"
            } else if (tinggi<107.9) {
                return "normal"
            } else if (tinggi<112.0) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==44) {
            if (tinggi<87.9) {
                return "sangat pendek"
            } else if (tinggi<92.0) {
                return "pendek"
            } else if (tinggi<108.6) {
                return "normal"
            } else if (tinggi<112.7) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==45) {
            if (tinggi<88.4) {
                return "sangat pendek"
            } else if (tinggi<92.5) {
                return "pendek"
            } else if (tinggi<109.3) {
                return "normal"
            } else if (tinggi<113.5) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==46) {
            if (tinggi<88.9) {
                return "sangat pendek"
            } else if (tinggi<93.1) {
                return "pendek"
            } else if (tinggi<110.0) {
                return "normal"
            } else if (tinggi<114.2) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==47) {
            if (tinggi<89.3) {
                return "sangat pendek"
            } else if (tinggi<93.6) {
                return "pendek"
            } else if (tinggi<110.7) {
                return "normal"
            } else if (tinggi<114.9) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==48) {
            if (tinggi<89.8) {
                return "sangat pendek"
            } else if (tinggi<94.1) {
                return "pendek"
            } else if (tinggi<111.3) {
                return "normal"
            } else if (tinggi<115.7) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==49) {
            if (tinggi<90.3) {
                return "sangat pendek"
            } else if (tinggi<94.6) {
                return "pendek"
            } else if (tinggi<112.0) {
                return "normal"
            } else if (tinggi<116.4) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==50) {
            if (tinggi<90.7) {
                return "sangat pendek"
            } else if (tinggi<95.1) {
                return "pendek"
            } else if (tinggi<112.7) {
                return "normal"
            } else if (tinggi<117.1) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==51) {
            if (tinggi<91.2) {
                return "sangat pendek"
            } else if (tinggi<95.6) {
                return "pendek"
            } else if (tinggi<113.3) {
                return "normal"
            } else if (tinggi<117.7) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==52) {
            if (tinggi<91.7) {
                return "sangat pendek"
            } else if (tinggi<96.1) {
                return "pendek"
            } else if (tinggi<114.0) {
                return "normal"
            } else if (tinggi<118.4) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==53) {
            if (tinggi<92.1) {
                return "sangat pendek"
            } else if (tinggi<96.6) {
                return "pendek"
            } else if (tinggi<114.6) {
                return "normal"
            } else if (tinggi<119.1) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==54) {
            if (tinggi<92.6) {
                return "sangat pendek"
            } else if (tinggi<97.1) {
                return "pendek"
            } else if (tinggi<115.2) {
                return "normal"
            } else if (tinggi<119.8) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==55) {
            if (tinggi<93.0) {
                return "sangat pendek"
            } else if (tinggi<97.6) {
                return "pendek"
            } else if (tinggi<115.9) {
                return "normal"
            } else if (tinggi<120.4) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==56) {
            if (tinggi<93.4) {
                return "sangat pendek"
            } else if (tinggi<98.1) {
                return "pendek"
            } else if (tinggi<116.5) {
                return "normal"
            } else if (tinggi<121.1) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==57) {
            if (tinggi<93.9) {
                return "sangat pendek"
            } else if (tinggi<98.5) {
                return "pendek"
            } else if (tinggi<117.1) {
                return "normal"
            } else if (tinggi<121.8) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==58) {
            if (tinggi<94.3) {
                return "sangat pendek"
            } else if (tinggi<99.0) {
                return "pendek"
            } else if (tinggi<117.7) {
                return "normal"
            } else if (tinggi<122.4) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==59) {
            if (tinggi<94.7) {
                return "sangat pendek"
            } else if (tinggi<99.5) {
                return "pendek"
            } else if (tinggi<118.3) {
                return "normal"
            } else if (tinggi<123.1) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==60) {
            if (tinggi<95.2) {
                return "sangat pendek"
            } else if (tinggi<99.9) {
                return "pendek"
            } else if (tinggi<118.9) {
                return "normal"
            } else if (tinggi<123.7) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        }

        return ""
    }

    private fun weightForAge1Perempuan(berat: Double, umur: Int): String {
        if (umur==0) {
            if (berat<2) {
                return "sangat kurus"
            } else if (berat<2.4) {
                return "kurus"
            } else if (berat<4.2) {
                return "normal"
            } else if (berat<4.8) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==1) {
            if (berat<2.7) {
                return "sangat kurus"
            } else if (berat<3.2) {
                return "kurus"
            } else if (berat<5.5) {
                return "normal"
            } else if (berat<6.2) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==2) {
            if (berat<3.4) {
                return "sangat kurus"
            } else if (berat<3.9) {
                return "kurus"
            } else if (berat<6.6) {
                return "normal"
            } else if (berat<7.5) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==3) {
            if (berat<4.0) {
                return "sangat kurus"
            } else if (berat<4.5) {
                return "kurus"
            } else if (berat<7.5) {
                return "normal"
            } else if (berat<8.5) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==4) {
            if (berat<4.4) {
                return "sangat kurus"
            } else if (berat<5.0) {
                return "kurus"
            } else if (berat<8.2) {
                return "normal"
            } else if (berat<9.3) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==5) {
            if (berat<4.8) {
                return "sangat kurus"
            } else if (berat<5.4) {
                return "kurus"
            } else if (berat<8.8) {
                return "normal"
            } else if (berat<10.0) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==6) {
            if (berat<5.1) {
                return "sangat kurus"
            } else if (berat<5.7) {
                return "kurus"
            } else if (berat<9.3) {
                return "normal"
            } else if (berat<10.6) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        }  else if (umur==7) {
            if (berat<5.3) {
                return "sangat kurus"
            } else if (berat<6.0) {
                return "kurus"
            } else if (berat<9.8) {
                return "normal"
            } else if (berat<11.1) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        }  else if (umur==8) {
            if (berat<5.6) {
                return "sangat kurus"
            } else if (berat<6.3) {
                return "kurus"
            } else if (berat<10.2) {
                return "normal"
            } else if (berat<11.6) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        }  else if (umur==9) {
            if (berat<5.8) {
                return "sangat kurus"
            } else if (berat<6.5) {
                return "kurus"
            } else if (berat<10.5) {
                return "normal"
            } else if (berat<12.0) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        }  else if (umur==10) {
            if (berat<5.9) {
                return "sangat kurus"
            } else if (berat<6.7) {
                return "kurus"
            } else if (berat<10.9) {
                return "normal"
            } else if (berat<12.4) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        }  else if (umur==11) {
            if (berat<6.1) {
                return "sangat kurus"
            } else if (berat<6.9) {
                return "kurus"
            } else if (berat<11.2) {
                return "normal"
            } else if (berat<12.8) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        }  else if (umur==12) {
            if (berat<6.3) {
                return "sangat kurus"
            } else if (berat<7.0) {
                return "kurus"
            } else if (berat<11.5) {
                return "normal"
            } else if (berat<13.1) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==13) {
            if (berat<6.4) {
                return "sangat kurus"
            } else if (berat<7.2) {
                return "kurus"
            } else if (berat<11.8) {
                return "normal"
            } else if (berat<13.5) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==14) {
            if (berat<6.6) {
                return "sangat kurus"
            } else if (berat<7.4) {
                return "kurus"
            } else if (berat<12.1) {
                return "normal"
            } else if (berat<13.8) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==15) {
            if (berat<6.7) {
                return "sangat kurus"
            } else if (berat<7.6) {
                return "kurus"
            } else if (berat<12.4) {
                return "normal"
            } else if (berat<14.1) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==16) {
            if (berat<6.9) {
                return "sangat kurus"
            } else if (berat<7.7) {
                return "kurus"
            } else if (berat<12.6) {
                return "normal"
            } else if (berat<14.5) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==17) {
            if (berat<7.0) {
                return "sangat kurus"
            } else if (berat<7.9) {
                return "kurus"
            } else if (berat<12.9) {
                return "normal"
            } else if (berat<14.8) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==18) {
            if (berat<7.2) {
                return "sangat kurus"
            } else if (berat<8.1) {
                return "kurus"
            } else if (berat<13.2) {
                return "normal"
            } else if (berat<15.1) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==19) {
            if (berat<7.3) {
                return "sangat kurus"
            } else if (berat<8.2) {
                return "kurus"
            } else if (berat<13.5) {
                return "normal"
            } else if (berat<15.4) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==20) {
            if (berat<7.5) {
                return "sangat kurus"
            } else if (berat<8.4) {
                return "kurus"
            } else if (berat<13.7) {
                return "normal"
            } else if (berat<15.4) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==21) {
            if (berat<7.6) {
                return "sangat kurus"
            } else if (berat<8.6) {
                return "kurus"
            } else if (berat<14.0) {
                return "normal"
            } else if (berat<16.0) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==22) {
            if (berat<7.8) {
                return "sangat kurus"
            } else if (berat<8.7) {
                return "kurus"
            } else if (berat<14.3) {
                return "normal"
            } else if (berat<16.4) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==23) {
            if (berat<7.9) {
                return "sangat kurus"
            } else if (berat<8.9) {
                return "kurus"
            } else if (berat<14.6) {
                return "normal"
            } else if (berat<16.7) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==24) {
            if (berat<8.1) {
                return "sangat kurus"
            } else if (berat<9.0) {
                return "kurus"
            } else if (berat<14.8) {
                return "normal"
            } else if (berat<17.0) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        }  else if (umur==25) {
            if (berat<8.2) {
                return "sangat kurus"
            } else if (berat<9.2) {
                return "kurus"
            } else if (berat<15.1) {
                return "normal"
            } else if (berat<17.3) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==26) {
            if (berat<8.4) {
                return "sangat kurus"
            } else if (berat<9.4) {
                return "kurus"
            } else if (berat<15.4) {
                return "normal"
            } else if (berat<17.7) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==27) {
            if (berat<8.5) {
                return "sangat kurus"
            } else if (berat<9.5) {
                return "kurus"
            } else if (berat<15.7) {
                return "normal"
            } else if (berat<18.0) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==28) {
            if (berat<8.6) {
                return "sangat kurus"
            } else if (berat<9.5) {
                return "kurus"
            } else if (berat<16.0) {
                return "normal"
            } else if (berat<18.3) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==29) {
            if (berat<8.8) {
                return "sangat kurus"
            } else if (berat<9.8) {
                return "kurus"
            } else if (berat<16.2) {
                return "normal"
            } else if (berat<18.7) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==30) {
            if (berat<8.9) {
                return "sangat kurus"
            } else if (berat<10.0) {
                return "kurus"
            } else if (berat<16.5) {
                return "normal"
            } else if (berat<19.0) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==31) {
            if (berat<9.0) {
                return "sangat kurus"
            } else if (berat<10.1) {
                return "kurus"
            } else if (berat<16.8) {
                return "normal"
            } else if (berat<19.3) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==32) {
            if (berat<9.1) {
                return "sangat kurus"
            } else if (berat<10.3) {
                return "kurus"
            } else if (berat<17.1) {
                return "normal"
            } else if (berat<19.6) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==33) {
            if (berat<9.3) {
                return "sangat kurus"
            } else if (berat<10.4) {
                return "kurus"
            } else if (berat<17.3) {
                return "normal"
            } else if (berat<20.0) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==34) {
            if (berat<9.4) {
                return "sangat kurus"
            } else if (berat<10.5) {
                return "kurus"
            } else if (berat<17.6) {
                return "normal"
            } else if (berat<20.3) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==35) {
            if (berat<9.5) {
                return "sangat kurus"
            } else if (berat<10.7) {
                return "kurus"
            } else if (berat<17.9) {
                return "normal"
            } else if (berat<20.6) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==36) {
            if (berat<9.6) {
                return "sangat kurus"
            } else if (berat<10.8) {
                return "kurus"
            } else if (berat<18.1) {
                return "normal"
            } else if (berat<20.9) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==37) {
            if (berat<9.7) {
                return "sangat kurus"
            } else if (berat<10.9) {
                return "kurus"
            } else if (berat<18.4) {
                return "normal"
            } else if (berat<21.3) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==38) {
            if (berat<9.8) {
                return "sangat kurus"
            } else if (berat<11.1) {
                return "kurus"
            } else if (berat<18.7) {
                return "normal"
            } else if (berat<21.6) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==39) {
            if (berat<9.9) {
                return "sangat kurus"
            } else if (berat<11.2) {
                return "kurus"
            } else if (berat<19.0) {
                return "normal"
            } else if (berat<22.0) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==40) {
            if (berat<10.1) {
                return "sangat kurus"
            } else if (berat<11.3) {
                return "kurus"
            } else if (berat<19.2) {
                return "normal"
            } else if (berat<22.3) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==41) {
            if (berat<10.2) {
                return "sangat kurus"
            } else if (berat<11.5) {
                return "kurus"
            } else if (berat<19.5) {
                return "normal"
            } else if (berat<22.7) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==42) {
            if (berat<10.3) {
                return "sangat kurus"
            } else if (berat<11.6) {
                return "kurus"
            } else if (berat<19.8) {
                return "normal"
            } else if (berat<23.0) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==43) {
            if (berat<10.4) {
                return "sangat kurus"
            } else if (berat<11.7) {
                return "kurus"
            } else if (berat<20.1) {
                return "normal"
            } else if (berat<23.4) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==44) {
            if (berat<10.5) {
                return "sangat kurus"
            } else if (berat<11.8) {
                return "kurus"
            } else if (berat<20.4) {
                return "normal"
            } else if (berat<23.7) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==45) {
            if (berat<10.6) {
                return "sangat kurus"
            } else if (berat<12.0) {
                return "kurus"
            } else if (berat<20.7) {
                return "normal"
            } else if (berat<24.1) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==46) {
            if (berat<10.7) {
                return "sangat kurus"
            } else if (berat<12.1) {
                return "kurus"
            } else if (berat<20.9) {
                return "normal"
            } else if (berat<24.5) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==47) {
            if (berat<10.8) {
                return "sangat kurus"
            } else if (berat<12.2) {
                return "kurus"
            } else if (berat<21.2) {
                return "normal"
            } else if (berat<24.8) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==48) {
            if (berat<10.9) {
                return "sangat kurus"
            } else if (berat<12.3) {
                return "kurus"
            } else if (berat<21.5) {
                return "normal"
            } else if (berat<25.2) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==49) {
            if (berat<11.0) {
                return "sangat kurus"
            } else if (berat<12.4) {
                return "kurus"
            } else if (berat<21.8) {
                return "normal"
            } else if (berat<25.2) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==50) {
            if (berat<11.1) {
                return "sangat kurus"
            } else if (berat<12.6) {
                return "kurus"
            } else if (berat<22.1) {
                return "normal"
            } else if (berat<25.9) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==51) {
            if (berat<11.2) {
                return "sangat kurus"
            } else if (berat<12.7) {
                return "kurus"
            } else if (berat<22.4) {
                return "normal"
            } else if (berat<26.3) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==52) {
            if (berat<11.3) {
                return "sangat kurus"
            } else if (berat<12.8) {
                return "kurus"
            } else if (berat<22.6) {
                return "normal"
            } else if (berat<26.6) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==53) {
            if (berat<11.4) {
                return "sangat kurus"
            } else if (berat<12.9) {
                return "kurus"
            } else if (berat<22.9) {
                return "normal"
            } else if (berat<27.0) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==54) {
            if (berat<11.5) {
                return "sangat kurus"
            } else if (berat<13.0) {
                return "kurus"
            } else if (berat<23.2) {
                return "normal"
            } else if (berat<27.4) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==55) {
            if (berat<11.6) {
                return "sangat kurus"
            } else if (berat<13.2) {
                return "kurus"
            } else if (berat<23.5) {
                return "normal"
            } else if (berat<27.7) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==56) {
            if (berat<11.7) {
                return "sangat kurus"
            } else if (berat<13.3) {
                return "kurus"
            } else if (berat<23.8) {
                return "normal"
            } else if (berat<28.1) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==57) {
            if (berat<11.8) {
                return "sangat kurus"
            } else if (berat<13.4) {
                return "kurus"
            } else if (berat<24.1) {
                return "normal"
            } else if (berat<28.5) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==58) {
            if (berat<11.9) {
                return "sangat kurus"
            } else if (berat<13.5) {
                return "kurus"
            } else if (berat<24.4) {
                return "normal"
            } else if (berat<28.8) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==59) {
            if (berat<12.0) {
                return "sangat kurus"
            } else if (berat<13.6) {
                return "kurus"
            } else if (berat<24.6) {
                return "normal"
            } else if (berat<29.2) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==60) {
            if (berat<12.1) {
                return "sangat kurus"
            } else if (berat<13.7) {
                return "kurus"
            } else if (berat<24.9) {
                return "normal"
            } else if (berat<29.5) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        }

        return ""
    }

    private fun weightForAge2Perempuan(umur: Int): Double {
        if (umur==0) {
            return 3.2
        } else if (umur==1) {
            return 4.2
        } else if (umur==2) {
            return 5.1
        } else if (umur==3) {
            return 5.8
        } else if (umur==4) {
            return 6.4
        } else if (umur==5) {
            return 6.9
        } else if (umur==6) {
            return 7.3
        } else if (umur==7) {
            return 7.6
        } else if (umur==8) {
            return 7.9
        } else if (umur==9) {
            return 8.2
        } else if (umur==10) {
            return 8.5
        } else if (umur==11) {
            return 8.7
        } else if (umur==12) {
            return 8.9
        } else if (umur==13) {
            return 9.2
        } else if (umur==14) {
            return 9.4
        } else if (umur==15) {
            return 9.6
        } else if (umur==16) {
            return 9.8
        } else if (umur==17) {
            return 10.0
        } else if (umur==18) {
            return 10.2
        } else if (umur==19) {
            return 10.4
        } else if (umur==20) {
            return 10.6
        } else if (umur==21) {
            return 10.9
        } else if (umur==22) {
            return 11.1
        } else if (umur==23) {
            return 11.3
        } else if (umur==24) {
            return 11.5
        } else if (umur==25) {
            return 11.7
        } else if (umur==26) {
            return 11.9
        } else if (umur==27) {
            return 12.1
        } else if (umur==28) {
            return 12.3
        } else if (umur==29) {
            return 12.5
        } else if (umur==30) {
            return 12.7
        } else if (umur==31) {
            return 12.9
        } else if (umur==32) {
            return 13.1
        } else if (umur==33) {
            return 13.3
        } else if (umur==34) {
            return 13.5
        } else if (umur==35) {
            return 13.7
        } else if (umur==36) {
            return 13.9
        } else if (umur==37) {
            return 14.0
        } else if (umur==38) {
            return 14.2
        } else if (umur==39) {
            return 14.4
        } else if (umur==40) {
            return 14.6
        } else if (umur==41) {
            return 14.8
        } else if (umur==42) {
            return 15.0
        } else if (umur==43) {
            return 15.2
        } else if (umur==44) {
            return 15.3
        } else if (umur==45) {
            return 15.5
        } else if (umur==46) {
            return 15.7
        } else if (umur==47) {
            return 15.9
        } else if (umur==48) {
            return 16.1
        } else if (umur==49) {
            return 16.3
        } else if (umur==50) {
            return 16.4
        } else if (umur==51) {
            return 16.6
        } else if (umur==52) {
            return 16.8
        } else if (umur==53) {
            return 17.0
        } else if (umur==54) {
            return 17.2
        } else if (umur==55) {
            return 17.3
        } else if (umur==56) {
            return 17.5
        } else if (umur==57) {
            return 17.7
        } else if (umur==58) {
            return 17.9
        } else if (umur==59) {
            return 18.0
        } else if (umur==60) {
            return 18.2
        }

        return -1.0
    }

    private fun weightForLengthPerempuan(tinggi: Double, umur: Int): String {
        val weight = weightForAge2Perempuan(umur)

        if (tinggi<=45) {
            if (weight<1.9) {
                return "sangat buruk"
            } else if (weight<2.1) {
                return "buruk"
            } else if (weight<3) {
                return "normal"
            } else if (weight<3.3) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=46) {
            if (weight<2) {
                return "sangat buruk"
            } else if (weight<2.2) {
                return "buruk"
            } else if (weight<3.2) {
                return "normal"
            } else if (weight<3.5) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=47) {
            if (weight<2.2) {
                return "sangat buruk"
            } else if (weight<2.4) {
                return "buruk"
            } else if (weight<3.4) {
                return "normal"
            } else if (weight<3.7) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=48) {
            if (weight<2.3) {
                return "sangat buruk"
            } else if (weight<2.5) {
                return "buruk"
            } else if (weight<3.6) {
                return "normal"
            } else if (weight<4) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=49) {
            if (weight<2.4) {
                return "sangat buruk"
            } else if (weight<2.6) {
                return "buruk"
            } else if (weight<3.8) {
                return "normal"
            } else if (weight<4.2) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=50) {
            if (weight<2.6) {
                return "sangat buruk"
            } else if (weight<2.8) {
                return "buruk"
            } else if (weight<4) {
                return "normal"
            } else if (weight<4.5) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=51) {
            if (weight<2.8) {
                return "sangat buruk"
            } else if (weight<3) {
                return "buruk"
            } else if (weight<4.3) {
                return "normal"
            } else if (weight<4.8) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=52) {
            if (weight<2.9) {
                return "sangat buruk"
            } else if (weight<3.2) {
                return "buruk"
            } else if (weight<4.6) {
                return "normal"
            } else if (weight<5.1) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=53) {
            if (weight<3.1) {
                return "sangat buruk"
            } else if (weight<3.4) {
                return "buruk"
            } else if (weight<4.9) {
                return "normal"
            } else if (weight<5.4) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=54) {
            if (weight<3.3) {
                return "sangat buruk"
            } else if (weight<3.6) {
                return "buruk"
            } else if (weight<5.2) {
                return "normal"
            } else if (weight<5.7) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=55) {
            if (weight<3.5) {
                return "sangat buruk"
            } else if (weight<3.8) {
                return "buruk"
            } else if (weight<5.5) {
                return "normal"
            } else if (weight<6.1) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=56) {
            if (weight<3.7) {
                return "sangat buruk"
            } else if (weight<4.0) {
                return "buruk"
            } else if (weight<5.8) {
                return "normal"
            } else if (weight<6.6) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=57) {
            if (weight<3.9) {
                return "sangat buruk"
            } else if (weight<4.3) {
                return "buruk"
            } else if (weight<6.1) {
                return "normal"
            } else if (weight<6.8) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=58) {
            if (weight<4.1) {
                return "sangat buruk"
            } else if (weight<4.5) {
                return "buruk"
            } else if (weight<6.5) {
                return "normal"
            } else if (weight<7.1) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=59) {
            if (weight<4.3) {
                return "sangat buruk"
            } else if (weight<4.7) {
                return "buruk"
            } else if (weight<6.8) {
                return "normal"
            } else if (weight<7.5) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=60) {
            if (weight<4.5) {
                return "sangat buruk"
            } else if (weight<4.9) {
                return "buruk"
            } else if (weight<7.1) {
                return "normal"
            } else if (weight<7.8) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=61) {
            if (weight<4.7) {
                return "sangat buruk"
            } else if (weight<5.1) {
                return "buruk"
            } else if (weight<7.4) {
                return "normal"
            } else if (weight<8.2) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=62) {
            if (weight<4.9) {
                return "sangat buruk"
            } else if (weight<5.3) {
                return "buruk"
            } else if (weight<7.7) {
                return "normal"
            } else if (weight<8.5) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=63) {
            if (weight<5.1) {
                return "sangat buruk"
            } else if (weight<5.5) {
                return "buruk"
            } else if (weight<8) {
                return "normal"
            } else if (weight<8.8) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=64) {
            if (weight<5.3) {
                return "sangat buruk"
            } else if (weight<5.7) {
                return "buruk"
            } else if (weight<8.3) {
                return "normal"
            } else if (weight<9.1) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=65) {
            if (weight<5.5) {
                return "sangat buruk"
            } else if (weight<5.9) {
                return "buruk"
            } else if (weight<8.6) {
                return "normal"
            } else if (weight<9.5) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=66) {
            if (weight<5.6) {
                return "sangat buruk"
            } else if (weight<6.1) {
                return "buruk"
            } else if (weight<8.8) {
                return "normal"
            } else if (weight<9.8) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=67) {
            if (weight<5.8) {
                return "sangat buruk"
            } else if (weight<6.3) {
                return "buruk"
            } else if (weight<9.1) {
                return "normal"
            } else if (weight<10) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=68) {
            if (weight<6) {
                return "sangat buruk"
            } else if (weight<6.5) {
                return "buruk"
            } else if (weight<9.4) {
                return "normal"
            } else if (weight<10.3) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=69) {
            if (weight<6.1) {
                return "sangat buruk"
            } else if (weight<6.7) {
                return "buruk"
            } else if (weight<9.6) {
                return "normal"
            } else if (weight<10.6) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=70) {
            if (weight<6.3) {
                return "sangat buruk"
            } else if (weight<6.9) {
                return "buruk"
            } else if (weight<9.9) {
                return "normal"
            } else if (weight<10.9) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=71) {
            if (weight<6.5) {
                return "sangat buruk"
            } else if (weight<7) {
                return "buruk"
            } else if (weight<10.1) {
                return "normal"
            } else if (weight<11.1) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=72) {
            if (weight<6.6) {
                return "sangat buruk"
            } else if (weight<7.2) {
                return "buruk"
            } else if (weight<10.3) {
                return "normal"
            } else if (weight<11.4) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=73) {
            if (weight<6.8) {
                return "sangat buruk"
            } else if (weight<7.4) {
                return "buruk"
            } else if (weight<10.6) {
                return "normal"
            } else if (weight<11.7) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=74) {
            if (weight<6.9) {
                return "sangat buruk"
            } else if (weight<7.5) {
                return "buruk"
            } else if (weight<10.8) {
                return "normal"
            } else if (weight<11.9) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=75) {
            if (weight<7.1) {
                return "sangat buruk"
            } else if (weight<7.7) {
                return "buruk"
            } else if (weight<11) {
                return "normal"
            } else if (weight<12.2) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=76) {
            if (weight<7.2) {
                return "sangat buruk"
            } else if (weight<7.8) {
                return "buruk"
            } else if (weight<11.2) {
                return "normal"
            } else if (weight<12.4) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=77) {
            if (weight<7.4) {
                return "sangat buruk"
            } else if (weight<8) {
                return "buruk"
            } else if (weight<11.5) {
                return "normal"
            } else if (weight<12.6) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=78) {
            if (weight<7.5) {
                return "sangat buruk"
            } else if (weight<8.2) {
                return "buruk"
            } else if (weight<11.7) {
                return "normal"
            } else if (weight<12.9) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=79) {
            if (weight<7.7) {
                return "sangat buruk"
            } else if (weight<8.3) {
                return "buruk"
            } else if (weight<11.9) {
                return "normal"
            } else if (weight<13.1) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=80) {
            if (weight<7.8) {
                return "sangat buruk"
            } else if (weight<8.5) {
                return "buruk"
            } else if (weight<12.1) {
                return "normal"
            } else if (weight<13.4) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=81) {
            if (weight<8) {
                return "sangat buruk"
            } else if (weight<8.7) {
                return "buruk"
            } else if (weight<12.4) {
                return "normal"
            } else if (weight<13.7) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=82) {
            if (weight<8.1) {
                return "sangat buruk"
            } else if (weight<8.8) {
                return "buruk"
            } else if (weight<12.6) {
                return "normal"
            } else if (weight<13.9) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=83) {
            if (weight<8.3) {
                return "sangat buruk"
            } else if (weight<9) {
                return "buruk"
            } else if (weight<12.9) {
                return "normal"
            } else if (weight<14.2) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=84) {
            if (weight<8.5) {
                return "sangat buruk"
            } else if (weight<9.2) {
                return "buruk"
            } else if (weight<13.2) {
                return "normal"
            } else if (weight<14.5) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=85) {
            if (weight<8.7) {
                return "sangat buruk"
            } else if (weight<9.4) {
                return "buruk"
            } else if (weight<13.5) {
                return "normal"
            } else if (weight<14.9) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=86) {
            if (weight<8.9) {
                return "sangat buruk"
            } else if (weight<9.7) {
                return "buruk"
            } else if (weight<13.8) {
                return "normal"
            } else if (weight<15.2) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=87) {
            if (weight<9.1) {
                return "sangat buruk"
            } else if (weight<9.9) {
                return "buruk"
            } else if (weight<14.1) {
                return "normal"
            } else if (weight<15.5) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=88) {
            if (weight<9.3) {
                return "sangat buruk"
            } else if (weight<10.1) {
                return "buruk"
            } else if (weight<14.4) {
                return "normal"
            } else if (weight<15.9) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=89) {
            if (weight<9.5) {
                return "sangat buruk"
            } else if (weight<10.3) {
                return "buruk"
            } else if (weight<14.7) {
                return "normal"
            } else if (weight<16.2) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=90) {
            if (weight<9.7) {
                return "sangat buruk"
            } else if (weight<10.5) {
                return "buruk"
            } else if (weight<15) {
                return "normal"
            } else if (weight<16.5) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=91) {
            if (weight<9.9) {
                return "sangat buruk"
            } else if (weight<10.7) {
                return "buruk"
            } else if (weight<15.3) {
                return "normal"
            } else if (weight<16.9) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=92) {
            if (weight<10.1) {
                return "sangat buruk"
            } else if (weight<10.9) {
                return "buruk"
            } else if (weight<15.6) {
                return "normal"
            } else if (weight<17.2) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=93) {
            if (weight<10.2) {
                return "sangat buruk"
            } else if (weight<11.1) {
                return "buruk"
            } else if (weight<15.9) {
                return "normal"
            } else if (weight<17.5) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=94) {
            if (weight<10.4) {
                return "sangat buruk"
            } else if (weight<11.3) {
                return "buruk"
            } else if (weight<16.2) {
                return "normal"
            } else if (weight<17.9) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=95) {
            if (weight<10.6) {
                return "sangat buruk"
            } else if (weight<11.5) {
                return "buruk"
            } else if (weight<16.5) {
                return "normal"
            } else if (weight<18.2) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=96) {
            if (weight<10.8) {
                return "sangat buruk"
            } else if (weight<11.7) {
                return "buruk"
            } else if (weight<16.8) {
                return "normal"
            } else if (weight<18.6) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=97) {
            if (weight<11) {
                return "sangat buruk"
            } else if (weight<12) {
                return "buruk"
            } else if (weight<17.1) {
                return "normal"
            } else if (weight<18.9) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=98) {
            if (weight<11.2) {
                return "sangat buruk"
            } else if (weight<12.2) {
                return "buruk"
            } else if (weight<17.5) {
                return "normal"
            } else if (weight<19.3) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=99) {
            if (weight<11.4) {
                return "sangat buruk"
            } else if (weight<12.4) {
                return "buruk"
            } else if (weight<17.8) {
                return "normal"
            } else if (weight<19.6) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=100) {
            if (weight<11.6) {
                return "sangat buruk"
            } else if (weight<12.6) {
                return "buruk"
            } else if (weight<18.1) {
                return "normal"
            } else if (weight<20) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=101) {
            if (weight<11.8) {
                return "sangat buruk"
            } else if (weight<12.8) {
                return "buruk"
            } else if (weight<18.5) {
                return "normal"
            } else if (weight<20.4) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=102) {
            if (weight<12) {
                return "sangat buruk"
            } else if (weight<13.1) {
                return "buruk"
            } else if (weight<18.9) {
                return "normal"
            } else if (weight<20.8) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=103) {
            if (weight<12.3) {
                return "sangat buruk"
            } else if (weight<13.3) {
                return "buruk"
            } else if (weight<19.2) {
                return "normal"
            } else if (weight<21.3) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=104) {
            if (weight<12.5) {
                return "sangat buruk"
            } else if (weight<13.6) {
                return "buruk"
            } else if (weight<19.6) {
                return "normal"
            } else if (weight<21.7) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=105) {
            if (weight<12.5) {
                return "sangat buruk"
            } else if (weight<13.6) {
                return "buruk"
            } else if (weight<19.6) {
                return "normal"
            } else if (weight<21.7) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=105) {
            if (weight<12.7) {
                return "sangat buruk"
            } else if (weight<13.8) {
                return "buruk"
            } else if (weight<20) {
                return "normal"
            } else if (weight<22.2) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=106) {
            if (weight<13) {
                return "sangat buruk"
            } else if (weight<14.1) {
                return "buruk"
            } else if (weight<20.5) {
                return "normal"
            } else if (weight<22.6) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=107) {
            if (weight<13.2) {
                return "sangat buruk"
            } else if (weight<14.4) {
                return "buruk"
            } else if (weight<20.9) {
                return "normal"
            } else if (weight<23.1) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=108) {
            if (weight<13.5) {
                return "sangat buruk"
            } else if (weight<14.7) {
                return "buruk"
            } else if (weight<21.3) {
                return "normal"
            } else if (weight<23.6) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=109) {
            if (weight<13.7) {
                return "sangat buruk"
            } else if (weight<15) {
                return "buruk"
            } else if (weight<21.8) {
                return "normal"
            } else if (weight<24.2) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=110) {
            if (weight<14) {
                return "sangat buruk"
            } else if (weight<15.3) {
                return "buruk"
            } else if (weight<22.3) {
                return "normal"
            } else if (weight<24.7) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        }

        return ""
    }

    private fun headCircumferenceForAgePerempuan(lingkar: Double, umur: Int): String {
        if (umur==0) {
            if (lingkar<30.3) {
                return "sangat kecil"
            } else if (lingkar<31.5) {
                return "kecil"
            } else if (lingkar<36.2) {
                return "normal"
            } else if (lingkar<37.4) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==1) {
            if (lingkar<33) {
                return "sangat kecil"
            } else if (lingkar<34.2) {
                return "kecil"
            } else if (lingkar<38.9) {
                return "normal"
            } else if (lingkar<40.1) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==2) {
            if (lingkar<34.6) {
                return "sangat kecil"
            } else if (lingkar<35.8) {
                return "kecil"
            } else if (lingkar<40.7) {
                return "normal"
            } else if (lingkar<41.9) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==3) {
            if (lingkar<35.8) {
                return "sangat kecil"
            } else if (lingkar<37.1) {
                return "kecil"
            } else if (lingkar<42) {
                return "normal"
            } else if (lingkar<43.3) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==4) {
            if (lingkar<36.8) {
                return "sangat kecil"
            } else if (lingkar<38.1) {
                return "kecil"
            } else if (lingkar<43.1) {
                return "normal"
            } else if (lingkar<44.4) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==5) {
            if (lingkar<37.6) {
                return "sangat kecil"
            } else if (lingkar<38.9) {
                return "kecil"
            } else if (lingkar<44) {
                return "normal"
            } else if (lingkar<45.3) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==6) {
            if (lingkar<38.3) {
                return "sangat kecil"
            } else if (lingkar<39.6) {
                return "kecil"
            } else if (lingkar<44.8) {
                return "normal"
            } else if (lingkar<46.1) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==7) {
            if (lingkar<38.9) {
                return "sangat kecil"
            } else if (lingkar<40.2) {
                return "kecil"
            } else if (lingkar<45.5) {
                return "normal"
            } else if (lingkar<46.8) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==8) {
            if (lingkar<39.4) {
                return "sangat kecil"
            } else if (lingkar<40.7) {
                return "kecil"
            } else if (lingkar<46) {
                return "normal"
            } else if (lingkar<47.4) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==9) {
            if (lingkar<39.9) {
                return "sangat kecil"
            } else if (lingkar<41.2) {
                return "kecil"
            } else if (lingkar<46.5) {
                return "normal"
            } else if (lingkar<47.8) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==10) {
            if (lingkar<40.2) {
                return "sangat kecil"
            } else if (lingkar<41.5) {
                return "kecil"
            } else if (lingkar<46.9) {
                return "normal"
            } else if (lingkar<48.3) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==11) {
            if (lingkar<40.5) {
                return "sangat kecil"
            } else if (lingkar<41.9) {
                return "kecil"
            } else if (lingkar<47.3) {
                return "normal"
            } else if (lingkar<48.6) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==12) {
            if (lingkar<40.8) {
                return "sangat kecil"
            } else if (lingkar<42.2) {
                return "kecil"
            } else if (lingkar<47.6) {
                return "normal"
            } else if (lingkar<49) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==13) {
            if (lingkar<41.1) {
                return "sangat kecil"
            } else if (lingkar<42.4) {
                return "kecil"
            } else if (lingkar<47.9) {
                return "normal"
            } else if (lingkar<49.3) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==14) {
            if (lingkar<41.3) {
                return "sangat kecil"
            } else if (lingkar<42.7) {
                return "kecil"
            } else if (lingkar<48.2) {
                return "normal"
            } else if (lingkar<49.5) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==15) {
            if (lingkar<41.5) {
                return "sangat kecil"
            } else if (lingkar<42.9) {
                return "kecil"
            } else if (lingkar<48.4) {
                return "normal"
            } else if (lingkar<49.8) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==16) {
            if (lingkar<41.7) {
                return "sangat kecil"
            } else if (lingkar<43.1) {
                return "kecil"
            } else if (lingkar<48.6) {
                return "normal"
            } else if (lingkar<50) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==17) {
            if (lingkar<41.9) {
                return "sangat kecil"
            } else if (lingkar<43.3) {
                return "kecil"
            } else if (lingkar<48.8) {
                return "normal"
            } else if (lingkar<50.2) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==18) {
            if (lingkar<42.1) {
                return "sangat kecil"
            } else if (lingkar<43.5) {
                return "kecil"
            } else if (lingkar<49) {
                return "normal"
            } else if (lingkar<50.4) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==19) {
            if (lingkar<42.3) {
                return "sangat kecil"
            } else if (lingkar<43.6) {
                return "kecil"
            } else if (lingkar<49.2) {
                return "normal"
            } else if (lingkar<50.6) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==20) {
            if (lingkar<42.4) {
                return "sangat kecil"
            } else if (lingkar<43.8) {
                return "kecil"
            } else if (lingkar<49.4) {
                return "normal"
            } else if (lingkar<50.7) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==21) {
            if (lingkar<42.6) {
                return "sangat kecil"
            } else if (lingkar<44) {
                return "kecil"
            } else if (lingkar<49.5) {
                return "normal"
            } else if (lingkar<50.9) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==22) {
            if (lingkar<42.7) {
                return "sangat kecil"
            } else if (lingkar<44.1) {
                return "kecil"
            } else if (lingkar<49.7) {
                return "normal"
            } else if (lingkar<51.1) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==23) {
            if (lingkar<42.9) {
                return "sangat kecil"
            } else if (lingkar<44.3) {
                return "kecil"
            } else if (lingkar<49.8) {
                return "normal"
            } else if (lingkar<51.2) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==24) {
            if (lingkar<43) {
                return "sangat kecil"
            } else if (lingkar<44.4) {
                return "kecil"
            } else if (lingkar<50) {
                return "normal"
            } else if (lingkar<51.4) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==25) {
            if (lingkar<43.1) {
                return "sangat kecil"
            } else if (lingkar<44.5) {
                return "kecil"
            } else if (lingkar<50.1) {
                return "normal"
            } else if (lingkar<51.5) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==26) {
            if (lingkar<43.3) {
                return "sangat kecil"
            } else if (lingkar<44.7) {
                return "kecil"
            } else if (lingkar<50.3) {
                return "normal"
            } else if (lingkar<51.7) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==27) {
            if (lingkar<43.4) {
                return "sangat kecil"
            } else if (lingkar<44.8) {
                return "kecil"
            } else if (lingkar<50.4) {
                return "normal"
            } else if (lingkar<51.8) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==28) {
            if (lingkar<43.5) {
                return "sangat kecil"
            } else if (lingkar<44.9) {
                return "kecil"
            } else if (lingkar<50.5) {
                return "normal"
            } else if (lingkar<51.9) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==29) {
            if (lingkar<43.6) {
                return "sangat kecil"
            } else if (lingkar<45) {
                return "kecil"
            } else if (lingkar<50.6) {
                return "normal"
            } else if (lingkar<52) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==30) {
            if (lingkar<43.7) {
                return "sangat kecil"
            } else if (lingkar<45.1) {
                return "kecil"
            } else if (lingkar<50.7) {
                return "normal"
            } else if (lingkar<52.2) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==31) {
            if (lingkar<43.8) {
                return "sangat kecil"
            } else if (lingkar<45.2) {
                return "kecil"
            } else if (lingkar<50.9) {
                return "normal"
            } else if (lingkar<52.3) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==32) {
            if (lingkar<43.9) {
                return "sangat kecil"
            } else if (lingkar<45.3) {
                return "kecil"
            } else if (lingkar<51) {
                return "normal"
            } else if (lingkar<52.4) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==33) {
            if (lingkar<44) {
                return "sangat kecil"
            } else if (lingkar<45.4) {
                return "kecil"
            } else if (lingkar<51.1) {
                return "normal"
            } else if (lingkar<52.5) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==34) {
            if (lingkar<44.1) {
                return "sangat kecil"
            } else if (lingkar<45.5) {
                return "kecil"
            } else if (lingkar<51.2) {
                return "normal"
            } else if (lingkar<52.6) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==35) {
            if (lingkar<44.2) {
                return "sangat kecil"
            } else if (lingkar<45.6) {
                return "kecil"
            } else if (lingkar<51.2) {
                return "normal"
            } else if (lingkar<52.7) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==36) {
            if (lingkar<44.3) {
                return "sangat kecil"
            } else if (lingkar<45.7) {
                return "kecil"
            } else if (lingkar<51.3) {
                return "normal"
            } else if (lingkar<52.7) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==37) {
            if (lingkar<44.4) {
                return "sangat kecil"
            } else if (lingkar<45.8) {
                return "kecil"
            } else if (lingkar<51.4) {
                return "normal"
            } else if (lingkar<52.8) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==38) {
            if (lingkar<44.4) {
                return "sangat kecil"
            } else if (lingkar<45.8) {
                return "kecil"
            } else if (lingkar<51.5) {
                return "normal"
            } else if (lingkar<52.9) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==39) {
            if (lingkar<44.5) {
                return "sangat kecil"
            } else if (lingkar<45.9) {
                return "kecil"
            } else if (lingkar<51.6) {
                return "normal"
            } else if (lingkar<53) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==40) {
            if (lingkar<44.6) {
                return "sangat kecil"
            } else if (lingkar<46) {
                return "kecil"
            } else if (lingkar<51.7) {
                return "normal"
            } else if (lingkar<53.1) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==41) {
            if (lingkar<44.6) {
                return "sangat kecil"
            } else if (lingkar<46.1) {
                return "kecil"
            } else if (lingkar<51.7) {
                return "normal"
            } else if (lingkar<53.1) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==42) {
            if (lingkar<44.7) {
                return "sangat kecil"
            } else if (lingkar<46.1) {
                return "kecil"
            } else if (lingkar<51.8) {
                return "normal"
            } else if (lingkar<53.2) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==43) {
            if (lingkar<44.8) {
                return "sangat kecil"
            } else if (lingkar<46.2) {
                return "kecil"
            } else if (lingkar<51.9) {
                return "normal"
            } else if (lingkar<53.3) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==44) {
            if (lingkar<44.8) {
                return "sangat kecil"
            } else if (lingkar<46.3) {
                return "kecil"
            } else if (lingkar<51.9) {
                return "normal"
            } else if (lingkar<53.3) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==45) {
            if (lingkar<44.9) {
                return "sangat kecil"
            } else if (lingkar<46.3) {
                return "kecil"
            } else if (lingkar<52) {
                return "normal"
            } else if (lingkar<53.4) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==46) {
            if (lingkar<45) {
                return "sangat kecil"
            } else if (lingkar<46.4) {
                return "kecil"
            } else if (lingkar<52.1) {
                return "normal"
            } else if (lingkar<53.5) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==47) {
            if (lingkar<45) {
                return "sangat kecil"
            } else if (lingkar<46.4) {
                return "kecil"
            } else if (lingkar<52.1) {
                return "normal"
            } else if (lingkar<53.5) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==48) {
            if (lingkar<45.1) {
                return "sangat kecil"
            } else if (lingkar<46.5) {
                return "kecil"
            } else if (lingkar<52.2) {
                return "normal"
            } else if (lingkar<53.6) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==49) {
            if (lingkar<45.1) {
                return "sangat kecil"
            } else if (lingkar<46.5) {
                return "kecil"
            } else if (lingkar<52.2) {
                return "normal"
            } else if (lingkar<53.6) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==50) {
            if (lingkar<45.2) {
                return "sangat kecil"
            } else if (lingkar<46.6) {
                return "kecil"
            } else if (lingkar<52.3) {
                return "normal"
            } else if (lingkar<53.7) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==51) {
            if (lingkar<45.2) {
                return "sangat kecil"
            } else if (lingkar<46.7) {
                return "kecil"
            } else if (lingkar<52.3) {
                return "normal"
            } else if (lingkar<53.8) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==52) {
            if (lingkar<45.3) {
                return "sangat kecil"
            } else if (lingkar<46.7) {
                return "kecil"
            } else if (lingkar<52.4) {
                return "normal"
            } else if (lingkar<53.8) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==53) {
            if (lingkar<45.3) {
                return "sangat kecil"
            } else if (lingkar<46.8) {
                return "kecil"
            } else if (lingkar<52.4) {
                return "normal"
            } else if (lingkar<53.9) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==54) {
            if (lingkar<45.4) {
                return "sangat kecil"
            } else if (lingkar<46.8) {
                return "kecil"
            } else if (lingkar<52.5) {
                return "normal"
            } else if (lingkar<53.9) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==55) {
            if (lingkar<45.4) {
                return "sangat kecil"
            } else if (lingkar<46.9) {
                return "kecil"
            } else if (lingkar<52.5) {
                return "normal"
            } else if (lingkar<54) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==56) {
            if (lingkar<45.5) {
                return "sangat kecil"
            } else if (lingkar<46.9) {
                return "kecil"
            } else if (lingkar<52.6) {
                return "normal"
            } else if (lingkar<54) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==57) {
            if (lingkar<45.5) {
                return "sangat kecil"
            } else if (lingkar<46.9) {
                return "kecil"
            } else if (lingkar<52.6) {
                return "normal"
            } else if (lingkar<54.1) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==58) {
            if (lingkar<45.6) {
                return "sangat kecil"
            } else if (lingkar<47) {
                return "kecil"
            } else if (lingkar<52.7) {
                return "normal"
            } else if (lingkar<54.1) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==59) {
            if (lingkar<45.6) {
                return "sangat kecil"
            } else if (lingkar<47) {
                return "kecil"
            } else if (lingkar<52.7) {
                return "normal"
            } else if (lingkar<54.1) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==60) {
            if (lingkar<45.7) {
                return "sangat kecil"
            } else if (lingkar<47.1) {
                return "kecil"
            } else if (lingkar<52.8) {
                return "normal"
            } else if (lingkar<54.2) {
                return "besar"
            } else {
                return "sangat besar"
            }
        }

        return ""
    }

    private fun heightForAgeLakilaki(tinggi: Double, umur: Int): String {
        if (umur==0) {
            if (tinggi<44.2) {
                return "sangat pendek"
            } else if (tinggi<46.1) {
                return "pendek"
            } else if (tinggi<53.7) {
                return "normal"
            } else if (tinggi<55.6) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==1) {
            if (tinggi<48.9) {
                return "sangat pendek"
            } else if (tinggi<50.8) {
                return "pendek"
            } else if (tinggi<58.6) {
                return "normal"
            } else if (tinggi<60.6) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==2) {
            if (tinggi<52.4) {
                return "sangat pendek"
            } else if (tinggi<54.4) {
                return "pendek"
            } else if (tinggi<62.4) {
                return "normal"
            } else if (tinggi<64.4) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==3) {
            if (tinggi<55.3) {
                return "sangat pendek"
            } else if (tinggi<57.3) {
                return "pendek"
            } else if (tinggi<65.5) {
                return "normal"
            } else if (tinggi<67.6) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==4) {
            if (tinggi<57.6) {
                return "sangat pendek"
            } else if (tinggi<59.7) {
                return "pendek"
            } else if (tinggi<68.0) {
                return "normal"
            } else if (tinggi<70.1) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==5) {
            if (tinggi<59.6) {
                return "sangat pendek"
            } else if (tinggi<61.7) {
                return "pendek"
            } else if (tinggi<70.1) {
                return "normal"
            } else if (tinggi<72.2) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==6) {
            if (tinggi<61.2) {
                return "sangat pendek"
            } else if (tinggi<63.3) {
                return "pendek"
            } else if (tinggi<71.9) {
                return "normal"
            } else if (tinggi<74.0) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==7) {
            if (tinggi<62.7) {
                return "sangat pendek"
            } else if (tinggi<64.8) {
                return "pendek"
            } else if (tinggi<73.5) {
                return "normal"
            } else if (tinggi<75.7) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==8) {
            if (tinggi<64.0) {
                return "sangat pendek"
            } else if (tinggi<66.2) {
                return "pendek"
            } else if (tinggi<75.0) {
                return "normal"
            } else if (tinggi<77.2) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==9) {
            if (tinggi<65.2) {
                return "sangat pendek"
            } else if (tinggi<67.5) {
                return "pendek"
            } else if (tinggi<76.5) {
                return "normal"
            } else if (tinggi<78.7) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==10) {
            if (tinggi<66.4) {
                return "sangat pendek"
            } else if (tinggi<68.7) {
                return "pendek"
            } else if (tinggi<77.9) {
                return "normal"
            } else if (tinggi<80.1) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==11) {
            if (tinggi<67.6) {
                return "sangat pendek"
            } else if (tinggi<69.9) {
                return "pendek"
            } else if (tinggi<79.2) {
                return "normal"
            } else if (tinggi<81.5) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==12) {
            if (tinggi<68.6) {
                return "sangat pendek"
            } else if (tinggi<71.0) {
                return "pendek"
            } else if (tinggi<80.5) {
                return "normal"
            } else if (tinggi<82.9) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==13) {
            if (tinggi<69.6) {
                return "sangat pendek"
            } else if (tinggi<72.1) {
                return "pendek"
            } else if (tinggi<81.8) {
                return "normal"
            } else if (tinggi<84.2) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==14) {
            if (tinggi<70.6) {
                return "sangat pendek"
            } else if (tinggi<73.1) {
                return "pendek"
            } else if (tinggi<83.0) {
                return "normal"
            } else if (tinggi<85.5) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==15) {
            if (tinggi<71.6) {
                return "sangat pendek"
            } else if (tinggi<74.1) {
                return "pendek"
            } else if (tinggi<84.2) {
                return "normal"
            } else if (tinggi<86.7) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==16) {
            if (tinggi<72.5) {
                return "sangat pendek"
            } else if (tinggi<75.0) {
                return "pendek"
            } else if (tinggi<85.4) {
                return "normal"
            } else if (tinggi<88.0) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==17) {
            if (tinggi<73.3) {
                return "sangat pendek"
            } else if (tinggi<76.0) {
                return "pendek"
            } else if (tinggi<86.5) {
                return "normal"
            } else if (tinggi<89.2) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==18) {
            if (tinggi<74.2) {
                return "sangat pendek"
            } else if (tinggi<76.9) {
                return "pendek"
            } else if (tinggi<87.7) {
                return "normal"
            } else if (tinggi<90.4) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==19) {
            if (tinggi<75.0) {
                return "sangat pendek"
            } else if (tinggi<77.7) {
                return "pendek"
            } else if (tinggi<88.8) {
                return "normal"
            } else if (tinggi<91.5) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==20) {
            if (tinggi<75.8) {
                return "sangat pendek"
            } else if (tinggi<78.6) {
                return "pendek"
            } else if (tinggi<89.8) {
                return "normal"
            } else if (tinggi<92.6) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        }  else if (umur==21) {
            if (tinggi<76.5) {
                return "sangat pendek"
            } else if (tinggi<79.4) {
                return "pendek"
            } else if (tinggi<90.9) {
                return "normal"
            } else if (tinggi<93.8) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==22) {
            if (tinggi<77.2) {
                return "sangat pendek"
            } else if (tinggi<80.2) {
                return "pendek"
            } else if (tinggi<91.9) {
                return "normal"
            } else if (tinggi<94.9) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==23) {
            if (tinggi<78.0) {
                return "sangat pendek"
            } else if (tinggi<81.0) {
                return "pendek"
            } else if (tinggi<92.9) {
                return "normal"
            } else if (tinggi<95.9) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==24) {
            if (tinggi<78.7) {
                return "sangat pendek"
            } else if (tinggi<81.7) {
                return "pendek"
            } else if (tinggi<93.9) {
                return "normal"
            } else if (tinggi<97.0) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==25) {
            if (tinggi<78.6) {
                return "sangat pendek"
            } else if (tinggi<81.7) {
                return "pendek"
            } else if (tinggi<95.2) {
                return "normal"
            } else if (tinggi<97.3) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==26) {
            if (tinggi<79.3) {
                return "sangat pendek"
            } else if (tinggi<82.5) {
                return "pendek"
            } else if (tinggi<95.2) {
                return "normal"
            } else if (tinggi<98.6) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==27) {
            if (tinggi<79.9) {
                return "sangat pendek"
            } else if (tinggi<83.1) {
                return "pendek"
            } else if (tinggi<96.1) {
                return "normal"
            } else if (tinggi<99.3) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==28) {
            if (tinggi<80.5) {
                return "sangat pendek"
            } else if (tinggi<83.8) {
                return "pendek"
            } else if (tinggi<97.0) {
                return "normal"
            } else if (tinggi<100.3) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==29) {
            if (tinggi<81.1) {
                return "sangat pendek"
            } else if (tinggi<85.1) {
                return "pendek"
            } else if (tinggi<97.9) {
                return "normal"
            } else if (tinggi<101.2) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==30) {
            if (tinggi<81.7) {
                return "sangat pendek"
            } else if (tinggi<85.1) {
                return "pendek"
            } else if (tinggi<98.7) {
                return "normal"
            } else if (tinggi<102.1) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==31) {
            if (tinggi<82.3) {
                return "sangat pendek"
            } else if (tinggi<85.7) {
                return "pendek"
            } else if (tinggi<99.6) {
                return "normal"
            } else if (tinggi<103.0) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==32) {
            if (tinggi<82.8) {
                return "sangat pendek"
            } else if (tinggi<86.4) {
                return "pendek"
            } else if (tinggi<100.4) {
                return "normal"
            } else if (tinggi<103.9) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==33) {
            if (tinggi<83.4) {
                return "sangat pendek"
            } else if (tinggi<86.9) {
                return "pendek"
            } else if (tinggi<101.2) {
                return "normal"
            } else if (tinggi<104.8) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==34) {
            if (tinggi<83.9) {
                return "sangat pendek"
            } else if (tinggi<87.5) {
                return "pendek"
            } else if (tinggi<102.0) {
                return "normal"
            } else if (tinggi<105.6) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==35) {
            if (tinggi<84.4) {
                return "sangat pendek"
            } else if (tinggi<88.1) {
                return "pendek"
            } else if (tinggi<102.7) {
                return "normal"
            } else if (tinggi<106.4) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==36) {
            if (tinggi<85.0) {
                return "sangat pendek"
            } else if (tinggi<88.7) {
                return "pendek"
            } else if (tinggi<103.5) {
                return "normal"
            } else if (tinggi<107.2) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==37) {
            if (tinggi<85.5) {
                return "sangat pendek"
            } else if (tinggi<89.2) {
                return "pendek"
            } else if (tinggi<104.2) {
                return "normal"
            } else if (tinggi<108.0) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==38) {
            if (tinggi<86.0) {
                return "sangat pendek"
            } else if (tinggi<89.8) {
                return "pendek"
            } else if (tinggi<105.0) {
                return "normal"
            } else if (tinggi<108.8) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==39) {
            if (tinggi<86.5) {
                return "sangat pendek"
            } else if (tinggi<90.3) {
                return "pendek"
            } else if (tinggi<105.7) {
                return "normal"
            } else if (tinggi<109.5) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==40) {
            if (tinggi<87.0) {
                return "sangat pendek"
            } else if (tinggi<90.9) {
                return "pendek"
            } else if (tinggi<106.4) {
                return "normal"
            } else if (tinggi<110.3) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==41) {
            if (tinggi<87.5) {
                return "sangat pendek"
            } else if (tinggi<91.4) {
                return "pendek"
            } else if (tinggi<107.1) {
                return "normal"
            } else if (tinggi<111.0) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==42) {
            if (tinggi<88.0) {
                return "sangat pendek"
            } else if (tinggi<91.9) {
                return "pendek"
            } else if (tinggi<107.8) {
                return "normal"
            } else if (tinggi<111.7) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==43) {
            if (tinggi<88.4) {
                return "sangat pendek"
            } else if (tinggi<92.4) {
                return "pendek"
            } else if (tinggi<108.5) {
                return "normal"
            } else if (tinggi<112.5) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==44) {
            if (tinggi<88.9) {
                return "sangat pendek"
            } else if (tinggi<93.0) {
                return "pendek"
            } else if (tinggi<109.1) {
                return "normal"
            } else if (tinggi<113.5) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==45) {
            if (tinggi<89.4) {
                return "sangat pendek"
            } else if (tinggi<93.5) {
                return "pendek"
            } else if (tinggi<109.8) {
                return "normal"
            } else if (tinggi<113.9) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==46) {
            if (tinggi<89.8) {
                return "sangat pendek"
            } else if (tinggi<94.0) {
                return "pendek"
            } else if (tinggi<110.4) {
                return "normal"
            } else if (tinggi<114.6) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==47) {
            if (tinggi<90.3) {
                return "sangat pendek"
            } else if (tinggi<94.4) {
                return "pendek"
            } else if (tinggi<111.1) {
                return "normal"
            } else if (tinggi<115.2) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==48) {
            if (tinggi<90.7) {
                return "sangat pendek"
            } else if (tinggi<94.9) {
                return "pendek"
            } else if (tinggi<111.7) {
                return "normal"
            } else if (tinggi<115.9) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        }else if (umur==49) {
            if (tinggi<91.2) {
                return "sangat pendek"
            } else if (tinggi<95.4) {
                return "pendek"
            } else if (tinggi<112.4) {
                return "normal"
            } else if (tinggi<116.6) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==50) {
            if (tinggi<91.6) {
                return "sangat pendek"
            } else if (tinggi<95.9) {
                return "pendek"
            } else if (tinggi<113.0) {
                return "normal"
            } else if (tinggi<117.3) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==51) {
            if (tinggi<92.1) {
                return "sangat pendek"
            } else if (tinggi<96.4) {
                return "pendek"
            } else if (tinggi<113.6) {
                return "normal"
            } else if (tinggi<117.9) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==52) {
            if (tinggi<92.5) {
                return "sangat pendek"
            } else if (tinggi<96.9) {
                return "pendek"
            } else if (tinggi<114.2) {
                return "normal"
            } else if (tinggi<118.6) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==53) {
            if (tinggi<93.0) {
                return "sangat pendek"
            } else if (tinggi<97.4) {
                return "pendek"
            } else if (tinggi<114.9) {
                return "normal"
            } else if (tinggi<119.2) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==54) {
            if (tinggi<93.4) {
                return "sangat pendek"
            } else if (tinggi<97.8) {
                return "pendek"
            } else if (tinggi<115.5) {
                return "normal"
            } else if (tinggi<119.9) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==55) {
            if (tinggi<93.9) {
                return "sangat pendek"
            } else if (tinggi<98.3) {
                return "pendek"
            } else if (tinggi<116.1) {
                return "normal"
            } else if (tinggi<120.6) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==56) {
            if (tinggi<94.3) {
                return "sangat pendek"
            } else if (tinggi<98.8) {
                return "pendek"
            } else if (tinggi<116.7) {
                return "normal"
            } else if (tinggi<121.2) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==57) {
            if (tinggi<94.7) {
                return "sangat pendek"
            } else if (tinggi<99.3) {
                return "pendek"
            } else if (tinggi<117.4) {
                return "normal"
            } else if (tinggi<121.9) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==58) {
            if (tinggi<95.2) {
                return "sangat pendek"
            } else if (tinggi<99.7) {
                return "pendek"
            } else if (tinggi<118.0) {
                return "normal"
            } else if (tinggi<122.6) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==59) {
            if (tinggi<95.6) {
                return "sangat pendek"
            } else if (tinggi<100.2) {
                return "pendek"
            } else if (tinggi<118.6) {
                return "normal"
            } else if (tinggi<123.2) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        } else if (umur==60) {
            if (tinggi<96.1) {
                return "sangat pendek"
            } else if (tinggi<100.7) {
                return "pendek"
            } else if (tinggi<119.2) {
                return "normal"
            } else if (tinggi<123.9) {
                return "tinggi"
            } else {
                return "sangat tinggi"
            }
        }

        return ""
    }

    private fun weightForAge1Lakilaki(berat: Double, umur: Int): String {
        if (umur==0) {
            if (berat<2.1) {
                return "sangat kurus"
            } else if (berat<2.5) {
                return "kurus"
            } else if (berat<4.4) {
                return "normal"
            } else if (berat<5) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==1) {
            if (berat<2.9) {
                return "sangat kurus"
            } else if (berat<3.4) {
                return "kurus"
            } else if (berat<5.8) {
                return "normal"
            } else if (berat<6.6) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==2) {
            if (berat<3.8) {
                return "sangat kurus"
            } else if (berat<4.3) {
                return "kurus"
            } else if (berat<7.1) {
                return "normal"
            } else if (berat<8) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==3) {
            if (berat<4.4) {
                return "sangat kurus"
            } else if (berat<5) {
                return "kurus"
            } else if (berat<8) {
                return "normal"
            } else if (berat<9) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==4) {
            if (berat<4.9) {
                return "sangat kurus"
            } else if (berat<5.6) {
                return "kurus"
            } else if (berat<8.7) {
                return "normal"
            } else if (berat<9.7) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==5) {
            if (berat<5.3) {
                return "sangat kurus"
            } else if (berat<6) {
                return "kurus"
            } else if (berat<9.3) {
                return "normal"
            } else if (berat<10.4) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==6) {
            if (berat<5.7) {
                return "sangat kurus"
            } else if (berat<6.4) {
                return "kurus"
            } else if (berat<9.8) {
                return "normal"
            } else if (berat<10.9) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        }  else if (umur==7) {
            if (berat<5.9) {
                return "sangat kurus"
            } else if (berat<6.7) {
                return "kurus"
            } else if (berat<10.3) {
                    return "normal"
                } else if (berat<11.4) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        }  else if (umur==8) {
            if (berat<6.2) {
                return "sangat kurus"
            } else if (berat<6.9) {
                return "kurus"
            } else if (berat<10.7) {
                return "normal"
            } else if (berat<11.9) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==9) {
            if (berat<6.4) {
                return "sangat kurus"
            } else if (berat<7.1) {
                return "kurus"
            } else if (berat<11) {
                return "normal"
            } else if (berat<12.3) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        }  else if (umur==10) {
            if (berat<6.6) {
                return "sangat kurus"
            } else if (berat<7.4) {
                return "kurus"
            } else if (berat<11.4) {
                return "normal"
            } else if (berat<12.7) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        }  else if (umur==11) {
            if (berat<6.8) {
                return "sangat kurus"
            } else if (berat<7.6) {
                return "kurus"
            } else if (berat<11.7) {
                return "normal"
            } else if (berat<13) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        }  else if (umur==12) {
            if (berat<6.9) {
                return "sangat kurus"
            } else if (berat<7.7) {
                return "kurus"
            } else if (berat<12) {
                return "normal"
            } else if (berat<13.3) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==13) {
            if (berat<7.1) {
                return "sangat kurus"
            } else if (berat<7.9) {
                return "kurus"
            } else if (berat<12.3) {
                return "normal"
            } else if (berat<13.7) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==14) {
            if (berat<7.2) {
                return "sangat kurus"
            } else if (berat<8.1) {
                return "kurus"
            } else if (berat<12.6) {
                return "normal"
            } else if (berat<14) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==15) {
            if (berat<7.4) {
                return "sangat kurus"
            } else if (berat<8.3) {
                return "kurus"
            } else if (berat<12.8) {
                return "normal"
            } else if (berat<14.3) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==16) {
            if (berat<7.5) {
                return "sangat kurus"
            } else if (berat<8.4) {
                return "kurus"
            } else if (berat<13.1) {
                return "normal"
            } else if (berat<14.6) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==17) {
            if (berat<7.7) {
                return "sangat kurus"
            } else if (berat<8.6) {
                return "kurus"
            } else if (berat<13.4) {
                return "normal"
            } else if (berat<14.9) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==18) {
            if (berat<7.8) {
                return "sangat kurus"
            } else if (berat<8.8) {
                return "kurus"
            } else if (berat<13.7) {
                return "normal"
            } else if (berat<15.3) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==19) {
            if (berat<8) {
                return "sangat kurus"
            } else if (berat<8.9) {
                return "kurus"
            } else if (berat<13.9) {
                return "normal"
            } else if (berat<15.6) {
                    return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==20) {
            if (berat<8.1) {
                return "sangat kurus"
            } else if (berat<9.1) {
                return "kurus"
            } else if (berat<14.2) {
                return "normal"
            } else if (berat<15.9) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==21) {
            if (berat<8.2) {
                return "sangat kurus"
            } else if (berat<9.2) {
                return "kurus"
            } else if (berat<14.5) {
                return "normal"
            } else if (berat<16.2) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==22) {
            if (berat<8.4) {
                return "sangat kurus"
            } else if (berat<9.4) {
                return "kurus"
            } else if (berat<14.7) {
                return "normal"
            } else if (berat<16.5) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==23) {
            if (berat<8.5) {
                return "sangat kurus"
            } else if (berat<9.5) {
                return "kurus"
            } else if (berat<15) {
                return "normal"
            } else if (berat<16.8) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==24) {
            if (berat<8.6) {
                return "sangat kurus"
            } else if (berat<9.7) {
                return "kurus"
            } else if (berat<15.3) {
                return "normal"
            } else if (berat<17.1) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        }  else if (umur==25) {
            if (berat<8.8) {
                return "sangat kurus"
            } else if (berat<9.8) {
                return "kurus"
            } else if (berat<15.5) {
                return "normal"
            } else if (berat<17.5) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==26) {
            if (berat<8.9) {
                return "sangat kurus"
            } else if (berat<10) {
                return "kurus"
            } else if (berat<15.8) {
                return "normal"
            } else if (berat<17.8) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==27) {
            if (berat<9) {
                return "sangat kurus"
            } else if (berat<10.1) {
                return "kurus"
            } else if (berat<16.1) {
                return "normal"
            } else if (berat<18.1) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==28) {
            if (berat<9.1) {
                return "sangat kurus"
            } else if (berat<10.2) {
                return "kurus"
            } else if (berat<16.3) {
                return "normal"
            } else if (berat<18.4) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==29) {
            if (berat<9.2) {
                return "sangat kurus"
            } else if (berat<10.4) {
                return "kurus"
            } else if (berat<16.6) {
                return "normal"
            } else if (berat<18.7) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==30) {
            if (berat<9.4) {
                return "sangat kurus"
            } else if (berat<10.5) {
                return "kurus"
            } else if (berat<16.9) {
                return "normal"
            } else if (berat<19) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==31) {
            if (berat<9.5) {
                return "sangat kurus"
            } else if (berat<10.7) {
                return "kurus"
            } else if (berat<17.1) {
                return "normal"
            } else if (berat<19.3) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==32) {
            if (berat<9.6) {
                return "sangat kurus"
            } else if (berat<10.8) {
                return "kurus"
            } else if (berat<17.4) {
                return "normal"
            } else if (berat<19.6) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==33) {
            if (berat<9.7) {
                return "sangat kurus"
            } else if (berat<10.9) {
                return "kurus"
            } else if (berat<17.6) {
                return "normal"
            } else if (berat<19.9) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==34) {
            if (berat<9.8) {
                return "sangat kurus"
            } else if (berat<11) {
                return "kurus"
            } else if (berat<17.8) {
                return "normal"
            } else if (berat<20.2) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==35) {
            if (berat<9.9) {
                return "sangat kurus"
            } else if (berat<11.2) {
                return "kurus"
            } else if (berat<18.1) {
                return "normal"
            } else if (berat<20.4) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==36) {
            if (berat<10) {
                return "sangat kurus"
            } else if (berat<11.3) {
                return "kurus"
            } else if (berat<18.3) {
                return "normal"
            } else if (berat<20.7) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==37) {
            if (berat<10.1) {
                return "sangat kurus"
            } else if (berat<11.4) {
                return "kurus"
            } else if (berat<18.6) {
                return "normal"
            } else if (berat<21) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==38) {
            if (berat<10.2) {
                return "sangat kurus"
            } else if (berat<11.5) {
                return "kurus"
            } else if (berat<18.8) {
                return "normal"
            } else if (berat<21.3) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==39) {
            if (berat<10.3) {
                return "sangat kurus"
            } else if (berat<11.6) {
                return "kurus"
            } else if (berat<19) {
                return "normal"
            } else if (berat<21.6) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==40) {
            if (berat<10.4) {
                return "sangat kurus"
            } else if (berat<11.8) {
                return "kurus"
            } else if (berat<19.3) {
                return "normal"
            } else if (berat<21.9) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==41) {
            if (berat<10.5) {
                return "sangat kurus"
            } else if (berat<11.9) {
                return "kurus"
            } else if (berat<19.5) {
                return "normal"
            } else if (berat<22.1) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==42) {
            if (berat<10.6) {
                return "sangat kurus"
            } else if (berat<12) {
                return "kurus"
            } else if (berat<19.7) {
                return "normal"
            } else if (berat<22.4) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==43) {
            if (berat<10.7) {
                return "sangat kurus"
            } else if (berat<12.1) {
                    return "kurus"
                } else if (berat<20) {
                return "normal"
            } else if (berat<22.7) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==44) {
            if (berat<10.8) {
                return "sangat kurus"
            } else if (berat<12.2) {
                return "kurus"
            } else if (berat<20.2) {
                return "normal"
            } else if (berat<23) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==45) {
            if (berat<10.9) {
                return "sangat kurus"
            } else if (berat<12.4) {
                return "kurus"
            } else if (berat<20.5) {
                return "normal"
            } else if (berat<23.3) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==46) {
            if (berat<11) {
                return "sangat kurus"
            } else if (berat<12.5) {
                return "kurus"
            } else if (berat<20.7) {
                return "normal"
            } else if (berat<23.6) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==47) {
            if (berat<11.1) {
                return "sangat kurus"
            } else if (berat<12.6) {
                return "kurus"
            } else if (berat<20.9) {
                return "normal"
            } else if (berat<23.9) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==48) {
            if (berat<11.2) {
                return "sangat kurus"
            } else if (berat<12.7) {
                return "kurus"
            } else if (berat<21.2) {
                return "normal"
            } else if (berat<24.2) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==49) {
            if (berat<11.3) {
                return "sangat kurus"
            } else if (berat<12.8) {
                return "kurus"
            } else if (berat<21.4) {
                return "normal"
            } else if (berat<24.5) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==50) {
            if (berat<11.4) {
                return "sangat kurus"
            } else if (berat<12.9) {
                return "kurus"
            } else if (berat<21.7) {
                return "normal"
            } else if (berat<24.8) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==51) {
            if (berat<11.5) {
                return "sangat kurus"
            } else if (berat<13.1) {
                return "kurus"
            } else if (berat<21.9) {
                return "normal"
            } else if (berat<25.1) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==52) {
            if (berat<11.6) {
                return "sangat kurus"
            } else if (berat<13.2) {
                return "kurus"
            } else if (berat<22.2) {
                return "normal"
            } else if (berat<25.4) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==53) {
            if (berat<11.7) {
                return "sangat kurus"
            } else if (berat<13.3) {
                return "kurus"
            } else if (berat<22.4) {
                return "normal"
            } else if (berat<25.7) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==54) {
            if (berat<11.8) {
                return "sangat kurus"
            } else if (berat<13.4) {
                return "kurus"
            } else if (berat<22.7) {
                return "normal"
            } else if (berat<26) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==55) {
            if (berat<11.9) {
                return "sangat kurus"
            } else if (berat<13.5) {
                return "kurus"
            } else if (berat<22.9) {
                return "normal"
            } else if (berat<26.3) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==56) {
            if (berat<12) {
                return "sangat kurus"
            } else if (berat<13.6) {
                return "kurus"
            } else if (berat<23.2) {
                return "normal"
            } else if (berat<26.6) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==57) {
            if (berat<12.1) {
                return "sangat kurus"
            } else if (berat<13.7) {
                return "kurus"
            } else if (berat<23.4) {
                return "normal"
            } else if (berat<26.9) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==58) {
            if (berat<12.2) {
                return "sangat kurus"
            } else if (berat<13.8) {
                return "kurus"
            } else if (berat<23.7) {
                return "normal"
            } else if (berat<27.2) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==59) {
            if (berat<12.3) {
                return "sangat kurus"
            } else if (berat<14) {
                return "kurus"
            } else if (berat<23.9) {
                return "normal"
            } else if (berat<27.6) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        } else if (umur==60) {
            if (berat<12.4) {
                return "sangat kurus"
            } else if (berat<14.1) {
                return "kurus"
            } else if (berat<24.2) {
                return "normal"
            } else if (berat<27.9) {
                return "gemuk"
            } else {
                return "sangat gemuk"
            }
        }

        return ""
    }

    private fun weightForAge2Lakilaki(umur: Int): Double {
        if (umur==0) {
            return 3.3
        } else if (umur==1) {
            return 4.5
        } else if (umur==2) {
            return 5.6
        } else if (umur==3) {
            return 6.4
        } else if (umur==4) {
            return 7.0
        } else if (umur==5) {
            return 7.5
        } else if (umur==6) {
            return 7.9
        } else if (umur==7) {
            return 8.3
        } else if (umur==8) {
            return 8.6
        } else if (umur==9) {
            return 8.9
        } else if (umur==10) {
            return 9.2
        } else if (umur==11) {
            return 9.4
        } else if (umur==12) {
            return 9.6
        } else if (umur==13) {
            return 9.9
        } else if (umur==14) {
            return 10.1
        } else if (umur==15) {
            return 10.3
        } else if (umur==16) {
            return 10.5
        } else if (umur==17) {
            return 10.7
        } else if (umur==18) {
            return 10.9
        } else if (umur==19) {
            return 11.1
        } else if (umur==20) {
            return 11.3
        } else if (umur==21) {
            return 11.5
        } else if (umur==22) {
            return 11.8
        } else if (umur==23) {
            return 12.0
        } else if (umur==24) {
            return 12.2
        } else if (umur==25) {
            return 12.4
        } else if (umur==26) {
            return 12.5
        } else if (umur==27) {
            return 12.7
        } else if (umur==28) {
            return 12.9
        } else if (umur==29) {
            return 13.1
        } else if (umur==30) {
            return 13.3
        } else if (umur==31) {
            return 13.5
        } else if (umur==32) {
            return 13.7
        } else if (umur==33) {
            return 13.8
        } else if (umur==34) {
            return 14.0
        } else if (umur==35) {
            return 14.2
        } else if (umur==36) {
            return 14.3
        } else if (umur==37) {
            return 14.5
        } else if (umur==38) {
            return 14.7
        } else if (umur==39) {
            return 14.8
        } else if (umur==40) {
            return 15.0
        } else if (umur==41) {
            return 15.2
        } else if (umur==42) {
            return 15.3
        } else if (umur==43) {
            return 15.5
        } else if (umur==44) {
            return 15.7
        } else if (umur==45) {
            return 15.8
        } else if (umur==46) {
            return 16.0
        } else if (umur==47) {
            return 16.2
        } else if (umur==48) {
            return 16.3
        } else if (umur==49) {
            return 16.5
        } else if (umur==50) {
            return 16.7
        } else if (umur==51) {
            return 16.8
        } else if (umur==52) {
            return 17.0
        } else if (umur==53) {
            return 17.2
        } else if (umur==54) {
            return 17.3
        } else if (umur==55) {
            return 17.5
        } else if (umur==56) {
            return 17.7
        } else if (umur==57) {
            return 17.8
        } else if (umur==58) {
            return 18.0
        } else if (umur==59) {
            return 18.2
        } else if (umur==60) {
            return 18.3
        }

        return -1.0
    }

    private fun weightForLengthLakilaki(tinggi: Double, umur: Int): String {
        val weight = weightForAge2Lakilaki(umur)

        if (tinggi<=45) {
            if (weight<1.9) {
                return "sangat buruk"
            } else if (weight<2) {
                return "buruk"
            } else if (weight<3) {
                return "normal"
            } else if (weight<3.3) {
                return "buruk"
            } else {
                return "sangat buruk"
            }
        } else if (tinggi<=46) {
            if (weight<2) {
                return "sangat buruk"
            } else if (weight<2.2) {
                return "buruk"
            } else if (weight<3.1) {
                return "normal"
            } else if (weight<3.5) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=47) {
            if (weight<2.1) {
                return "sangat buruk"
            } else if (weight<2.3) {
                return "buruk"
            } else if (weight<3.3) {
                return "normal"
            } else if (weight<3.7) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=48) {
            if (weight<2.3) {
                return "sangat buruk"
            } else if (weight<2.5) {
                return "buruk"
            } else if (weight<3.6) {
                return "normal"
            } else if (weight<3.9) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=49) {
            if (weight<2.4) {
                return "sangat buruk"
            } else if (weight<2.6) {
                return "buruk"
            } else if (weight<3.8) {
                return "normal"
            } else if (weight<4.2) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=50) {
            if (weight<2.6) {
                return "sangat buruk"
            } else if (weight<2.8) {
                return "buruk"
            } else if (weight<4) {
                return "normal"
            } else if (weight<4.4) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=51) {
            if (weight<2.7) {
                return "sangat buruk"
            } else if (weight<3) {
                return "buruk"
            } else if (weight<4.2) {
                return "normal"
            } else if (weight<4.7) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=52) {
            if (weight<2.9) {
                return "sangat buruk"
            } else if (weight<3.2) {
                return "buruk"
            } else if (weight<4.5) {
                return "normal"
            } else if (weight<5) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=53) {
            if (weight<3.1) {
                return "sangat buruk"
            } else if (weight<3.4) {
                return "buruk"
            } else if (weight<4.8) {
                return "normal"
            } else if (weight<5.3) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=54) {
            if (weight<3.3) {
                return "sangat buruk"
            } else if (weight<3.6) {
                return "buruk"
            } else if (weight<5.1) {
                return "normal"
            } else if (weight<5.6) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=55) {
            if (weight<3.6) {
                return "sangat buruk"
            } else if (weight<3.8) {
                return "buruk"
            } else if (weight<5.4) {
                return "normal"
            } else if (weight<6) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=56) {
            if (weight<3.8) {
                return "sangat buruk"
            } else if (weight<4.1) {
                return "buruk"
            } else if (weight<5.8) {
                return "normal"
            } else if (weight<6.3) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=57) {
            if (weight<4) {
                return "sangat buruk"
            } else if (weight<4.3) {
                return "buruk"
            } else if (weight<6.1) {
                return "normal"
            } else if (weight<6.7) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=58) {
            if (weight<4.3) {
                return "sangat buruk"
            } else if (weight<4.6) {
                return "buruk"
            } else if (weight<6.4) {
                return "normal"
            } else if (weight<7.1) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=59) {
            if (weight<4.5) {
                return "sangat buruk"
            } else if (weight<4.8) {
                return "buruk"
            } else if (weight<6.8) {
                return "normal"
            } else if (weight<7.4) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=60) {
            if (weight<4.7) {
                return "sangat buruk"
            } else if (weight<5.1) {
                return "buruk"
            } else if (weight<7.1) {
                return "normal"
            } else if (weight<7.8) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=61) {
            if (weight<4.9) {
                return "sangat buruk"
            } else if (weight<5.3) {
                return "buruk"
            } else if (weight<7.4) {
                return "normal"
            } else if (weight<8.1) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=62) {
            if (weight<5.1) {
                return "sangat buruk"
            } else if (weight<5.6) {
                return "buruk"
            } else if (weight<7.7) {
                return "normal"
            } else if (weight<8.5) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=63) {
            if (weight<5.5) {
                return "sangat buruk"
            } else if (weight<6) {
                return "buruk"
            } else if (weight<8.3) {
                return "normal"
            } else if (weight<9.1) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=65) {
            if (weight<5.7) {
                return "sangat buruk"
            } else if (weight<6.2) {
                return "buruk"
            } else if (weight<8.6) {
                return "normal"
            } else if (weight<9.4) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=66) {
            if (weight<5.9) {
                return "sangat buruk"
            } else if (weight<6.4) {
                return "buruk"
            } else if (weight<8.9) {
                return "normal"
            } else if (weight<9.7) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=67) {
            if (weight<6.1) {
                return "sangat buruk"
            } else if (weight<6.6) {
                return "buruk"
            } else if (weight<9.2) {
                return "normal"
            } else if (weight<10) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=68) {
            if (weight<6.3) {
                return "sangat buruk"
            } else if (weight<6.8) {
                return "buruk"
            } else if (weight<9.4) {
                return "normal"
            } else if (weight<10.3) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=69) {
            if (weight<6.5) {
                return "sangat buruk"
            } else if (weight<7) {
                return "buruk"
            } else if (weight<9.7) {
                return "normal"
            } else if (weight<10.6) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=70) {
            if (weight<6.6) {
                return "sangat buruk"
            } else if (weight<7.2) {
                return "buruk"
            } else if (weight<10) {
                return "normal"
            } else if (weight<10.9) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=71) {
            if (weight<6.8) {
                return "sangat buruk"
            } else if (weight<7.4) {
                return "buruk"
            } else if (weight<10.2) {
                return "normal"
            } else if (weight<11.2) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=72) {
            if (weight<7) {
                return "sangat buruk"
            } else if (weight<7.6) {
                return "buruk"
            } else if (weight<10.5) {
                return "normal"
            } else if (weight<11.5) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=73) {
            if (weight<7.2) {
                return "sangat buruk"
            } else if (weight<7.7) {
                return "buruk"
            } else if (weight<10.8) {
                return "normal"
            } else if (weight<11.8) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=74) {
            if (weight<7.3) {
                return "sangat buruk"
            } else if (weight<7.9) {
                return "buruk"
            } else if (weight<11) {
                return "normal"
            } else if (weight<12.1) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=75) {
            if (weight<7.5) {
                return "sangat buruk"
            } else if (weight<8.1) {
                return "buruk"
            } else if (weight<11.3) {
                return "normal"
            } else if (weight<12.3) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=76) {
            if (weight<7.6) {
                return "sangat buruk"
            } else if (weight<8.3) {
                return "buruk"
            } else if (weight<11.5) {
                return "normal"
            } else if (weight<12.6) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=77) {
            if (weight<7.8) {
                return "sangat buruk"
            } else if (weight<8.4) {
                return "buruk"
            } else if (weight<11.7) {
                return "normal"
            } else if (weight<12.8) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=78) {
            if (weight<7.9) {
                return "sangat buruk"
            } else if (weight<8.6) {
                return "buruk"
            } else if (weight<12) {
                return "normal"
            } else if (weight<13.1) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=79) {
            if (weight<8.1) {
                return "sangat buruk"
            } else if (weight<8.7) {
                return "buruk"
            } else if (weight<12.2) {
                return "normal"
            } else if (weight<13.3) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=80) {
            if (weight<8.2) {
                return "sangat buruk"
            } else if (weight<8.9) {
                return "buruk"
            } else if (weight<12.4) {
                return "normal"
            } else if (weight<13.6) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=81) {
            if (weight<8.4) {
                return "sangat buruk"
            } else if (weight<9.1) {
                return "buruk"
            } else if (weight<12.6) {
                return "normal"
            } else if (weight<13.8) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=82) {
            if (weight<8.5) {
                return "sangat buruk"
            } else if (weight<9.2) {
                return "buruk"
            } else if (weight<12.8) {
                return "normal"
            } else if (weight<14) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=83) {
            if (weight<8.7) {
                return "sangat buruk"
            } else if (weight<9.4) {
                return "buruk"
            } else if (weight<13.1) {
                return "normal"
            } else if (weight<14.3) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=84) {
            if (weight<8.9) {
                return "sangat buruk"
            } else if (weight<9.6) {
                return "buruk"
            } else if (weight<13.3) {
                return "normal"
            } else if (weight<14.6) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=85) {
            if (weight<9.1) {
                return "sangat buruk"
            } else if (weight<9.8) {
                return "buruk"
            } else if (weight<13.6) {
                return "normal"
            } else if (weight<14.9) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=86) {
            if (weight<9.3) {
                return "sangat buruk"
            } else if (weight<10) {
                return "buruk"
            } else if (weight<13.9) {
                return "normal"
            } else if (weight<15.2) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=87) {
            if (weight<9.5) {
                return "sangat buruk"
            } else if (weight<10.2) {
                return "buruk"
            } else if (weight<14.2) {
                return "normal"
            } else if (weight<15.5) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=88) {
            if (weight<9.7) {
                return "sangat buruk"
            } else if (weight<10.5) {
                return "buruk"
            } else if (weight<14.5) {
                return "normal"
            } else if (weight<15.8) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=89) {
            if (weight<9.9) {
                return "sangat buruk"
            } else if (weight<10.7) {
                return "buruk"
            } else if (weight<14.7) {
                return "normal"
            } else if (weight<16.1) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=90) {
            if (weight<10.1) {
                return "sangat buruk"
            } else if (weight<10.9) {
                return "buruk"
            } else if (weight<15) {
                return "normal"
            } else if (weight<16.4) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=91) {
            if (weight<10.3) {
                return "sangat buruk"
            } else if (weight<11.1) {
                return "buruk"
            } else if (weight<15.3) {
                return "normal"
            } else if (weight<16.7) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=92) {
            if (weight<10.5) {
                return "sangat buruk"
            } else if (weight<11.3) {
                return "buruk"
            } else if (weight<15.6) {
                return "normal"
            } else if (weight<17) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=93) {
            if (weight<10.7) {
                return "sangat buruk"
            } else if (weight<11.5) {
                return "buruk"
            } else if (weight<15.8) {
                return "normal"
            } else if (weight<17.3) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=94) {
            if (weight<10.8) {
                return "sangat buruk"
            } else if (weight<11.7) {
                return "buruk"
            } else if (weight<16.1) {
                return "normal"
            } else if (weight<17.6) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=95) {
            if (weight<11) {
                return "sangat buruk"
            } else if (weight<11.9) {
                return "buruk"
            } else if (weight<16.4) {
                return "normal"
            } else if (weight<17.9) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=96) {
            if (weight<11.2) {
                return "sangat buruk"
            } else if (weight<12.1) {
                return "buruk"
            } else if (weight<16.7) {
                return "normal"
            } else if (weight<18.2) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=97) {
            if (weight<11.4) {
                return "sangat buruk"
            } else if (weight<12.3) {
                return "buruk"
            } else if (weight<17) {
                return "normal"
            } else if (weight<18.5) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=98) {
            if (weight<11.6) {
                return "sangat buruk"
            } else if (weight<12.5) {
                return "buruk"
            } else if (weight<17.3) {
                return "normal"
            } else if (weight<18.9) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=99) {
            if (weight<11.8) {
                return "sangat buruk"
            } else if (weight<12.7) {
                return "buruk"
            } else if (weight<17.6) {
                return "normal"
            } else if (weight<19.2) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=100) {
            if (weight<12) {
                return "sangat buruk"
            } else if (weight<12.9) {
                return "buruk"
            } else if (weight<18) {
                return "normal"
            } else if (weight<19.6) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=101) {
            if (weight<12.2) {
                return "sangat buruk"
            } else if (weight<13.2) {
                return "buruk"
            } else if (weight<18.3) {
                return "normal"
            } else if (weight<20) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=102) {
            if (weight<12.4) {
                return "sangat buruk"
            } else if (weight<13.4) {
                return "buruk"
            } else if (weight<18.7) {
                return "normal"
            } else if (weight<20.4) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=103) {
            if (weight<12.6) {
                return "sangat buruk"
            } else if (weight<13.6) {
                return "buruk"
            } else if (weight<19) {
                return "normal"
            } else if (weight<20.8) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=104) {
            if (weight<12.8) {
                return "sangat buruk"
            } else if (weight<13.9) {
                return "buruk"
            } else if (weight<19.4) {
                return "normal"
            } else if (weight<21.2) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=105) {
            if (weight<13) {
                return "sangat buruk"
            } else if (weight<14.1) {
                return "buruk"
            } else if (weight<19.8) {
                return "normal"
            } else if (weight<21.7) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=106) {
            if (weight<13.3) {
                return "sangat buruk"
            } else if (weight<14.4) {
                return "buruk"
            } else if (weight<20.2) {
                return "normal"
            } else if (weight<22.1) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=107) {
            if (weight<13.5) {
                return "sangat buruk"
            } else if (weight<14.6) {
                return "buruk"
            } else if (weight<20.6) {
                return "normal"
            } else if (weight<22.6) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=108) {
            if (weight<13.7) {
                return "sangat buruk"
            } else if (weight<14.9) {
                return "buruk"
            } else if (weight<21) {
                return "normal"
            } else if (weight<23.1) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=109) {
            if (weight<14) {
                return "sangat buruk"
            } else if (weight<15.1) {
                return "buruk"
            } else if (weight<21.4) {
                return "normal"
            } else if (weight<23.6) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        } else if (tinggi<=110) {
            if (weight<14.2) {
                return "sangat buruk"
            } else if (weight<15.4) {
                return "buruk"
            } else if (weight<21.9) {
                return "normal"
            } else if (weight<24.1) {
                return "buruk"
            } else {
                return "sangat buruk"
            }

        }

        return ""
    }

    private fun headCircumferenceForAgeLakilaki(lingkar: Double, umur: Int): String {
        if (umur==0) {
            if (lingkar<30.7) {
                return "sangat kecil"
            } else if (lingkar<31.9) {
                return "kecil"
            } else if (lingkar<37) {
                return "normal"
            } else if (lingkar<38.3) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==1) {
            if (lingkar<33.8) {
                return "sangat kecil"
            } else if (lingkar<34.9) {
                return "kecil"
            } else if (lingkar<39.6) {
                return "normal"
            } else if (lingkar<40.8) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==2) {
            if (lingkar<35.6) {
                return "sangat kecil"
            } else if (lingkar<36.8) {
                return "kecil"
            } else if (lingkar<41.5) {
                return "normal"
            } else if (lingkar<42.6) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==3) {
            if (lingkar<37) {
                return "sangat kecil"
            } else if (lingkar<38.1) {
                return "kecil"
            } else if (lingkar<42.9) {
                return "normal"
            } else if (lingkar<44.1) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==4) {
            if (lingkar<38) {
                return "sangat kecil"
            } else if (lingkar<39.2) {
                return "kecil"
            } else if (lingkar<44) {
                return "normal"
            } else if (lingkar<45.2) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==5) {
            if (lingkar<38.9) {
                return "sangat kecil"
            } else if (lingkar<40.1) {
                return "kecil"
            } else if (lingkar<45) {
                return "normal"
            } else if (lingkar<46.2) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==6) {
            if (lingkar<39.7) {
                return "sangat kecil"
            } else if (lingkar<40.9) {
                return "kecil"
            } else if (lingkar<45.8) {
                return "normal"
            } else if (lingkar<47) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==7) {
            if (lingkar<40.3) {
                return "sangat kecil"
            } else if (lingkar<41.5) {
                return "kecil"
            } else if (lingkar<46.4) {
                return "normal"
            } else if (lingkar<47.7) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==8) {
            if (lingkar<40.8) {
                return "sangat kecil"
            } else if (lingkar<42) {
                return "kecil"
            } else if (lingkar<47) {
                return "normal"
            } else if (lingkar<48.3) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==9) {
            if (lingkar<41.2) {
                return "sangat kecil"
            } else if (lingkar<42.5) {
                return "kecil"
            } else if (lingkar<47.5) {
                return "normal"
            } else if (lingkar<48.8) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==10) {
            if (lingkar<41.6) {
                return "sangat kecil"
            } else if (lingkar<42.9) {
                return "kecil"
            } else if (lingkar<47.9) {
                return "normal"
            } else if (lingkar<49.2) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==11) {
            if (lingkar<41.9) {
                return "sangat kecil"
            } else if (lingkar<43.2) {
                return "kecil"
            } else if (lingkar<48.3) {
                return "normal"
            } else if (lingkar<49.6) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==12) {
            if (lingkar<42.2) {
                return "sangat kecil"
            } else if (lingkar<43.5) {
                return "kecil"
            } else if (lingkar<48.6) {
                return "normal"
            } else if (lingkar<49.9) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==13) {
            if (lingkar<42.5) {
                return "sangat kecil"
            } else if (lingkar<43.8) {
                return "kecil"
            } else if (lingkar<48.9) {
                return "normal"
            } else if (lingkar<50.2) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==14) {
            if (lingkar<42.7) {
                return "sangat kecil"
            } else if (lingkar<44) {
                return "kecil"
            } else if (lingkar<49.2) {
                return "normal"
            } else if (lingkar<50.5) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==15) {
            if (lingkar<42.9) {
                return "sangat kecil"
            } else if (lingkar<44.2) {
                return "kecil"
            } else if (lingkar<49.4) {
                return "normal"
            } else if (lingkar<50.7) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==16) {
            if (lingkar<43.1) {
                return "sangat kecil"
            } else if (lingkar<44.4) {
                return "kecil"
            } else if (lingkar<49.6) {
                return "normal"
            } else if (lingkar<51) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==17) {
            if (lingkar<43.2) {
                return "sangat kecil"
            } else if (lingkar<44.6) {
                return "kecil"
            } else if (lingkar<49.8) {
                return "normal"
            } else if (lingkar<51.2) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==18) {
            if (lingkar<43.4) {
                return "sangat kecil"
            } else if (lingkar<44.7) {
                return "kecil"
            } else if (lingkar<50) {
                return "normal"
            } else if (lingkar<51.4) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==19) {
            if (lingkar<43.5) {
                return "sangat kecil"
            } else if (lingkar<44.9) {
                return "kecil"
            } else if (lingkar<50.2) {
                return "normal"
            } else if (lingkar<51.5) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==20) {
            if (lingkar<43.7) {
                return "sangat kecil"
            } else if (lingkar<45) {
                return "kecil"
            } else if (lingkar<50.4) {
                return "normal"
            } else if (lingkar<51.7) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==21) {
            if (lingkar<43.8) {
                return "sangat kecil"
            } else if (lingkar<45.2) {
                return "kecil"
            } else if (lingkar<50.5) {
                return "normal"
            } else if (lingkar<51.9) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==22) {
            if (lingkar<43.9) {
                return "sangat kecil"
            } else if (lingkar<45.3) {
                return "kecil"
            } else if (lingkar<50.7) {
                return "normal"
            } else if (lingkar<52) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==23) {
            if (lingkar<44.1) {
                return "sangat kecil"
            } else if (lingkar<45.4) {
                return "kecil"
            } else if (lingkar<50.8) {
                return "normal"
            } else if (lingkar<52.2) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==24) {
            if (lingkar<44.2) {
                return "sangat kecil"
            } else if (lingkar<45.5) {
                return "kecil"
            } else if (lingkar<51) {
                return "normal"
            } else if (lingkar<52.3) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==25) {
            if (lingkar<44.3) {
                return "sangat kecil"
            } else if (lingkar<45.6) {
                return "kecil"
            } else if (lingkar<51.1) {
                return "normal"
            } else if (lingkar<52.5) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==26) {
            if (lingkar<44.4) {
                return "sangat kecil"
            } else if (lingkar<45.8) {
                return "kecil"
            } else if (lingkar<51.2) {
                return "normal"
            } else if (lingkar<52.6) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==27) {
            if (lingkar<44.5) {
                return "sangat kecil"
            } else if (lingkar<45.9) {
                return "kecil"
            } else if (lingkar<51.4) {
                return "normal"
            } else if (lingkar<52.7) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==28) {
            if (lingkar<44.6) {
                return "sangat kecil"
            } else if (lingkar<46) {
                return "kecil"
            } else if (lingkar<51.5) {
                return "normal"
            } else if (lingkar<52.9) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==29) {
            if (lingkar<44.7) {
                return "sangat kecil"
            } else if (lingkar<46.1) {
                return "kecil"
            } else if (lingkar<51.6) {
                return "normal"
            } else if (lingkar<53) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==30) {
            if (lingkar<44.8) {
                return "sangat kecil"
            } else if (lingkar<46.1) {
                return "kecil"
            } else if (lingkar<51.7) {
                return "normal"
            } else if (lingkar<53.1) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==31) {
            if (lingkar<44.8) {
                return "sangat kecil"
            } else if (lingkar<46.1) {
                return "kecil"
            } else if (lingkar<51.7) {
                return "normal"
            } else if (lingkar<53.1) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==32) {
            if (lingkar<44.9) {
                return "sangat kecil"
            } else if (lingkar<46.3) {
                return "kecil"
            } else if (lingkar<51.9) {
                return "normal"
            } else if (lingkar<53.3) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==33) {
            if (lingkar<45) {
                return "sangat kecil"
            } else if (lingkar<46.4) {
                return "kecil"
            } else if (lingkar<52) {
                return "normal"
            } else if (lingkar<53.4) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==34) {
            if (lingkar<45.1) {
                return "sangat kecil"
            } else if (lingkar<46.5) {
                return "kecil"
            } else if (lingkar<52.1) {
                return "normal"
            } else if (lingkar<53.5) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==35) {
            if (lingkar<45.1) {
                return "sangat kecil"
            } else if (lingkar<46.6) {
                return "kecil"
            } else if (lingkar<52.2) {
                return "normal"
            } else if (lingkar<53.6) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==36) {
            if (lingkar<45.2) {
                return "sangat kecil"
            } else if (lingkar<46.6) {
                return "kecil"
            } else if (lingkar<52.3) {
                return "normal"
            } else if (lingkar<53.7) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==37) {
            if (lingkar<45.3) {
                return "sangat kecil"
            } else if (lingkar<46.7) {
                return "kecil"
            } else if (lingkar<52.4) {
                return "normal"
            } else if (lingkar<53.8) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==38) {
            if (lingkar<45.3) {
                return "sangat kecil"
            } else if (lingkar<46.8) {
                return "kecil"
            } else if (lingkar<52.5) {
                return "normal"
            } else if (lingkar<53.9) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==39) {
            if (lingkar<45.4) {
                return "sangat kecil"
            } else if (lingkar<46.8) {
                return "kecil"
            } else if (lingkar<52.5) {
                return "normal"
            } else if (lingkar<54) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==40) {
            if (lingkar<45.4) {
                return "sangat kecil"
            } else if (lingkar<46.9) {
                return "kecil"
            } else if (lingkar<52.6) {
                return "normal"
            } else if (lingkar<54.1) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==41) {
            if (lingkar<45.5) {
                return "sangat kecil"
            } else if (lingkar<46.9) {
                return "kecil"
            } else if (lingkar<52.7) {
                return "normal"
            } else if (lingkar<54.1) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==42) {
            if (lingkar<45.5) {
                return "sangat kecil"
            } else if (lingkar<47) {
                return "kecil"
            } else if (lingkar<52.8) {
                return "normal"
            } else if (lingkar<54.2) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==43) {
            if (lingkar<45.6) {
                return "sangat kecil"
            } else if (lingkar<47) {
                return "kecil"
            } else if (lingkar<52.8) {
                return "normal"
            } else if (lingkar<54.3) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==44) {
            if (lingkar<45.6) {
                return "sangat kecil"
            } else if (lingkar<47.1) {
                return "kecil"
            } else if (lingkar<52.9) {
                return "normal"
            } else if (lingkar<54.3) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==45) {
            if (lingkar<45.7) {
                return "sangat kecil"
            } else if (lingkar<47.1) {
                return "kecil"
            } else if (lingkar<53) {
                return "normal"
            } else if (lingkar<54.4) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==46) {
            if (lingkar<45.7) {
                return "sangat kecil"
            } else if (lingkar<47.2) {
                return "kecil"
            } else if (lingkar<53) {
                return "normal"
            } else if (lingkar<54.5) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==47) {
            if (lingkar<45.8) {
                return "sangat kecil"
            } else if (lingkar<47.2) {
                return "kecil"
            } else if (lingkar<53.1) {
                return "normal"
            } else if (lingkar<54.5) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==48) {
            if (lingkar<45.8) {
                return "sangat kecil"
            } else if (lingkar<47.3) {
                return "kecil"
            } else if (lingkar<53.1) {
                return "normal"
            } else if (lingkar<54.6) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==49) {
            if (lingkar<45.9) {
                return "sangat kecil"
            } else if (lingkar<47.3) {
                return "kecil"
            } else if (lingkar<53.2) {
                return "normal"
            } else if (lingkar<54.7) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==50) {
            if (lingkar<45.9) {
                return "sangat kecil"
            } else if (lingkar<47.4) {
                return "kecil"
            } else if (lingkar<53.2) {
                return "normal"
            } else if (lingkar<54.7) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==51) {
            if (lingkar<45.9) {
                return "sangat kecil"
            } else if (lingkar<47.4) {
                return "kecil"
            } else if (lingkar<53.3) {
                return "normal"
            } else if (lingkar<54.8) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==52) {
            if (lingkar<46) {
                return "sangat kecil"
            } else if (lingkar<47.5) {
                return "kecil"
            } else if (lingkar<53.4) {
                return "normal"
            } else if (lingkar<54.8) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==53) {
            if (lingkar<46) {
                return "sangat kecil"
            } else if (lingkar<47.5) {
                return "kecil"
            } else if (lingkar<53.4) {
                return "normal"
            } else if (lingkar<54.9) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==54) {
            if (lingkar<46.1) {
                return "sangat kecil"
            } else if (lingkar<47.5) {
                return "kecil"
            } else if (lingkar<53.5) {
                return "normal"
            } else if (lingkar<54.9) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==55) {
            if (lingkar<46.1) {
                return "sangat kecil"
            } else if (lingkar<47.6) {
                return "kecil"
            } else if (lingkar<53.5) {
                return "normal"
            } else if (lingkar<55) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==56) {
            if (lingkar<46.1) {
                return "sangat kecil"
            } else if (lingkar<47.6) {
                return "kecil"
            } else if (lingkar<53.5) {
                return "normal"
            } else if (lingkar<55) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==57) {
            if (lingkar<46.2) {
                return "sangat kecil"
            } else if (lingkar<47.6) {
                return "kecil"
            } else if (lingkar<53.6) {
                return "normal"
            } else if (lingkar<55.1) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==58) {
            if (lingkar<46.2) {
                return "sangat kecil"
            } else if (lingkar<47.7) {
                return "kecil"
            } else if (lingkar<53.6) {
                return "normal"
            } else if (lingkar<55.1) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==59) {
            if (lingkar<46.2) {
                return "sangat kecil"
            } else if (lingkar<47.7) {
                return "kecil"
            } else if (lingkar<53.7) {
                return "normal"
            } else if (lingkar<55.2) {
                return "besar"
            } else {
                return "sangat besar"
            }
        } else if (umur==60) {
            if (lingkar<46.3) {
                return "sangat kecil"
            } else if (lingkar<47.7) {
                return "kecil"
            } else if (lingkar<53.7) {
                return "normal"
            } else if (lingkar<55.2) {
                return "besar"
            } else {
                return "sangat besar"
            }
        }

        return ""
    }

}