package com.example.contadorcasino.userdetail

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contadorcasino.R
import com.example.contadorcasino.model.Persona
import android.content.Context

class UserDetailAdapter(
    private val context: Context,
    private val onClickListener: (Persona) -> Unit,
    private val dataset: List<Persona>
): RecyclerView.Adapter<UserDetailAdapter.UserViewHolder>() {

    var data = listOf<Persona>()

    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val photo: ImageView = view.findViewById(R.id.image_item)
        val textNombre: TextView = view.findViewById(R.id.nombre_item)
        val textFecha: TextView = view.findViewById(R.id.text_fecha)
        val textPuntosPremio: TextView = view.findViewById(R.id.puntosPremio)
        val textPuntosCastigo: TextView = view.findViewById(R.id.puntosCastigo)
        val textPuntosJuego: TextView = view.findViewById(R.id.puntosJuego)
        val textPuntosAyer: TextView = view.findViewById(R.id.puntosAyer)
        val textPuntosHoy: TextView = view.findViewById(R.id.puntosHoy)
        val textDinero: TextView = view.findViewById(R.id.dinero)

        fun render(
            context: Context,
            element: Persona,
            onClickListener: (Persona) -> Unit
        ) {
            photo.setImageResource(element.photoResourceId)
            textNombre.text = element.nombre
            textFecha.text = "Fecha:  ${element.fecha}"
            textPuntosPremio.text = element.puntosPremio.toString()
            textPuntosCastigo.text = element.puntosCastigo.toString()
            textPuntosJuego.text = element.puntosJuego.toString()
            textPuntosAyer.text = "Ayer ${element.puntosAyer} puntos"
            textPuntosHoy.text = "Hoy ${element.puntosHoy} puntos"
            textDinero.text = "S/. ${element.dinero}"
            itemView.setOnClickListener { onClickListener(element) }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UserViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = data[position]
        holder.render(context, item, onClickListener)
    }

}