package hu.gameoflife

import hu.gameoflife.Board.Companion.CELL_COUNT_X
import hu.gameoflife.Board.Companion.CELL_COUNT_Y
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DirectionTest {

    private lateinit var cell1: Cell
    private lateinit var cell2: Cell

    @Before
    fun init() {
        cell1 = Cell(0, 0)
        cell2 = Cell(CELL_COUNT_X - 1, CELL_COUNT_Y - 1)
    }

    @Test
    fun getX_North() {
        assertEquals(0, North.getX(cell1))
        assertEquals(CELL_COUNT_X - 1, North.getX(cell2))
    }

    @Test
    fun getY_North() {
        assertEquals(CELL_COUNT_Y - 1, North.getY(cell1))
        assertEquals(CELL_COUNT_Y - 2, North.getY(cell2))
    }

    @Test
    fun getX_NorthEast() {
        assertEquals(1, NorthEast.getX(cell1))
        assertEquals(0, NorthEast.getX(cell2))
    }

    @Test
    fun getY_NorthEast() {
        assertEquals(CELL_COUNT_Y - 1, NorthEast.getY(cell1))
        assertEquals(CELL_COUNT_Y - 2, NorthEast.getY(cell2))
    }

    @Test
    fun getX_East() {
        assertEquals(1, East.getX(cell1))
        assertEquals(0, East.getX(cell2))
    }

    @Test
    fun getY_East() {
        assertEquals(0, East.getY(cell1))
        assertEquals(CELL_COUNT_Y - 1, East.getY(cell2))
    }

    @Test
    fun getX_SouthEast() {
        assertEquals(1, SouthEast.getX(cell1))
        assertEquals(0, SouthEast.getX(cell2))
    }

    @Test
    fun getY_SouthEast() {
        assertEquals(1, SouthEast.getY(cell1))
        assertEquals(0, SouthEast.getY(cell2))
    }

    @Test
    fun getX_South() {
        assertEquals(0, South.getX(cell1))
        assertEquals(CELL_COUNT_X - 1, South.getX(cell2))
    }

    @Test
    fun getY_South() {
        assertEquals(1, South.getY(cell1))
        assertEquals(0, South.getY(cell2))
    }

    @Test
    fun getX_SouthWest() {
        assertEquals(CELL_COUNT_X - 1, SouthWest.getX(cell1))
        assertEquals(CELL_COUNT_X - 2, SouthWest.getX(cell2))
    }

    @Test
    fun getY_SouthWest() {
        assertEquals(1, SouthWest.getY(cell1))
        assertEquals(0, SouthWest.getY(cell2))
    }

    @Test
    fun getX_West() {
        assertEquals(CELL_COUNT_X - 1, West.getX(cell1))
        assertEquals(CELL_COUNT_X - 2, West.getX(cell2))
    }

    @Test
    fun getY_West() {
        assertEquals(0, West.getY(cell1))
        assertEquals(CELL_COUNT_Y - 1, West.getY(cell2))
    }

    @Test
    fun getX_NorthWest() {
        assertEquals(CELL_COUNT_X - 1, NorthWest.getX(cell1))
        assertEquals(CELL_COUNT_X - 2, NorthWest.getX(cell2))
    }

    @Test
    fun getY_NorthWest() {
        assertEquals(CELL_COUNT_Y - 1, NorthWest.getY(cell1))
        assertEquals(CELL_COUNT_Y - 2, NorthWest.getY(cell2))
    }
}