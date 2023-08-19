package com.example.buscadordecoincidenciasdetexto

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.buscadordecoincidenciasdetexto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val comparacionDeTextoViewModel: ComparacionDeTextoViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botonComparador.setOnClickListener {
            val fraseUno = binding.campoFraseUno.text.toString()
            val fraseDos = binding.campoFraseDos.text.toString()
            comparacionDeTextoViewModel.comparacionDeTexto(fraseUno, fraseDos)
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }

        comparacionDeTextoViewModel.resultadoDeComparacion.observe(this) { result ->
            binding.resultadoDeLaComparacion.text = result
        }
    }
}