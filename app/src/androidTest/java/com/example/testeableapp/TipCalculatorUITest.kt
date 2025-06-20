package com.example.testeableapp

import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performSemanticsAction
import androidx.compose.ui.test.performTextInput
import com.example.testeableapp.ui.Screens.TipCalculatorScreen
import kotlinx.coroutines.sync.Semaphore
import org.junit.Rule
import org.junit.Test

class TipCalculatorUITest{

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test

    fun redondear_validarpropina(){
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        composeTestRule.onNodeWithTag("monto").performTextInput("100")
        composeTestRule.onNodeWithTag("porcentajePropina").performSemanticsAction(SemanticsActions.SetProgress){
            it(10f)
        }
        composeTestRule.onNodeWithTag("incrementarPersona").performClick()
        composeTestRule.onNodeWithTag("incrementarPersona").performClick()

        val resultadoSinRedondeo = composeTestRule.onNodeWithTag("validarPropina")
            .assertExists()
            .assertTextContains("Propina: $", substring = true)

        composeTestRule.onNodeWithTag("redondeo").performClick()

        val resultadoConRedondeo = composeTestRule.onNodeWithTag("validarPropina")
            .assertExists()
            .assertTextContains("Propina: $", substring = true)

        assert(resultadoSinRedondeo != resultadoConRedondeo)
    }
    @Test

    fun cambiarSlider_verificarValor(){
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        composeTestRule.onNodeWithTag("monto").performTextInput("100")
        composeTestRule.onNodeWithTag("incrementarPersona").performClick()
        composeTestRule.onNodeWithTag("porcentajePropina").performSemanticsAction(SemanticsActions.SetProgress){
            it(50f)
        }

        composeTestRule
            .onNodeWithTag("validarPropina")
            .assertExists()
            .assertTextContains("Propina: \$50.00")

        composeTestRule
            .onNodeWithTag("totalPorPersona")
            .assertExists()
            .assertTextContains("Total por persona: \$75.00")

    }

    @Test
    fun validar_PrecenciaDeElementos(){
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        composeTestRule.onNodeWithTag("monto").assertExists().assertIsDisplayed()
        composeTestRule.onNodeWithTag("porcentajePropina").assertExists().assertIsDisplayed()
        composeTestRule.onNodeWithTag("numeroPersona").assertExists().assertIsDisplayed()

    }

    @Test
    fun incremento_contador_DePersonas_y_noBajaDe1(){
        composeTestRule.setContent {
            TipCalculatorScreen()
        }

        composeTestRule.onNodeWithTag("numeroPersona")
            .assertExists().assertTextEquals("1")

        repeat(3){
            composeTestRule.onNodeWithTag("incrementarPersona").performClick()
        }

        composeTestRule.onNodeWithTag("numeroPersona").assertTextEquals("4")

        repeat(5){ //no debe bajar de 1
            composeTestRule.onNodeWithTag("decrementarPersona").performClick()
        }

        composeTestRule.onNodeWithTag("numeroPersona").assertTextEquals("1")
    }

}