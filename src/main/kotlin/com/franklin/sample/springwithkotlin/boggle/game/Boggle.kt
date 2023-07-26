package com.franklin.sample.springwithkotlin.boggle.game

class Boggle {

    companion object {
        var cellNeighbors: List<Pair<Int, Int>> = listOf(
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