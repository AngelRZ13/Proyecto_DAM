package com.example.proyecto_dam.utils

import android.app.Application
import android.content.Context
import com.example.proyecto_dam.base.BurgerBD

class appConfig:Application(){

    companion object{

        lateinit var CONTEXT:Context
        lateinit var BDNAME:String
        var VERSION:Int=1
        lateinit var BD:BurgerBD

    }

    override fun onCreate() {
        super.onCreate()
        BDNAME = "BurgerCiber4.bd"
        CONTEXT = applicationContext
        BD=BurgerBD(CONTEXT)


    }


}