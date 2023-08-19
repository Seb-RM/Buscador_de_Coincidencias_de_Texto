package com.example.buscadordecoincidenciasdetexto

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class ComparadorDeTextoUnitTest {

    private lateinit var viewModel: ComparacionDeTextoViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = ComparacionDeTextoViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun testCompararTextosDiferentes() {
        val viewModel = ComparacionDeTextoViewModel()
        viewModel.comparacionDeTexto("Sí funciona.", "No funciona.")
        assertEquals("Resultado : \nLos textos ingresados no coinciden.", viewModel.resultadoDeComparacion.value)
    }

    @Test
    fun testCompararTextosIguales() {
        val viewModel = ComparacionDeTextoViewModel()
        viewModel.comparacionDeTexto("Sí funciona.", "Sí funciona.")
        assertEquals("Resultado : \nAmbos textos ingresados coinciden, y son iguales.", viewModel.resultadoDeComparacion.value)
    }
}