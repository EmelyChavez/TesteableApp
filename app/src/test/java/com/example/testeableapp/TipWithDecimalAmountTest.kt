package com.example.testeableapp

import com.example.testeableapp.ui.Screens.calculateTip
import org.junit.Assert.assertEquals
import org.junit.Test

class TipWithDecimalAmountTest {
    @Test
    fun calcular_propina_con_monto_decimal() {
        val resultado = calculateTip(amount = 123.45, tipPercent = 20, roundUp = false)
        // 123.45 * 0.20 = 24.69
        assertEquals(24.69, resultado, 0.01)
    }
}