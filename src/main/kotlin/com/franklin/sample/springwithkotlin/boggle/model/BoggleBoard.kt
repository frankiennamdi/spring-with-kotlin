package com.franklin.sample.springwithkotlin.boggle.model

import java.util.ArrayList
import java.util.StringJoiner
import java.util.stream.Collectors

class BoggleBoard(val board: List<List<Char>>) {

    fun toCharArray(): Array<CharArray> {
        val temp: List<CharArray> = board
                .stream().map { l -> l.joinToString("") }
                .map { s -> s.toCharArray() }
                .collect(Collectors.toList())

        val conversion: Array<CharArray> = Array(temp.size) { CharArray(0) }

        for (i in temp.size downTo 0 step 1) {
            conversion[i] = temp[i]
        }
        return conversion
    }

    companion object Factory {
        fun create(boardAsCharArray: Array<CharArray>): BoggleBoard {
            val boardAsList: MutableList<List<Char>> = mutableListOf()
            for (chars: CharArray in boardAsCharArray) {
                boardAsList.add(chars.toList())
            }
            return BoggleBoard(boardAsList)
        }
    }
}
