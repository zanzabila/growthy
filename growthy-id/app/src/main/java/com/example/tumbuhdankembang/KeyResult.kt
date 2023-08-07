package com.example.tumbuhdankembang

class KeyResult(val namaAnak: String, val tglAnak: String) {
    override fun hashCode(): Int {
        return 1
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as KeyResult

        if (namaAnak != other.namaAnak) return false
        if (tglAnak != other.tglAnak) return false

        return true
    }
}