package com.franklin.sample.springwithkotlin.boggle.support

import java.util.stream.Collectors

class SampleDictionary(words: List<String>) : Dictionary {
    private var dictionary: Trie = Trie()
    private var characterSet: MutableSet<Char>

    init {
        words.forEach { word -> dictionary.insert(word) }
        val englishChars = AlphabetSupport.englishAlphabet().getAlphabet(true)
        characterSet = String(englishChars).chars().mapToObj { e: Int -> e.toChar() }.collect(Collectors.toSet())

    }

    override fun characterSet(): Set<Char> {
        return characterSet
    }

    override fun findWord(word: String): SearchResult {
        return dictionary.search(word)
    }
}