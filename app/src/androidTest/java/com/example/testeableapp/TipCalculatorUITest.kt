package com.example.testeableapp

import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.test.assertTextContains
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

        composeTestRule.onNodeWithTag("redondeo").performClick()

        composeTestRule.onNodeWithTag("validarPropina")
            .assertExists()
            .assertTextContains("Propina: $", substring = true)
    }



}