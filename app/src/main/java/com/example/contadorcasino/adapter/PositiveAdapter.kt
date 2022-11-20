package com.example.contadorcasino.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contadorcasino.R
import com.example.contadorcasino.model.PositiveAction

class PositiveAdapter(
    private val context: Context,
    private val onClickActionResta: (PositiveAction) -> Unit,
    private val onClickAction: (PositiveAction) -> Unit,
    private val dataset: List<PositiveAction>
) : RecyclerView.Adapter<PositiveAdapter.ItemViewHolderOk>() {

    class ItemViewHolderOk(view: View) : RecyclerView.ViewHolder(view) {
        private val txtStringPositive: TextView = view.findViewById(R.id.textStringPositive)
        private val imagePositive: ImageView = view.findViewById(R.id.imageViewPositive)
        private val textValorPositive: TextView = view.findViewById(R.id.textValorPositive)
        private val textContadorItem: TextView = view.findViewById(R.id.textContadorItem)
        private val btnRestar: ImageButton = view.findViewById(R.id.btnRestar)
        fun render(
            context: Context,
            elemento: PositiveAction,
            onClickListenerRestar: (PositiveAction) -> Unit,
            onClickListener: (PositiveAction) -> Unit
        ) {
            imagePositive.setImageResource(elemento.imageResource)
            textValorPositive.text = (elemento.valor).toString()
            txtStringPositive.text = context.resources.getText(elemento.stringResourceId)
            btnRestar.setOnClickListener { onClickListenerRestar(elemento) }
            itemView.setOnClickListener { onClickListener(elemento) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolderOk {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_card_actions, parent, false)

        return ItemViewHolderOk(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolderOk, position: Int) {
        val item = dataset[position]
        holder.render(context, item, onClickActionResta, onClickAction)
    }

    override fun getItemCount() = dataset.size
}