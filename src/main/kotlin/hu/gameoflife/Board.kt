package hu.gameoflife

import hu.gameoflife.State.Alive
import hu.gameoflife.State.Dead

class Board {

    companion object {
        const val CELL_COUNT_X: Int = 80
        const val CELL_COUNT_Y: Int = 80
    }

    val cells = List(CELL_COUNT_X) { i -> List(CELL_COUNT_Y) { j -> Cell(i, j) } }

    private val directions: Set<Direction> = setOf(North, NorthEast, East, SouthEast, South, SouthWest, West,  NorthWest)

    fun reset() {
        for (cellRow in cells) {
            for (cell in cellRow) {
                cell.state = Dead
            }
        }
    }

    fun update() {
        for (cellRow in cells) {
            for (cell in cellRow) {
                cell.calculateNextState(countAliveNeighbours(cell))
            }
        }
        for (cellRow in cells) {
            for (cell in cellRow) {
                cell.update()
            }
        }
    }

    fun switchState(x: Int, y: Int) {
        val cell = cells[x][y]
        cell.switchState()
    }

    private fun countAliveNeighbours(cell: Cell): Int {
        var result = 0
        for (direction in directions) {
            if (getNeighbour(cell, direction).state == Alive) result++
        }
        return result
    }

    private fun getNeighbour(cell: Cell, direction: Direction): Cell {
        val x = direction.getX(cell)
        val y = direction.getY(cell)
        return cells[x][y]
    }
}