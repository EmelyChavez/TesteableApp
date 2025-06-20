package com.example.testeableapp

import org.junit.Assert.assertEquals
import org.junit.Test
import com.example.testeableapp.ui.Screens.calculateTip

class TipCalculatorWithNegativeValueTest {

    @Test
    fun TipCalculatorWithNegativeValueTest() {
        val resultado = calculateTip(-100.0, 15, false)
        assertEquals(0.0, resultado, 0.0)
    }
}
