package com.example.contadorcasino.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contadorcasino.R
import com.example.contadorcasino.model.Persona
import org.w3c.dom.Text

class ItemAdapter(
    private val context: Context,
    private val dataset: List<Persona>
) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textNombre: TextView = view.findViewById(R.id.nombre_item)
        val textPuntos: TextView = view.findViewById(R.id.item_puntos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        //Create a new view
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textNombre.text = (item.nombre)
        holder.textPuntos.text = item.puntos.toString()
    }

    override fun getItemCount(): Int = dataset.size
}