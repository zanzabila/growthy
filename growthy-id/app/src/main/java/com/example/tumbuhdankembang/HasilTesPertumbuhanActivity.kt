package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class HasilTesPertumbuhanActivity : AppCompatActivity() {

    var tvHasil1: TextView? = null
    var tvHasil2: TextView? = null
    var tvHasil3: TextView? = null
    var tvHasil4: TextView? = null
    var tvJudulHasil1: TextView? = null
    var tvJudulHasil2: TextView? = null
    var tvJudulHasil3: TextView? = null
    var tvJudulHasil4: TextView? = null
    var imgP: ImageView? = null
    var imgL: ImageView? = null
    private lateinit var btnHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_tes_pertumbuhan)

        val hasil1 = intent.getStringExtra("hasil1")
        val hasil2 = intent.getStringExtra("hasil2")
        val hasil3 = intent.getStringExtra("hasil3")
        val hasil4 = intent.getStringExtra("hasil4")
        val umur = intent.getIntExtra("umur", 0)
        var nama = intent.getStringExtra("nama")
        val jk = intent.getStringExtra("jk")
        val tglLahir = intent.getStringExtra("tglLahir")
        val tglHariIni = intent.getStringExtra("tglHariIni")

        tvHasil1 = findViewById(R.id.tv_heightForAge2)
        tvHasil2 = findViewById(R.id.tv_weightForAge2)
        tvHasil3 = findViewById(R.id.tv_weightForLength2)
        tvHasil4 = findViewById(R.id.tv_headCircumferenceForAge2)
        tvJudulHasil1 = findViewById(R.id.tv_heightForAge1)
        tvJudulHasil2 = findViewById(R.id.tv_weightForAge1)
        tvJudulHasil3 = findViewById(R.id.tv_weightForLength1)
        tvJudulHasil4 = findViewById(R.id.tv_headCircumferenceForAge1)
        imgP = findViewById(R.id.imageView43)
        imgL = findViewById(R.id.imageView44)
        btnHome = findViewById(R.id.btn_keBerandaPertumbuhan)

        if (jk.equals("Perempuan")) {
            imgP!!.setVisibility(View.VISIBLE)
            imgL!!.setVisibility(View.GONE)
        } else if (jk.equals("Laki-laki")) {
            imgP!!.setVisibility(View.GONE)
            imgL!!.setVisibility(View.VISIBLE)
        }

        val k = KeyResult(nama!!, tglLahir!!)
        var v: ValueResult
        if (MyApplication.listHasilTes.containsKey(k)) {
            v = MyApplication.listHasilTes.get(k)!!
        } else {
            v = ValueResult()
        }
        if (umur <= 60) {
            v.setHasilPertumbuhan(tglHariIni!!, hasil1!!, hasil2!!, hasil3!!, hasil4!!)
        } else {
            v.setHasilPertumbuhan(tglHariIni!!, "", "", hasil1!!, hasil2!!)
        }
        MyApplication.listHasilTes.put(k, v)



        if (umur>60) { // Sembunyikan hasil 3-4 jika umur anak >60 bulan
            tvJudulHasil3!!.setVisibility(View.GONE)
            tvHasil3!!.setVisibility(View.GONE)
            tvJudulHasil4!!.setVisibility(View.GONE)
            tvHasil4!!.setVisibility(View.GONE)

            // Tampilkan berat terhadap tinggi
            tvJudulHasil1!!.text = "Berat terhadap Tinggi Anak"
            when {
                hasil1.equals("gizi buruk") -> {
                    tvHasil1!!.text = "$nama kemungkinan mengalami gizi buruk. Perhatikan lagi asupan anak dengan baik."
                }
                hasil1.equals("gizi kurang") -> {
                    tvHasil1!!.text = "$nama kemungkinan mengalami gizi kurang. Perhatikan lagi asupan anak dengan baik."
                }
                hasil1.equals("gizi baik") -> {
                    tvHasil1!!.text = "Kerja baik! $nama memiliki gizi yang baik."
                }
                hasil1.equals("gizi lebih") -> {
                    tvHasil1!!.text = "$nama kemungkinan mengalami gizi lebih. Perhatikan lagi asupan anak dengan baik."
                }
                hasil1.equals("obesitas") -> {
                    tvHasil1!!.text = "$nama kemungkinan mengalami obesitas. Perhatikan lagi asupan anak dengan baik."
                }
            }
            
            // Tampilkan lingkar kepala terhadap usia
            tvJudulHasil2!!.text = "Lingkar Kepala terhadap Umur Anak"
            when {
                hasil2.equals("sangat kecil") -> {
                    tvHasil2!!.text = "Lingkar kepala $nama sangat kecil jika dibandingkan dengan ukuran anak seusianya. Ada indikasi ditemukan mikrosefal pada anak, segera rujuk $nama untuk pemeriksaan yang lebih akurat."
                }
                hasil2.equals("kecil") -> {
                    tvHasil2!!.text = "Lingkar kepala $nama lebih kecil dari yang seharusnya. Ada indikasi ditemukan mikrosefal pada anak, segera rujuk $nama untuk pemeriksaan yang lebih akurat."
                }
                hasil2.equals("normal") -> {
                    tvHasil2!!.text = "Selamat! Lingkar kepala $nama NORMAL. Harap lakukan pengukuran kembali tiga bulan kemudian (untuk umur 0-11 bulan) atau enam bulan kemudian (untuk umur 12-72 bulan)."
                }
                hasil2.equals("besar") -> {
                    tvHasil2!!.text = "Lingkar kepala $nama lebih besar dari yang seharusnya. Ada indikasi ditemukan makrosefal pada anak, segera rujuk $nama untuk pemeriksaan yang lebih akurat."
                }
                hasil2.equals("sangat besar") -> {
                    tvHasil2!!.text = "Lingkar kepala $nama sangat besar jika dibandingkan dengan ukuran anak seusianya. Ada indikasi ditemukan makrosefal pada anak, segera rujuk $nama untuk pemeriksaan yang lebih akurat."
                }
            }

        } else { // untuk umur <=60 bulan
            
            // Tampilkan tinggi terhadap usia
            when {
                hasil1.equals("sangat pendek") -> {
                    tvHasil1!!.text = "Dilihat dari umurnya, tinggi badan $nama sangatlah rendah."
                }
                hasil1.equals("pendek") -> {
                    tvHasil1!!.text = "Dilihat dari umurnya, tinggi badan $nama termasuk rendah."
                }
                hasil1.equals("normal") -> {
                    tvHasil1!!.text = "Kerja baik! Tinggi badan $nama sesuai dengan umurnya."
                }
                hasil1.equals("tinggi") -> {
                    tvHasil1!!.text = "Dilihat dari umurnya, tinggi badan $nama termasuk tinggi."
                }
                hasil1.equals("sangat tinggi") -> {
                    tvHasil1!!.text = "Dilihat dari umurnya, tinggi badan $nama sangatlah tinggi."
                }
            }

            // Tampilkan berat terhadap usia
            when {
                hasil2.equals("sangat kurus") -> {
                    tvHasil2!!.text = "$nama sangatlah kurus untuk ukuran seusianya."
                }
                hasil2.equals("kurus") -> {
                    tvHasil2!!.text = "$nama termasuk kurus untuk ukuran seusianya."
                }
                hasil2.equals("normal") -> {
                    tvHasil2!!.text = "Kerja baik! Berat badan $nama sesuai dengan umurnya."
                }
                hasil2.equals("gemuk") -> {
                    tvHasil2!!.text = "$nama termasuk gemuk untuk ukuran seusianya."
                }
                hasil2.equals("sangat gemuk") -> {
                    tvHasil2!!.text = "$nama sangatlah gemuk untuk ukuran seusianya."
                }
            }

            // Tampilkan berat terhadap tinggi
            when {
                hasil3.equals("sangat buruk") -> {
                    tvHasil3!!.text = "Perbandingan antara berat dan tinggi badan $nama sangatlah buruk. Segera konsultasikan $nama ke petugas kesehatan."
                }
                hasil3.equals("buruk") -> {
                    tvHasil3!!.text = "Perbandingan antara berat dan tinggi badan $nama termasuk buruk. Konsultasikanlah kondisi $nama ke petugas kesehatan."
                }
                hasil3.equals("normal") -> {
                    tvHasil3!!.text = "Kerja baik! Proporsi antara berat dan tinggi $nama termasuk normal."
                }
                hasil3.equals("") -> {
                    tvHasil3!!.text = "Mohon maaf, tinggi $nama melebihi tinggi yang dapat diukur oleh alat tes ini."
                }
            }

            // Tampilkan lingkar kepala terhadap usia
            when {
                hasil4.equals("sangat kecil") -> {
                    tvHasil4!!.text = "Lingkar kepala $nama sangat kecil jika dibandingkan dengan ukuran anak seusianya. Ada indikasi ditemukan mikrosefal pada anak, segera rujuk $nama untuk pemeriksaan yang lebih akurat."
                }
                hasil4.equals("kecil") -> {
                    tvHasil4!!.text = "Lingkar kepala $nama lebih kecil dari yang seharusnya. Ada indikasi ditemukan mikrosefal pada anak, segera rujuk $nama untuk pemeriksaan yang lebih akurat."
                }
                hasil4.equals("normal") -> {
                    tvHasil4!!.text = "Selamat! Lingkar kepala $nama NORMAL. Harap lakukan pengukuran kembali tiga bulan kemudian (untuk umur 0-11 bulan) atau enam bulan kemudian (untuk umur 12-72 bulan)."
                }
                hasil4.equals("besar") -> {
                    tvHasil4!!.text = "Lingkar kepala $nama lebih besar dari yang seharusnya. Ada indikasi ditemukan makrosefal pada anak, segera rujuk $nama untuk pemeriksaan yang lebih akurat."
                }
                hasil4.equals("sangat besar") -> {
                    tvHasil4!!.text = "Lingkar kepala $nama sangat besar jika dibandingkan dengan ukuran anak seusianya. Ada indikasi ditemukan makrosefal pada anak, segera rujuk $nama untuk pemeriksaan yang lebih akurat."
                }
            }

        }


        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}