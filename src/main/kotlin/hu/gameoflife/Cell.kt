package hu.gameoflife

import hu.gameoflife.State.Alive
import hu.gameoflife.State.Dead

enum class State {
    Alive,
    Dead
}

class Cell(val x: Int, val y: Int) {
    var state: State = Dead
    var nextState: State = state
        private set

    fun switchState() {
        state = when (state) {
            Alive -> Dead
            Dead -> Alive
        }
    }

    fun calculateNextState(aliveNeighbours: Int) {
        nextState = when (state) {
            Alive -> if (aliveNeighbours in 2..3) Alive else Dead
            Dead -> if (aliveNeighbours == 3) Alive else Dead
        }
    }

    fun update() {
        state = nextState
    }
}
