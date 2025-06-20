package com.example.testeableapp

import com.example.testeableapp.ui.Screens.calculateTip
import junit.framework.TestCase.assertEquals
import org.junit.Test

class TipZeroPercentTest {
    @Test
    fun testTipZeroPercent(){
        val montoCuenta = 100.0
        val porcentajePropina = 0
        val redondear = false

        val propinaEsperada = calculateTip(montoCuenta, porcentajePropina, redondear) // = 0.00

        assertEquals(0.0, propinaEsperada, 0.0)

    }
}