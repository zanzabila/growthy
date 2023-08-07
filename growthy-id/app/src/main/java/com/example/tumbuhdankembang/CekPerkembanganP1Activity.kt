package com.example.tumbuhdankembang

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class CekPerkembanganP1Activity : AppCompatActivity() {

    var tvIsiTglLahir: TextView? = null
    var btnCalendar: ImageButton? = null
    var today = Calendar.getInstance()
    var cal = Calendar.getInstance()
    private lateinit var etUsiaHamil: TextView
    private lateinit var btnPerkembangan1: Button
    var tvInvalidDate: TextView? = null
    var tvEmptyAlertUsia: TextView? = null
    var tvTidakTes: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cek_perkembangan_p1)

        tvIsiTglLahir = findViewById(R.id.tv_isiTglLahirPerkembangan)
        btnCalendar = findViewById(R.id.btn_calendarPerkembangan)
        etUsiaHamil = findViewById(R.id.et_usiaHamilPerkembangan)
        btnPerkembangan1 = findViewById(R.id.btn_perkembangan1)
        tvInvalidDate = findViewById(R.id.tv_invalidTglLahirPerkembangan)
        tvEmptyAlertUsia = findViewById(R.id.tv_emptyAlertUsiaHamilPerkembangan)
        tvTidakTes = findViewById(R.id.tv_invalidUsiaPerkembangan)

        tvEmptyAlertUsia!!.text = ""
        tvTidakTes!!.text = ""
        this.updateDateInView()

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month)
                cal.set(Calendar.DAY_OF_MONTH, day)
                updateDateInView()
            }
        }

        btnCalendar!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(this@CekPerkembanganP1Activity,
                    dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })

        btnPerkembangan1.setOnClickListener {
            tvTidakTes!!.text = ""
            if (etUsiaHamil.text.toString().length > 0) {
                tvEmptyAlertUsia!!.text = ""
                if (!cal.after(today)) {
                    var umur = getUmur(etUsiaHamil.text.toString().toInt())

                    if (umur<3) {
                        tvTidakTes!!.text = "Bayi di bawah 3 bulan belum perlu untuk melakukan tes. Harap kembali ke halaman sebelumnya."
                    } else if (umur<6) {
                        val intent = Intent(this, CekPerkembanganP2b03Activity::class.java)
                        intent.putExtra("umur", umur)
                        startActivity(intent)
                    } else if (umur<9) {
                        val intent = Intent(this, CekPerkembanganP2b06Activity::class.java)
                        intent.putExtra("umur", umur)
                        startActivity(intent)
                    } else if (umur<12) {
                        val intent = Intent(this, CekPerkembanganP2b09Activity::class.java)
                        intent.putExtra("umur", umur)
                        startActivity(intent)
                    } else if (umur<15) {
                        val intent = Intent(this, CekPerkembanganP2b12Activity::class.java)
                        intent.putExtra("umur", umur)
                        startActivity(intent)
                    } else if (umur<18) {
                        val intent = Intent(this, CekPerkembanganP2b15Activity::class.java)
                        intent.putExtra("umur", umur)
                        startActivity(intent)
                    } else if (umur<21) {
                        val intent = Intent(this, CekPerkembanganP2b18Activity::class.java)
                        intent.putExtra("umur", umur)
                        startActivity(intent)
                    } else if (umur<24) {
                        val intent = Intent(this, CekPerkembanganP2b21Activity::class.java)
                        intent.putExtra("umur", umur)
                        startActivity(intent)
                    } else if (umur<30) {
                        val intent = Intent(this, CekPerkembanganP2b24Activity::class.java)
                        intent.putExtra("umur", umur)
                        startActivity(intent)
                    } else if (umur<36) {
                        val intent = Intent(this, CekPerkembanganP2b30Activity::class.java)
                        intent.putExtra("umur", umur)
                        startActivity(intent)
                    } else if (umur<42) {
                        val intent = Intent(this, CekPerkembanganP2b36Activity::class.java)
                        intent.putExtra("umur", umur)
                        startActivity(intent)
                    } else if (umur<48) {
                        val intent = Intent(this, CekPerkembanganP2b42Activity::class.java)
                        intent.putExtra("umur", umur)
                        startActivity(intent)
                    } else if (umur<54) {
                        val intent = Intent(this, CekPerkembanganP2b48Activity::class.java)
                        intent.putExtra("umur", umur)
                        startActivity(intent)
                    } else if (umur<60) {
                        val intent = Intent(this, CekPerkembanganP2b54Activity::class.java)
                        intent.putExtra("umur", umur)
                        startActivity(intent)
                    } else if (umur<66) {
                        val intent = Intent(this, CekPerkembanganP2b60Activity::class.java)
                        intent.putExtra("umur", umur)
                        startActivity(intent)
                    } else if (umur<72) {
                        val intent = Intent(this, CekPerkembanganP2b66Activity::class.java)
                        intent.putExtra("umur", umur)
                        startActivity(intent)
                    } else if (umur>=72) {
                        val intent = Intent(this, CekPerkembanganP2b72Activity::class.java)
                        intent.putExtra("umur", umur)
                        startActivity(intent)
                    } /*else {
                        tvTidakTes!!.text = "Mohon maaf, tes perkembangan hanya dapat dilakukan untuk anak berumur 72 bulan ke bawah."
                    }*/

                }
            } else {
                tvEmptyAlertUsia!!.text = "Mohon lengkapi isian usia kehamilan."
            }
        }
    }

    private fun getUmur(usiaHamil: Int): Int {
        var c = cal.clone() as Calendar
        if (usiaHamil < 9) {
            c.add(Calendar.MONTH, 9-usiaHamil)
        }
        var count = 0
        while (!c.after(today)) {
            c.add(Calendar.MONTH, 1)
            ++count
        }
        if (count<0) return 0
        return count-1
    }

    private fun updateDateInView() {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
        tvIsiTglLahir!!.text = sdf.format(cal.getTime())
        if (cal.after(today)) {
            tvInvalidDate!!.text = "Mohon masukkan tanggal lahir yang valid."
        } else {
            tvInvalidDate!!.text = ""
        }
    }

}