package com.franklin.sample.springwithkotlin.boggle.support

import java.util.*

class Trie {
    private var root = TrieNode()

    fun insert(word: String) {
        val wordUpper = word.uppercase(Locale.getDefault())
        var curr = root
        for (element in wordUpper) {
            val trieNode = curr.getNode(element)
            if (trieNode == null) {
                curr.addNewCharacter(element)
            }
            curr = curr.getNode(element)!!
        }
        curr.markAsEndOfWord()
    }

    private fun find(word: String): TrieNode? {
        val wordUpper = word.uppercase(Locale.getDefault())
        var curr = root
        for (element in wordUpper) {
            curr = curr.getNode(element) ?: return null
        }
        return curr
    }

    fun search(word: String): SearchResult {
        val trieNode = find(word)
        return SearchResult(word, (trieNode != null) && trieNode.hasChildren(),
                (trieNode != null) && trieNode.isEndOfWord())
    }
}
