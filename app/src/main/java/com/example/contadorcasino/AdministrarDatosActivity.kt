package com.example.contadorcasino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contadorcasino.GuardarDatos.Companion.prefs
import com.example.contadorcasino.databinding.ActivityAdministrarDatosBinding

class AdministrarDatosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAdministrarDatosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdministrarDatosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val stringDataAndrew = prefs.getAndrew()
        val stringDataMatthew = prefs.getMatthew()
        val stringDataMom = prefs.getMama()
        val stringDataDad = prefs.getPapa()


        binding.textDatos.text = cadenaToStringLejible(stringDataAndrew)
    }

    fun cadenaToStringLejible(cad: String): String{
        var stringFinal = ""
        if(cad != "no hay"){
            val nombre: String = cad.split(",")[0]
            val fecha: String = cad.split(",")[1]
            val puntosPremio: Int = cad.split(",")[2].toInt()
            val puntosCastigo: Int = cad.split(",")[3].toInt()
            val puntosJuego: Int = cad.split(",")[4].toInt()
            val puntosAyer: Int = cad.split(",")[5].toInt()
            val puntosHoy: Int = cad.split(",")[6].toInt()
            val dinero: Float = cad.split(",")[7].toFloat()

            stringFinal =
                    "Nombre: $nombre\n" +
                    "Fecha: $fecha\n" +
                    "Puntos Premio: $puntosPremio\n" +
                    "Puntos Castigo: $puntosCastigo\n" +
                    "Puntos Juego: $puntosJuego\n" +
                    "Puntos Ayer: $puntosAyer\n" +
                    "Puntos Hoy: $puntosHoy\n" +
                    "Dinero: $dinero"
        }

        return stringFinal
    }
}