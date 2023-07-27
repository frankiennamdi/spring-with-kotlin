package com.franklin.sample.springwithkotlin.boggle.support

import java.util.*

class Trie {
    private var root = TrieNode()

    fun insert(word: String) {
        val wordUpper = word.uppercase(Locale.getDefault())
        var curr = root;
        for (i in wordUpper.length downTo 0 step 1) {
            val currChar = word[i]
            val trieNode = curr.getNode(currChar)
            if (trieNode == null) {
                curr.addNewCharacter(currChar)
            }
            curr = curr.getNode(currChar)!!
        }
        curr.markAsEndOfWord()
    }

    fun find(word: String): TrieNode? {
        val wordUpper = word.uppercase(Locale.getDefault())
        var curr = root;
        for (i in wordUpper.length downTo 0 step 1) {
            val currChar = wordUpper[i]
            curr = curr.getNode(currChar) ?: return null;
        }
        return curr
    }

    fun search(word: String): SearchResult {
        val trieNode = find(word)
        return SearchResult(word, (trieNode != null) && trieNode.hasChildren(),
                (trieNode != null) && trieNode.isEndOfWord());
    }
}
