package com.example.contadorcasino.data

import com.example.contadorcasino.R
import com.example.contadorcasino.model.NegativeAction
import com.example.contadorcasino.model.Persona
import com.example.contadorcasino.model.PositiveAction

class Datasource {
    fun loadPositiveActions(): List<PositiveAction> {
        return listOf(
            PositiveAction(
                stringResourceId = R.string.positiveAction1,
                imageResource = R.drawable.user,
                valor = 35
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction2,
                imageResource = R.drawable.user,
                valor = 35
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction3,
                imageResource = R.drawable.user,
                valor = 35
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction4,
                imageResource = R.drawable.user,
                valor = 35
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction5,
                imageResource = R.drawable.user,
                valor = 35
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction6,
                imageResource = R.drawable.user,
                valor = 35
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction7,
                imageResource = R.drawable.user,
                valor = 35
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction8,
                imageResource = R.drawable.user,
                valor = 35
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction9,
                imageResource = R.drawable.user,
                valor = 35
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction10,
                imageResource = R.drawable.user,
                valor = 35
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction11,
                imageResource = R.drawable.user,
                valor = 35
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction12,
                imageResource = R.drawable.user,
                valor = 35
            ),
            PositiveAction(
                stringResourceId = R.string.positiveAction13,
                imageResource = R.drawable.user,
                valor = 35
            ),
        )
    }
    fun loadNegativeActions(): List<NegativeAction>{
        val listaNegativeAction: List<NegativeAction> = listOf<NegativeAction>(
            NegativeAction(
                stringResourceId = R.string.negativeAction1,
                imageResource = R.drawable.user,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction2,
                imageResource = R.drawable.user,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction3,
                imageResource = R.drawable.user,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction4,
                imageResource = R.drawable.user,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction5,
                imageResource = R.drawable.user,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction6,
                imageResource = R.drawable.user,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction7,
                imageResource = R.drawable.user,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction8,
                imageResource = R.drawable.user,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction9,
                imageResource = R.drawable.user,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction10,
                imageResource = R.drawable.user,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction11,
                imageResource = R.drawable.user,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction12,
                imageResource = R.drawable.user,
                valor = 10
            ),
            NegativeAction(
                stringResourceId = R.string.negativeAction13,
                imageResource = R.drawable.user,
                valor = 10
            ),
        )
        return listaNegativeAction
    }
    fun loadPersonas(): List<Persona> {
        return listOf<Persona>(
            Persona(
                nombre = "Andrew",
                puntos = 10
            ), Persona(
                nombre = "Matthews",
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