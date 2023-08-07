package com.example.tumbuhdankembang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class KesimpulanActivity : AppCompatActivity() {

    private lateinit var btnHome: Button
    var tvTinggiUmur: TextView? = null
    var tvBeratUmur: TextView? = null
    var tvBeratTinggi: TextView? = null
    var tvLingkarUmur: TextView? = null
    var tvKPSP: TextView? = null
    var tvTDD: TextView? = null
    var tvTDL: TextView? = null
    var tvMCHAT: TextView? = null
    var tvKMPE: TextView? = null
    var tvGPPH: TextView? = null
    var tvNama: TextView? = null
    var tvTgl: TextView? = null
    var tvTglPert: TextView? = null
    var tvTglPerk: TextView? = null
    var tvTglEmos: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kesimpulan)

        btnHome = findViewById(R.id.btn_keBerandaKesimpulan)
        tvTglPert = findViewById(R.id.tv_tglPertumbuhan)
        tvTglPerk = findViewById(R.id.tv_tglPerkembangan)
        tvTglEmos = findViewById(R.id.tv_tglEmosional)
        tvTinggiUmur = findViewById(R.id.tv_heightForAge_simpulan)
        tvBeratUmur = findViewById(R.id.tv_weightForAge_simpulan)
        tvBeratTinggi = findViewById(R.id.tv_weightForLength_simpulan)
        tvLingkarUmur = findViewById(R.id.tv_headCircumferenceForAge_simpulan)
        tvKPSP = findViewById(R.id.tv_hasilKPSP_simpulan)
        tvTDD = findViewById(R.id.tv_hasilTDD_simpulan)
        tvTDL = findViewById(R.id.tv_hasilTDL_simpulan)
        tvMCHAT = findViewById(R.id.tv_hasilEmoMCHAT_simpulan)
        tvKMPE = findViewById(R.id.tv_hasilEmoKMPE_simpulan)
        tvGPPH = findViewById(R.id.tv_hasilEmoGPPH_simpulan)
        tvNama = findViewById(R.id.tv_nama_simpulan)
        tvTgl = findViewById(R.id.tv_lahir_simpulan)
        
        val namaAnak = intent.getStringExtra("namaAnak")
        val tgl = intent.getStringExtra("tgl")
        tvNama!!.text = namaAnak
        tvTgl!!.text = tgl

        val k = KeyResult(namaAnak!!, tgl!!)
        val tglPert = MyApplication.listHasilTes.get(k)!!.getTglPert()
        val tglPerk = MyApplication.listHasilTes.get(k)!!.getTglPerk()
        val tglEmos = MyApplication.listHasilTes.get(k)!!.getTglEmos()
        val TinggiUmur = MyApplication.listHasilTes.get(k)!!.getTinggiUmur()
        val BeratUmur = MyApplication.listHasilTes.get(k)!!.getBeratUmur()
        val BeratTinggi = MyApplication.listHasilTes.get(k)!!.getBeratTinggi()
        val LingkarUmur = MyApplication.listHasilTes.get(k)!!.getLingkarUmur()
        val KPSP = MyApplication.listHasilTes.get(k)!!.getKPSP()
        val TDD = MyApplication.listHasilTes.get(k)!!.getTDD()
        val TDL = MyApplication.listHasilTes.get(k)!!.getTDL()
        val MCHAT = MyApplication.listHasilTes.get(k)!!.getMCHAT()
        val KMPE = MyApplication.listHasilTes.get(k)!!.getKMPE()
        val GPPH = MyApplication.listHasilTes.get(k)!!.getGPPH()

        if (tglPert.length > 0) tvTglPert!!.text = tglPert
        else tvTglPert!!.text = "(--/--/----)"
        if (tglPerk.length > 0) tvTglPerk!!.text = tglPerk
        else tvTglPerk!!.text = "(--/--/----)"
        if (tglEmos.length > 0) tvTglEmos!!.text = tglEmos
        else tvTglEmos!!.text = "(--/--/----)"

        // Pertumbuhan
        when {
            TinggiUmur.equals("") -> {
                tvTinggiUmur!!.text = "-"
            }
            else -> {
                tvTinggiUmur!!.text = TinggiUmur.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                }
            }
        }
        when {
            BeratUmur.equals("") -> {
                tvBeratUmur!!.text = "-"
            }
            else -> {
                tvBeratUmur!!.text = BeratUmur.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                }
            }
        }
        when {
            BeratTinggi.equals("") -> {
                tvBeratTinggi!!.text = "-"
            }
            else -> {
                tvBeratTinggi!!.text = BeratTinggi.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                }
            }
        }
        when {
            LingkarUmur.equals("") -> {
                tvLingkarUmur!!.text = "-"
            }
            (LingkarUmur.equals("sangat kecil") || LingkarUmur.equals("kecil")) -> {
                tvLingkarUmur!!.text = "Mikrosefal"
            }
            LingkarUmur.equals("normal") -> {
                tvLingkarUmur!!.text = "Normal"
            }
            (LingkarUmur.equals("besar") || LingkarUmur.equals("sangat besar")) -> {
                tvLingkarUmur!!.text = "Makrosefal"
            }
        }

        // Perkembangan
        when {
            KPSP.equals("") -> {
                tvKPSP!!.text = "-"
            }
            else -> {
                tvKPSP!!.text = KPSP.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                }
            }
        }
        when {
            TDD.equals("") -> {
                tvTDD!!.text = "-"
            }
            else -> {
                tvTDD!!.text = TDD.replaceFirstChar {
                    if (it.isLowerCase()) it.titlecase(
                        Locale.getDefault()
                    ) else it.toString()
                }
            }
        }
        when {
            TDL.equals("") -> {
                tvTDL!!.text = "-"
            }
            TDL.equals("normal") -> {
                tvTDL!!.text = "Normal"
            }
            TDL.equals("normal kiri") -> {
                tvTDL!!.text = "Kemungkinan gangguan pada mata kanan"
            }
            TDL.equals("normal kanan") -> {
                tvTDL!!.text = "Kemungkinan gangguan pada mata kiri"
            }
            TDL.equals("mungkin gangguan") -> {
                tvTDL!!.text = "Kemungkinan gangguan pada kedua mata"
            }
        }

        // Emosional
        when {
            MCHAT.equals("") -> {
                tvMCHAT!!.text = "-"
            }
            MCHAT.equals("risiko") -> {
                tvMCHAT!!.text = "Risiko tinggi autisme"
            }
            MCHAT.equals("normal") -> {
                tvMCHAT!!.text = "Normal"
            }
        }
        when {
            KMPE.equals("") -> {
                tvKMPE!!.text = "-"
            }
            KMPE.equals("normal") -> {
                tvKMPE!!.text = "Normal"
            }
            KMPE.equals("terindikasi ringan") -> {
                tvKMPE!!.text = "Terindikasi ringan masalah perilaku emosional"
            }
            KMPE.equals("terindikasi berat") -> {
                tvKMPE!!.text = "Terindikasi berat masalah perilaku emosional"
            }
        }
        when {
            GPPH.equals("") -> {
                tvGPPH!!.text = "-"
            }
            GPPH.equals("normal") -> {
                tvGPPH!!.text = "Normal"
            }
            GPPH.equals("kemungkinan gpph") -> {
                tvGPPH!!.text = "Terindikasi kemungkinan gangguan pemusatan perhatian dan hiperaktivitas"
            }
        }

        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

    }
}