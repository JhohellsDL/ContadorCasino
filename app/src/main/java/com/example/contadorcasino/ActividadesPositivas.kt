package com.example.contadorcasino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contadorcasino.adapter.ItemAdapter
import com.example.contadorcasino.adapter.PositiveAdapter
import com.example.contadorcasino.data.Datasource
import com.example.contadorcasino.databinding.ActivityActividadesPositivasBinding
import com.example.contadorcasino.model.PositiveAction

class ActividadesPositivas : AppCompatActivity() {

    private lateinit var binding: ActivityActividadesPositivasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadesPositivasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myDataset = Datasource().loadPositiveActions()
        val recyclerView = binding.recyclerViewPositive
        recyclerView.adapter = PositiveAdapter(this,{
            onItemSelected(it)
        }, myDataset)
        recyclerView.setHasFixedSize(true)
    }
    fun onItemSelected(elementolista: PositiveAction) {
        Toast.makeText(this, "${this.resources.getString(elementolista.stringResourceId)}", Toast.LENGTH_SHORT).show()
    }
}