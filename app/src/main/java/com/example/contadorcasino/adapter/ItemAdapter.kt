package com.example.contadorcasino.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contadorcasino.GuardarDatos.Companion.prefs
import com.example.contadorcasino.R
import com.example.contadorcasino.databinding.ActivityActividadesPositivasBinding
import com.example.contadorcasino.model.NegativeAction
import com.example.contadorcasino.model.Persona
import com.example.contadorcasino.model.PositiveAction
import org.w3c.dom.Text

class ItemAdapter(
    private val context: Context,
    private val onClickListener: (Persona) -> Unit,
    private val dataset: List<Persona>
) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
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
        ){
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
    ): ItemViewHolder {
        //Create a new view
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.render(context, item, onClickListener)
        //holder.textPuntos.text = item.puntos.toString()
    }

    override fun getItemCount(): Int = dataset.size
}