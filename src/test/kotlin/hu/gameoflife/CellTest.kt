package hu.gameoflife


import hu.gameoflife.State.Alive
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

    @Test
    fun getX() {
        assertEquals(0, cell.x)
    }

    @Test
    fun getY() {
        assertEquals(0, cell.y)
    }

    @Test
    fun setState() {
        assertEquals(Dead, cell.state)
        cell.state = Alive
        assertEquals(Alive, cell.state)
    }

    @Test
    fun switchState() {
        assertEquals(Dead, cell.state)
        cell.switchState()
        assertEquals(Alive, cell.state)
        cell.switchState()
        assertEquals(Dead, cell.state)
    }

    @Test
    fun calculateNextState_Dead_Dead() {
        assertEquals(Dead, cell.state)
        assertEquals(Dead, cell.nextState)
        cell.calculateNextState(1)
        assertEquals(Dead, cell.nextState)
    }

    @Test
    fun calculateNextState_Dead_Alive() {
        assertEquals(Dead, cell.state)
        assertEquals(Dead, cell.nextState)
        cell.calculateNextState(3)
        assertEquals(Alive, cell.nextState)
    }

    @Test
    fun calculateNextState_Alive_Dead() {
        cell.switchState()
        assertEquals(Alive, cell.state)
        assertEquals(Dead, cell.nextState)
        cell.calculateNextState(1)
        assertEquals(Dead, cell.nextState)
        cell.calculateNextState(4)
        assertEquals(Dead, cell.nextState)
    }

    @Test
    fun calculateNextState_Alive_Alive() {
        cell.switchState()
        assertEquals(Alive, cell.state)
        assertEquals(Dead, cell.nextState)
        cell.calculateNextState(2)
        assertEquals(Alive, cell.nextState)
        cell.calculateNextState(3)
        assertEquals(Alive, cell.nextState)
    }

    @Test
    fun update() {
        cell.switchState()
        assertEquals(Alive, cell.state)
        assertEquals(Dead, cell.nextState)
        cell.update()
        assertEquals(Dead, cell.state)
        assertEquals(Dead, cell.nextState)
    }
}