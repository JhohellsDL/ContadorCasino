package com.example.contadorcasino

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.contadorcasino.adapter.ItemAdapter
import com.example.contadorcasino.data.Datasource
import com.example.contadorcasino.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val myDataset = Datasource().loadPositiveActions() //Datasource().loadPersonas()
        //val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        binding.recyclerView.adapter = ItemAdapter(this, myDataset)
        binding.recyclerView.setHasFixedSize(true)

        binding.next.setOnClickListener { goToActividades() }
    }

    fun goToActividades(){
        startActivity(Intent(this, ActividadesPositivas::class.java))
    }
}