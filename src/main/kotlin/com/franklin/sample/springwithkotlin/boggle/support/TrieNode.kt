package com.franklin.sample.springwithkotlin.boggle.support

class TrieNode {

    private var isLeaf = false

    private var nodes: MutableMap<Char, TrieNode> = LinkedHashMap()

    fun getNode(character: Char): TrieNode? {
        return nodes[character]
    }

    fun addNewCharacter(character: Char) {
        nodes[character] = TrieNode()
    }

    fun isEndOfWord(): Boolean {
        return isLeaf
    }

    fun markAsEndOfWord() {
        isLeaf = true
    }

    fun hasChildren(): Boolean {
        return nodes.isNotEmpty()
    }
}
