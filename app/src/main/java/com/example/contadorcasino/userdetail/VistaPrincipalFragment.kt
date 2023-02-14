package com.example.contadorcasino.userdetail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.contadorcasino.R
import com.example.contadorcasino.data.Datasource
import com.example.contadorcasino.databinding.ActivityActividadesPositivasBinding
import com.example.contadorcasino.databinding.FragmentVistaPrincipalBinding
import com.example.contadorcasino.model.Persona
import com.example.contadorcasino.registroactividades.RegistroActividadesViewModel

class VistaPrincipalFragment : Fragment() {


    private lateinit var binding: FragmentVistaPrincipalBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentVistaPrincipalBinding.inflate(inflater)


        //--------------------------------- AMBOS FUNCIONAN PARA LA NAVEGACION --------------------------------------------------------------
        /*binding.button.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_vistaPrincipalFragment_to_actividadesPositivas)
        }*/
        binding.button.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_vistaPrincipalFragment_to_actividadesPositivas)
        )
        //------------------------------------------------------------------------------------------------------------------------------------




        /*val myDataset = Datasource().loadPersonas()

        binding.listUsers.adapter = UserDetailAdapter(this.requireContext(), onClickListener = { pasarDatos(it) }, myDataset)
*/

        return binding.root
    }

    private fun pasarDatos(it: Persona) {
        print("dasfkjalsd")
    }
}