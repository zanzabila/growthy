package com.example.tumbuhdankembang

import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageButton
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class CekEmosionalUmur : AppCompatActivity() {

    var tvIsiTglLahir: TextView? = null
    var btnCalendar: ImageButton? = null
    var today = Calendar.getInstance()
    var cal = Calendar.getInstance()
    private lateinit var etUsiaHamil: TextView
    private lateinit var btnEmosional: Button
    var tvInvalidDate: TextView? = null
    var tvEmptyAlertUsia: TextView? = null
    var tvLebih72: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cek_emosional_umur)

        tvIsiTglLahir = findViewById(R.id.tv_isiTglLahirEmosional)
        btnCalendar = findViewById(R.id.btn_calendarEmosional)
        etUsiaHamil = findViewById(R.id.et_usiaHamilEmosional)
        btnEmosional = findViewById(R.id.btn_emosional1)
        tvInvalidDate = findViewById(R.id.tv_invalidTglLahirEmosional)
        tvEmptyAlertUsia = findViewById(R.id.tv_emptyAlertUsiaHamilEmosional)
        tvLebih72 = findViewById(R.id.tv_invalidUsiaEmosional)

        tvEmptyAlertUsia!!.text = ""
        tvLebih72!!.text = ""
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
                DatePickerDialog(this@CekEmosionalUmur,
                    dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })

        btnEmosional.setOnClickListener {
            tvLebih72!!.text = ""
            if (etUsiaHamil.text.toString().length > 0) {
                tvEmptyAlertUsia!!.text = ""
                if (!cal.after(today)) {
                    var umur = getUmur(etUsiaHamil.text.toString().toInt())

                    if (umur < 18) {
                        tvEmptyAlertUsia!!.setTextColor(Color.parseColor("#000000"))
                        tvEmptyAlertUsia!!.text = "Anak belum perlu melakukan tes emosional.\nSilakan kembali ke halaman sebelumnya."
                    } else if (umur <= 36) {
                        tvEmptyAlertUsia!!.text = ""
                        val intent = Intent(this, CekEmosionalMCHAT::class.java)
                        intent.putExtra("umur", umur)
                        startActivity(intent)
                    } else if (umur<=72) {
                        val intent = Intent(this, CekEmosionalKMPE::class.java)
                        intent.putExtra("umur", umur)
                        startActivity(intent)
                    } else {
                        tvLebih72!!.text = "Mohon maaf, tes perkembangan hanya dapat dilakukan untuk anak berumur 72 bulan ke bawah."
                    }

                }
            } else {
                tvEmptyAlertUsia!!.setTextColor(Color.parseColor("#D0342C"))
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