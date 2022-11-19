package com.example.contadorcasino.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contadorcasino.R
import com.example.contadorcasino.model.NegativeAction

class NegativeAdapter(
    private val context: Context,
    private val onClickAction: (NegativeAction) -> Unit,
    private val dataset: List<NegativeAction>
) : RecyclerView.Adapter<NegativeAdapter.NegativeViewHolder>(){

    class NegativeViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val txtStringNegative: TextView = view.findViewById(R.id.textStringPositive)
        private val imageNegative: ImageView = view.findViewById(R.id.imageViewPositive)
        private val textValorNegative: TextView = view.findViewById(R.id.textValorPositive)
        fun render(
            context: Context,
            element: NegativeAction,
            onClickListener: (NegativeAction) -> Unit
        ){
            imageNegative.setImageResource(element.imageResource)
            textValorNegative.text = (element.valor).toString()
            txtStringNegative.text = context.resources.getString(element.stringResourceId)
            itemView.setOnClickListener { onClickListener(element) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NegativeViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_card_actions,parent,false)
        return NegativeViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: NegativeViewHolder, position: Int) {
        val item = dataset[position]
        holder.render(context, item, onClickAction)
    }

    override fun getItemCount(): Int = dataset.size
}