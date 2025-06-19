package com.example.testeableapp

import com.example.testeableapp.ui.Screens.calculateTip
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class TipCalculatorUnitTest {

    @Test
    fun calcular_total_por_persona_correctamente() {
        val montoCuenta = 100.0
        val porcentajePropina = 20
        val redondear = false
        val personas = 4

        val propinaEsperada = calculateTip(montoCuenta, porcentajePropina, redondear) // = 20.0
        val totalEsperadoPorPersona = (montoCuenta + propinaEsperada) / personas     // = 30.0

        assertEquals(20.0, propinaEsperada, 0.0)
        assertEquals(30.0, totalEsperadoPorPersona, 0.0)
    }
}
