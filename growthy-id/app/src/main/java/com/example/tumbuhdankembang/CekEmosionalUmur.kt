package com.example.tumbuhdankembang

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
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
    var tvTidakTes: TextView? = null
    var etNama: EditText? = null
    var tvEmptyAlertNama: TextView? = null
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cek_emosional_umur)

        tvIsiTglLahir = findViewById(R.id.tv_isiTglLahirEmosional)
        btnCalendar = findViewById(R.id.btn_calendarEmosional)
        etUsiaHamil = findViewById(R.id.et_usiaHamilEmosional)
        btnEmosional = findViewById(R.id.btn_emosional1)
        tvInvalidDate = findViewById(R.id.tv_invalidTglLahirEmosional)
        tvEmptyAlertUsia = findViewById(R.id.tv_emptyAlertUsiaHamilEmosional)
        tvTidakTes = findViewById(R.id.tv_invalidUsiaEmosional)
        etNama = findViewById(R.id.et_namaEmosional)
        tvEmptyAlertNama = findViewById(R.id.tv_emptyAlertNamaEmosional)

        tvEmptyAlertNama!!.text = ""
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
                DatePickerDialog(this@CekEmosionalUmur,
                    dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })

        btnEmosional.setOnClickListener {
            tvTidakTes!!.text = ""

            if (etUsiaHamil.text.toString().length > 0) tvEmptyAlertUsia!!.text = ""
            else tvEmptyAlertUsia!!.text = "Mohon lengkapi isian usia kehamilan."

            if (etNama!!.text.toString().length > 0) tvEmptyAlertNama!!.text = ""
            else tvEmptyAlertNama!!.text = "Mohon lengkapi isian nama anak."

            if (etUsiaHamil.text.toString().length>0 && etNama!!.text.toString().length>0) {
                tvEmptyAlertUsia!!.text = ""
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

                    if (umur < 18) {
                        tvTidakTes!!.text = "Anak belum perlu melakukan tes emosional.\nSilakan kembali ke halaman sebelumnya."
                    } else if (umur < 42) {
                        tvEmptyAlertUsia!!.text = ""
                        val intent = Intent(this, CekEmosionalMCHAT::class.java)
                        intent.putExtra("umur", umur)
                        intent.putExtra("nama", nama)
                        intent.putExtra("tglLahir", tglLahir)
                        intent.putExtra("tglHariIni", tglHariIni)
                        startActivity(intent)
                    } else if (umur<=72) {
                        val intent = Intent(this, CekEmosionalKMPE::class.java)
                        intent.putExtra("umur", umur)
                        intent.putExtra("nama", nama)
                        intent.putExtra("tglLahir", tglLahir)
                        intent.putExtra("tglHariIni", tglHariIni)
                        startActivity(intent)
                    } else {
                        tvTidakTes!!.text = "Mohon maaf, tes mental emosional hanya dapat dilakukan untuk anak berumur 72 bulan ke bawah."
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