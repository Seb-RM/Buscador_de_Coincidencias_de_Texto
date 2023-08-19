package com.example.buscadordecoincidenciasdetexto

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TestDeUIMainActivity {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun testUI() {
        val fraseUno = "Si funciona."
        val fraseDos = "No funciona."

        onView(withId(R.id.campoFraseUno)).perform(typeText(fraseUno))
        onView(withId(R.id.campoFraseDos)).perform(typeText(fraseDos))
        onView(withId(R.id.botonComparador)).perform(click())

        onView(withId(R.id.resultadoDeLaComparacion))
            .check(matches(withText("Resultado : \nLos textos ingresados no coinciden.")))
    }
}