package com.kanchan.kotlin

import java.util.LinkedList
import java.util.Queue

object TestKotlin {
    data class Person1(val name: String = "Kanchan", val title: String = "Pal")
    data class Person2(val name: String = "Kanchan", val title: String = "Pal")

    fun testObjects(person1: Person1,  person2: Person2) {
        println(" person equals ${person1.equals(person2)}")
    }

    fun testHashCodes(person1: Person1, person2: Person2) {
        println("person 1 hashcode ${person1.hashCode()} person 2 hashcode ${person2.hashCode()}" )
    }

    fun testSameClass(person1: Person1, person2: Person1) {
        println("same person equals ${person1 == person2}")
        println("same person 1 hashcode ${person1.hashCode()} person 2 hashcode ${person2.hashCode()}" )
    }

    fun testDataStructures() {
        val hasSet = HashSet<Int>()
        val queue: Queue<Int> = LinkedList<Int>()
        queue.addAll(hasSet)
    }
}