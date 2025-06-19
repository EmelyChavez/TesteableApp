package com.example.testeableapp

import org.junit.Assert.assertEquals
import org.junit.Test
import com.example.testeableapp.ui.Screens.calculateTip

class TipCalculatorUnitTest3 {

    @Test
    fun calcular_propina_con_monto_negativo() {
        val resultado = calculateTip(-100.0, 15, false)
        assertEquals(0.0, resultado, 0.0)
    }
}
