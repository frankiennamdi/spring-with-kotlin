package com.franklin.sample.springwithkotlin.boggle.support

interface Dictionary {

    fun characterSet(): Set<Char>

    fun findWord(word: String): SearchResult
}
