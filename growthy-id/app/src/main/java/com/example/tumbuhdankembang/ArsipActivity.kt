package com.example.tumbuhdankembang

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class ArsipActivity : AppCompatActivity() {

    var tvIsiTglLahir: TextView? = null
    var btnCalendar: ImageButton? = null
    var cal = Calendar.getInstance()
    var tvInvalidDataAnak: TextView? = null
    var etNama: EditText? = null
    var tvEmptyAlertNama: TextView? = null
    private lateinit var btnArsip: Button
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_arsip)

        tvIsiTglLahir = findViewById(R.id.tv_isiTglLahirArsip)
        btnCalendar = findViewById(R.id.btn_calendarArsip)
        tvInvalidDataAnak = findViewById(R.id.tv_invalidDataAnak)
        etNama = findViewById(R.id.et_namaArsip)
        tvEmptyAlertNama = findViewById(R.id.tv_emptyAlertNamaArsip)
        btnArsip = findViewById(R.id.btn_arsip1)

        tvEmptyAlertNama!!.text = ""
        tvInvalidDataAnak!!.text = ""
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
                DatePickerDialog(this@ArsipActivity,
                    dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }
        })

        btnArsip.setOnClickListener {
            tvEmptyAlertNama!!.text = ""
            tvInvalidDataAnak!!.text = ""

            if (etNama!!.text.toString().length > 0) {
                var namaAnak = (etNama!!.text.toString()).lowercase()
                namaAnak = namaAnak.split(" ").joinToString(" ") { it.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                } }.trimEnd()
                val tgl = sdf.format(cal.getTime())
                val k = KeyResult(namaAnak, tgl)
                if (MyApplication.listHasilTes.containsKey(k)) {
                    val intent = Intent(this, KesimpulanActivity::class.java)
                    intent.putExtra("namaAnak", namaAnak)
                    intent.putExtra("tgl", tgl)
                    startActivity(intent)
                } else {
                    tvInvalidDataAnak!!.text = "Mohon maaf, data anak tidak ditemukan. Pastikan nama anak yang dimasukkan sama dengan yang dimasukkan saat tes."
                }
            } else {
                tvEmptyAlertNama!!.text = "Mohon lengkapi isian nama anak."
            }
        }

    }

    private fun updateDateInView() {
        tvIsiTglLahir!!.text = sdf.format(cal.getTime())
    }
}