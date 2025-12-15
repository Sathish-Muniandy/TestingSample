package com.example.interviewpreparationtesting

import org.junit.After
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

data class Country(val name:String, val driveSide:String)

object CountryFilter {
    fun filterDriveSide(countries:List<Country>,side:String):List<Country> {
        return countries.filter { it.driveSide == side }
    }
}

class CountryFilterTest {

    private var countries = listOf<Country>()

    @Before
    fun loadCountriesList() {
         countries = listOf(
            Country("India","right"),
            Country("Russia","right"),
            Country("Isral","left")
        )
    }

    @After
    fun clearCountryList() {
        countries = listOf()
    }

    @Test
    fun checkNull() {
        val filterRight = CountryFilter.filterDriveSide(countries,"right")
        val result = filterRight.find { it.driveSide == "left" }
        assertNull(result)
    }


    @Test
    fun testFilterByDriveSideLeft() {
        val result = CountryFilter.filterDriveSide(countries,"right")
        assertEquals(2,result.size)
    }
}