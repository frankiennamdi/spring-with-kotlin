package com.franklin.sample.springwithkotlin.boggle.support


import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class TrieTest {

    @ParameterizedTest
    @MethodSource("arguments")
    fun testSearch(wordToFind: String, expectedToBeFound: Boolean) {
        val keys: List<String> = listOf("the", "there", "their", "a", "answer", "any", "by", "bye")
        val trie = Trie()
        keys.forEach(trie::insert)
        val isFound = trie.search(wordToFind)
        Assertions.assertEquals(isFound.isWord, expectedToBeFound)
    }

    companion object {
        @JvmStatic
        fun arguments() = listOf(
                Arguments.of("the", true),
                Arguments.of("these", false),
                Arguments.of("their", true),
                Arguments.of("thaw", false))
    }
}
