package com.example.contadorcasino

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.*
import com.example.contadorcasino.adapter.ItemAdapter
import com.example.contadorcasino.data.Datasource
import com.example.contadorcasino.databinding.ActivityMainBinding
import com.example.contadorcasino.model.Persona

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val pickMedia = registerForActivityResult(PickVisualMedia()) {
        if(it != null){
            imgPrueba.setImageURI(it)
        }else{

        }
    }
    lateinit var imgPrueba : ImageView
    lateinit var btnImage : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnImage = findViewById(R.id.btnImagen)
        imgPrueba = findViewById(R.id.imgPrueba)
        btnImage.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(PickVisualMedia.ImageOnly))
        }


        val myDataset = Datasource().loadPersonas() //Datasource().loadPersonas()
        //val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        binding.recyclerView.adapter = ItemAdapter(this, onClickListener = {pasarDatos(it)}, myDataset)
        binding.recyclerView.setHasFixedSize(true)

        //binding.next.setOnClickListener { goToActividades() }
    }

    fun goToActividades(){
        startActivity(Intent(this, ActividadesPositivas::class.java))
    }

    fun pasarDatos(element: Persona){
        val nameIt: String = element.nombre
        val myIntent: Intent = Intent(this, ActividadesPositivas::class.java)
        val name: String = "pasamos!!!"

        myIntent.putExtra("ok",nameIt)
        startActivity(myIntent)
    }
}