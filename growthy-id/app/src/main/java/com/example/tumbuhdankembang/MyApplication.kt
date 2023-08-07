package com.example.tumbuhdankembang

import android.app.Application

class MyApplication: Application() {

    companion object {
        var listHasilTes: HashMap<KeyResult, ValueResult> = HashMap<KeyResult, ValueResult>()
    }

    override fun onCreate() {
        super.onCreate()
    }


}