package com.example.buscadordecoincidenciasdetexto

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ComparacionDeTextoViewModel: ViewModel() {

    private val _resultadoDeComparacion = MutableLiveData<String>()
    val resultadoDeComparacion: LiveData<String> = _resultadoDeComparacion

    fun comparacionDeTexto(fraseUno: String, fraseDos: String) {
        _resultadoDeComparacion.value = if (fraseUno == fraseDos) {
            "Resultado : \nAmbos textos ingresados coinciden, y son iguales."
        } else {
            "Resultado : \nLos textos ingresados no coinciden."
        }
    }
}