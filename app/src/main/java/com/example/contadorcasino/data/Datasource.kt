package com.example.contadorcasino.data

import android.util.Log
import android.widget.Toast
import com.example.contadorcasino.GuardarDatos.Companion.prefs
import com.example.contadorcasino.R
import com.example.contadorcasino.model.NegativeAction
import com.example.contadorcasino.model.Persona
import com.example.contadorcasino.model.PositiveAction

class Datasource {
    fun loadPositiveActions(): List<PositiveAction> {
        return listOf(
            PositiveAction(
                stringResourceId = R.string.positiveAction1,
                imageResource = R.drawable.platos_limpios,
                valor = 35
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction2,
                imageResource = R.drawable.arr_sala,
                valor = 10
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction3,
                imageResource = R.drawable.arr_cocina,
                valor = 10
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction4,
                imageResource = R.drawable.arr_ropa,
                valor = 20
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction5,
                imageResource = R.drawable.trapear,
                valor = 30
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction6,
                imageResource = R.drawable.lav_cocina,
                valor = 10
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction7,
                imageResource = R.drawable.ser_amable,
                valor = 20
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction8,
                imageResource = R.drawable.ban_perro,
                valor = 10
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction9,
                imageResource = R.drawable.cuidar,
                valor = 10
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction10,
                imageResource = R.drawable.rec_juguetes,
                valor = 5
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction11,
                imageResource = R.drawable.lav_ba_o,
                valor = 20
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction12,
                imageResource = R.drawable.ayudar,
                valor = 5
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction13,
                imageResource = R.drawable.cocinar,
                valor = 20
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction14,
                imageResource = R.drawable.jug_riley,
                valor = 10
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction15,
                imageResource = R.drawable.lav_pies,
                valor = 5
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction16,
                imageResource = R.drawable.lleg_temprano,
                valor = 5
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction17,
                imageResource = R.drawable.hablar_ingles,
                valor = 10
            )
        )
    }
    fun loadNegativeActions(): List<NegativeAction> {
        return listOf(
            NegativeAction(
                stringResourceId = R.string.negativeAction1,
                imageResource = R.drawable.cara_fea,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction2,
                imageResource = R.drawable.ser_malo,
                valor = 20
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction3,
                imageResource = R.drawable.molestar,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction4,
                imageResource = R.drawable.golpear,
                valor = 30
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction5,
                imageResource = R.drawable.adios,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction6,
                imageResource = R.drawable.comportamiento,
                valor = 30
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction7,
                imageResource = R.drawable.problema,
                valor = 30
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction8,
                imageResource = R.drawable.enfermo,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction9,
                imageResource = R.drawable.sucio__1_,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction10,
                imageResource = R.drawable.mentiroso,
                valor = 20
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction11,
                imageResource = R.drawable.incomodo,
                valor = 20
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction12,
                imageResource = R.drawable.incomodo__1_,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction13,
                imageResource = R.drawable.jugador,
                valor = 20
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction14,
                imageResource = R.drawable.abuso_verbal,
                valor = 15
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction15,
                imageResource = R.drawable.reflexologia,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction16,
                imageResource = R.drawable.tarde,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction17,
                imageResource = R.drawable.no_hablar_ingles,
                valor = 10
            )
        )
    }
    fun stringToPersona(cad: String, photo: Int): Persona {
        val photoResourceId: Int = photo
        val nombre: String = cad.split(",")[0]
        val fecha: String = cad.split(",")[1]
        val puntosPremio: Int = cad.split(",")[2].toInt()
        val puntosCastigo: Int = cad.split(",")[3].toInt()
        val puntosJuego: Int = cad.split(",")[4].toInt()
        val puntosAyer: Int = cad.split(",")[5].toInt()
        val puntosHoy: Int = cad.split(",")[6].toInt()
        val dinero: Float = cad.split(",")[7].toFloat()

        val p: Persona = Persona(
            photoResourceId = photoResourceId,
            nombre = nombre,
            fecha = fecha,
            puntosPremio = puntosPremio,
            puntosCastigo = puntosCastigo,
            puntosJuego = puntosJuego,
            puntosAyer = puntosAyer,
            puntosHoy = puntosHoy,
            dinero = dinero
        )

        return p
    }
    fun loadPersonas(): List<Persona> {
        var andrew = prefs.getAndrew()
        if (andrew == "no hay"){
            andrew = "Andrew,10/10/2022,0,0,0,0,0,0"
        }
        var matthew = prefs.getMatthew()
        if (matthew == "no hay"){
            matthew = "Matthew,10/10/2022,0,0,0,0,0,0"
        }
        var mom = prefs.getMama()
        if (mom == "no hay"){
            mom = "Mom,10/10/2022,0,0,0,0,0,0"
        }
        var dad = prefs.getPapa()
        if (dad == "no hay"){
            dad = "Dad,10/10/2022,0,0,0,0,0,0"
        }

        val andrewString: String =  andrew //"Andrew,10/10/2022,180,100,90,200,222,5.6"
        val andrewPhoto: Int = R.drawable.andrew

        val matthewString: String = matthew //"Matthew,10/10/2022,180,100,90,200,222,5.6"
        val matthewPhoto: Int = R.drawable.matthew

        val momString: String = mom //"Mom,10/10/2022,180,100,90,200,222,5.6"
        val momPhoto: Int = R.drawable.mom

        val dadString: String = dad //"DAD,10/10/2022,180,100,90,200,222,5.6"
        val dadPhoto: Int = R.drawable.dad

        val andrewPersona: Persona = stringToPersona(andrewString, andrewPhoto)
        val matthewPersona: Persona = stringToPersona(matthewString, matthewPhoto)
        val momPersona: Persona = stringToPersona(momString, momPhoto)
        val dadPersona: Persona = stringToPersona(dadString, dadPhoto)

        val listaPersonas : List<Persona> = listOf<Persona>(andrewPersona, matthewPersona, momPersona, dadPersona)

        return listaPersonas
        /*
        return listOf<Persona>(
            Persona(
                photoResourceId = R.drawable.andrew,
                nombre = "Andrew",
                fecha = "",
                puntosPremio = 0,
                puntosCastigo = 0,
                puntosJuego = 0,
                puntosAyer = 0,
                puntosHoy = 0,
                dinero = 0f
            ), Persona(
                photoResourceId = R.drawable.matthew,
                nombre = "Matthew",
                fecha = "",
                puntosPremio = 0,
                puntosCastigo = 0,
                puntosJuego = 0,
                puntosAyer = 0,
                puntosHoy = 0,
                dinero = 0f
            ), Persona(
                photoResourceId = R.drawable.mom,
                nombre = "Mom",
                fecha = "",
                puntosPremio = 0,
                puntosCastigo = 0,
                puntosJuego = 0,
                puntosAyer = 0,
                puntosHoy = 0,
                dinero = 0f
            ), Persona(
                photoResourceId = R.drawable.dad,
                nombre = "Dad",
                fecha = "",
                puntosPremio = 0,
                puntosCastigo = 0,
                puntosJuego = 0,
                puntosAyer = 0,
                puntosHoy = 0,
                dinero = 0f
            )
        )*/
    }
}