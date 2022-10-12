package com.example.contadorcasino

import android.content.Context
import android.widget.Toast

class Prefs(private val context: Context) {

    val SHARED_NAME = "MyDataBase"

    val SHARED_DATO = "dato"

    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveDato(dato: String){
        storage.edit().putString(SHARED_DATO, dato).apply()
        Toast.makeText(this.context, "Guardado: $dato", Toast.LENGTH_SHORT).show()
    }
    fun getDato(): String{
        return storage.getString(SHARED_DATO,"no hay")!!
    }
}