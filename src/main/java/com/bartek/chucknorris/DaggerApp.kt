package com.bartek.chucknorris

import android.app.Application

internal class DaggerApp : Application() {

    lateinit var injector: Injector

    override fun onCreate() {
        super.onCreate()

        instance = this

        injector = DaggerInjector
            .builder()
            .apiModule(ApiModule())
            .build()

    }



    companion object {
        lateinit var instance: DaggerApp private set
    }

}