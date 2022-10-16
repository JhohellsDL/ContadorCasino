package com.example.contadorcasino

import android.content.Context
import android.widget.Toast

class Prefs(private val context: Context) {

    val SHARED_NAME = "MyDataBase"

    val SHARED_DATO = "dato"
    val SHARED_ANDREW = "andrew"
    val SHARED_MATTHEW = "matthew"
    val SHARED_MAMA = "mama"
    val SHARED_PAPA = "papa"

    val storage = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveDato(dato: String){
        storage.edit().putString(SHARED_DATO, dato).apply()
        Toast.makeText(this.context, "Guardado: $dato", Toast.LENGTH_SHORT).show()
    }
    fun getDato(): String{
        return storage.getString(SHARED_DATO,"no hay")!!
    }

    fun saveAndrew(dato: String){
        storage.edit().putString(SHARED_ANDREW, dato).apply()
        Toast.makeText(this.context, "Guardado: $dato", Toast.LENGTH_SHORT).show()
    }
    fun getAndrew(): String{
        return storage.getString(SHARED_ANDREW,"no hay")!!
    }

    fun saveMatthew(dato: String){
        storage.edit().putString(SHARED_MATTHEW, dato).apply()
        Toast.makeText(this.context, "Guardado: $dato", Toast.LENGTH_SHORT).show()
    }
    fun getMatthew(): String{
        return storage.getString(SHARED_MATTHEW,"no hay")!!
    }

    fun saveMama(dato: String){
        storage.edit().putString(SHARED_MAMA, dato).apply()
        Toast.makeText(this.context, "Guardado: $dato", Toast.LENGTH_SHORT).show()
    }
    fun getMama(): String{
        return storage.getString(SHARED_MAMA,"no hay")!!
    }

    fun savePapa(dato: String){
        storage.edit().putString(SHARED_PAPA, dato).apply()
        Toast.makeText(this.context, "Guardado: $dato", Toast.LENGTH_SHORT).show()
    }
    fun getPapa(): String{
        return storage.getString(SHARED_PAPA,"no hay")!!
    }
}