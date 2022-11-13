package com.example.contadorcasino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contadorcasino.adapter.ItemAdapter
import com.example.contadorcasino.adapter.NegativeAdapter
import com.example.contadorcasino.adapter.PositiveAdapter
import com.example.contadorcasino.data.Datasource
import com.example.contadorcasino.databinding.ActivityActividadesPositivasBinding
import com.example.contadorcasino.model.NegativeAction
import com.example.contadorcasino.model.PositiveAction

class ActividadesPositivas : AppCompatActivity() {

    private lateinit var binding: ActivityActividadesPositivasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadesPositivasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myPositiveDataset = Datasource().loadPositiveActions()
        val myNegativeDataset = Datasource().loadNegativeActions()
        val recyclerViewPositive = binding.recyclerViewPositive
        val recyclerViewNegative = binding.recyclerViewNegative

        recyclerViewPositive.adapter = PositiveAdapter(
            context = this,
            onClickAction = {
                onItemPositiveSelected(it)
            },
            dataset = myPositiveDataset
        )
        recyclerViewPositive.setHasFixedSize(true)

        recyclerViewNegative.adapter = NegativeAdapter(
            context = this,
            onClickAction = {
                onItemNegativeSelected(it)
            },
            dataset = myNegativeDataset
        )


    }

    fun onItemNegativeSelected(elementolista: NegativeAction) {
        Toast.makeText(
            this,
            "${this.resources.getString(elementolista.stringResourceId)}",
            Toast.LENGTH_SHORT
        ).show()
    }
    fun onItemPositiveSelected(elementolista: PositiveAction) {
        Toast.makeText(
            this,
            "${this.resources.getString(elementolista.stringResourceId)}",
            Toast.LENGTH_SHORT
        ).show()
    }
}