package hu.gameoflife

import hu.gameoflife.State.Alive
import hu.gameoflife.State.Dead
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BoardTest {

    private lateinit var board: Board

    @Before
    fun init() {
        board = Board()
        board.cells[1][0].state = Alive
        board.cells[1][1].state = Alive
        board.cells[1][2].state = Alive
    }

    @Test
    fun reset() {
        board.reset()
        board.cells.forEach { cellRow ->
            cellRow.forEach { cell ->
                assertEquals(Dead, cell.state)
            }
        }
    }

    @Test
    fun update() {
        board.update()
        assertEquals(Dead, board.cells[0][0].state)
        assertEquals(Dead, board.cells[1][0].state)
        assertEquals(Dead, board.cells[2][0].state)
        assertEquals(Alive, board.cells[0][1].state)
        assertEquals(Alive, board.cells[1][1].state)
        assertEquals(Alive, board.cells[2][1].state)
        assertEquals(Dead, board.cells[0][2].state)
        assertEquals(Dead, board.cells[1][2].state)
        assertEquals(Dead, board.cells[2][2].state)
    }
}