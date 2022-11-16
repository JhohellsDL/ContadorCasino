package com.example.contadorcasino.model

data class Persona(
    val photoResourceId: Int,
    val nombre: String,
    val fecha: String,
    val puntosPremio: Int,
    val puntosCastigo: Int,
    val puntosJuego: Int,
    val puntosAyer: Int,
    val puntosHoy: Int,
    val dinero: Float
) {
}
// Andrew,10/10/2022,180,100,90,200,222,5.6