package hu.gameoflife


import hu.gameoflife.State.Dead
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class CellTest {
    private lateinit var cell: Cell

    @Before
    fun init() {
        cell = Cell(0, 0)
    }

    @Test
    fun init_Success() {
        assertEquals(Dead, cell.state)
    }
}