package com.example.testeableapp

import com.example.testeableapp.ui.Screens.calculateTip
import org.junit.Assert.assertEquals
import org.junit.Test

class TipFifteenPercentAndRoundedTest {
    @Test
    fun testTipFifteenPercent (){

        val montoCuenta = 150.0
        val porcentajePropina = 15
        val redondear = true

        val propinaEsperada = calculateTip(montoCuenta, porcentajePropina, redondear) // = 23.00

        assertEquals(23.0, propinaEsperada, 0.0)
    }
}