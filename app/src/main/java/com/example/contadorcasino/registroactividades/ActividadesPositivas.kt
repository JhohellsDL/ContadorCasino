package com.example.contadorcasino.registroactividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.contadorcasino.GuardarDatos.Companion.prefs
import com.example.contadorcasino.MainActivity
import com.example.contadorcasino.R
import com.example.contadorcasino.adapter.NegativeAdapter
import com.example.contadorcasino.adapter.PositiveAdapter
import com.example.contadorcasino.data.Datasource
import com.example.contadorcasino.databinding.ActivityActividadesPositivasBinding
import com.example.contadorcasino.model.NegativeAction
import com.example.contadorcasino.model.Persona
import com.example.contadorcasino.model.PositiveAction

class ActividadesPositivas : AppCompatActivity() {

    private lateinit var viewModel : RegistroActividadesViewModel
    private lateinit var binding: ActivityActividadesPositivasBinding

    private var increase: Int = 0
    private var decrease: Int = 0
    private var totalPoints: Int = 0
    private var money: Float =0f

    private var cadenaDeLaVista: String = ""
    private var cadFinal: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityActividadesPositivasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //-------------------------------llamada al view model -------------------------------------------------------------------------------
        viewModel = ViewModelProvider(this)[RegistroActividadesViewModel::class.java]
        Log.i("viewmodel","view model llamado!!")

        viewModel.ptsGanados.observe(this, Observer {
            binding.puntosGanados.text = it.toString()
        })
        viewModel.ptsPerdidos.observe(this, Observer {
            binding.puntosPerdidos.text = it.toString()
        })
        viewModel.ptsTotal.observe(this, Observer {
            binding.puntosTotalGanados.text = it.toString()
        })
        viewModel.dineroTotal.observe(this, Observer {
            binding.valorEnDinero.text = it.toString()
        })

        //------------------------------------------------------------------------------------------------------------------------------------

        val myPositiveDataset = Datasource().loadPositiveActions()
        val myNegativeDataset = Datasource().loadNegativeActions()
        val recyclerViewPositive = binding.recyclerViewPositive
        val recyclerViewNegative = binding.recyclerViewNegative

        var nameUser: String = ""
        var dineroGanado: Float = 0f
        var totalPuntos: Int = 0
        var puntosGanados: Int = 0
        var puntosPerdidos: Int = 0

        val myIntent: String? = intent.getStringExtra("ok")
        binding.nameUser.text = myIntent

        val photo = when (myIntent) {
            "Andrew" -> R.drawable.andrew
            "Matthew" -> R.drawable.matthew
            "Dad" -> R.drawable.dad
            else -> R.drawable.mom
        }
        nameUser = when (myIntent) {
            "Andrew" -> "Andrew"
            "Matthew" -> "Matthew"
            "Dad" -> "Dad"
            else -> "Mom"
        }

        var cadenaDeShared = when (myIntent) {
            "Andrew" -> prefs.getAndrew()
            "Matthew" -> prefs.getMatthew()
            "Dad" -> prefs.getPapa()
            else -> prefs.getMama()
        }

        if(cadenaDeShared == "no hay"){
            cadenaDeShared = "$nameUser,00/00/0000,0,0,0,0,0,0"
        }
        binding.photoUser.setImageResource(photo)

        binding.btnXd.setOnClickListener {
            goToActividades()
        }

        recyclerViewPositive.adapter = PositiveAdapter(
            context = this,
            onClickActionResta = {
                goToActividades()
            },
            onClickAction = {
                Log.i("viewmodel","click1!!")
                viewModel.onItemPositiveSelected(it)
            },
            dataset = myPositiveDataset
        )
        recyclerViewPositive.setHasFixedSize(true)

        recyclerViewNegative.adapter = NegativeAdapter(
            context = this,
            onClickActionResta = {
                goToActividades()
            },
            onClickAction = {
                viewModel.onItemNegativeSelected(it)
            },
            dataset = myNegativeDataset
        )

        binding.btnGuardarDatos.setOnClickListener {
            dineroGanado = binding.valorEnDinero.text.toString().toFloat()
            totalPuntos = binding.puntosTotalGanados.text.toString().toInt()
            puntosGanados = binding.puntosGanados.text.toString().toInt()
            puntosPerdidos = binding.puntosPerdidos.text.toString().toInt()

            // Andrew,10/10/2022,180,100,90,200,222,5.6
            cadenaDeLaVista = "$nameUser,10/10/2022,$puntosGanados,$puntosPerdidos,0,0,$totalPuntos,$dineroGanado"

            val personaDeLaVista: Persona = stringToPersona(cad = cadenaDeLaVista, photo)
            val personaDeShared: Persona = stringToPersona(cadenaDeShared,photo)

            cadFinal = sumarPersonas(personaDeLaVista, personaDeShared)
            val personaFinal: Persona = stringToPersona(cadFinal,photo)

            //binding.textMuestra.text = cadFinal

            when (myIntent) {
                "Andrew" -> prefs.saveAndrew(cadFinal)
                "Matthew" -> prefs.saveMatthew(cadFinal)
                "Dad" -> prefs.savePapa(cadFinal)
                else -> prefs.saveMama(cadFinal)
            }
            //Toast.makeText(this, "Guardado en $nameUser",Toast.LENGTH_SHORT).show()
        }
    }

    // Andrew,10/10/2022,180,100,90,200,222,5.6
    fun sumarPersonas(person1: Persona, person2: Persona): String{
        val cadena: String

        val nombre: String = person1.nombre
        val fecha: String = person1.fecha
        val puntosPremio: Int = person1.puntosPremio + person2.puntosPremio
        val puntosCastigo: Int = person1.puntosCastigo + person2.puntosCastigo
        val puntosJuego: Int = person1.puntosJuego + person2.puntosJuego
        val puntosAyer: Int = person1.puntosAyer + person2.puntosAyer
        val puntosHoy: Int = person1.puntosHoy + person2.puntosHoy
        val dinero: Float = person1.dinero + person2.dinero

        cadena = "$nombre,$fecha,$puntosPremio,$puntosCastigo,$puntosJuego,$puntosAyer,$puntosHoy,$dinero"
        return cadena
    }

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

    // 0.025 by point
    fun onItemNegativeSelected1(elementolista: NegativeAction) {
        decrease += elementolista.valor
        totalPoints -= elementolista.valor
        money = (totalPoints*0.025f)

        binding.valorEnDinero.text = "$money"
        binding.puntosTotalGanados.text = "$totalPoints"
        binding.puntosPerdidos.text = "$decrease"
    }
    fun onItemPositiveSelected1(elementolista: PositiveAction) {
        increase += elementolista.valor
        totalPoints += elementolista.valor
        money = (totalPoints*0.025f)

        binding.valorEnDinero.text = "$money"
        binding.puntosTotalGanados.text = "$totalPoints"
        binding.puntosGanados.text = "$increase"
    }
    fun goToActividades(){
        startActivity(Intent(this, MainActivity::class.java))
    }
}