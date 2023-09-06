package com.franklin.sample.springwithkotlin.boggle.support

import org.hamcrest.Matchers
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class SampleDictionaryTest {

    @Test
    fun testCanFindWordInDictionary() {
        val sampleDictionary = SampleDictionary(listOf("GEEKS", "FOR", "QUIZ", "GO"))
        Assertions.assertEquals(sampleDictionary.findWord("GEEKS").isWord, true)
        Assertions.assertEquals(sampleDictionary.findWord("GE").isWord, false)
        Assertions.assertEquals(sampleDictionary.findWord("QUIZ").isWord, true)
    }
}
