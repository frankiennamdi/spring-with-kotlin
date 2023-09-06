package com.franklin.sample.springwithkotlin.boggle.game

import com.franklin.sample.springwithkotlin.boggle.model.BoggleBoard
import com.franklin.sample.springwithkotlin.boggle.model.BoggleResult
import com.franklin.sample.springwithkotlin.boggle.support.Dictionary
import com.franklin.sample.springwithkotlin.boggle.support.SearchResult

class Boggle(private val dictionary: Dictionary) {


    fun solve(boggleBoard: BoggleBoard): BoggleResult {
        val board: Array<CharArray> = boggleBoard.toCharArray()
        val results: MutableList<String> = mutableListOf()
        val usedCells: MutableSet<Pair<Int, Int>> = hashSetOf()
        val m = board.size
        require(m != 0) { "rows must be a positive integer" }
        val n = board[0].size
        require(n != 0) { "columns must be a positive integer" }
        for (i in board.indices) {
            for (j in board[i].indices) {
                require(board[i].size == n) { "board must be proportional" }
                val currentChar = isValidCharInAlphabet(board[i][j])
                results.addAll(findWords(board, java.lang.StringBuilder(currentChar.toString()), i, j, usedCells))
            }
        }
        return BoggleResult(results)
    }

    private fun findWords(board: Array<CharArray>, currentString: StringBuilder, y: Int, x: Int, usedCells: MutableSet<Pair<Int, Int>>): Set<String> {
        val foundWords: MutableSet<String> = mutableSetOf()
        for (pos in CELL_NEIGHBOURS) {
            val nextY: Int = pos.first + y
            val nextX: Int = pos.second + x
            val nextPos = pos(nextY, nextX)
            if (isValidPosition(board, nextY, nextX) && !usedCells.contains(nextPos)) {
                usedCells.add(nextPos)
                val currentChar = isValidCharInAlphabet(board[nextY][nextX])
                currentString.append(currentChar)
                val searchResult: SearchResult = dictionary.findWord(currentString.toString())
                if (searchResult.isWord) {
                    foundWords.add(searchResult.searchString)
                }
                if (searchResult.isPrefix) {
                    foundWords.addAll(findWords(board, currentString, nextY, nextX, usedCells))
                }
                usedCells.remove(nextPos)
                currentString.setLength(currentString.length - 1)
            }
        }
        return foundWords
    }

    private fun isValidPosition(board: Array<CharArray>, y: Int, x: Int): Boolean {
        return y >= 0 && x >= 0 && y < board.size && x < board[y].size
    }

    private fun isValidCharInAlphabet(character: Char): Char {
        if (dictionary.characterSet().contains(character)) {
            return character
        }
        throw RuntimeException(String.format("Board Contains Illegal Characters for the dictionary [%c]", character))
    }

    companion object {
        var CELL_NEIGHBOURS: List<Pair<Int, Int>> = listOf(
                pos(-1, -1),
                pos(-1, 0),
                pos(-1, 1),
                pos(0, -1),
                pos(0, 1),
                pos(1, -1),
                pos(1, 0),
                pos(1, 1)
        )

        private fun pos(y: Int, x: Int): Pair<Int, Int> {
            return Pair(y, x)
        }
    }
}
