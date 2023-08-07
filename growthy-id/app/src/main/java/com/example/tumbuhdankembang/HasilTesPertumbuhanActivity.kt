package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class HasilTesPertumbuhanActivity : AppCompatActivity() {

    var tvHasil1: TextView? = null
    var tvHasil2: TextView? = null
    var tvHasil3: TextView? = null
    var tvHasil4: TextView? = null
    var tvJudulHasil4: TextView? = null
    private lateinit var btnHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_tes_pertumbuhan)

        val hasil1 = intent.getStringExtra("hasil1")
        val hasil2 = intent.getStringExtra("hasil2")
        val hasil3 = intent.getStringExtra("hasil3")
        val hasil4 = intent.getStringExtra("hasil4")
        val umur = intent.getIntExtra("umur", 0)

        tvHasil1 = findViewById(R.id.tv_heightForAge2)
        tvHasil2 = findViewById(R.id.tv_weightForAge2)
        tvHasil3 = findViewById(R.id.tv_weightForLength2)
        tvHasil4 = findViewById(R.id.tv_headCircumferenceForAge2)
        tvJudulHasil4 = findViewById(R.id.tv_headCircumferenceForAge1)
        btnHome = findViewById(R.id.btn_keBerandaPertumbuhan)

        // Sembunyikan hasil lingkar kepala jika umur anak > 60 bulan
        if (umur>60) {
            tvJudulHasil4!!.setVisibility(View.GONE)
            tvHasil4!!.setVisibility(View.GONE)
        } else {
            tvJudulHasil4!!.setVisibility(View.VISIBLE)
            tvHasil4!!.setVisibility(View.VISIBLE)
        }

        // Tampilkan tinggi terhadap usia
        when {
            hasil1.equals("sangat pendek") -> {
                tvHasil1!!.text = "Dilihat dari umurnya, tinggi badan anak sangatlah rendah."
            }
            hasil1.equals("pendek") -> {
                tvHasil1!!.text = "Dilihat dari umurnya, tinggi badan anak termasuk rendah."
            }
            hasil1.equals("normal") -> {
                tvHasil1!!.text = "Kerja baik! Tinggi badan anak sesuai dengan umurnya."
            }
            hasil1.equals("tinggi") -> {
                tvHasil1!!.text = "Dilihat dari umurnya, tinggi badan anak termasuk tinggi."
            }
            hasil1.equals("sangat tinggi") -> {
                tvHasil1!!.text = "Dilihat dari umurnya, tinggi badan anak sangatlah tinggi."
            }
        }

        // Tampilkan berat terhadap usia
        when {
            hasil2.equals("sangat kurus") -> {
                tvHasil2!!.text = "Anak Anda sangatlah kurus untuk ukuran seusianya."
            }
            hasil2.equals("kurus") -> {
                tvHasil2!!.text = "Anak Anda termasuk kurus untuk ukuran seusianya."
            }
            hasil2.equals("normal") -> {
                tvHasil2!!.text = "Kerja baik! Berat badan anak sesuai dengan umurnya."
            }
            hasil2.equals("gemuk") -> {
                tvHasil2!!.text = "Anak Anda termasuk gemuk untuk ukuran seusianya."
            }
            hasil2.equals("sangat gemuk") -> {
                tvHasil2!!.text = "Anak Anda sangatlah gemuk untuk ukuran seusianya."
            }
        }

        // Tampilkan berat terhadap tinggi
        when {
            hasil3.equals("sangat buruk") -> {
                tvHasil3!!.text = "Perbandingan antara berat dan tinggi badan anak Anda sangatlah buruk. Segera konsultasikan anak Anda ke petugas kesehatan."
            }
            hasil3.equals("buruk") -> {
                tvHasil3!!.text = "Perbandingan antara berat dan tinggi badan anak Anda termasuk buruk. Konsultasikanlah kondisi anak Anda ke petugas kesehatan."
            }
            hasil3.equals("normal") -> {
                tvHasil3!!.text = "Kerja baik! Proporsi antara berat dan tinggi anak Anda termasuk normal."
            }
        }

        // Tampilkan lingkar kepala terhadap usia
        when {
            hasil4.equals("sangat kecil") -> {
                tvHasil4!!.text = "Lingkar kepala anak Anda sangat kecil jika dibandingkan dengan ukuran anak seusianya. Ada indikasi ditemukan mikrosefal pada anak, segera rujuk anak Anda untuk pemeriksaan yang lebih akurat."
            }
            hasil4.equals("kecil") -> {
                tvHasil4!!.text = "Lingkar kepala anak Anda lebih kecil dari yang seharusnya. Ada indikasi ditemukan mikrosefal pada anak, segera rujuk anak Anda untuk pemeriksaan yang lebih akurat."
            }
            hasil4.equals("normal") -> {
                tvHasil4!!.text = "Selamat! Lingkar kepala anak Anda NORMAL. Harap lakukan pengukuran kembali tiga bulan kemudian  untuk umur 0-11 bulan) atau enam bulan kemudian (untuk umur 12-72 bulan)."
            }
            hasil4.equals("besar") -> {
                tvHasil4!!.text = "Lingkar kepala anak Anda lebih besar dari yang seharusnya. Ada indikasi ditemukan makrosefal pada anak, segera rujuk anak Anda untuk pemeriksaan yang lebih akurat."
            }
            hasil4.equals("sangat besar") -> {
                tvHasil4!!.text = "Lingkar kepala anak Anda sangat besar jika dibandingkan dengan ukuran anak seusianya. Ada indikasi ditemukan makrosefal pada anak, segera rujuk anak Anda untuk pemeriksaan yang lebih akurat."
            }
        }

        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}