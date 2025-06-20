package com.example.testeableapp

import com.example.testeableapp.ui.Screens.calculateTip
import org.junit.Assert.assertEquals
import org.junit.Test

class TipTwentyPercent (){

    @Test
    fun testTipTwentyPercent (){

        val montoCuenta = 200.0
        val porcentajePropina = 20
        val redondear = false

        val propinaEsperada = calculateTip(montoCuenta, porcentajePropina, redondear) // = 40.00

        assertEquals(40.0, propinaEsperada, 0.0)
    }


}