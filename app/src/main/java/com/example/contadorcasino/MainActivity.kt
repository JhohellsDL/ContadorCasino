package com.example.contadorcasino

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts.*
import androidx.fragment.app.DialogFragment
import com.example.contadorcasino.GuardarDatos.Companion.prefs
import com.example.contadorcasino.adapter.ItemAdapter
import com.example.contadorcasino.data.Datasource
import com.example.contadorcasino.databinding.ActivityMainBinding
import com.example.contadorcasino.model.Persona
import com.example.contadorcasino.model.StartGameDialogFragment
import kotlinx.coroutines.NonCancellable.start

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myDataset = Datasource().loadPersonas() //Datasource().loadPersonas()
        //val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        binding.recyclerView.adapter =
            ItemAdapter(this, onClickListener = { pasarDatos(it) }, myDataset)
        binding.recyclerView.setHasFixedSize(true)

        binding.btnImagen.setOnClickListener {
            startAlertDialog()
        }

        //binding.next.setOnClickListener { goToActividades() }
    }

    fun goToActividades() {
        startActivity(Intent(this, ActividadesPositivas::class.java))
    }

    // Andrew,10/10/2022,180,100,90,200,222,5.6
    val andrewString: String = "Andrew,10/10/2022,180,100,90,200,222,5.6"
    val andrewPhoto: Int = R.drawable.andrew

    val andrewPersona: Persona = stringToPersona(andrewString, andrewPhoto)

    fun stringToPersona(cad: String, photo: Int): Persona {
        val photoResourceId: Int = photo
        val nombre: String = cad.split(",")[0]
        val fecha: String = cad.split(",")[1]
        val puntosPremio: Int = cad.split(",")[2].toInt()
        val puntosCastigo: Int = cad.split(",")[3].toInt()
        val puntosJuego: Int = cad.split(",")[4].toInt()
        val puntosAyer: Int = cad.split(",")[5].toInt()
        val puntosHoy: Int = cad.split(",")[6].toInt()
        val dinero: Float = cad.split(",")[7].toFloat()

        val p: Persona = Persona(
            photoResourceId = photoResourceId,
            nombre = nombre,
            fecha = fecha,
            puntosPremio = puntosPremio,
            puntosCastigo = puntosCastigo,
            puntosJuego = puntosJuego,
            puntosAyer = puntosAyer,
            puntosHoy = puntosHoy,
            dinero = dinero
        )

        return p
    }


    fun pasarDatos(element: Persona) {
        val nameIt: String = element.nombre
        val myIntent: Intent = Intent(this, ActividadesPositivas::class.java)
        val name: String = "pasamos!!!"

        myIntent.putExtra("ok", nameIt)
        startActivity(myIntent)
    }

    fun startAlertDialog() {
        val andrew = prefs.getAndrew()
        val matthew = prefs.getMatthew()
        val mom = prefs.getMama()
        val dad = prefs.getPapa()
        val cadena: String = "$andrew\n$matthew\n$mom\n$dad"
        val newFragment = StartGameDialogFragment(cadena)
        newFragment.show(supportFragmentManager, "game")
    }

}