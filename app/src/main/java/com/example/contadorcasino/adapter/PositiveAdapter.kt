package com.example.contadorcasino.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contadorcasino.R
import com.example.contadorcasino.model.PositiveAction

class PositiveAdapter(
    private val context: Context,
    private val onClickAction: (PositiveAction) -> Unit,
    private val dataset: List<PositiveAction>
) : RecyclerView.Adapter<PositiveAdapter.ItemViewHolderOk>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class ItemViewHolderOk(private val view: View) : RecyclerView.ViewHolder(view) {
        private val txtStringPositive: TextView = view.findViewById(R.id.textStringPositive)
        fun render(
            context: Context,
            elemento: PositiveAction,
            onClickListener: (PositiveAction) -> Unit
        ) {
            txtStringPositive.text = context.resources.getText(elemento.stringResourceId)
            itemView.setOnClickListener { onClickListener(elemento) }
        }
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolderOk {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_card_actions, parent, false)

        return ItemViewHolderOk(adapterLayout)
    }
    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
    override fun onBindViewHolder(holder: ItemViewHolderOk, position: Int) {
        val item = dataset[position]
        holder.render(context, item, onClickAction)
        //holder.txtStringPositive.text = context.resources.getString(item.stringResourceId)
    }
}