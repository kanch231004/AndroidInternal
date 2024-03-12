package com.kanchan.kotlin

class TestKotlin {
    data class Person1(val name: String = "Kanchan", val title: String = "Pal")
    data class Person2(val name: String = "Kanchan", val title: String = "Pal")

    fun testObjects( person1: Person1,  person2: Person2) {
        println(person1.equals(person2))
    }
}