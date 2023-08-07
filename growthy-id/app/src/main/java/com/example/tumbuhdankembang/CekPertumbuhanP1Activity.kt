package com.example.tumbuhdankembang

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class CekPertumbuhanP1Activity : AppCompatActivity() {

    var tvIsiTglLahir: TextView? = null
    var btnCalendar: ImageButton? = null
    var today = Calendar.getInstance()
    var cal = Calendar.getInstance()
    private lateinit var etUsiaHamil: TextView
    private lateinit var btnPertumbuhan1: Button
    var tvInvalidDate: TextView? = null
    var tvEmptyAlertUsia: TextView? = null
    var radioJenis: RadioGroup? = null
    var tvEmptyAlertJenis: TextView? = null
    var tvLebih72: TextView? = null
    var etNama: EditText? = null
    var tvEmptyAlertNama: TextView? = null
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cek_pertumbuhan_p1)

        tvIsiTglLahir = findViewById(R.id.tv_isiTglLahirPertumbuhan)
        btnCalendar = findViewById(R.id.btn_calendarPertumbuhan)
        etUsiaHamil = findViewById(R.id.et_usiaHamilPertumbuhan)
        btnPertumbuhan1 = findViewById(R.id.btn_pertumbuhan1)
        tvInvalidDate = findViewById(R.id.tv_invalidTglLahirPertumbuhan)
        tvEmptyAlertUsia = findViewById(R.id.tv_emptyAlertUsiaHamilPertumbuhan)
        radioJenis = findViewById(R.id.radio_jkPerkembangan)
        tvEmptyAlertJenis = findViewById(R.id.tv_emptyAlertJenisPertumbuhan)
        tvLebih72 = findViewById(R.id.tv_invalidUsiaPertumbuhan)
        etNama = findViewById(R.id.et_namaPertumbuhan)
        tvEmptyAlertNama = findViewById(R.id.tv_emptyAlertNamaPertumbuhan)

        tvEmptyAlertNama!!.text = ""
        tvEmptyAlertUsia!!.text = ""
        tvEmptyAlertJenis!!.text = ""
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
                DatePickerDialog(this@CekPertumbuhanP1Activity,
                    dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })

        btnPertumbuhan1.setOnClickListener {
            tvLebih72!!.text = ""
            var jk: String = ""

            if (etNama!!.text.toString().length > 0) {
                tvEmptyAlertNama!!.text = ""
            }  else {
                tvEmptyAlertNama!!.text = "Mohon lengkapi isian nama anak."
            }

            if (etUsiaHamil.text.toString().length > 0){
                tvEmptyAlertUsia!!.text = ""
            } else {
                tvEmptyAlertUsia!!.text = "Mohon lengkapi isian usia kehamilan."
            }

            if (radioJenis!!.checkedRadioButtonId > -1) {
                tvEmptyAlertJenis!!.text = ""
                val radioSelected: RadioButton = findViewById(radioJenis!!.checkedRadioButtonId)
                jk = radioSelected.getText().toString()
            } else {
                tvEmptyAlertJenis!!.text = "Mohon pilih jenis kelamin anak."
            }

            if (etUsiaHamil.text.toString().length > 0 &&
                radioJenis!!.checkedRadioButtonId > -1 &&
                etNama!!.text.toString().length > 0) {
                if (!cal.after(today)) {
                    var umur = getUmur(etUsiaHamil.text.toString().toInt())
                    var nama = (etNama!!.text.toString()).lowercase()
                    nama = nama.split(" ").joinToString(" ") { it.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                            Locale.getDefault()
                        ) else it.toString()
                    } }.trimEnd()
                    val tglLahir = tvIsiTglLahir!!.text
                    val tglHariIni = sdf.format(today.getTime())

                    if (umur<=72) {
                        val intent = Intent(this, CekPertumbuhanP2Activity::class.java)
                        intent.putExtra("jk", jk)
                        intent.putExtra("umur", umur)
                        intent.putExtra("nama", nama)
                        intent.putExtra("tglLahir", tglLahir)
                        intent.putExtra("tglHariIni", tglHariIni)
                        startActivity(intent)
                    } else {
                        tvLebih72!!.text = "Mohon maaf, tes pertumbuhan hanya dapat dilakukan untuk anak berumur 72 bulan ke bawah."
                    }
                }
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
        if (count==0) return 0
        if (count==73) {
            c.add(Calendar.MONTH, -1)
            var days = 0
            while (c.before(today)) {
                c.add(Calendar.DAY_OF_MONTH, 1)
                ++days
            }
            if (days<30) return 72
            else return 73
        }
        return count-1
    }

    private fun updateDateInView() {
        tvIsiTglLahir!!.text = sdf.format(cal.getTime())
        if (cal.after(today)) {
            tvInvalidDate!!.text = "Mohon masukkan tanggal lahir yang valid."
        } else {
            tvInvalidDate!!.text = ""
        }
    }

}