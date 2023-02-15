package com.example.contadorcasino.registroactividades

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.RoomDatabase
import com.example.contadorcasino.database.HijosDataBaseDao
import com.example.contadorcasino.model.NegativeAction
import com.example.contadorcasino.model.PositiveAction

class RegistroActividadesViewModel(
    val database: HijosDataBaseDao,
    application: Application
): AndroidViewModel(application) {

    private var _ptsGanados = MutableLiveData<Int>()
    val ptsGanados: LiveData<Int>
        get() = _ptsGanados

    private var _ptsPerdidos = MutableLiveData<Int>()
    val ptsPerdidos: LiveData<Int>
        get() = _ptsPerdidos

    private var _ptsTotal = MutableLiveData<Int>()
    val ptsTotal: LiveData<Int>
        get() = _ptsTotal

    private var _dineroTotal = MutableLiveData<Float>()
    val dineroTotal: LiveData<Float>
        get() = _dineroTotal

    /*private var cadenaDeLaVista: String = ""
    private var cadFinal: String = ""*/

    init {
        _ptsPerdidos.value = 0
        _ptsGanados.value = 0
        _ptsTotal.value = 0
        _dineroTotal.value = 0f

        Log.i("viewmodel","Creagaod!")
    }

    override fun onCleared() {
        Log.i("viewmodel","Cerradasdfadfo!")
        super.onCleared()
    }

    // 0.025 by point
    fun onItemNegativeSelected(elementolista: NegativeAction) {
        _ptsPerdidos.value = _ptsPerdidos.value!! + elementolista.valor
        _ptsTotal.value = _ptsTotal.value!! - elementolista.valor
       _dineroTotal.value = _ptsTotal.value!! * 0.025f
    }
    fun onItemPositiveSelected(elementolista: PositiveAction) {
        _ptsGanados.value = _ptsGanados.value!! + elementolista.valor
        _ptsTotal.value = _ptsTotal.value!! + elementolista.valor
        _dineroTotal.value = _ptsTotal.value!! * 0.025f
    }
}