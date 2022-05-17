package hu.gameoflife

import hu.gameoflife.Board.Companion.CELL_COUNT_X
import hu.gameoflife.Board.Companion.CELL_COUNT_Y

sealed class Direction {
    open fun getX(cell: Cell): Int {
        return cell.x
    }

    open fun getY(cell: Cell): Int {
        return cell.y
    }
}

object North: Direction() {
    override fun getY(cell: Cell): Int {
        return if (cell.y == 0) {
            CELL_COUNT_Y - 1
        } else {
            cell.y - 1
        }
    }
}

object NorthEast: Direction() {
    override fun getX(cell: Cell): Int {
        return if (cell.x == CELL_COUNT_X - 1) {
            0
        } else {
            cell.x + 1
        }
    }

    override fun getY(cell: Cell): Int {
        return if (cell.y == 0) {
            CELL_COUNT_Y - 1
        } else {
            cell.y - 1
        }
    }
}

object East: Direction() {
    override fun getX(cell: Cell): Int {
        return if (cell.x == CELL_COUNT_X - 1) {
            0
        } else {
            cell.x + 1
        }
    }
}

object SouthEast: Direction() {
    override fun getX(cell: Cell): Int {
        return if (cell.x == CELL_COUNT_X - 1) {
            0
        } else {
            cell.x + 1
        }
    }

    override fun getY(cell: Cell): Int {
        return if (cell.y == CELL_COUNT_Y - 1) {
            0
        } else {
            cell.y + 1
        }
    }
}

object South: Direction() {
    override fun getY(cell: Cell): Int {
        return if (cell.y == CELL_COUNT_Y - 1) {
            0
        } else {
            cell.y + 1
        }
    }
}

object SouthWest: Direction() {
    override fun getX(cell: Cell): Int {
        return if (cell.x == 0) {
            CELL_COUNT_X - 1
        } else {
            cell.x - 1
        }
    }

    override fun getY(cell: Cell): Int {
        return if (cell.y == CELL_COUNT_Y - 1) {
            0
        } else {
            cell.y + 1
        }
    }
}

object West: Direction() {
    override fun getX(cell: Cell): Int {
        return if (cell.x == 0) {
            CELL_COUNT_X - 1
        } else {
            cell.x - 1
        }
    }
}

object NorthWest: Direction() {
    override fun getX(cell: Cell): Int {
        return if (cell.x == 0) {
            CELL_COUNT_X - 1
        } else {
            cell.x - 1
        }
    }

    override fun getY(cell: Cell): Int {
        return if (cell.y == 0) {
            CELL_COUNT_Y - 1
        } else {
            cell.y - 1
        }
    }
}