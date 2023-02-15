package com.example.contadorcasino.registroactividades

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.contadorcasino.database.HijosDataBaseDao

class RegistroActividadesViewModelFactory(
    private val dataSource: HijosDataBaseDao,
    private val application: Application
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegistroActividadesViewModel::class.java)){
            return RegistroActividadesViewModel(dataSource, application) as T
        }
        throw java.lang.IllegalArgumentException("View Model class Desconocida!")
    }
}