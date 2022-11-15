package com.example.contadorcasino

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
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
    private var increase: Int = 0
    private var decrease: Int = 0
    private var totalPoints: Int = 0
    private var money: Float =0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadesPositivasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myPositiveDataset = Datasource().loadPositiveActions()
        val myNegativeDataset = Datasource().loadNegativeActions()
        val recyclerViewPositive = binding.recyclerViewPositive
        val recyclerViewNegative = binding.recyclerViewNegative

        val myIntent: String? = intent.getStringExtra("ok")
        binding.nameUser.text = myIntent

        val photo = when(myIntent) {
            "Andrew" -> R.drawable.andrew
            "Matthew" -> R.drawable.matthew
            "Dad" -> R.drawable.dad
            else -> R.drawable.mom
        }
        binding.photoUser.setImageResource(photo)

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

    // 0.025 by point
    fun onItemNegativeSelected(elementolista: NegativeAction) {
        decrease += elementolista.valor
        totalPoints -= elementolista.valor
        money = (totalPoints*0.025f)

        binding.valorEnDinero.text = "S/. $money"
        binding.puntosTotalGanados.text = "$totalPoints"
        binding.puntosPerdidos.text = "$decrease"
    }
    fun onItemPositiveSelected(elementolista: PositiveAction) {
        increase += elementolista.valor
        totalPoints += elementolista.valor
        money = (totalPoints*0.025f)

        binding.valorEnDinero.text = "S/. $money"
        binding.puntosTotalGanados.text = "$totalPoints"
        binding.puntosGanados.text = "$increase"
    }
}