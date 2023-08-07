package com.example.tumbuhdankembang

class ValueResult {
    private var tglPert: String = ""
    private var tglPerk: String = ""
    private var tglEmos: String = ""

    private var pertTinggiUmur: String = ""
    private var pertBeratUmur: String = ""
    private var pertBeratTinggi: String = ""
    private var pertLingkarUmur: String = ""

    private var perkKPSP: String = ""
    private var perkTDD: String = ""
    private var perkTDL: String = ""

    private var emosMCHAT: String = ""
    private var emosKMPE: String = ""
    private var emosGPPH: String = ""


    fun getTglPert(): String {return tglPert}
    fun getTglPerk(): String {return tglPerk}
    fun getTglEmos(): String {return tglEmos}

    fun setHasilPertumbuhan(tgl: String,
                            tinggiUmur: String,
                            beratUmur: String,
                            beratTinggi: String,
                            lingkarUmur: String) {
        this.tglPert = tgl
        this.pertTinggiUmur = tinggiUmur
        this.pertBeratUmur = beratUmur
        this.pertBeratTinggi = beratTinggi
        this.pertLingkarUmur = lingkarUmur
    }

    fun setHasilPerkembangan(tgl: String,
                             kpsp: String,
                             tdd: String,
                             tdl: String) {
        this.tglPerk = tgl
        this.perkKPSP = kpsp
        this.perkTDD = tdd
        this.perkTDL = tdl
    }

    fun setHasilEmosional(tgl: String,
                          mchat: String,
                          kmpe: String,
                          gpph: String) {
        this.tglEmos = tgl
        this.emosMCHAT = mchat
        this.emosKMPE = kmpe
        this.emosGPPH = gpph
    }

    fun getTinggiUmur(): String {return pertTinggiUmur}
    fun getBeratUmur(): String {return pertBeratUmur}
    fun getBeratTinggi(): String {return pertBeratTinggi}
    fun getLingkarUmur(): String {return pertLingkarUmur}

    fun getKPSP(): String {return perkKPSP}
    fun getTDD(): String {return perkTDD}
    fun getTDL(): String {return perkTDL}

    fun getMCHAT(): String {return emosMCHAT}
    fun getKMPE(): String {return emosKMPE}
    fun getGPPH(): String {return emosGPPH}

}