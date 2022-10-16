package com.example.contadorcasino.data

import com.example.contadorcasino.model.Persona

class Datasource {
    fun loadPersonas(): List<Persona> {
        return listOf<Persona>(
            Persona(
                nombre = "Andrew",
                puntos = 10
            ), Persona(
                nombre = "Matthew",
                puntos = 10
            ), Persona(
                nombre = "Mama",
                puntos = 10
            ), Persona(
                nombre = "Papa",
                puntos = 10
            )
        )
    }
}