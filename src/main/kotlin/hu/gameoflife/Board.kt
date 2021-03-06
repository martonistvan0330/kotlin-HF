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
        cells.forEach { cellRow ->
            cellRow.forEach { cell ->
                cell.state = Dead
            }
        }
    }

    fun update() {
        cells.forEach { cellRow ->
            cellRow.forEach { cell ->
                cell.calculateNextState(countAliveNeighbours(cell))
            }
        }
        cells.forEach { cellRow ->
            cellRow.forEach { cell ->
                cell.update()
            }
        }
    }

    fun switchState(x: Int, y: Int) {
        val cell = cells[x][y]
        cell.switchState()
    }

    private fun countAliveNeighbours(cell: Cell): Int {
        return directions.count { direction ->
            checkAliveNeighbour(cell, direction)
        }
    }

    private fun checkAliveNeighbour(cell: Cell, direction: Direction): Boolean {
        return getNeighbour(cell, direction).state == Alive
    }

    private fun getNeighbour(cell: Cell, direction: Direction): Cell {
        val x = direction.getX(cell)
        val y = direction.getY(cell)
        return cells[x][y]
    }
}